package org.example.daos;


import org.example.core.Database;
import org.example.core.Template;
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
        boolean flag = false;
        Database db =Database.get();
        Connection connection = db.getConnection();
        User myUser = new User();
        User notUser= new User();


        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateurs WHERE pseudo =? OR mot_de_passe=?");
            statement.setString(1, pseudo);
            statement.setString(2, mdp);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();


           String rightPseudo = resultSet.getString("pseudo");
           String rightPsw = resultSet.getString("mot_de_passe");




                if (pseudo.equals(rightPseudo)&&(mdp.equals(rightPsw))){
                    flag=true;
                    myUser= mapUser(resultSet);

                    System.out.println("L'utilisateur existe");

                }
//                resultSet.close();

                if (flag=false) {
                    System.out.println("ca ne marche pas");
                    return notUser;



                }
;


//
//            }


           System.out.println(resultSet.getString(2));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return myUser ;
    }


    private static User mapUser (ResultSet resultSet) throws SQLException{
        User u = new User();
        u.setId(resultSet.getInt(1));
        u.setPseudo(resultSet.getString(2));
        u.setPassword(resultSet.getString(3));
        u.setNom(resultSet.getString(4));
        u.setPrenom(resultSet.getString(5));
        return u;
    }

}
