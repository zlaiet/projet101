package com.example.project101.Repository;

import com.example.project101.model.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeRepository extends MongoRepository<Groupe,String> {
}
