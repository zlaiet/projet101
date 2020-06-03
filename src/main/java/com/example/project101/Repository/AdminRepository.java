package com.example.project101.Repository;

import com.example.project101.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdminRepository extends MongoRepository<Admin,String> {



    public List<Admin> findByNom(String nom);
    public Admin findByCin(String cin);

}
