package br.farmacia.estoque.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.farmacia.estoque.model.ItemVenda;
import br.farmacia.estoque.model.Venda;
import br.farmacia.estoque.repository.VendaRepository;

@Named
@ViewScoped
public class VendaController extends Controller<Venda>  {


	private static final long serialVersionUID = 8780605158802086205L;

	private String pesquisa;
	
	private ItemVenda itemVenda;
	
	private List<Venda> listaVenda = null;
	
	public VendaController() {
		super(null);
	}
	
	public void adicionarProduto() {
		if (getEntity().getItemVenda() == null)
			getEntity().setItemVenda(new ArrayList<ItemVenda>());
		
		// relacionando o produto com a Venda
		getItemVenda().setVenda(getEntity());
		
		// adicionando o produtos na lista
		getEntity().getItemVenda().add(getItemVenda());
		
		//limpando o intens
		setItemVenda(null);
	}
	
	public void removerTelefone(ItemVenda itemVenda) {
		System.out.println(itemVenda.getProduto().getNome());
		getEntity().getItemVenda().remove(itemVenda);
	}
	
	
	public void limpar() {
		setEntity(null);
		listaVenda = null;
	}
	
	public void pesquisar() {
		VendaRepository repository = new VendaRepository(getEntityManager());
		listaVenda = repository.getVendas(pesquisa);
	}
	
	public List<Venda> getlistaVendas() {
		if (listaVenda == null)
			listaVenda = new ArrayList<Venda>();
		return listaVenda;
	}

	@Override
	public Venda getEntity() {
		if (entity == null) {
			entity = new Venda();
		}
		return entity;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public ItemVenda getItemVenda() {
		if (itemVenda == null) {
			itemVenda = new ItemVenda();
		}
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	
	


}
