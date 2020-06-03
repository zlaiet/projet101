package com.example.project101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
public class Groupe implements Serializable {

    @Id
    String idGroupe;
    String nomGroupe;
    String matiere;
    String nomEnseignant;

    @DBRef(lazy = true)
    @JsonIgnoreProperties
    List<Etudiant> etudiants;

    public Groupe() {
    }

    public Groupe(String idGroupe, String nomGroupe, String matiere, String nomEnseignant, List<Etudiant> etudiants) {
        this.idGroupe = idGroupe;
        this.nomGroupe = nomGroupe;
        this.matiere = matiere;
        this.nomEnseignant = nomEnseignant;
        this.etudiants = etudiants;
    }

    public String getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(String idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }


}

