package be.fooda.backend.media.dao;

import be.fooda.backend.media.model.dto.FoodaMediaProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaMediaProductRepository extends CrudRepository<FoodaMediaProductDto, Long> {
}
