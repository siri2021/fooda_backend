package be.fooda.backend.matching.config;

import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchCategoryDto;
import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.service.exception.MatchingException;
import be.fooda.backend.commons.service.mapper.FoodaMatchingMapper;
import be.fooda.backend.commons.service.util.FoodaMatchUtil;
import be.fooda.backend.commons.service.validator.MatchId;
import be.fooda.backend.commons.service.validator.Matchable;
import be.fooda.backend.matching.dao.MatchResultRepository;
import com.google.common.util.concurrent.AtomicDouble;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

@Component
@Slf4j
@RequiredArgsConstructor
public class CmdStartupRunner implements CommandLineRunner {

    private final FoodaMatchingMapper mapper;
    private final MatchResultRepository repo;

    @Override
    public void run(final String... args) {
        log.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
                Arrays.toString(args));

        final Product p = Product.builder().id(125).name("Pizza Margheritta").desc(
                "An amazin Italian taste..! Ingredients. 1 12-inch round of pizza dough, stretched (see recipe) 3 tablespoons tomato sauce (see note) Extra-virgin olive oil. 2 ¾ ounces fresh mozzarella. 4 to 5 basil leaves, roughly torn.")
                .price(12.50).city("Brussels").imageUrl("https://fooda.be/pizzahut/pizza/pizza-margheritta.jpg")
                .build();

        out.println("-------------------------- TEMP DB TRANSACTION IS STARTED --------------------------");

        Arrays.asList("pizza", "margheritta", "italian").forEach(keyword -> {
            List<FoodaMatchReq> reqList = null;
            try {
                reqList = mapper.objectToRequest(p);
            } catch (final MatchingException e) {
                e.printStackTrace();
            }
            final List<FoodaMatchDto> results = generateMatchTable(Objects.requireNonNull(reqList), keyword);
            results.forEach(repo::save);
        });

        out.println("---------------------------- TEMP DB TRANSACTION IS ENDED ----------------------------");
    }

    private static List<FoodaMatchDto> generateMatchTable(final List<FoodaMatchReq> itemsToSearchIn, final String keyword) {
        // H2 memory DB
        final FoodaMatchUtil utils = new FoodaMatchUtil();
        final List<FoodaMatchDto> results = new ArrayList<>();
        itemsToSearchIn.forEach(result -> {
            final AtomicDouble matchSum = new AtomicDouble(0);
            final String[] words = String.valueOf(result.getMatched()).split("\\W+");
            Arrays.stream(words).forEach(word -> {
                final double scoreByWord = (utils.levensteinRatio(word.toLowerCase(), keyword.toLowerCase()));
                matchSum.addAndGet(scoreByWord);
            });

            if (matchSum.get() > result.getMinScore()) {
                final FoodaMatchCategoryDto category = FoodaMatchCategoryDto.builder()
                        .title(result.getCategory().getTitle())
                        .weight(result.getCategory().getWeight())
                        .build();

                final FoodaMatchDto matchDto = FoodaMatchDto.builder()
                        .relatedId(result.getRelatedId())
                        .category(category)
                        .keyword(result.getKeyword())
                        .score(matchSum.get() / words.length)
                        .build();

                // saving to MatchDB ..
                results.add(matchDto);
            }

        });

        return results;
    }

    @Data
    @Builder
    static class Product {

        @MatchId
        @Matchable
        private Integer id;

        @Matchable(value = "product.name", minScore = 0.75)
        private String name;

        @Matchable(value = "product.description", weight = 0.75, minScore = 0.50)
        private String desc;

        @Matchable(value = "product.price", weight = 0.50)
        private Double price;

        @Matchable(value = "store.location.city", weight = 0.50)
        private String city;
        
        private String imageUrl;
    }

    @Data
    @Builder
    static class Ingredients{

        private Integer id;

        @Matchable(value = "ingredient.name", weight = 0.25)
        private String name;

        private Double price;
    }
}