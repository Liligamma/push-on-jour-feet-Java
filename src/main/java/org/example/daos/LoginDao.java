package org.example.daos;


import org.example.core.Database;
import org.example.modeles.Evenement;
import org.example.modeles.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    public User createUser (User user){
        User firstUser = new User();


        return firstUser;


    }

    public static User getUserByPseudo(String pseudo){
        User user = new User();
        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo =?");
            statement.setString(1, pseudo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
//            User u = new User();
            user.setId(resultSet.getInt(1));
            user.setPseudo(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setNom(resultSet.getString(4));
            user.setPrenom(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));

            System.out.println(resultSet.getString(2));




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  user;
    }

}
