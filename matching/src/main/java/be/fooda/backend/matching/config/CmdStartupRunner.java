package be.fooda.backend.matching.config;

import be.fooda.backend.matching.model.request.MatchResultCategoryRequest;
import be.fooda.backend.matching.model.request.MatchResultRequest;
import be.fooda.backend.matching.repository.MatchResultRepository;
import be.fooda.backend.matching.service.flow.exception.MatchingException;
import be.fooda.backend.matching.service.mappers.KeywordMapper;
import be.fooda.backend.matching.service.mappers.MatchId;
import be.fooda.backend.matching.service.mappers.Matchable;
import be.fooda.backend.matching.service.mappers.SearchableItem;
import be.fooda.backend.matching.service.utils.MatchUtils;
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

import static java.lang.System.out;

@Component
@Slf4j
@RequiredArgsConstructor
public class CmdStartupRunner implements CommandLineRunner {

    private final KeywordMapper mapper;
    private final MatchResultRepository repo;

    @Override
    public void run(final String... args) throws Exception {
        log.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
                Arrays.toString(args));

        final Product p = Product.builder().id(125).name("Pizza Margheritta").desc(
                "An amazin Italian taste..! Ingredients. 1 12-inch round of pizza dough, stretched (see recipe) 3 tablespoons tomato sauce (see note) Extra-virgin olive oil. 2 ¾ ounces fresh mozzarella. 4 to 5 basil leaves, roughly torn.")
                .price(12.50).city("Brussels").imageUrl("https://fooda.be/pizzahut/pizza/pizza-margheritta.jpg")
                .build();

        out.println("-------------------------- TEMP DB TRANSACTION IS STARTED --------------------------");

        Arrays.asList("pizza", "margheritta", "italian").forEach(keyword -> {
            List<SearchableItem> itemsToSearchIn = null;
            try {
                itemsToSearchIn = mapper.match(p);
            } catch (final MatchingException e) {
                e.printStackTrace();
            }
            final List<MatchResultRequest> results = generateMatchTable(itemsToSearchIn, keyword);
            results.forEach(repo::save);
        });

        out.println("---------------------------- TEMP DB TRANSACTION IS ENDED ----------------------------");
    }

    private static List<MatchResultRequest> generateMatchTable(final List<SearchableItem> itemsToSearchIn, final String keyword) {
        // H2 memory DB
        final MatchUtils utils = new MatchUtils();
        final List<MatchResultRequest> results = new ArrayList<>();
        itemsToSearchIn.stream().forEach(result -> {
            final AtomicDouble matchSum = new AtomicDouble(0);
            final String[] words = String.valueOf(result.getValue()).split("\\W+");
            Arrays.stream(words).forEach(word -> {
                final double scoreByWord = (utils.levensteinRatio(word.toLowerCase(), keyword.toLowerCase()));
                matchSum.addAndGet(scoreByWord);
            });

            if (matchSum.get() > result.getMinScore()) {
                final MatchResultCategoryRequest category = MatchResultCategoryRequest.builder()
                        .title(result.getName())
                        .weight(result.getWeight())
                        .build();

                final MatchResultRequest request = MatchResultRequest.builder()
                        .relatedId(Integer.valueOf(result.getId()))
                        .category(category)
                        .keyword(result.getValue())
                        .score(matchSum.get() / words.length)
                        .build();

                // saving to MatchDB ..
                results.add(request);
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

        @Matchable(value = "product.name", weight = 1.00, minScore = 0.75)
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