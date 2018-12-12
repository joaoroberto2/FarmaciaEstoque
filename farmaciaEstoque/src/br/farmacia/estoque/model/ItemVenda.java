package br.farmacia.estoque.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ItemVenda extends DefaultEntity<ItemVenda>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2979105321904364752L;


	private int quantidade;

	private double preco;

	@ManyToOne
	@JoinColumn(name="idvenda")
	private Venda venda;

	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
