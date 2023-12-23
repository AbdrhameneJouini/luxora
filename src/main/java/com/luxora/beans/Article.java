package com.luxora.beans;
public class Article {
    private int Reference;
    private int Prix;
    private String Nom_Article;
    private String Description;
    private String Image;
    private int Quantite;
    private String Taille ;
  
   

    public int getReference() {
        return Reference;
    }

    public void setReference(int reference) {
        Reference = reference;
    }

    
    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    
    public String getNom_Article() {
        return Nom_Article;
    }

    public void setNom_Article(String nom_Article) {
        Nom_Article = nom_Article;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

   
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    
    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }

   
    public String getTaille() {
        return Taille;
    }

    public void setTaille(String taille) {
        Taille = taille;
    }

   
    public Article(int reference, int prix, String nom_Article, String description, String image, int quantite, String taille) {
    	super() ;
        this.Reference = reference;
        this.Prix = prix;
        this.Nom_Article = nom_Article;
        this.Description = description;
        this.Image = image;
        this.Quantite = quantite;
        this.Taille = taille;
    }
   public Article() {
	   super() ;
        this.Reference = 0;
        this.Prix = 0;
        this.Nom_Article = "";
        this.Description = "";
        this.Image = "";
        this.Quantite = 0;
        this.Taille = "";
    }
}
