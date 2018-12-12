package br.farmacia.estoque.model;

import javax.persistence.Entity;

@Entity
public class Produto extends DefaultEntity<Produto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6964016186683874678L;

	private String nome;

	private double preco;

	private PessoaFornecedor fornecedor;	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public PessoaFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(PessoaFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
