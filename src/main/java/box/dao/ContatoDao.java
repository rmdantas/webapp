package box.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import box.jdbc.ConnectionFactory;
import box.modelo.Contato;

public class ContatoDao {
	
	private static final Logger log = Logger.getLogger("ContatoDao");
	private Connection connection;

	// Criando a conexão com o banco de dados
	public ContatoDao() throws SQLException {
		connection = ConnectionFactory.getConnection();
		connection.setAutoCommit(false);
	}

	// Adiciona um contato no banco de dados
	public void adicionaContato(Contato contato) {

		final String sql = "insert into contatos(nome, email, endereco, dataNascimento) values(?,?,?,?);";

		try (PreparedStatement insert = connection.prepareStatement(sql)) {

			insert.setString(1, contato.getNome());
			insert.setString(2, contato.getEmail());
			insert.setString(3, contato.getEndereco());
			insert.setDate(4, (Date) contato.getDataNascimento());

			// insert.execute();
			insert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			log.warning("Erro ao inserir um conteudo no banco de dados");
		}
	}

	// Listando os contatos
	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<>();
		final String sql = "select * from contatos";
		
		try (PreparedStatement select = connection.prepareStatement(sql)) {
			try (ResultSet rs = select.executeQuery()) {
				while (rs.next()) {

					Contato contato = new Contato();

					contato.setIdContato(rs.getLong("id_usuario"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					contato.setDataNascimento(rs.getDate("dataNascimento"));

					contatos.add(contato);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

		return contatos;
	}

}
