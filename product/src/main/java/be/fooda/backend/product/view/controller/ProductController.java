package be.fooda.backend.product.view.controller;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.product.dao.FoodaProductRepository;
import be.fooda.backend.product.model.dto.FoodaProductDto;
import be.fooda.backend.product.service.mapper.FoodaProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private FoodaProductRepository productRepo;
    private FoodaProductDtoMapper productDtoMapper;

    @GetMapping("/getAll")
    public List<FoodaProductRes> apiGetAllProducts() {
        Iterable<FoodaProductDto> dtoList = productRepo.findAll();
        return stream(dtoList.iterator()).map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public FoodaProductRes apiAddProduct(final FoodaProductReq req) {
        FoodaProductDto productDto = productDtoMapper.requestToDto(req);
        FoodaProductDto addedProduct = productRepo.save(productDto);
        return productDtoMapper.dtoToResponse(addedProduct);
    }

    public static <T> Stream<T> stream(Iterator<T> iterator) {
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);

        // Get a Sequential Stream from spliterator
        return StreamSupport.stream(spliterator, false);
    }
}