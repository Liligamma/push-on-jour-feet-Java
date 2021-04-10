package org.example.modeles;

//J'initialise la classe Review//

import java.time.LocalDateTime;

public class review {
    int id;
    long date;
    String contenuReview;
    int auteurId;

    public review(int id, long date, String contenuReview, int auteurId) {
        this.id = id;
        this.date = date;
        this.contenuReview = contenuReview;
        this.auteurId = auteurId;
    }
}
