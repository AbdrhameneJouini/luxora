package com.luxora.beans;
import java.util.List;

import com.luxora.dao.NoteDAO;

import com.luxora.beans.Note;
public class Article {
    private String Reference;
    private int Prix;
    private String Nom_Article;
    private String Description;
    private String Image;
    private int Quantite;
    private String Taille ;
    private double moynote;
  
   

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

   
    public Article(String reference, int prix, String nom_Article, String description, String image, int quantite, String taille) {
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
        this.Reference = "";
        this.Prix = 0;
        this.Nom_Article = "";
        this.Description = "";
        this.Image = "";
        this.Quantite = 0;
        this.Taille = "";
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
  

