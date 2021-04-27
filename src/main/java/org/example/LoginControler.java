package org.example;

import org.example.core.Template;
import org.example.daos.LoginDao;
import org.example.modeles.Evenement;
import org.example.modeles.User;
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
        User firstUser = new User(1, "email@email.fr", "motDePasse");
        System.out.println(firstUser);
        modele.put("firstUser", firstUser);
        return Template.render("logout.html", modele);

    }

    public String displayAccount (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        String userPseudo = request.queryParams("user_Pseudo");
        String userMdp = request.queryParams("mdp");


        User firstUsers= loginDao.getUserByPseudo(userPseudo);


        System.out.println(firstUsers);
        System.out.println(userPseudo);
        System.out.println(userMdp);


        modele.put("account", firstUsers);

        return Template.render("monCompte.html", modele);
    }

    public String createAccount (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        String firstPrenom = request.queryParams("prenom");
        String firstNom = request.queryParams("nom");
        String firstPseudo = request.queryParams("pseudo");
        String firstPassword = request.queryParams("password");
        String firstTelephone = request.queryParams("telephone");
        String firstEmail = request.queryParams("email");
        User user = new User();


//       user.setPrenom(firstPrenom);
//
//      user.setNom(firstNom);
//
//       user.setPseudo(firstPseudo);
//
//        user.setPassword(firstPseudo);
//
//       user.setTelephone(firstTelephone);

//       user.setEmail(firstEmail);



         User theUser = loginDao.setNewUser(user);

        System.out.println(theUser);




        modele.put("accountCreation", theUser);

        return Template.render("creationCompte.html", modele);
    }


}
