package com.example.project101.Repository;

import com.example.project101.model.Evenement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvenementRepository extends MongoRepository<Evenement,String> {
}
