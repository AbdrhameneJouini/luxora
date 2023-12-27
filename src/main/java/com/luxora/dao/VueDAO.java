package com.luxora.dao;

import com.luxora.beans.Vue;
import com.luxora.dao.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueDAO {


    private void prepareStatements(Vue vu, PreparedStatement preparedStatement) throws SQLException {
    	 preparedStatement.setString(1, vu.getReference());
        preparedStatement.setInt(2, vu.getId_uti());
        preparedStatement.setDate(3, vu.getDate());
        
  }
    public int calculerNombreVuesParReference(String reference) {
        int nombreDeVues = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) AS nombre_vues FROM Vue WHERE Reference = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reference);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nombreDeVues = resultSet.getInt("nombre_vues");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return nombreDeVues;
    }

   
}
