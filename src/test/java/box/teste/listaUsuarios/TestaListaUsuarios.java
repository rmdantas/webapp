package box.teste.listaUsuarios;

import java.util.List;

import org.junit.jupiter.api.Test;

import box.dao.ContatoDao;
import box.modelo.Contato;

public class TestaListaUsuarios {

	@Test
	public void initTestaLista() {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("ID: " + contato.getIdContato());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data Nascimento: " + contato.getDataNascimento() +"\n");
		}
	}
}
