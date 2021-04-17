package org.example.modeles;

//J'initialise la classe Evenements//

import java.time.LocalDateTime;

public class Evenements {
    int id;
    String dateEvenement;
    double latitude;
    double longitude;
    String nomEvenement;
    int organisateurId;
    String commentairesEvenement;
    int participants;

    public Evenements(int id, String dateEvenement, double latitude, double longitude, String nomEvenement, int organisateurId, String commentairesEvenement, int participants) {
        this.id = id;
        this.dateEvenement = dateEvenement;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomEvenement = nomEvenement;
        this.organisateurId = organisateurId;
        this.commentairesEvenement = commentairesEvenement;
        this.participants = participants;
    }

    public String getdateEvenement()
    {return dateEvenement;}

    public void setDateEvenement(String id)
    { this.dateEvenement = dateEvenement;}

    public String getnomEvenement()
    {return nomEvenement;}

    public void setNomEvenement(String id)
    { this.nomEvenement = nomEvenement;}

    public String getcommentairesEvenement()
    {return commentairesEvenement;}

    public void setCommentairesEvenement(String id)
    { this.commentairesEvenement = commentairesEvenement;}


//    @Override
//    public String toString(){
//        return "Quand ?\r\n" + dateEvenement + "Quoi ?\r\n" + nomEvenement +"Commentaires : \r\n" + commentairesEvenement;
//    }
}
