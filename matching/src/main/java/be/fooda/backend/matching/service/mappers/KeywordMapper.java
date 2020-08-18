package be.fooda.backend.matching.service.mappers;

import static java.util.Objects.requireNonNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import be.fooda.backend.matching.service.flow.exception.MatchingException;

public class KeywordMapper {
	// Java Reflection API
	public List<SearchableItem> match(final Object object) throws MatchingException {

		try {
			final Class<?> objectClass = requireNonNull(object).getClass();
			final List<SearchableItem> results = new ArrayList<>();

			for (final Field field : objectClass.getDeclaredFields()) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(Matchable.class)) {
					results.add(SearchableItem.builder().name(getName(field)).value(String.valueOf(field.get(object)))
							.weight(getWeight(field)).build());
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

	private static String getName(final Field field) {
		return field.getAnnotation(Matchable.class).value();
	}
}