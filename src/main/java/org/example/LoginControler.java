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
        String userName = "Magali";
        int age =23;
        Map<String, Object > modele = new HashMap<>();
        modele.put("user", userName);
        modele.put ("age", age);
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

        User userCo = new User();

        String userPseudo = query.get("pseudo");
        String userMdp = query.get("password");


       User firstUsers= loginDao.getUserByPseudo(userPseudo, userMdp);


        modele.put("account", firstUsers);

        if (firstUsers.prenom==null){
            return Template.render("loginIssue.html", modele);


        }


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


}
