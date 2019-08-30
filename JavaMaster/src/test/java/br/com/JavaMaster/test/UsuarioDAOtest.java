package br.com.JavaMaster.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.JavaMaster.dao.UsuarioDAO;
import br.com.JavaMaster.entidade.Curso;
import br.com.JavaMaster.entidade.Perfil;
import br.com.JavaMaster.entidade.Usuario;

public class UsuarioDAOtest {

	@Test
	//@Ignore
	public void salvar() throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		UsuarioDAO dao = new UsuarioDAO();

		Perfil p = new Perfil("Usuario");
		Curso c = new Curso("Adimistrador");

		Usuario u = new Usuario();
		u.setCpf("091.990.254-50");
		u.setNome("Deyvisson mendes");
		u.setCurso(c);
		u.setDataNascimento(df.parse("25/06/1993"));
		u.setPerfil(p);
		u.setEmail("deyvisson1993@gmail.com");
		u.setSexo("M");
		u.setAtivo("S");

		dao.salvar(u);
		System.out.println("Usuario Cadastrado com sucesso");

	}
	
	//@Test
	@Ignore
	public void listar() {

		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> u = dao.listar();

		for (Usuario usuario : u) {

			System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data de NAsc: "
					+ usuario.getDataNascimento() + " Email: " + usuario.getEmail() + " Ativo: " + usuario.getAtivo()
					+ " Curso: " + usuario.getCurso().getDescricao() + " Perfil do Usuario: " + usuario.getPerfil().getDescricao());
		}
	}
	
	//@Test
	@Ignore
	public void buscar() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);
		
		System.out.println("Nome: " + usuario.getNome() + " CPF: " + usuario.getCpf() + " Data de NAsc: "
				+ usuario.getDataNascimento() + " Email: " + usuario.getEmail() + " Ativo: " + usuario.getAtivo()
				+ " Curso: " + usuario.getCurso().getDescricao() + " Perfil do Usuario: " + usuario.getPerfil().getDescricao());
	}
	
	//@Test
	@Ignore
	public void atualizar() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);
		usuario.setNome("Deyvisson Mende de Araujo");
		
		dao.salvar(usuario);
		
		System.out.println("Atualizado com sucesso: " + usuario.getNome());
	}
	
	//@Test
	@Ignore
	public void remover() {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);
		
		dao.excluir(usuario);
		System.out.println("Excluido com Sucesso!");
	}

}