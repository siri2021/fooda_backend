package be.fooda.backend.matching.config;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import be.fooda.backend.matching.model.request.MatchResultCategoryRequest;
import be.fooda.backend.matching.model.request.MatchResultRequest;
import be.fooda.backend.matching.repository.MatchResultRepository;
import be.fooda.backend.matching.service.mappers.KeywordMapper;
import be.fooda.backend.matching.service.mappers.SearchableItem;
import be.fooda.backend.matching.service.utils.MatchUtils;
import be.fooda.backend.matching.service.mappers.Matchable;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

        final Product p = Product.builder()
                .id(1)
                .name("Pizza Margheritta")
                .desc("Ingredients. 1 12-inch round of pizza dough, stretched (see recipe) 3 tablespoons tomato sauce (see note) Extra-virgin olive oil. 2 ¾ ounces fresh mozzarella. 4 to 5 basil leaves, roughly torn.")
                .price(12.50)
                .city("Brussels")
                .imageUrl("https://fooda.be/pizzahut/pizza/pizza-margheritta.jpg")
                .build();

        out.println("-------------------------- MATCHING STARTED --------------------------");
        final List<SearchableItem> itemsToSearchIn = mapper.match(p);
        itemsToSearchIn.forEach(out::println);
        out.println("-------------------------- MATCHING STARTED --------------------------");
        // H2 memory DB
        out.println("-------------------------- TEMP DB TRANSACTION IS STARTED --------------------------");
        final MatchUtils utils = new MatchUtils();
        itemsToSearchIn.stream()
        .map(result -> 
            MatchResultRequest.builder()
            .category(MatchResultCategoryRequest.builder().title(result.getName()).weight(result.getWeight()).build())
            .keyword(String.valueOf(result.getValue()))
            .score(utils.levensteinRatio(result.getValue(), "pizza"))
            .build()
        ).forEach(repo::save);
        out.println("-------------------------- TEMP DB TRANSACTION IS STARTED --------------------------");
    }

    @Data
    @Builder
    static class Product {
        
        private Integer id;
        
        @Matchable(value = "product.name", weight = 1.00)
        private String name;
        
        @Matchable(value = "product.description", weight = 0.75)
        private String desc;
        
        @Matchable(value = "product.price", weight = 0.50)
        private Double price;

        @Matchable(value = "store.location", weight = 0.50)
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