package com.luxora.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luxora.dao.NoteDAO;

public class Note {
	 private int Id_note;

    private int Id_uti;
    private String reference;
    private double note;
    private Date date;

    public Note() {
    } 
    public Note(int Id_note ,int Id_uti, String reference, double note, Date date) {
    	 this.Id_note = Id_note;
        this.Id_uti = Id_uti;
        this.reference = reference;
        this.note = note;
        this.date = date;
    }
    public int getId_note() {
        return Id_note;
    }
    public void setId_note(int Id_note) {
        this.Id_note = Id_note;
    }

    public int getId_uti() {
        return Id_uti;
    }

    public void setId_uti(int Id_uti) {
        this.Id_uti = Id_uti;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public static double calculNoteMoyenneParArticle(String referenceArticle, NoteDAO noteDAO) {
        List<Note> notesArticle = noteDAO.getNotesByArticleReference(referenceArticle);

        if (notesArticle.isEmpty()) {
            return 0; 
        }

        double sommeNotes = 0;
        for (Note note : notesArticle) {
            sommeNotes += note.getNote();
        }

        return sommeNotes / notesArticle.size();
    }
    
}