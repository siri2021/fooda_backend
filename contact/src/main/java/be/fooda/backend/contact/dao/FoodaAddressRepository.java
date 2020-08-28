package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.dto.FoodaAddressDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaAddressRepository extends CrudRepository<FoodaAddressDto, Long>{ }