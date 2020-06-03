package com.example.project101.Controller;

import com.example.project101.Repository.EnseignantRepository;

import com.example.project101.exception.RessourceNotFoundException;
import com.example.project101.model.Enseignant;

import com.example.project101.model.Etudiant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

    @Autowired
    EnseignantRepository enseignantRepository;

    //Get all
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/enseignants")
    public List<Enseignant> getAllEns(){
        return enseignantRepository.findAll();
    }
    //Get By Id
    @GetMapping("/enseignants/{id}")
    public Enseignant getEtudiantById(@PathVariable("id") String id){
        Enseignant enseignant =  enseignantRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Enseignant", "id", id));
        return  enseignant;
    }

    //create new student
    @PostMapping("/createEns")
    public Enseignant createEns(@Valid @RequestBody Enseignant enseignant){

        return  enseignantRepository.save(enseignant);
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Enseignant> login(@RequestBody Identif identif) {
        Enseignant enseignant= enseignantRepository.findByEmailAndPassword(identif.getEmail(), identif.getPassword());
        if (enseignant != null) {
            return new ResponseEntity<Enseignant>(enseignant, HttpStatus.OK);          }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);}     }


    //update student (find by id = cin)

    @PutMapping("/updateEns/{id}")
    public Enseignant updateEns(@PathVariable("id") String idEns, @Valid@RequestBody Enseignant enseignantDetails){

        Enseignant enseignant =  enseignantRepository.findById(idEns).orElseThrow(() -> new RessourceNotFoundException("Enseignant", "id", idEns));

        enseignant.setEmail(enseignantDetails.getEmail());
        enseignant.setNom(enseignantDetails.getNom());
        enseignant.setPassword(enseignantDetails.getPassword());
        enseignant.setPrenom(enseignantDetails.getPrenom());
        enseignant.setCin(enseignantDetails.getCin());
        /*
        enseignant.setCommentaires(enseignantDetails.getCommentaires());
        enseignant.setEvenements(enseignantDetails.getEvenements());
        enseignant.setPublications(enseignantDetails.getPublications());*/





        Enseignant updatedEns = enseignantRepository.save(enseignant);
        return updatedEns;


    }

    //Delete a student

    @DeleteMapping("/deleteEns/{id}")
    public ResponseEntity<?> deleteEns(@PathVariable("id") String idEns){

        Enseignant enseignant = enseignantRepository.findById(idEns).orElseThrow(() -> new RessourceNotFoundException("Enseignant", "id", idEns));

        enseignantRepository.delete(enseignant);
        return ResponseEntity.ok().build();

    }

    /*@PostMapping("/enseignantImage")
    public String uploadResources( HttpServletRequest servletRequest,
                                   @ModelAttribute Enseignant enseignant,
                                   Model model)
    {
        //Get the uploaded files and store them

        List<MultipartFile> files = enseignant.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                try
                {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        // Here, you can save the product details in database

        model.addAttribute("enseignant", enseignant);
        return "viewProductDetail";
    }
*/





}
