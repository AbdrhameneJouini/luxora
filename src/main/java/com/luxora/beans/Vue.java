package com.luxora.beans;

import java.sql.Date;

public class Vue {
    private String Reference;;
    private int Id_uti;
    private Date date;
    public Vue() {}
    public Vue(String reference, int id_uti, Date date) {
        this.Reference = reference;
        this.Id_uti = id_uti;
        this.date = date;
    }
    public String getReference() {
        return Reference;
    }


    public void setReference(String reference) {
        this.Reference = reference;
    }

   
    public int getId_uti() {
        return Id_uti;
    }

   
    public void setId_uti(int id_uti) {
        this.Id_uti = id_uti;
    }

    public Date getDate() {
        return date;
    }

 
    public void setDate(Date date) {
        this.date = date;
    } }
