package be.fooda.backend.matching.config;

import be.fooda.backend.commons.service.validator.MatchId;
import be.fooda.backend.commons.service.validator.Matchable;
import be.fooda.backend.matching.data.FoodaMatchingRepository;
import be.fooda.backend.matching.service.mapper.FoodaMatchingDtoMapper;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.System.out;

@Component
@Slf4j
@RequiredArgsConstructor
public class FoodaStartupRunner implements CommandLineRunner {

    private final FoodaMatchingDtoMapper dtoMapper;
    private final FoodaMatchingRepository matchingRepo;

    @Override
    public void run(final String... args) {
        final Product product = Product.builder()
                .id(125)
                .name("Pizza Margheritta").desc("An amazin Italian taste..! Ingredients. 1 12-inch round of pizza dough, stretched (see recipe) 3 tablespoons tomato sauce (see note) Extra-virgin olive oil. 2 ¾ ounces fresh mozzarella. 4 to 5 basil leaves, roughly torn.")
                .price(12.50)
                .city("Brussels")
                .imageUrl("https://fooda.be/pizzahut/pizza/pizza-margheritta.jpg")
                .build();

        out.println("-------------------------- MATCHING STARTED --------------------------");
        Arrays.asList("pizza", "margheritta", "italian", "basil", "tomato").forEach(keyword -> dtoMapper.objectToDto(product, keyword, 0.75).forEach(matchingRepo::save));
        out.println("--------------------------- MATCHING ENDED ---------------------------");

    }

    @Data
    @Builder
    static class Product {

        @MatchId
        @Matchable
        private Integer id;

        @Matchable(category = "product.name")
        private String name;

        @Matchable(category = "product.description", weight = 0.75)
        private String desc;

        @Matchable(category = "product.price", weight = 0.50)
        private Double price;

        @Matchable(category = "store.location.city", weight = 0.50)
        private String city;

        private String imageUrl;
    }

    @Data
    @Builder
    static class Ingredients {

        private Integer id;

        @Matchable(category = "ingredient.name", weight = 0.25)
        private String name;

        private Double price;
    }
}