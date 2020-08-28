package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.dto.FoodaContactDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaContactRepository extends CrudRepository<FoodaContactDto, Long>{ }