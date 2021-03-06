package br.com.contmatic.model.v1.endereco;

import static br.com.contmatic.util.v1.CamposTypes.CIDADE_NOME_TAMANHO_MAX;
import static br.com.contmatic.util.v1.CamposTypes.CIDADE_NOME_TAMANHO_MIN;
import static br.com.contmatic.util.v1.validator.NumericValidator.validaTamanho;
import static br.com.contmatic.util.v1.validator.StringValidator.validaEspacamento;
import static br.com.contmatic.util.v1.validator.StringValidator.validaNulo;
import static br.com.contmatic.util.v1.validator.StringValidator.verificaSeCampoPossuiDigitos;

public class Cidade {

	private String nome;

	private Estado estado;

	public Cidade(String cidade, Estado estado) {
		this.setCidade(cidade);
		this.setEstado(estado);
	}

	public Cidade(String cidade, EstadoType uf) {
		this.setCidade(cidade);
		this.setEstado(new Estado(uf));
	}

	public Cidade(String cidade, String estado, String uf, PaisType pais) {
		this.setCidade(cidade);
		this.setEstado(new Estado(estado, uf, pais));
	}

	public String getNome() {
		return nome;
	}

	public void setCidade(String nome) {
		validaNulo(getClass(), "nome", nome);
		validaEspacamento(getClass(), "nome", nome, CIDADE_NOME_TAMANHO_MIN);
		validaTamanho(getClass(), "nome", nome.length(), CIDADE_NOME_TAMANHO_MIN, CIDADE_NOME_TAMANHO_MAX);
		verificaSeCampoPossuiDigitos(getClass(), "nome", nome);
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validaNulo(getClass(), "estado", estado);
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null) {
				return false;
			}
		} else if (!estado.equals(other.estado)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": Nome=" + nome + ", " + estado;
	}
}
