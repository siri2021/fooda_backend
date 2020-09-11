package be.fooda.backend.matching.service.flow.impl;

import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.matching.service.flow.FoodaMatchingFlow;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class FoodaMatchingFlowImpl implements FoodaMatchingFlow {

    private final FoodaDtoMapper dtoMapper;

    @Override
    public void createMatch(FoodaMatchReq req) {

    }

    @Override
    public void updateMatch(Long id, FoodaMatchReq req) {

    }

    @Override
    public void deleteMatch(Long id) {

    }

    @Override
    public Collection<FoodaMatchRes> getMatches() {
        return null;
    }
}
