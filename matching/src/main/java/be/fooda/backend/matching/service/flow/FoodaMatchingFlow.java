package be.fooda.backend.matching.service.flow;

import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.service.util.FoodaMatchUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodaMatchingFlow<DTO, REQ, RES> {

    private final FoodaMatchUtil utils;

    public void startSearch(final String keyword, final Object matchableObject) {

    }

    private List<FoodaMatchDto> generateMatchTable(final List<FoodaMatchReq> itemsToSearchIn, final String keyword) {
        return null;
    }


}
