package com.example.project101.Controller;

import com.example.project101.Repository.EvenementRepository;
import com.example.project101.Repository.GroupeRepository;
import com.example.project101.exception.RessourceNotFoundException;
import com.example.project101.model.Evenement;
import com.example.project101.model.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class GroupeController {

    @Autowired
    GroupeRepository groupeRepository;

    //Get all

    @GetMapping("/groupes")
    public List<Groupe> getAllGrp(){
        return groupeRepository.findAll();
    }
    @GetMapping("/groupes/{id}")
    public  Groupe getGroupeById(@PathVariable("id") String id){
        Groupe groupe =  groupeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Groupe", "id", id));
        return  groupe;
    }

    //create new student
    @PostMapping("/createGroupe")
    public Groupe createGroupe(@Valid @RequestBody Groupe groupe){

        return  groupeRepository.save(groupe);
    }

    //update student (find by id = cin)

    @PutMapping("/updateGrp/{id}")
    public Groupe updateGroupe(@PathVariable("id") String idgrp, @Valid@RequestBody Groupe groupeDetails){

        Groupe groupe =  groupeRepository.findById(idgrp).orElseThrow(() -> new RessourceNotFoundException("Groupe", "id", idgrp));

        groupe.setMatiere(groupeDetails.getMatiere());
        groupe.setNomEnseignant(groupeDetails.getNomEnseignant());
        groupe.setEtudiants(groupeDetails.getEtudiants());
        groupe.setNomGroupe(groupeDetails.getNomGroupe());



        Groupe updatedGrp = groupeRepository.save(groupe);
        return updatedGrp;


    }

    //Delete a student

    @DeleteMapping("/deleteGrp/{id}")
    public ResponseEntity<?> deleteGrp(@PathVariable("id") String idGrp){

        Groupe groupe = groupeRepository.findById(idGrp).orElseThrow(() -> new RessourceNotFoundException("Groupe", "id", idGrp));

        groupeRepository.delete(groupe);
        return ResponseEntity.ok().build();

    }




}




