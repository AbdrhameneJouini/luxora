package com.luxora.beans;

public class DetailArticle {
    private String reference;
    private String taille;

    private int quantite;

    public DetailArticle( ) {

    }

    public DetailArticle(String reference, String taille, int quantite) {
        this.reference = reference;
        this.taille = taille;
        this.quantite = quantite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }



}
