package com.luxora.beans;

public class Commentaire {
    private int id_commentaire;
    private String date;
    private String texte;
    private int id_uti ;
    private String reference ;

    public Commentaire() {
        
    }
    public Commentaire(int id_commentaire, String date, String texte) {
        this.id_commentaire = id_commentaire;
        this.date = date;
        this.texte = texte;
    }

    
    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public int getId_uti() {
        return id_uti;
    }
    public void setId_uti(int id_uti) {
        this.id_uti = id_uti;
    }

}