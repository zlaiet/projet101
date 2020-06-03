package com.example.project101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document

public class Etudiant implements Serializable {

    @Id

    String cin;
    String nom;
    String prenom;
    String niveauEtude ;
    String password;
    String email;
    String path;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @DBRef(lazy = true)
    @JsonIgnoreProperties
    List<Enseignant> enseignants;
    @JsonIgnoreProperties
    @DBRef(lazy = true)
    List<Commentaire> commentaires;


    public Etudiant() {
    }

    public Etudiant(String cin, String nom, String prenom, String niveauEtude, String password, String email,String path) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.niveauEtude = niveauEtude;
        this.password = password;
        this.email = email;
        this.path = path;
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

    public String getNiveauEtude() {return niveauEtude;}

    public void setNiveauEtude(String niveauEtude) {this.niveauEtude = niveauEtude; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
*/
    @Override
    public String toString() {
        return "Etudiant{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}