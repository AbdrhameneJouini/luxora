package com.luxora.beans;
import java.util.List;

import com.luxora.dao.NoteDAO;

public class Article {
    private String Reference;
    private double Prix;
    private String Nom_Article;
    private String Description;
    private String Image;

    private String Categorie;
    private List <DetailArticle> listDetailArticle;
    private List <Commentaire> listCommentaires;
    private double moynote;
    private int nbvues;
  
    public int getnbvues() {
        return nbvues;
    }
    public void setnbvues(int nbvues) {
        this.nbvues = nbvues;
      }

    public String getReference() {
        return Reference;
    }
    public double getMoyenneNote() {
        return moynote;
    }

    public void setMoyenneNote(double moyenneNote) {
      moynote = moyenneNote;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    
    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    
    public String getNom_Article() {
        return Nom_Article;
    }

    public void setNom_Article(String nom_Article) {
        Nom_Article = nom_Article;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public void setListDetailArticle(List<DetailArticle> listDetailArticle) {
        this.listDetailArticle = listDetailArticle;
    }



    public double getMoynote() {
        return moynote;
    }

    public void setMoynote(double moynote) {
        this.moynote = moynote;
    }

    public int getNbvues() {
        return nbvues;
    }

    public void setNbvues(int nbvues) {
        this.nbvues = nbvues;
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


    public Article(String reference, String nom_Article,Double prix,  String categorie,String description) {
        Reference = reference;
        Prix = prix;
        Nom_Article = nom_Article;
        Description = description;
        Categorie = categorie;
    }

    public Article(String reference, Double prix, String nom_Article, String description, String image, int nbvues, String Categorie) {
    	super() ;
        this.Reference = reference;
        this.Prix = prix;
        this.Nom_Article = nom_Article;
        this.Description = description;
        this.Image = image;
        this.nbvues= nbvues;
        this.Categorie= Categorie;
    }
   public Article() {
	   super() ;
        this.Reference = "";
        this.Prix = 0;
        this.Nom_Article = "";
        this.Description = "";
        this.Image = "";

    }  
 double calculNoteMoyenne(String ref) {
     NoteDAO noteDAO = new NoteDAO();
 
        List<Note> notesArticle = noteDAO.getNotesByArticleReference(ref);

        if (notesArticle.isEmpty()) {   this.moynote= 0;
            return 0; 
        }

        double sommeNotes = 0;
        for (Note note : notesArticle) {
            sommeNotes += note.getNote();
        }
        this.moynote= sommeNotes;

        return sommeNotes / notesArticle.size();
    } }
  

