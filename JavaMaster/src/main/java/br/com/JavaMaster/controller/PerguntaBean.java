package br.com.JavaMaster.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.JavaMaster.dao.PerguntaDAO;
import br.com.JavaMaster.dao.UsuarioDAO;
import br.com.JavaMaster.entidade.Pergunta;
import br.com.JavaMaster.entidade.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class PerguntaBean implements Serializable {

	private Pergunta pergunta;

	private List<Usuario> usuarios;
	private List<Pergunta> perguntas;

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public void novo() {

		try {

			pergunta = new Pergunta();

			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel lisatr os usuaios");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			PerguntaDAO dao = new PerguntaDAO();
			this.pergunta.setData_criacao(new Date());
			
			if(this.pergunta.getAtivo().equals("true")) {
				
				this.pergunta.setAtivo("S");
			}else {
				this.pergunta.setAtivo("N");

			}
			
			dao.salvar(pergunta);

			novo();
			
			perguntas = dao.listar();

			Messages.addGlobalInfo("Sua pergunta foi salva com SUCESSO!");
		} catch (RuntimeException erro) {

			Messages.addGlobalError("NAo foi possivel salvar a Pergunta");
			erro.printStackTrace();
		}

	}

}
