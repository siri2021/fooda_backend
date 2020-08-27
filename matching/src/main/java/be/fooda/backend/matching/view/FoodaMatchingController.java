package be.fooda.backend.matching.view;

import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import be.fooda.backend.commons.service.mapper.FoodaMatchingMapper;
import be.fooda.backend.matching.service.flow.FoodaMatchingFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/match")
public class FoodaMatchingController {

    @Autowired
    private FoodaMatchingFlow<FoodaMatchDto, FoodaMatchReq, FoodaMatchRes> matchingFlow;

    @Autowired
    private FoodaMatchingMapper matchingMapper;

    @GetMapping
    public ResponseEntity<List<FoodaMatchRes>> apiGetMatchProduct(@RequestBody @Valid final Object req) {
        return null;
    }
}
