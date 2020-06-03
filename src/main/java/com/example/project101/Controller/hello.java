package com.example.project101.Controller;

import com.example.project101.Repository.EtudiantRepository;
import com.example.project101.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class hello {
    @Autowired
    EtudiantRepository etudiantRepository;

    @GetMapping("/")
    public List<Etudiant> getAllEt(){
        return etudiantRepository.findAll();
    }

}
