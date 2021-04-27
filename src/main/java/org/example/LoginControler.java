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


        modele.put("account", firstUsers);

        return Template.render("monCompte.html", modele);
    }

    public String createAccount (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();
        User user = new User();
        String prenom = request.queryParams("prenom");
        user.setPrenom(prenom);
        String nom = request.queryParams("nom");
        user.setNom(nom);
        String pseudo = request.queryParams("pseudo");
        user.setPseudo(pseudo);
        String password = request.queryParams("password");
        user.setPassword(password);
        String telephone = request.queryParams("telephone");
        user.setTelephone(telephone);
        String email = request.queryParams("email");
        user.setEmail(email);


        User theUser = loginDao.setNewUser(user);

        System.out.println(prenom);




        modele.put("accountCreation", theUser);

        return Template.render("creationCompte.html", modele);
    }


}
