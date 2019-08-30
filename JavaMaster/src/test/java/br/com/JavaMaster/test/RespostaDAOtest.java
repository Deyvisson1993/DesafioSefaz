package br.com.JavaMaster.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.JavaMaster.dao.PerguntaDAO;
import br.com.JavaMaster.dao.RespostaDAO;
import br.com.JavaMaster.dao.UsuarioDAO;
import br.com.JavaMaster.entidade.Pergunta;
import br.com.JavaMaster.entidade.Resposta;
import br.com.JavaMaster.entidade.Usuario;

public class RespostaDAOtest {
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	 @Test
	 //@Ignore
	public void salvar() throws Exception {


		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);

		PerguntaDAO dao1 = new PerguntaDAO();
		Pergunta pergunta = dao1.consultarPorId(1L);

		RespostaDAO dao3 = new RespostaDAO();
		Resposta resposta = new Resposta("Depende do projeto, más as mas utilizadas são JAVA, Phyton, C# ",
				df.parse("28/08/2019"), pergunta, usuario);
		dao3.salvar(resposta);

		System.out.println("Sua resposta foi Salva com Sucesso");

	}

	//@Test
	@Ignore
	public void listar() {

		RespostaDAO dao = new RespostaDAO();
		List<Resposta> respostas = dao.listar();

		for (Resposta resposta : respostas) {

			System.out.println("Nome do Usuario: " + resposta.getUsuario().getNome() + " - Pergunta: "
					+ resposta.getPergunta().getDescricao() + " - Resposta: " + resposta.getDescricao());
		}

	}
	
	//@Test
	@Ignore
	public void buscar() {
		
		RespostaDAO dao = new RespostaDAO();
		Resposta resposta = dao.consultarPorId(1L);
		

		System.out.println("Nome do Usuario: " + resposta.getUsuario().getNome() + " - Pergunta: "
				+ resposta.getPergunta().getDescricao() + " - Resposta: " + resposta.getDescricao());
	}
	
	//@Test
	@Ignore
	public void atualizar() throws Exception {
		
		RespostaDAO dao = new RespostaDAO();
		Resposta resposta = dao.consultarPorId(1L);
		resposta.setDate_criacao(df.parse("29/08/2019"));
		
		System.out.println("A data da resposta foi atualizada: " + resposta.getDate_criacao());
		
	}
	
	//@Test
	@Ignore
	public void excluir() {
		
		RespostaDAO dao = new RespostaDAO();
		Resposta resposta = dao.consultarPorId(1L);
		
		dao.excluir(resposta);
		
		System.out.println("Resposta excluida");
	
		
		
	}
			
			

}