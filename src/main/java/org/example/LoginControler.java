package org.example;

import org.example.core.Template;
import org.example.modeles.User;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginControler {

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


}
