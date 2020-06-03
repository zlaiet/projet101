package com.example.project101.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document
public class Publication  implements Serializable {

    @Id
    String id;
    Date dateAjout;
    String contenu;
    @DBRef(lazy = true)
    Enseignant enseignant;
    @DBRef(lazy = true)
    List<Commentaire> commentaires;

    public Publication() {
    }

    public Publication(String id, Date dateAjout, String contenu, Enseignant enseignant, List<Commentaire> commentaires) {
        this.id = id;
        this.dateAjout = dateAjout;
        this.contenu = contenu;
        this.enseignant = enseignant;
        this.commentaires = commentaires;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                ", dateAjout=" + dateAjout +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
