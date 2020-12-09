package box.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 * Classe responsável por fazer a conexão com o banco de dados
 * 
 * @author Gabriel Menezes
 */
public class ConnectionFactory {

	private static final Logger log = Logger.getLogger("ConnectionFactory");
	
	private ConnectionFactory() {
		throw new IllegalStateException("Utility class");
	}
	
	private static Connection create(final String url, final String user, final String password) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		log.info("Conectado no banco com louvor!");
		return connection;
	}
	
	public static Connection getConnection() throws SQLException {
		final String url = "jdbc:postgresql://localhost/postgres";
		final String user = "postgres";
		final String password = "123";
		
		return create(url, user, password);
	}
	
	public static Connection getConnection(final String url, final String user, final String password) throws SQLException {
		return create(url, user, password);
	}
}
