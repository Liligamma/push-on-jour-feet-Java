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
        String userPseudo = request.queryParamOrDefault("user_Pseudo", "0");
        User firstUsers= loginDao.getUserByPseudo(userPseudo);

        System.out.println(firstUsers);

        modele.put("account", firstUsers);

        return Template.render("monCompte.html", modele);
    }

    public String createAccount (Request request, Response response){
        User user = new User();
        Map<String, Object > modele = new HashMap<>();
//        String theUser = request.queryParamOrDefault("user_Pseudo", "0");
        User theUser = loginDao.getUser(user);
        modele.put("accountCreation", theUser);
        return Template.render("creationCompte.html", modele);
    }


}
