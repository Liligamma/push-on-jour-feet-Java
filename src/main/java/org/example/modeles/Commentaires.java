package org.example.modeles;

//J'initialise la classe commentaires des review//

public class Commentaires {
    int id;
    long dateCommentaire;
    String contenu;
    int reviewId;
    int commentateurId;

    public Commentaires(int id, long dateCommentaire, String contenu, int reviewId, int commentateurId) {
        this.id = id;
        this.dateCommentaire = dateCommentaire;
        this.contenu = contenu;
        this.reviewId = reviewId;
        this.commentateurId = commentateurId;
    }
}

