package org.example.modeles;

//J'initialise la classe User//

public class User {

    int id;
    String pseudo;
    public String password;
    String nom;
    String prenom;
    public String  email;
    String telephone;
    String role;

    public User(){

    }


    public User(int id, String email, String password) {
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
}
