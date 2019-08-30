package br.com.JavaMaster.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.JavaMaster.dao.CursoDAO;
import br.com.JavaMaster.entidade.Curso;

public class CursoDAOtest {

	@Test
	//@Ignore
	public void salvar() {

		CursoDAO dao = new CursoDAO();
		Curso c = new Curso("Sistemas de Informacao");

		dao.salvar(c);

		System.out.println("Cadastrado com Sucesso");

	}

	// @Test
	@Ignore
	public void listar() {

		CursoDAO dao = new CursoDAO();
		List<Curso> lista = dao.listar();
		for (Curso curso : lista) {

			System.out.println("Descrição do Curso: " + curso.getDescricao());
		}
	}

	// @Test
	@Ignore
	public void buscar() {

		CursoDAO dao = new CursoDAO();
		Curso c = dao.consultarPorId(1L);

		System.out.println("Descrição do Curso: " + c.getDescricao());

	}

	//@Test
	@Ignore
	public void atualizar() {

		CursoDAO dao = new CursoDAO();
		Curso c = dao.consultarPorId(1L);

		c.setDescricao("Adimistração");

		dao.salvar(c);

		System.out.println("Curso atualizado com Sucesso:  " + c.getDescricao());

	}
	
	//@Test
	@Ignore
	public void excluir() {
		
		CursoDAO dao = new CursoDAO();
		Curso c = dao.consultarPorId(1L);

		dao.excluir(c);
		
		System.out.println("Curso excluido com Sucesso");
		
	}

}
