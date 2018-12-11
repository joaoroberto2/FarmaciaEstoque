package br.farmacia.estoque.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.farmacia.estoque.model.CorPeleHumana;
import br.farmacia.estoque.model.PessoaFornecedor;
import br.farmacia.estoque.model.Sexo;
import br.farmacia.estoque.model.Telefone;
import br.farmacia.estoque.repository.PessoaFornecedorRepository;

@Named
@ViewScoped
public class FornecedorController extends Controller<PessoaFornecedor>  {


	private static final long serialVersionUID = -4270221378549569000L;

	private String pesquisa;
	
	private Telefone telefone;
	
	private List<PessoaFornecedor> listaFornecedor = null;
	
	public FornecedorController() {
		super(null);
	}
	
	public void adicionarTelefone() {
		if (getEntity().getListaTelefone() == null)
			getEntity().setListaTelefone(new ArrayList<Telefone>());
		
		// relacionando o telefone com a pessoa
		getTelefone().setPessoa(getEntity());
		
		// adicionando o telefone na lista
		getEntity().getListaTelefone().add(getTelefone());
		
		//limpando o telefone depois da adicao
		setTelefone(null);
	}
	
	public void removerTelefone(Telefone telefone) {
		System.out.println(telefone.getNumero());
		getEntity().getListaTelefone().remove(telefone);
	}
	
	
	public void limpar() {
		setEntity(null);
		listaFornecedor = null;
	}
	
	public void pesquisar() {
		PessoaFornecedorRepository repository = new PessoaFornecedorRepository(getEntityManager());
		listaFornecedor = repository.getFornecedores(pesquisa);
	}
	
	public List<PessoaFornecedor> getlistaFornecedores() {
		if (listaFornecedor == null)
			listaFornecedor = new ArrayList<PessoaFornecedor>();
		return listaFornecedor;
	}

	@Override
	public PessoaFornecedor getEntity() {
		if (entity == null) {
			entity = new PessoaFornecedor();
		}
		return entity;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Telefone getTelefone() {
		if (telefone == null) {
			telefone = new Telefone();
		}
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	
	public Sexo[] getVetorSexo() {
		return Sexo.values();
	}
	
	public CorPeleHumana[] getVetorCorPeleHumana() {
		return CorPeleHumana.values();
	}
	

}
