package br.com.JavaMaster.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.JavaMaster.dao.PerguntaDAO;
import br.com.JavaMaster.dao.VotacaoDAO;
import br.com.JavaMaster.entidade.Pergunta;
import br.com.JavaMaster.entidade.Votacao;

public class VotacaoDAOtest {

	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	// @Ignore
	public void salvar() throws Exception {

		PerguntaDAO perguntaDAO = new PerguntaDAO();
		Pergunta p = perguntaDAO.consultarPorId(1L);

		Votacao v = new Votacao(df.parse("28/08/2019"), df.parse("29/08/2019"), p);

		VotacaoDAO dao = new VotacaoDAO();
		dao.salvar(v);

		System.out.println("A votacação foi salva com sucesso");

	}

	// @Test
	@Ignore
	public void listar() {

		VotacaoDAO dao = new VotacaoDAO();
		List<Votacao> votacaos = dao.listar();

		for (Votacao votacao : votacaos) {

			System.out.println("Data Inicio: " + votacao.getDataInicio() + " - Data Fim: " + votacao.getDataFim()
					+ " - Pergunta: " + votacao.getPergunta().getDescricao());
		}

	}

	// @Test
	@Ignore
	public void buscar() {

		VotacaoDAO dao = new VotacaoDAO();
		Votacao votacao = dao.consultarPorId(1L);

		System.out.println("Data Inicio: " + votacao.getDataInicio() + " - Data Fim: " + votacao.getDataFim()
				+ " - Pergunta: " + votacao.getPergunta().getDescricao());

	}

	// @Test
	@Ignore
	public void atualizar() throws Exception {

		VotacaoDAO dao = new VotacaoDAO();
		Votacao votacao = dao.consultarPorId(1L);

		votacao.setDataFim(df.parse("30/08/2019"));

		System.out.println("A data de fim foi atualizada: " + votacao.getDataFim());

	}

	// @Test
	@Ignore
	public void excluir() {

		VotacaoDAO dao = new VotacaoDAO();
		Votacao votacao = dao.consultarPorId(1L);
		dao.excluir(votacao);

		System.out.println("A votacao foi excluida com sucesso");

	}
}