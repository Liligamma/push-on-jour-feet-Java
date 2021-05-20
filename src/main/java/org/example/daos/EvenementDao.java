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
import java.util.Date;


public class EvenementDao {


    public Evenement getEvenementById (int id){
        Evenement evenement = new Evenement();
        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM evenements WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            evenement=mapEvenement(resultSet);



            System.out.println(resultSet.getString(2));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return evenement;
    }

    public User getOrganisateur (int id){
        User organisateur = new User();

        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateurs INNER JOIN evenements ON utilisateurs.id = evenements.organisateur_id WHERE evenements.id =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            organisateur=mapUser(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return organisateur;
    }


    public List<User> getParticipants (int id){
        List<User> participants = new ArrayList<User>();
        Database db =Database.get();
       Connection connection = db.getConnection();
       try {
           PreparedStatement statement = connection.prepareStatement("SELECT * FROM utilisateurs  INNER JOIN evenements_utilisateurs ON utilisateurs.id = evenements_utilisateurs.utilisateurs_id WHERE evenements_utilisateurs.evenements_id=?");
          statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()== true) {
                User p = mapUser(resultSet);
                participants.add(p);

           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
         return participants;
    }


    public List<Evenement> getAllEvenements(){
        List<Evenement> evenements = new ArrayList<>();

        Database db =Database.get();
        Connection connection = db.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM evenements");
//           Donne un curseur
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next() == true){
                Evenement e = mapEvenement(resultSet);
                evenements.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return evenements;

    }

    public Evenement setNewEvent (Evenement event){
        Database db =Database.get();
        Connection connection = db.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO evenements (date, latitude, longitude, nom, organisateur_id, commentaires, type_sortie ) VALUES (?,?,?,?,?,?,?)");
            statement.setDate(1, (java.sql.Date) event.dateEvenement);
            statement.setDouble(2, event.latitude);
            statement.setDouble(3, event.longitude);
            statement.setString(4, event.nomEvenement);
            statement.setInt(5, event.organisateurId);
            statement.setString(6, event.commentairesEvenement);
            statement.setBoolean(7, event.typeEvent);

            int resultset = statement.executeUpdate();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return event;
    }

    public int setParticipants (int eventId, int userId){
        Database db =Database.get();
        Connection connection = db.getConnection();

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO evenements_utilisateurs (evenements_id, utilisateurs_id) VALUES (?,?)");
            statement.setInt(1, eventId);
            statement.setInt(2, userId);

            int resultset = statement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


           return userId;
    }

    private Evenement mapEvenement(ResultSet resultSet) throws SQLException {
        Evenement e = new Evenement();
        e.setId(resultSet.getInt(1));
        e.setDateEvenement(resultSet.getDate(2));
        e.setNomEvenement(resultSet.getString(5));
        e.setLatitude(resultSet.getDouble(3));
        e.setLongitude(resultSet.getDouble(4));
        e.setOrganisateurId(resultSet.getInt(6));
        e.setCommentairesEvenement(resultSet.getString(7));
        e.setTypeEvent(resultSet.getBoolean(8));
       return e;
    }

    private User mapUser (ResultSet resultSet) throws SQLException{
        User u = new User();
        u.setId(resultSet.getInt(1));
        u.setPseudo(resultSet.getString(2));
        return u;
    }


}
