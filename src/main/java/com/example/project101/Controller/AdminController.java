package com.example.project101.Controller;

import com.example.project101.Repository.AdminRepository;
import com.example.project101.exception.RessourceNotFoundException;
import com.example.project101.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

   @Autowired
    AdminRepository adminRepository;

   //Get all

     @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
         return adminRepository.findAll();
     }

     //create new admin
    @PostMapping("/create")
    public Admin createAdmin(@Valid@RequestBody Admin admin){

         return  adminRepository.save(admin);
    }

    //update admin (find by id = cin)

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable("id") String idAd,@Valid@RequestBody Admin adminDetails){

         Admin admin =  adminRepository.findById(idAd).orElseThrow(() -> new RessourceNotFoundException("Admin", "id", idAd));

         admin.setCin(adminDetails.getCin());
         admin.setEmail(adminDetails.getEmail());
         admin.setEnseignants(adminDetails.getEnseignants());
         admin.setNom(adminDetails.getNom());
         admin.setPassword(adminDetails.getPassword());
         admin.setPrenom(adminDetails.getPrenom());

         Admin updatedAdmin = adminRepository.save(admin);
         return updatedAdmin;


     }

     //Delete an

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") String idAd){

         Admin admin = adminRepository.findById(idAd).orElseThrow(() -> new RessourceNotFoundException("Admin", "id", idAd));

         adminRepository.delete(admin);
         return ResponseEntity.ok().build();

    }




}
