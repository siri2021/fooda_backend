package be.fooda.backend.matching.service.mappers;

import be.fooda.backend.matching.service.flow.exception.MatchingException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * REFLECTION API
 */
public class KeywordMapper {
	public List<SearchableItem> match(final Object object) throws MatchingException {
		try {
			final Class<?> objectClass = requireNonNull(object).getClass();
			final List<SearchableItem> results = new ArrayList<>();
			final Optional<Field> idField = Arrays.stream(objectClass.getDeclaredFields())
					.filter(field -> field.isAnnotationPresent(MatchId.class)).findFirst();

			final String relatedId;
			if (idField.isPresent()) {
				idField.get().setAccessible(true);
				relatedId = String.valueOf(idField.get().get(object));
			} else {
				relatedId = "-1";
			}

			for (final Field field : objectClass.getDeclaredFields()) {
				field.setAccessible(true);

				if (field.isAnnotationPresent(Matchable.class)) {
					final SearchableItem searchableItem = SearchableItem.builder()
							.id(relatedId)
							.name(getName(field))
							.value(String.valueOf(field.get(object)))
							.weight(getWeight(field))
							.minScore(getMinScore(field))
							.build();

					results.add(searchableItem);
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