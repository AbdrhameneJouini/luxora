package com.luxora.beans;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

 public abstract class Utilisateur {
     private int id_uti;
     private String nom_uti;
     private String prenom_uti;
     private String login;
     private String mdp;
     private String email;
     private String address;
     private String username;

     private String etat;


     public Utilisateur() {
     }


     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getAddress() {
         return address;
     }

     public void setAddress(String address) {
         this.address = address;
     }

     public String getEtat() {
         return etat;
     }

     public void setEtat(String etat) {
         this.etat = etat;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }


     public int getId_uti() {
         return id_uti;
     }

     public void setId_uti(int id_uti) {
         this.id_uti = id_uti;
     }

     public String getNom_uti() {
         return nom_uti;
     }

     public void setNom_uti(String nom_uti) {
         this.nom_uti = nom_uti;
     }

     public String getPrenom_uti() {
         return prenom_uti;
     }

     public void setPrenom_uti(String prenom_uti) {
         this.prenom_uti = prenom_uti;
     }

     public String getLogin() {
         return login;
     }

     public void setLogin(String login) {
         this.login = login;
     }

     public String getMdp() {
         return mdp;
     }

     public void setMdp(String mdp) {
         this.mdp = mdp;
     }







 }
