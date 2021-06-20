package org.example.modeles;

//J'initialise la classe Review//

import java.time.LocalDateTime;
import java.util.Date;

public class Review {
    int id;
    Date date;
    String contenuReview;
    int auteurId;
    String titre;

    Review review = new Review();

    public Review(int id, Date date, String contenuReview, int auteurId, String titre) {
        this.id = id;
        this.date = date;
        this.contenuReview = contenuReview;
        this.auteurId = auteurId;
        this.titre = titre;
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContenuReview() {
        return contenuReview;
    }

    public void setContenuReview(String contenuReview) {
        this.contenuReview = contenuReview;
    }

    public int getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(int auteurId) {
        this.auteurId = auteurId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
