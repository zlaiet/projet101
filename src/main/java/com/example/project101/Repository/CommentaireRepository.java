package com.example.project101.Repository;

import com.example.project101.model.Commentaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentaireRepository extends MongoRepository<Commentaire,String> {
}
