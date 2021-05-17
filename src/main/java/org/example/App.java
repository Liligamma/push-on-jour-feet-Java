package org.example;

import org.example.core.Conf;
import org.example.core.Database;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import spark.Spark;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        initialize();

        Database db = Database.get();
        db.checkConnection();

        LoginControler loginControler = new LoginControler();
        Spark.get("/login", (req, res) -> loginControler.displayLogin(req, res));
        Spark.post("/login", (req, res) -> loginControler.displayLogin(req, res));
        Spark.get("/logout", (req, res) -> loginControler.displayLogout(req, res));

        EventControler eventControler = new EventControler();
        Spark.get("/evenements", (req, res) -> eventControler.displayEvents(req, res));
        Spark.get("/evenements/details", (req, res) -> eventControler.eventDetails(req, res));
        Spark.get("/evenements/nouveau", (req, res) -> eventControler.displayEventForm(req, res));
        Spark.post("/nouveau", (req, res) -> eventControler.createEvent(req, res));
        Spark.get("/participation", (req, res) -> eventControler.participation(req, res));


        HomeControler homeControler = new HomeControler();
        Spark.get("/home", (req, res) -> homeControler.displayHome(req, res));

        Spark.get("/", (req, res) -> {
            System.out.println("coucou");
            return Template.render("home.html", new HashMap<>());
        });

        Spark.post("/bienvenu", (req, res) -> loginControler.createAccount(req, res));



        Spark.get("/account", (req, res) -> loginControler.displayAccount(req, res));



        Spark.get("/error", (req, res) -> {

            return Template.render("loginIssue.html", new HashMap<>());
        });






    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
