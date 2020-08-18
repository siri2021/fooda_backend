package be.fooda.backend.matching.service.utils;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class MatchUtils {

    private static final LevenshteinDistance lv = new LevenshteinDistance();

    public double levensteinRatio(final String s, final String s1) {
        return 1 - ((double) lv.apply(s, s1)) / Math.max(s.length(), s1.length());
    }
}