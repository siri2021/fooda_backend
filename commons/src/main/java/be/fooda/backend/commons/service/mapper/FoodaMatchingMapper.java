package be.fooda.backend.commons.service.mapper;


import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchItemRes;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import be.fooda.backend.commons.service.util.FoodaMatchUtil;
import be.fooda.backend.commons.service.validator.MatchId;
import be.fooda.backend.commons.service.validator.Matchable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
public class FoodaMatchingMapper implements FoodaObjectMapper<FoodaMatchDto, FoodaMatchReq, FoodaMatchRes> {

    private final FoodaMatchUtil utils;

    @SneakyThrows
    public List<FoodaMatchDto> objectToDto(final Object matchableObject, final String keyword) {
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
                    dtoList.add(FoodaMatchDto.builder()
                            .relatedId(relatedId)
                            .category(getCategory(field))
                            .keyword(keyword)
                            .matched(word)
                            .weight(getWeight(field))
                            .score(utils.levensteinRatio(word.toLowerCase(), keyword.toLowerCase()))
                            .build());
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
    public FoodaMatchReq dtoToRequest(FoodaMatchDto foodaMatchDto) {
        return FoodaMatchReq.builder()
                .keywordSet(Set.of(foodaMatchDto.getKeyword()))
                .build();
    }

    @Override
    public FoodaMatchReq responseToRequest(FoodaMatchRes foodaMatchRes) {
        return FoodaMatchReq.builder()
                .session(foodaMatchRes.getSession())
                .keywordSet(foodaMatchRes.getResultSet().stream().map(FoodaMatchItemRes::getKeyword).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public FoodaMatchRes dtoToResponse(FoodaMatchDto foodaMatchDto) {
        return null;
    }

    @Override
    public FoodaMatchRes requestToResponse(FoodaMatchReq req) {
        return null;
    }

    @Override
    public FoodaMatchDto requestToDto(FoodaMatchReq req) {
        return null;
    }

    @Override
    public FoodaMatchDto responseToDto(FoodaMatchRes foodaMatchRes) {
        return null;
    }
}