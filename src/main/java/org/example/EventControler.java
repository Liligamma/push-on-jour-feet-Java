package org.example;


import org.apache.commons.lang.ObjectUtils;
import org.example.core.Template;
import org.example.daos.EvenementDao;
import org.example.modeles.Evenement;
import org.example.modeles.User;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static spark.route.HttpMethod.before;

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
//  on récupère l'organisateur de l'événement
  User orgaEvent = evenementDao.getOrganisateur(eventid);
//  on récupère la liste des participants
  List<User> listeParticipants = evenementDao.getParticipants(eventid);

  System.out.println(orgaEvent.getPseudo());
  System.out.println(listeParticipants);



// on envoie au HTML l'index de l'événement en question à l'aide de la méthode put
  modele.put("detailEvenement", firstEvent);
  modele.put("organisateur", orgaEvent);
  modele.put("ListeParticipants", listeParticipants);
//  on retourne la page HTML de référence pour afficher les détails de l'événement 
  return  Template.render("detailsEvenements.html", modele);

 }

// fonction afficher le formulaire de création d'un événenemt
 public String displayEventForm (Request request, Response response) {

  Map<String, Object> modele = new HashMap<>();

 int userId = UserAuthenticate(request);

  return Template.render("nouvelEvenement.html", modele);
 }


 public String createEvent (Request request, Response response) throws ParseException {
  Map<String, Object > modele = new HashMap<>();
  Map<String, String> query = URLUtils.decodeQuery(request.body());



  Evenement event = new Evenement();
  String nom = query.get("nom");
  String date = query.get("date");
  String typeSortie = query.get("typeSortie");
  String latitude = query.get("latitude");
  String longitude = query.get("longitude");
  String commentaires = query.get("commentaires");


  SimpleDateFormat realDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

  Date myDate= realDate.parse(date);

  System.out.println(myDate);


  Double realLatitude = Double.parseDouble(latitude);
  Double realLongitude = Double.parseDouble(longitude);
  Boolean realType = Boolean.parseBoolean(typeSortie);

  System.out.println(myDate);

//  int userId = UserAuthenticate(request);
  int userId=0;
  Session session = request.session(false);
  Object userIdObj = session.attribute("currentUserId");
  userId = (Integer) userIdObj;

  java.sql.Date date_sql = new java.sql.Date(myDate.getTime());

  event.setNomEvenement(nom);
  event.setTypeEvent(realType);
  event.setDateEvenement(date_sql);
  event.setLatitude(realLatitude);
  event.setLongitude(realLongitude);
  event.setCommentairesEvenement(commentaires);
  event.setOrganisateurId(userId);



  Evenement myEvent = evenementDao.setNewEvent(event);

  modele.put("newEvent", myEvent);

  return Template.render("confirmationNewEvent.html", modele);
 }

 public String participation (Request request, Response response) {
  Map<String, Object > modele = new HashMap<>();

  String eventIdString = request.queryParamOrDefault("detail_id", "0");
  int eventid = Integer.parseInt(eventIdString);

  int userId=0;
  Session session = request.session(false);
  Object userIdObj = session.attribute("currentUserId");
  userId = (Integer) userIdObj;

  System.out.println(eventid);
  System.out.println(userId);

  int myUserId = evenementDao.setParticipants(eventid, userId);

  modele.put("participantId", myUserId);

  return Template.render("participation.html", modele);
 }





 public static int UserAuthenticate (Request request){
  Response response=null;

  Session session = request.session(false);
  int userId=0;

  if(session==null){

//            return Template.render("login.html", modele);
   response.redirect("/login");

  }

  Object userIdObj = session.attribute("currentUserId");
  if (userIdObj instanceof Integer) {
   userId = (Integer) userIdObj;
  } else if (userIdObj instanceof String) {
   userId = Integer.parseInt((String) userIdObj);
  } else {
   Spark.halt(401, "No valid session found");
  }

  return userId;
 }

}
