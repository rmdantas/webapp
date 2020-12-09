package box.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import box.jdbc.ConnectionFactory;
import box.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	// Criando a conexão com o banco de dados
	public ContatoDao() {
		connection = new ConnectionFactory().getConnection();
	}

	// Adiciona um contato no banco de dados
	public void adicionaContato(Contato contato) {

		String sql = "insert into contatos(nome, email, endereco, dataNascimento)" + "values(?,?,?,?);";

		try {
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setString(1, contato.getNome());
			insert.setString(2, contato.getEmail());
			insert.setString(3, contato.getEndereco());
			insert.setDate(4, (Date) contato.getDataNascimento());

			// insert.execute();
			insert.executeUpdate();
			insert.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao inserir um conteudo no banco de dados");
		}
	}

	// Listando os contatos
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();
			String sql = "select * from contatos";

			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();

				contato.setIdContato(rs.getLong("id_usuario"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(rs.getDate("dataNascimento"));

				contatos.add(contato);
			}

			rs.close();
			select.close();
			return contatos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao criar uma lista de usuários");
		}
	}

}
