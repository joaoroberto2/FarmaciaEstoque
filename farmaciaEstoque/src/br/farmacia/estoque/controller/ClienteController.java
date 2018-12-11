package br.farmacia.estoque.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.farmacia.estoque.model.CorPeleHumana;
import br.farmacia.estoque.model.PessoaCliente;
import br.farmacia.estoque.model.Sexo;
import br.farmacia.estoque.model.Telefone;
import br.farmacia.estoque.repository.PessoaClienteRepository;

@Named
@ViewScoped
public class ClienteController extends Controller<PessoaCliente>  {


	private static final long serialVersionUID = -4270221378549569000L;

	private String pesquisa;
	
	private Telefone telefone;
	
	private List<PessoaCliente> listaCliente = null;
	
	public ClienteController() {
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
		listaCliente = null;
	}
	
	public void pesquisar() {
		PessoaClienteRepository repository = new PessoaClienteRepository(getEntityManager());
		listaCliente = repository.getClientes(pesquisa);
	}
	
	public List<PessoaCliente> getlistaClientes() {
		if (listaCliente == null)
			listaCliente = new ArrayList<PessoaCliente>();
		return listaCliente;
	}

	@Override
	public PessoaCliente getEntity() {
		if (entity == null) {
			entity = new PessoaCliente();
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
