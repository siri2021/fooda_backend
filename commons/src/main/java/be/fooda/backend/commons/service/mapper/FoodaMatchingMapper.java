package be.fooda.backend.commons.service.mapper;


import be.fooda.backend.commons.model.template.matching.request.FoodaMatchCategoryReq;
import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.service.exception.MatchingException;
import be.fooda.backend.commons.service.validator.MatchId;
import be.fooda.backend.commons.service.validator.Matchable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class FoodaMatchingMapper {

	public List<FoodaMatchReq> objectToRequest(final Object object) throws MatchingException {
		try {
			final Class<?> objectClass = requireNonNull(object).getClass();
			final List<FoodaMatchReq> results = new ArrayList<>();
			final Optional<Field> idField = Arrays.stream(objectClass.getDeclaredFields())
					.filter(field -> field.isAnnotationPresent(MatchId.class)).findFirst();

			final Long relatedId;
			if (idField.isPresent()) {
				idField.get().setAccessible(true);
				relatedId = Long.parseLong(idField.get().get(object).toString());
			} else {
				relatedId = 0L;
			}

			for (final Field field : objectClass.getDeclaredFields()) {
				field.setAccessible(true);

				if (field.isAnnotationPresent(Matchable.class)) {
					final FoodaMatchReq req = FoodaMatchReq.builder()
							.relatedId(relatedId)
							.keyword(getName(field))
							.matched(String.valueOf(field.get(object)))
							.minScore(getMinScore(field))
							.category(FoodaMatchCategoryReq.builder().weight(getWeight(field)).build())
							.build();

					results.add(req);
				}
			}

			return results;
		} catch (final IllegalAccessException e) {
			throw new MatchingException(e.getMessage());
		}
	}

	private static double getWeight(final Field field) {
		return field.getAnnotation(Matchable.class).weight();
	}

	private static double getMinScore(final Field field) {
		return field.getAnnotation(Matchable.class).minScore();
	}

	private static String getName(final Field field) {
		return field.getAnnotation(Matchable.class).value();
	}
}