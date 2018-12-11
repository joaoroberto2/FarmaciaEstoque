package br.farmacia.estoque.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Tabela_PessoaFisica")
public class PessoaFisica extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6653522130358695654L;
	private String cpf;
	private String rg;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}
