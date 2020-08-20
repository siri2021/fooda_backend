package be.fooda.backend.commons.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.fooda.backend.commons.model.template.contact.dto.FoodaAddressDto;

@Repository
public interface FoodaAddressRepository extends CrudRepository<FoodaAddressDto, Long>{ }