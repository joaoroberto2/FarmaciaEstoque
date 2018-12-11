package br.farmacia.estoque.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.farmacia.estoque.application.Util;
import br.farmacia.estoque.factory.JPAFactory;
import br.farmacia.estoque.model.Cidade;
import br.farmacia.estoque.repository.CidadeRepository;

@Named
@ViewScoped
public class RelatorioCidadeController implements Serializable {

	private static final long serialVersionUID = 8960480190786168795L;

	private String nomeCidade;
	private List<Cidade> listaCidade;

	
	public void pesquisar() {
		listaCidade = null;
	}
	
	public void imprimir() {
		Util.redirect("/topicos2/cidadeReport?NOME_CIDADE="+getNomeCidade());
	}
	
	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repo = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repo.getCidades(nomeCidade);
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

}
