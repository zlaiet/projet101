package com.example.project101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Document
public class Enseignant implements Serializable {

    @Id
    String cin;
    String nom;
    String prenom;
    String email;
    String password;
   /* @JsonIgnoreProperties
    public List<MultipartFile> getImages() {
        return images;
    }
      @JsonIgnoreProperties
    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    @JsonIgnoreProperties
    private List<MultipartFile> images;
    */
    /*Admin admin;
    @DBRef(lazy = true)
    List<Publication> publications;
    @DBRef(lazy = true)
    List<Evenement> evenements;
    @DBRef(lazy = true)
    List<Commentaire> commentaires;
    @DBRef(lazy = true)
    List<Etudiant> etudiants;*/


    public Enseignant() {
    }

    public Enseignant(String cin, String nom, String prenom, String email, String password, List<MultipartFile> images) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;

       // this.images = images;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   /*
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
*/

    @Override
    public String toString() {
        return "Enseignant{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }}