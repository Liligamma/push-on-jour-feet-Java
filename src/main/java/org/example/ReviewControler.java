package org.example;

import org.apache.commons.lang.ObjectUtils;
import org.example.core.Template;
import org.example.daos.EvenementDao;
import org.example.daos.ReviewDao;
import org.example.modeles.Evenement;
import org.example.modeles.Review;
import org.example.modeles.User;
import org.example.utils.URLUtils;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static spark.route.HttpMethod.before;




public class ReviewControler  {

    ReviewDao reviewDao = new ReviewDao();

    public String displayReview (Request request, Response response){
        Map<String, Object > modele = new HashMap<>();

        List<Review> review = reviewDao.getAllReview();







        return null;
    }
}
