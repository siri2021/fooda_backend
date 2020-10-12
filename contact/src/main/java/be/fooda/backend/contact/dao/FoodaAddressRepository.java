package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.dto.FoodaAddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaAddressRepository extends JpaRepository<FoodaAddressDto, Long> { }