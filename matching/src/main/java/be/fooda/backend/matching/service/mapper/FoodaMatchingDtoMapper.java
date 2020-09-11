package be.fooda.backend.matching.service.mapper;


import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.commons.service.validator.MatchId;
import be.fooda.backend.commons.service.validator.Matchable;
import be.fooda.backend.matching.model.dto.FoodaMatchDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
public class FoodaMatchingDtoMapper implements FoodaDtoMapper<FoodaMatchDto, FoodaMatchReq, FoodaMatchRes> {

    @SneakyThrows
    public List<FoodaMatchDto> objectToDto(final Object matchableObject, final String keyword) {
        return objectToDto(matchableObject, keyword, 0.50);
    }

    @SneakyThrows
    public List<FoodaMatchDto> objectToDto(final Object matchableObject, final String keyword, final Double minScore) {
        final Class<?> objectClass = requireNonNull(matchableObject).getClass();
        final List<FoodaMatchDto> dtoList = new ArrayList<>();
        final Optional<Field> idField = Arrays.stream(objectClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(MatchId.class)).findFirst();

        final Long relatedId;
        if (idField.isPresent()) {
            idField.get().setAccessible(true);
            relatedId = Long.parseLong(idField.get().get(matchableObject).toString());
        } else {
            relatedId = 0L;
        }

        for (final Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Matchable.class)) {
                Arrays.stream(getValue(field, matchableObject).split("\\W+")).forEach(word -> {
                    final double score = levensteinRatio(word.toLowerCase(), keyword.toLowerCase());
                    if (score >= minScore) {
                        dtoList.add(FoodaMatchDto.builder()
                                .relatedId(relatedId)
                                .category(getCategory(field))
                                .keyword(keyword)
                                .matched(word)
                                .weight(getWeight(field))
                                .score(score)
                                .build());
                    }
                });
            }
        }

        return dtoList;
    }

    private double getWeight(final Field field) {
        return field.getAnnotation(Matchable.class).weight();
    }

    private String getCategory(final Field field) {
        return field.getAnnotation(Matchable.class).category();
    }

    @SneakyThrows
    private String getValue(final Field field, final Object object) {
        return String.valueOf(field.get(object));
    }

    @Override
    public FoodaMatchDto requestToDto(FoodaMatchReq req) {
        return null;
    }

    @Override
    public FoodaMatchDto responseToDto(FoodaMatchRes foodaMatchRes) {
        return null;
    }

    @Override
    public FoodaMatchReq dtoToRequest(FoodaMatchDto foodaMatchDto) {
        return null;
    }

    @Override
    public FoodaMatchRes dtoToResponse(FoodaMatchDto foodaMatchDto) {
        return null;
    }

    private static final LevenshteinDistance lv = new LevenshteinDistance();

    public double levensteinRatio(final String s, final String s1) {
        return 1 - ((double) lv.apply(s, s1)) / Math.max(s.length(), s1.length());
    }
}