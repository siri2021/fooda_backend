package be.fooda.backend.matching.service.flow;

import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;

import java.util.Collection;

public interface FoodaMatchingFlow {
    void createMatch(final FoodaMatchReq req);

    void updateMatch(final Long id, FoodaMatchReq req);

    void deleteMatch(final Long id);

    Collection<FoodaMatchRes> getMatches();
}
