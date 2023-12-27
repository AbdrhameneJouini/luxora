package com.luxora.dao;
import com.luxora.beans.Note;
import com.luxora.dao.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
	private void prepareStatements(Note note, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, note.getId_note());
		preparedStatement.setInt(2, note.getId_uti());
		preparedStatement.setString(2, note.getReference());
		preparedStatement.setDouble(3,note.getNote());
		java.sql.Date sqlDate = new java.sql.Date(note.getDate().getTime());
		preparedStatement.setDate(4, sqlDate);


	}
	public void insertNote(Note note) {
		try (Connection connection = DBConnection.getConnection()) {
			String query = "INSERT INTO note (Id_note,Id_uti,reference,note,date) VALUES (?,?, ?, ?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				prepareStatements(note, preparedStatement);

				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("note ajouté");
					// If needed, you can retrieve the generated ID
					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
					if (generatedKeys.next()) {
						int generatedId = generatedKeys.getInt(1);
						note.setId_note(generatedId);
					}
				} else {
					System.out.println("pas d'ajout de note.");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private Note mapResultSetToNote(ResultSet resultSet) throws SQLException {
		Note note = new Note();
		note.setId_note(resultSet.getInt("Id_note"));
		note.setId_uti(resultSet.getInt("Id_uti"));
		note.setReference(resultSet.getString(" reference"));
		note.setNote(resultSet.getDouble("note"));
		note.setDate(resultSet.getDate("date"));


		return note;
	} public List<Note> getNotesByArticleReference(String referenceArticle) {
		List<Note> notes = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection()) {
			String query = "SELECT * FROM Note WHERE reference = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, referenceArticle);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Note note = mapResultSetToNote(resultSet);
						notes.add(note);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return notes;
	}
}