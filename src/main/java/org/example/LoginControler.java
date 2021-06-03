package org.example;

import org.example.core.Template;
import org.example.daos.EvenementDao;
import org.example.daos.LoginDao;
import org.example.modeles.Evenement;
import org.example.modeles.User;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LoginControler {

    LoginDao loginDao = new LoginDao();
    EvenementDao EvenementDao = new EvenementDao();

    public String displayLogin(Request request, Response response){
        if(request.requestMethod().equals("POST")){
            Map<String, Object > modele = new HashMap<>();
            Map<String, String> query = URLUtils.decodeQuery(request.body());


            String userPseudo = query.get("pseudo");
            String userMdp = query.get("password");

            try {
                User firstUsers= loginDao.getUserByPseudo(userPseudo, userMdp);
                System.out.println("ca marche partie 2");
                modele.put("authenticationSucceeded", true);

                request.session(true).attribute("currentUserId",firstUsers.getId());
                response.cookie("currentUserId", ""+ firstUsers.getId());


                response.redirect("/account");



                return null;

            }
            catch (Exception e){
                modele.put("authenticationFailed", true);
                System.out.println("ca ne marche pas partie 2");
                response.redirect("/error");
                return null;

            }

        }

        else {

            Map<String, Object > modele = new HashMap<>();
            return Template.render("login.html", modele);

        }

    }

    public String displayLogout (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        User firstUser = new User();
        System.out.println(firstUser);
        modele.put("firstUser", firstUser);
        return Template.render("logout.html", modele);

    }

    public String displayAccount (Request request, Response response){

        Map<String, Object > modele = new HashMap<>();

        int userId = UserAuthenticate(request, response);
//

            User firstUsers = loginDao.getUserById(userId);
            List<Evenement> listeEvenementsInAccount = EvenementDao.getEventInAccount(userId);
            List<Evenement> createdEventList = EvenementDao.getEventCreated(userId);
            List<User> listeParticipants = EvenementDao.getParticipants(eventid);


            modele.put("account", firstUsers);
            modele.put("listeEventInAccount", listeEvenementsInAccount);
            modele.put ("createdEventList", createdEventList);

            return Template.render("monCompte.html", modele);


    }



    public String createAccount (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        Map<String, String> query = URLUtils.decodeQuery(request.body());

        User user = new User();

        String firstPrenom = query.get("prenom");
        String firstNom = query.get("nom");
        String firstPseudo = query.get("pseudo");
        String firstPassword = query.get("password");
        String firstTelephone = query.get("telephone");
        String firstEmail = query.get("email");


      user.setPrenom(firstPrenom);
      user.setNom(firstNom);
      user.setPseudo(firstPseudo);
      user.setPassword(firstPassword);
      user.setTelephone(firstTelephone);
      user.setEmail(firstEmail);

        System.out.println(firstPrenom);
        System.out.println(user);
        System.out.println(user.telephone);


     User theUser = loginDao.setNewUser(user);


       modele.put("accountCreation", theUser);

        return Template.render("creationCompte.html", modele);
    }


    public static int UserAuthenticate (Request request, Response response){
//        Response response=null;
        Session session = request.session(false);
        int userId=0;
        System.out.println(session);
        if(session==null){

//            return Template.render("login.html", modele);
            response.redirect("/login");

        }
        else {
            Object userIdObj = session.attribute("currentUserId");
            if (userIdObj instanceof Integer) {
                userId = (Integer) userIdObj;
            } else if (userIdObj instanceof String) {
                userId = Integer.parseInt((String) userIdObj);
            } else {
                Spark.halt(401, "No valid session found");
            }
        }
            return userId;

    }

}
