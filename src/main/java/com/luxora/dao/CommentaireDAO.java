package com.luxora.dao;

import com.luxora.beans.Commentaire;
import com.luxora.dao.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentaireDAO {
	private void prepareStatements(Commentaire comm, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, comm.getId_commentaire());
		preparedStatement.setString(2, comm.getDate());
		preparedStatement.setString(3, comm.getTexte());
		preparedStatement.setInt(4, comm.getId_uti());
		preparedStatement.setString(5, comm.getreference());
		preparedStatement.setInt(6, comm.getref_comm());

	}
	public void insertComm(Commentaire comm) {
		try (Connection connection = DBConnection.getConnection()) {
			String query = "INSERT INTO Commentaire (Id_commentaire, Date, Texte, Id_uti, reference,ref_comm) VALUES (?, ?, ?, ?, ?,?)";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				prepareStatements(comm, preparedStatement);

				int rowsAffected = preparedStatement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Commentaire ajouté");
					// If needed, you can retrieve the generated ID
					ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
					if (generatedKeys.next()) {
						int generatedId = generatedKeys.getInt(1);
						comm.setId_commentaire(generatedId);
					}
				} else {
					System.out.println("pas d'ajout de commentaire.");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Commentaire> getCommByReference(String reference) {
		List<Commentaire> commentaires = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection()) {
			String query = "SELECT * FROM Commentaire WHERE reference=?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, reference);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Commentaire commentaire = mapResultSetToComm(resultSet);
						commentaires.add(commentaire);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return commentaires;
	}


	private Commentaire mapResultSetToComm(ResultSet resultSet) throws SQLException {
		Commentaire comm = new Commentaire();
		comm.setId_commentaire(resultSet.getInt("Id_commentaire"));
		comm.setDate(resultSet.getString("Date"));
		comm.setTexte(resultSet.getString("Texte"));
		comm.setId_uti(resultSet.getInt("Id_uti"));
		comm.setreference(resultSet.getString("reference"));
		comm.setref_comm(resultSet.getInt("ref_comm"));

		return comm;
	}
	public List<Commentaire> getAllComments() {
		List<Commentaire> commentaires = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection()) {
			String query = "SELECT * FROM Commentaire";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Commentaire commentaire = mapResultSetToComm(resultSet);
						commentaires.add(commentaire);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return commentaires;
	}
	public static List<Commentaire> getAllSubComments(List<Commentaire> allComments, Commentaire parentComment) {
		List<Commentaire> subComments = new ArrayList<>();
		int parentId = parentComment.getId_commentaire();

		for (Commentaire comment : allComments) {
			if (comment.getref_comm() == parentId) {
				subComments.add(comment);
				subComments.addAll(getAllSubComments(allComments, comment));
			}
		}

		return subComments;
	}
	public static void main(String[] args) {
		CommentaireDAO commentaireDAO = new CommentaireDAO();
		List<Commentaire> infoComm;
		String reference = "m";

		infoComm = commentaireDAO.getCommByReference(reference);

		if (!infoComm.isEmpty()) {
			for (Commentaire comm : infoComm) {
				System.out.println("Comm trouvé : " + comm.getTexte());

			}} else {
			System.out.println("Aucun commentaire trouvé avec la référence : " + reference);
		}

		List<Commentaire> allComments = commentaireDAO.getAllComments();


		List<Commentaire> commentairesPrincipaux = Commentaire.getCommentairesPrincipaux(allComments);

		for (Commentaire commentairePrincipal : commentairesPrincipaux) {
			List<Commentaire> subComments = getAllSubComments(allComments, commentairePrincipal);


			System.out.println("Sous-commentaires pour le commentaire principal ID " + commentairePrincipal.getId_commentaire());
			for (Commentaire subComment : subComments) {
				System.out.println("Sous-commentaire - ID : " + subComment.getId_commentaire());
			}
		}
	}
}