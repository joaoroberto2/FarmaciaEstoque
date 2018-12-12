package br.farmacia.estoque.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity

public class Venda extends DefaultEntity<Venda> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8087220938829287652L;
	private Date data;

	private double totalDesconto;

	private double totalVenda;

	@ManyToOne
	@JoinColumn(name="idcliente")
	private PessoaCliente cliente;

	@ManyToOne
	@JoinColumn(name="idfuncionario")
	private PessoaFuncionario funcionario;

	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItemVenda> itemVenda;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getTotalDesconto() {
		return totalDesconto;
	}

	public void setTotalDesconto(double totalDesconto) {
		this.totalDesconto = totalDesconto;
	}

	public double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}

	public List<ItemVenda> getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(List<ItemVenda> itemVenda) {
		this.itemVenda = itemVenda;
	}

	public PessoaCliente getCliente() {
		return cliente;
	}

	public void setCliente(PessoaCliente cliente) {
		this.cliente = cliente;
	}

	public PessoaFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(PessoaFuncionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
