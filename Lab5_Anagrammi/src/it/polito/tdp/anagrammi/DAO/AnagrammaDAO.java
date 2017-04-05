package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	/**
	 * mi dice se @param anagramma è presente nel dizionario
	 * @return true o false se presente o non 
	 */
	
	public boolean isCorrect(String anagramma) {

		final String sql = "SELECT nome FROM `parola` "
				+ "WHERE nome=? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				return true; 
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
			
		}
		return false ;

	}
	
	
}
