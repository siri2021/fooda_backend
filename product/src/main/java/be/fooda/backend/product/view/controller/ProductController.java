package be.fooda.backend.product.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.fooda.backend.commons.dao.repo.FoodaProductRepository;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductDto;
import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.commons.service.mapper.FoodaProductMapper;
import lombok.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private FoodaProductRepository productRepo;
    private FoodaProductMapper productMapper;

    @GetMapping("/getAll")
    public List<FoodaProductRes> apiGetAllProducts() {
        List<FoodaProductDto> dtoList = productRepo.findAll();
        return dtoList.stream().map(productMapper::dtoToResponse).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public FoodaProductRes apiAddProduct(final FoodaProductReq req) {
        FoodaProductDto productDto = productMapper.requestToDto(req);
        FoodaProductDto addedProduct = productRepo.save(productDto);
        return productMapper.dtoToResponse(addedProduct);
    }
}