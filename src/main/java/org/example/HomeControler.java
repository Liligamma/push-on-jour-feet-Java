package org.example;

import org.example.core.Template;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeControler {

    public String displayHome(Request request, Response response) {
        Map<String, Object> modele = new HashMap<>();

        return Template.render("home.html", modele);
    }
}
