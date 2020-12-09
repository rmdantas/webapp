package box.teste.adiciona;

import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import box.dao.ContatoDao;
import box.modelo.Contato;

public class TestaAdiciona {

	@Test
	public void initAdiciona() throws SQLException {

		Date data = new Date();
		
		Contato contato = new Contato("Gabriel", "gabriel@gmail.com", "Rua ministro godoi", data);

		ContatoDao dao = new ContatoDao();

		dao.adicionaContato(contato);
		System.out.println("Contato: " + contato.getNome() + ", adicionado com sucesso!");
	}
}