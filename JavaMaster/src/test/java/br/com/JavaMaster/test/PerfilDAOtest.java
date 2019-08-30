package br.com.JavaMaster.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.JavaMaster.dao.PerfilDAO;
import br.com.JavaMaster.entidade.Perfil;

public class PerfilDAOtest {

	@Test
	//@Ignore
	public void salvar() {

		PerfilDAO dao = new PerfilDAO();
		Perfil p = new Perfil("Admistrador");

		dao.salvar(p);

		System.out.println("Cadastrado com Sucesso");

	}

	//@Test
	@Ignore
	public void listar() {

		PerfilDAO dao = new PerfilDAO();
		List<Perfil> lista = dao.listar();
		for (Perfil perfil : lista) {

			System.out.println("Descrição do Perfil: " + perfil.getDescricao());
		}
	}

	//@Test
	@Ignore
	public void buscar() {

		PerfilDAO dao = new PerfilDAO();
		Perfil p = dao.consultarPorId(1L);

		System.out.println("Descrição do Perfil: " + p.getDescricao());

	}

	//@Test
	@Ignore
	public void atualizar() {

		PerfilDAO dao = new PerfilDAO();
		Perfil p = dao.consultarPorId(1L);
		
		p.setDescricao("Usuario");

		dao.salvar(p);

		System.out.println("Perfil atualizado com Sucesso:  " + p.getDescricao());

	}

	//@Test
	@Ignore
	public void excluir() {
		
		PerfilDAO dao = new PerfilDAO();
		Perfil p = dao.consultarPorId(1L);

		dao.excluir(p);

		System.out.println("Perfil excluido com Sucesso");

	}

}
