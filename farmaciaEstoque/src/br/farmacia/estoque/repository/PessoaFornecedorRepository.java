package br.farmacia.estoque.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.farmacia.estoque.model.PessoaFornecedor;

public class PessoaFornecedorRepository extends Repository<PessoaFornecedor> {
	
	public PessoaFornecedorRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFornecedor> getFornecedores(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From PessoaFornecedor p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<PessoaFornecedor> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<PessoaFornecedor>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFornecedor> getFornecedores() {
		List<PessoaFornecedor> lista = getEntityManager().
				createQuery("Select p From PessoaFornecedor p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<PessoaFornecedor>();
		return lista;
	}
}
