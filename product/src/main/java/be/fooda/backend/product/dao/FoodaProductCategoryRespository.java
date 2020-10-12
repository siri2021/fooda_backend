package be.fooda.backend.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.fooda.backend.product.model.dto.FoodaProductCategoryDto;

@Repository
public interface FoodaProductCategoryRespository extends JpaRepository<FoodaProductCategoryDto, Long>{
    
    


}
