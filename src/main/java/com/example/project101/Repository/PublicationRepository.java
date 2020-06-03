package com.example.project101.Repository;

import com.example.project101.model.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicationRepository extends MongoRepository<Publication,String> {
}
