package com.example.project101.Controller;



import com.example.project101.Repository.EtudiantRepository;

import com.example.project101.Service.EmailService;
import com.example.project101.Service.FileStorageService;
import com.example.project101.exception.RessourceNotFoundException;

import com.example.project101.model.Etudiant;
import com.example.project101.model.Groupe;
import com.example.project101.model.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/etudiant")
public class EtudiantCotroller {

    @Autowired
    EmailService emailService ;

    @Autowired
    EtudiantRepository etudiantRepository;

    //Get all

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEt(){
        return etudiantRepository.findAll();
    }
   //Get By Id
    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") String id){
        Etudiant etudiant =  etudiantRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Etudiant", "id", id));
        return  etudiant;
    }
    @Autowired
    private FileStorageService fileStorageService;

    //create new student
    @PostMapping("/createEt")
    public Etudiant createEt(Etudiant etudiant,@RequestParam("file") MultipartFile file){
         //System.out.println(etudiant);

        emailService.sendMail(etudiant.getEmail(),"inscription ",etudiant);

        // return etudiant ;

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        etudiant.setPath(fileDownloadUri);

        return  etudiantRepository.save(etudiant);


    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Etudiant> login(@RequestBody Identif identif) {

        Etudiant etudiant= etudiantRepository.findByEmailAndPassword(identif.getEmail(), identif.getPassword());

        if (etudiant != null) {

            return new ResponseEntity<Etudiant>(etudiant, HttpStatus.OK);

        }
        else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    //update student (find by id = cin)

    @PutMapping("/updateEt/{id}")
    public Etudiant updateEt(@PathVariable("id") String idEt, @Valid@RequestBody Etudiant etudiantDetails){

        Etudiant etudiant =  etudiantRepository.findById(idEt).orElseThrow(() -> new RessourceNotFoundException("Etudiant", "id", idEt));

       etudiant.setEmail(etudiantDetails.getEmail());
       etudiant.setNom(etudiantDetails.getNom());
       etudiant.setPassword(etudiantDetails.getPassword());
       etudiant.setPrenom(etudiantDetails.getPrenom());
       etudiant.setCin(etudiantDetails.getCin());
       /*etudiant.setCommentaires(etudiantDetails.getCommentaires());
       etudiant.setEnseignants(etudiantDetails.getEnseignants());*/



        Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        return updatedEtudiant;


    }

    //Delete a student

    @DeleteMapping("/deleteEt/{id}")
    public ResponseEntity<?> deleteEt(@PathVariable("id") String idEt){

        Etudiant etudiant = etudiantRepository.findById(idEt).orElseThrow(() -> new RessourceNotFoundException("Etudiant", "id", idEt));

        etudiantRepository.delete(etudiant);
        return ResponseEntity.ok().build();

    }




}

