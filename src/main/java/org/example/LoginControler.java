package org.example;

import org.example.core.Template;
import org.example.daos.LoginDao;
import org.example.modeles.Evenement;
import org.example.modeles.User;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;



public class LoginControler {

    LoginDao loginDao = new LoginDao();

    public String displayLogin(Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        return Template.render("login.html", modele);

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
        Map<String, String> query = URLUtils.decodeQuery(request.body());


        String userPseudo = query.get("pseudo");
        String userMdp = query.get("password");


       User firstUsers= loginDao.getUserByPseudo(userPseudo, userMdp);



        if (firstUsers.password.equals(userMdp)){
           System.out.println("ca marche partie 2");
           modele.put("authenticationSucceeded", true);
           boolean authenticated = true;

             request.session(true).attribute("currentUserId",firstUsers.getId());


            modele.put("account", firstUsers);

            return Template.render("monCompte.html", modele);

       }

        else {
            modele.put("authenticationFailed", true);
            System.out.println("ca ne marche pas partie 2");
            return Template.render("loginIssue.html", modele);
        }


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


}
