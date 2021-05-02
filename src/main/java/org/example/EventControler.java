package org.example;


import org.apache.commons.lang.ObjectUtils;
import org.example.core.Template;
import org.example.daos.EvenementDao;
import org.example.modeles.Evenement;
import org.example.modeles.User;
import spark.Request;
import spark.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventControler {
 EvenementDao evenementDao = new EvenementDao();
// on crée l'array list ici pour pouvoir y avoir accès dans toutes les méthodes de la classe EventControler. Cette ArrayList comporte tous les évènement créés


// on créée la méthodes displayEvent pour pouvoir afficher tous les évènement créés. A l'intérieur de cette méthode on créée les objets de types Evenements
 public String displayEvents(Request request, Response response) {
  Map<String, Object > modele = new HashMap<>();

  List<Evenement> listeEvenements = evenementDao.getAllEvenements();

  modele.put("listeEvenements", listeEvenements);

// Cette fonction retourne le template HTML qui va nous servir à afficher les événements à l'écran
  return Template.render("evenements.html", modele);

 }

// on créée la méthode eventDetails qui va nous permettre d'afficher les détails d'un événement spécifique sur une autre page
 public String eventDetails (Request request, Response response){
  Map<String, Object > modele = new HashMap<>();
//  on initialise le queryparameter qui correspond à l'id de l'événement que l'on veut afficher
  String eventIdString = request.queryParamOrDefault("detail_id", "0");
  int eventid = Integer.parseInt(eventIdString);
  Evenement firstEvent= evenementDao.getEvenementById(eventid);
  User orgaEvent = evenementDao.getOrganisateur(eventid);
//  List <User> ListeParticipants = evenementDao.getParticipants(eventid);
  
  System.out.println(orgaEvent.getPseudo());


// on envoie au HTML l'index de l'événement en question à l'aide de la méthode put
  modele.put("detailEvenement", firstEvent);
  modele.put("organisateur", orgaEvent);
  modele.put("participants", )
//  on retourne la page HTML de référence pour afficher les détails de l'événement 
  return  Template.render("detailsEvenements.html", modele);

 }

 public String displayEventForm (Request request, Response response) {
  Map<String, Object> modele = new HashMap<>();

  return Template.render("nouvelEvenement.html", modele);
 }

 public String createEvent (Request request, Response response){
  Map<String, Object > modele = new HashMap<>();

  return Template.render("confirmationNewEvent.html", modele);
 }

}
