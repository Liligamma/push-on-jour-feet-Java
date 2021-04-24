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
            PreparedStatement statement = connection.prepareStatement("SELECT*FROM utilisateurs WHERE pseudo =?");
            statement.setString(1, pseudo);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User u = new User();
            u.setId(resultSet.getInt(1));
            u.setPseudo(resultSet.getString(2));
            u.setPassword(resultSet.getString(3));
            u.setNom(resultSet.getString(4));
            u.setPrenom(resultSet.getString(5));
            u.setEmail(resultSet.getString(6));




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  user;
    }

}
