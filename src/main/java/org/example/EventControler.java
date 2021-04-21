package org.example;


import org.example.core.Template;
import org.example.modeles.Evenements;
import org.example.modeles.User;
import spark.Request;
import spark.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventControler {
// on crée l'array list ici pour pouvoir y avoir accès dans toutes les méthodes de la classe EventControler. Cette ArrayList comporte tous les évènement créés
 ArrayList<Evenements> listeEvenements = new ArrayList<Evenements>();

// on créée la méthodes displayEvent pour pouvoir afficher tous les évènement créés. A l'intérieur de cette méthode on créée les objets de types Evenements
 public String displayEvents(Request request, Response response) {
  Map<String, Object > modele = new HashMap<>();
  Evenements firstEvent = new Evenements(1, "15 avril 9h",  48, 2, "Sortie Running 10km au bois de boulogne", 2,
          "Rendez vous porte d'Auteuil devant la fontaine à 10h", 2);

  Evenements secondEvent = new Evenements(2, "17 avril 8h", 48, 2, "Sortie velo Lonchamps ", 1,
          "Rendez vous  Lonchamps à 8h", 2);

  Evenements thirdEvent = new Evenements(3, "25 avril 15h", 48, 2, "Sortie running 15km ", 1,
          "Rendez vous aux Buttes Chaumont à 15h", 2);

  Evenements fourthEvent = new Evenements(4, "30 avril 15h", 48, 2, "Sortie running 20km ", 1,
          "Rendez vous aux Buttes Chaumont à 12h", 2);

// on efface l'arrayList qui a été créé par défaut au dessus lors de l'initialisation,
 listeEvenements.clear();
// on ajoute les objets de type evenement dans l'arraylist
  listeEvenements.add(firstEvent);
  listeEvenements.add(secondEvent);
  listeEvenements.add(thirdEvent);
  listeEvenements.add(fourthEvent);
//  on envoie au modele HTML la liste des événements, on lui attribue un nom de variable spécialement pour le HTML
  modele.put("listeEvenements", listeEvenements);

// Cette fonction retourne le template HTML qui va nous servir à afficher les événements à l'écran
  return Template.render("evenements.html", modele);

 }

// on créée la méthode eventDetails qui va nous permettre d'afficher les détails d'un événement spécifique sur une autre page
 public String eventDetails (Request request, Response response){
  Map<String, Object > modele = new HashMap<>();
//  on initialise le queryparameter qui correspond à l'id de l'événement que l'on veut afficher
  String eventId = request.queryParamOrDefault("detail_id", "0");
//  System.out.println("coucou c'est moi");
//  on initialise la variable indexEvenement qui va stocker l'index de l'évènement qu'on recherche et dont on a l'id
  int indexEvenement=0;
//  on parcours la liste des événement à l'aide d'un for pour trouver l'événement qui possède l'id correspondant au queryparam
  for (int i=0; i< listeEvenements.size(); i++){
//   on s'arrête quand on trouve l'id d'un événement qui est égal au queryparam eventId et on stock l'index de l'évènement dans la variable indexEvenement
  if (listeEvenements.get(i).getidEvenement() == Integer.parseInt(eventId)) {
   indexEvenement = i;
   }
  }
// on envoie au HTML l'index de l'événement en question à l'aide de la méthode put
  modele.put("detailEvenement", listeEvenements.get(indexEvenement));
//  on retourne la page HTML de référence pour afficher les détails de l'événement 
  return  Template.render("detailsEvenements.html", modele);
 }

}
