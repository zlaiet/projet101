package com.example.project101.Repository;

import com.example.project101.model.Enseignant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EnseignantRepository extends MongoRepository<Enseignant,String> {


    public List<Enseignant> findByNom(String nom);
    public Enseignant findByCin(String cin);
    public Enseignant findByEmailAndPassword(String email ,String password);
}
