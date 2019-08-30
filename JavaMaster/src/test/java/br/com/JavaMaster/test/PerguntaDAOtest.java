package br.com.JavaMaster.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.JavaMaster.dao.PerguntaDAO;
import br.com.JavaMaster.dao.UsuarioDAO;
import br.com.JavaMaster.entidade.Pergunta;
import br.com.JavaMaster.entidade.Usuario;

public class PerguntaDAOtest {

	@Test
	//@Ignore
	public void salvar() throws Exception {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.consultarPorId(1L);

		PerguntaDAO dao = new PerguntaDAO();
		Pergunta p = new Pergunta("Qual é a melhor linguagem de programação ?", df.parse("28/08/2019"), "S", usuario);
		dao.salvar(p);

		System.out.println("Pergunta Salva com Sucesso");

	}

	// @Test
	@Ignore
	public void listar() {

		PerguntaDAO dao = new PerguntaDAO();
		List<Pergunta> perguntas = dao.listar();

		for (Pergunta pergunta : perguntas) {

			System.out.println("Nome do Usuario: " + pergunta.getUsuario().getNome() + " Pergunta: "
					+ pergunta.getDescricao() + " Data da Pergunta: " + pergunta.getData_criacao()
					+ " Esta pergunta esta ativa: " + pergunta.getAtivo());
		}

	}

	// @Test
	@Ignore
	public void buscar() {

		PerguntaDAO dao = new PerguntaDAO();
		Pergunta pergunta = dao.consultarPorId(1L);

		System.out.println("Nome do Usuario: " + pergunta.getUsuario().getNome() + " Pergunta: "
				+ pergunta.getDescricao() + " Data da Pergunta: " + pergunta.getData_criacao()
				+ " Esta pergunta esta ativa: " + pergunta.getAtivo());

	}

	// @Test
	@Ignore
	public void atualizar() {

		PerguntaDAO dao = new PerguntaDAO();
		Pergunta pergunta = dao.consultarPorId(1L);

		pergunta.setDescricao("Java é uma a melhro linguagem de programação");
		dao.salvar(pergunta);

		System.out.println("A sua pergunta foi atualiza: " + pergunta.getDescricao());

	}

	//@Test
	 @Ignore
	public void remover() {

		PerguntaDAO dao = new PerguntaDAO();
		Pergunta pergunta = dao.consultarPorId(1L);

		dao.excluir(pergunta);

		System.out.println("Sua pergunat foi excluida");

	}

}