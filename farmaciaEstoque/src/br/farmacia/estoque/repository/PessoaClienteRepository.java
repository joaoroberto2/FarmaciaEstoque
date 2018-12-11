package br.farmacia.estoque.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.farmacia.estoque.model.PessoaCliente;

public class PessoaClienteRepository extends Repository<PessoaCliente> {
	
	public PessoaClienteRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaCliente> getClientes(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From PessoaCliente p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<PessoaCliente> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<PessoaCliente>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaCliente> getClientes() {
		List<PessoaCliente> lista = getEntityManager().
				createQuery("Select p From PessoaCliente p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<PessoaCliente>();
		return lista;
	}
}
