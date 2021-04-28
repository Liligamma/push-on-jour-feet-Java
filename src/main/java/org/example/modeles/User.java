package org.example.modeles;

//J'initialise la classe User//

public class User {

    int id;
    public String pseudo;
    public String password;
    public String nom;
    public String prenom;
    public String  email;
    public String telephone;
    public String role;

    public User(){

    }


    public User(int id, String pseudo, String password, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.pseudo=pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom=prenom;
        this.email = email;
        this.telephone=telephone;
        this.role =role;

    }

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public String setPseudo() {
        return null;
    }

    {


    };
}
