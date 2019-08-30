package br.com.JavaMaster.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codgigo;

	@Column(length = 20, nullable = false)
	private String descricao;

	public Long getCodgigo() {
		return codgigo;
	}

	public void setCodgigo(Long codgigo) {
		this.codgigo = codgigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codgigo == null) ? 0 : codgigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Perfil other = (Perfil) obj;
		if (codgigo == null) {
			if (other.codgigo != null)
				return false;
		} else if (!codgigo.equals(other.codgigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	public Perfil() {
		super();
	}

	public Perfil(String descricao) {
		super();
		this.descricao = descricao;
	}
}
