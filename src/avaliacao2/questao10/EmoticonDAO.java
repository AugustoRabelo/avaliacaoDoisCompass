package avaliacao2.questao10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import avaliacao2.questao10.Emoticon;

public class EmoticonDAO {
	
	private Connection connection;

	public EmoticonDAO(Connection connection) {
		this.connection = connection;
	}

	public void inserir(Emoticon emoticon) throws SQLException {
		String sql = "INSERT INTO emoticons (sentimento) VALUES (?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, emoticon.getSentimento());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					emoticon.setId(rst.getInt(1));
				}

			}
		}

	}
	
	
	
}
