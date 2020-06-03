package com.example.project101.Controller;

import com.example.project101.Repository.EtudiantRepository;
import com.example.project101.Repository.EvenementRepository;
import com.example.project101.exception.RessourceNotFoundException;
import com.example.project101.model.Etudiant;
import com.example.project101.model.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/evenements")
public class EventController {
    @Autowired
    EvenementRepository evenementRepository;

    //Get all

    @GetMapping("/evenement")
    public List<Evenement> getAllEt(){
        return evenementRepository.findAll();
    }
    //GET By Id
    @GetMapping("/evenement/{id}")
    public Evenement getEvenementById(@PathVariable("id") String id){
        Evenement evenement =  evenementRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Evenement", "id", id));
        return  evenement;
    }

    //create new student
    @PostMapping("/createEvent")
    public Evenement createEvent(@Valid @RequestBody Evenement evenement){

        return  evenementRepository.save(evenement);
    }

    //update student (find by id = cin)

    @PutMapping("/updateEvent/{id}")
    public Evenement updateEvent(@PathVariable("id") String idEt, @Valid@RequestBody Evenement evenementDetails){

        Evenement evenement =  evenementRepository.findById(idEt).orElseThrow(() -> new RessourceNotFoundException("Evenement", "id", idEt));


        evenement.setDate(evenementDetails.getDate());
        evenement.setDescription(evenementDetails.getDescription());
        evenement.setEnseignant(evenementDetails.getEnseignant());
        evenement.setTitre(evenementDetails.getTitre());




        Evenement updatedEvent = evenementRepository.save(evenement);
        return updatedEvent;


    }

    //Delete a student

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") String idEt){

        Evenement evenement = evenementRepository.findById(idEt).orElseThrow(() -> new RessourceNotFoundException("Evenement", "id", idEt));

        evenementRepository.delete(evenement);
        return ResponseEntity.ok().build();

    }




}

