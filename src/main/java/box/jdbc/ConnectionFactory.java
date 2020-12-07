package box.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por fazer a conexão com o banco de dados
 * 
 * @author Gabriel Menezes
 */
public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Conectado no banco com louvor!");
			return DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "123");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao se conectar com o banco de dados");
		}
	}
}