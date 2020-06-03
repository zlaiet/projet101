package com.example.project101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class Evenement implements Serializable {

    @Id
    String id;
    String titre;
    Date date;
    String description;
    @JsonIgnoreProperties
    @DBRef(lazy = true)
    Enseignant enseignant;

    public Evenement() {
    }

    public Evenement(String id, String titre, Date date, String description, Enseignant enseignant) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.enseignant = enseignant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }


}

