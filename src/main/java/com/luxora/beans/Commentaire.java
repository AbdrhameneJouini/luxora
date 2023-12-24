package com.luxora.beans;
import java.util.ArrayList;
import java.util.List;

public class Commentaire {
    private int id_commentaire;
    private String date;
    private String texte;
    private int id_uti ;
    private String reference ;
    private int ref_comm ;
    List<Commentaire> sous_com;

    public Commentaire() {
        
    }
    public Commentaire(int id_commentaire, String date, String texte,int id_uti,String reference,int ref_comm) {
        this.id_commentaire = id_commentaire;
        this.date = date;
        this.texte = texte;
        this.id_uti= id_uti;
        this.reference = reference;
        this.ref_comm=ref_comm;
    }
public List<Commentaire> getsous_comm () 
{return sous_com;}
public void setsous_comm(List<Commentaire> sous_comm) {this.sous_com=sous_comm;}
    public int getref_comm() {
        return ref_comm;
    }
    public void setref_comm(int ref_comm) {this.ref_comm=ref_comm;}
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
    public String getreference() {
        return reference;
    }
    public void setreference(String ref) {
        this.reference = ref;
    }

    public static List<Commentaire> getCommentairesPrincipaux(List<Commentaire> commentaires) {
        List<Commentaire> commentairesPrincipaux = new ArrayList<>();
        for (Commentaire commentaire : commentaires) {
            if (commentaire.getref_comm() == 0) {
                commentairesPrincipaux.add(commentaire);
            }
        }
        return commentairesPrincipaux;
    }
    public static List<Commentaire> getSousCommentaires(List<Commentaire> commentaires, Commentaire commentairePrincipal) {
        List<Commentaire> sousCommentaires = new ArrayList<>();
        int idCommentairePrincipal = commentairePrincipal.getId_commentaire();
        for (Commentaire commentaire : commentaires) {
            if (commentaire.getref_comm() == idCommentairePrincipal) {
                sousCommentaires.add(commentaire);
            }
        }
        return sousCommentaires;
    }
}