package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.dto.FoodaContactDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaContactRepository extends JpaRepository<FoodaContactDto, Long> { }