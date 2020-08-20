package be.fooda.backend.commons.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.fooda.backend.commons.model.template.contact.dto.FoodaContactDto;

@Repository
public interface FoodaContactRepository extends CrudRepository<FoodaContactDto, Long>{ }