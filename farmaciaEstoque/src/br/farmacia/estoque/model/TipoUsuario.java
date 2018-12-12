package br.farmacia.estoque.model;

import java.util.Arrays;
import java.util.List;

public enum TipoUsuario {
	
	ADMINSTRADOR(0, "Adminstrador", 
			Arrays.asList("cadastroCliente.xhtml", "cadastroFornecedor.xhtml","relatorioFornecedor.xhtml", "listagemcidade.xhtml", "listagemusuario.xhtml", "cadastroFuncionario","cadastrousuario.xhtml")),
	USUARIO_COMUM(1, "Usuario Comum", Arrays.asList("cadastroCliente.xhtml", "listagemcidade.xhtml"));
	
	private int id;
	private String label;
	private List<String> pages;
	
	private TipoUsuario(int id, String label, List<String> pages) {
		this.id = id;
		this.label = label;
		this.pages = pages;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

	public List<String> getPages() {
		return pages;
	}
	
}
