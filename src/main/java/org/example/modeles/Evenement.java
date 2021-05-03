package org.example.modeles;

//J'initialise la classe Evenements//

import java.time.LocalDateTime;

public class Evenement {
    int id;
    String dateEvenement;
    double latitude;
    double longitude;
    String nomEvenement;
    int organisateurId;
    boolean typeEvent;
    String commentairesEvenement;
    int participants;

    public Evenement(int id, String dateEvenement, double latitude, double longitude, String nomEvenement, int organisateurId, boolean typeEvent ,String commentairesEvenement) {
        this.id = id;
        this.dateEvenement = dateEvenement;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomEvenement = nomEvenement;
        this.organisateurId = organisateurId;
        this.typeEvent = typeEvent;
        this.commentairesEvenement = commentairesEvenement;


    }

    public Evenement(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public int getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(int organisateurId) {
        this.organisateurId = organisateurId;
    }

    public boolean gettypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(boolean typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getCommentairesEvenement() {
        return commentairesEvenement;
    }

    public void setCommentairesEvenement(String commentairesEvenement) {
        this.commentairesEvenement = commentairesEvenement;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    @Override
 public String toString(){
        return "Quand ?\r\n" + dateEvenement + "Quoi ?\r\n" + nomEvenement +"Commentaires : \r\n" + commentairesEvenement;
    }
}
