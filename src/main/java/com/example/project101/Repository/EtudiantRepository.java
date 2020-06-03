package com.example.project101.Repository;

import com.example.project101.model.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EtudiantRepository extends MongoRepository<Etudiant,String> {



    public List<Etudiant> findByNom(String nom);
    public Etudiant findByCin(String cin);
    public Etudiant findByEmailAndPassword(String email,String password);
    public List<Etudiant> findByNiveauEtude(String nv);


}
