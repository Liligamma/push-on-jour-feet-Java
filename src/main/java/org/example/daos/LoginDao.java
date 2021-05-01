package org.example.daos;


import org.example.core.Database;
import org.example.modeles.Evenement;
import org.example.modeles.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginDao {

    public User setNewUser (User user){

        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO utilisateurs (pseudo, mot_de_passe, nom, prenom, email, telephone) VALUES (?,?,?,?,?,?) ");
            statement.setString(1, user.pseudo);
           statement.setString(2, user.password);
           statement.setString(3, user.nom);
           statement.setString(4, user.prenom);
           statement.setString(5, user.email);
           statement.setString(6, user.telephone);
            int resultSet = statement.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return user;


    }

    public static User getUserByPseudo(String pseudo, String mdp){
        User user = new User();
        Database db =Database.get();
        Connection connection = db.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo =? AND mot_de_passe =?");
            statement.setString(1, pseudo);
            statement.setString(2,mdp );
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            if (!resultSet.next()){


            }
//
//            user.setId(resultSet.getInt(1));
//            user.setPseudo(resultSet.getString(2));
//            user.setPassword(resultSet.getString(3));
//            user.setNom(resultSet.getString(4));
//            user.setPrenom(resultSet.getString(5));
//            user.setEmail(resultSet.getString(6));
//            user.setTelephone(resultSet.getString(7));

//            System.out.println(resultSet.getString(2));




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  user;
    }



}
