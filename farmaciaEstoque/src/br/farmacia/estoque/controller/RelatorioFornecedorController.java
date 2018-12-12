package br.farmacia.estoque.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.farmacia.estoque.application.Util;
import br.farmacia.estoque.factory.JPAFactory;
import br.farmacia.estoque.model.PessoaFornecedor;
import br.farmacia.estoque.repository.PessoaFornecedorRepository;

@Named
@ViewScoped
public class RelatorioFornecedorController implements Serializable {

	private static final long serialVersionUID = 8960480190786168795L;

	private String nomeFornecedor;
	private List<PessoaFornecedor> listaFornecedor;

	
	public void pesquisar() {
		listaFornecedor = null;
	}
	
	public void imprimir() {
		Util.redirect("/farmaciaEstoque/fornecedorReport?NOME_FORNECEDOR="+getNomeFornecedor());
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public List<PessoaFornecedor> getListaFornecedor() {
		if (listaFornecedor == null) {
			PessoaFornecedorRepository repo = new PessoaFornecedorRepository(JPAFactory.getEntityManager());
			listaFornecedor = repo.getFornecedores(nomeFornecedor);
		}
		return listaFornecedor;
	}

	public void setListaFornecedor(List<PessoaFornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

}
