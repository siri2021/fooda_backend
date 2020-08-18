package be.fooda.backend.matching.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.fooda.backend.matching.model.request.MatchResultRequest;

@Repository
public interface MatchResultRepository extends CrudRepository<MatchResultRequest, BigInteger>{
    
}