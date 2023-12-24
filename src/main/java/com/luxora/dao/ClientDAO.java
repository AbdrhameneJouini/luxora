package com.luxora.dao;

import com.luxora.beans.Client;
import com.luxora.dao.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {


    private void prepareStatements(Client clt, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, clt.getId_uti());
        preparedStatement.setString(2, clt.getNom_uti());
        preparedStatement.setString(3, clt.getPrenom_uti());
        preparedStatement.setString(7, clt.getEmail());
        preparedStatement.setString(4, clt.getUsername());
        preparedStatement.setString(6, clt. getAddress());
        preparedStatement.setString(7, clt.getNum_Tel());
       
        preparedStatement.setString(5, clt.getEtatCompte());
       
       
        
       
    }
    

    


    public Client getClientById( int Id_uti) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM client WHERE Id_uti=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id_uti);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToClient(resultSet);
                    } else {
                        System.out.println("Article not found.");
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
        clt.setId_uti(resultSet.getInt("Id_uti"));
        clt.setNom_uti(resultSet.getString("Nom_uti"));
        clt.setPrenom_uti(resultSet.getString("Prenom_uti"));
        clt.setEmail(resultSet.getString("email"));
       
        clt.setUsername(resultSet.getString("username"));
        clt.setAddress(resultSet.getString("address"));
        clt.setNum_Tel(resultSet.getString("num_Tel"));
        clt.setEtatCompte(resultSet.getString("etatCompte"));
        return clt;
    }



    public static void main(String[] args) {
        ClientDAO infoClient = new ClientDAO();
        int Id_uti = 1;

        Client clt = infoClient.getClientById(Id_uti);

        if (clt!= null) {
            System.out.println("client trouvé : " + clt.getNom_uti());
            
        } else {
            System.out.println("Aucun client trouvé avec l'ID : " + Id_uti);
        }
    }
}
