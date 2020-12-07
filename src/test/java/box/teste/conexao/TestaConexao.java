package box.teste.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import box.jdbc.ConnectionFactory;

public class TestaConexao {

	@Test
	public void initBanco() throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("CONEXÃO INICIADA");
		connection.close();
	}
}
