package be.fooda.backend.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.fooda.backend.product.model.dto.FoodaProductTagDto;

public interface FoodaProductTagRespository extends JpaRepository<FoodaProductTagDto, Long> {
    
    
}
