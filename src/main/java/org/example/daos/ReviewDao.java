package org.example.daos;

import org.example.core.Database;
import org.example.modeles.Evenement;
import org.example.modeles.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {

    public List<Review> getAllReview(){

        List<Review> review = new ArrayList<>();

        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM review");
//           Donne un curseur
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next() == true){
                Review r = mapReview(resultSet);
                review.add(r);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



       return review;

    }

    private Review mapReview (ResultSet resultSet) throws SQLException{
        Review r = new Review();
        r.setId (resultSet.getInt(1));
        r.setDate(resultSet.getDate(2));
        r.setContenuReview(resultSet.getString(3));
        r.setAuteurId(resultSet.getInt(4));
        r.setTitre(resultSet.getString(5));

        return r;


    }
}
