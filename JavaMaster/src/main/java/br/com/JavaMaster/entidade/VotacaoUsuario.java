package br.com.JavaMaster.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VotacaoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codigo;
	
	@ManyToOne
	private Votacao votacao;
	
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "data_cricao", nullable = false)
	private Date dataCriacao;


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Votacao getVotacao() {
		return votacao;
	}

	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((votacao == null) ? 0 : votacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotacaoUsuario other = (VotacaoUsuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (votacao == null) {
			if (other.votacao != null)
				return false;
		} else if (!votacao.equals(other.votacao))
			return false;
		return true;
	}

	public VotacaoUsuario() {
		super();
	}

	public VotacaoUsuario(Long codigo, Votacao votacao, Usuario usuario, Date dataCriacao) {
		super();
		this.codigo = codigo;
		this.votacao = votacao;
		this.usuario = usuario;
		this.dataCriacao = dataCriacao;
	}

}
