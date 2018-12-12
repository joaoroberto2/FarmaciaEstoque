package br.farmacia.estoque.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.farmacia.estoque.model.Venda;

public class VendaRepository extends Repository<Venda> {
	
	public VendaRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> getVendas(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From Venda p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Venda> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Venda>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> getVendas() {
		List<Venda> lista = getEntityManager().
				createQuery("Select p From Venda p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Venda>();
		return lista;
	}
}
