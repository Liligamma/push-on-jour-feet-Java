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


 public String displayEvents(Request request, Response response) {
  Map<String, Object > modele = new HashMap<>();
  Evenements firstEvent = new Evenements(1, "15 avril 9h",  48, 2, "Sortie Running 10km au bois de boulogne", 2,
          "Rendez vous porte d'Auteuil devant la fontaine à 10h", 2);

  Evenements secondEvent = new Evenements(1, "17 avril 8h", 48, 2, "Sortie velo Lonchamps ", 1,
          "Rendez vous  Lonchamps à 8h", 2);

  Evenements thirdEvent = new Evenements(1, "25 avril 15h", 48, 2, "Sortie running 15km ", 1,
          "Rendez vous aux Buttes Chaumont à 15h", 2);

  Evenements fourthEvent = new Evenements(1, "30 avril 15h", 48, 2, "Sortie running 20km ", 1,
          "Rendez vous aux Buttes Chaumont à 12h", 2);


  ArrayList<Evenements> listeEvenements = new ArrayList<Evenements>();
  listeEvenements.add(firstEvent);
  listeEvenements.add(secondEvent);
  listeEvenements.add(thirdEvent);
  listeEvenements.add(fourthEvent);
  modele.put("listeEvenements", listeEvenements);

  return Template.render("evenements.html", modele);

 }
}
