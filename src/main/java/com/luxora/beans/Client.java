package com.luxora.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Client extends Utilisateur{
    String address;
    String num_Tel;

    public Client() {

    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNum_Tel() {
        return num_Tel;
    }

    public void setNum_Tel(String num_Tel) {
        this.num_Tel = num_Tel;
    }

    public static void main(String args[]){

        Connection con;
        PreparedStatement pst;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","root");
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();

        }  catch (SQLException ex){
            ex.printStackTrace();
        }


    }



}
