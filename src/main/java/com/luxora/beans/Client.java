package com.luxora.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.luxora.dao.DBConnection;


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
    public Client getClientById(int Id_Uti) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM Client WHERE Id_uti=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id_Uti);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToClient(resultSet);
                    } else {
                        System.out.println("Utilisateur not found.");
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Client mapResultSetToClient(ResultSet resultSet) throws SQLException {
        Client clt = new Client();
        clt.setId_uti(resultSet.getInt("id_uti"));
        clt.setNom_uti(resultSet.getString("nom_uti"));
        clt.setPrenom_uti(resultSet.getString("prenom_uti"));
        clt.setEmail(resultSet.getString("email"));
        clt.setUsername(resultSet.getString("username"));
        clt.setEtat(resultSet.getString("etat"));  
        clt.setAddress(resultSet.getString("address"));
        return clt;
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
