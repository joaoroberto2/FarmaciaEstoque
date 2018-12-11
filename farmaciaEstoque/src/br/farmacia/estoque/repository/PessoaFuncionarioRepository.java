package br.farmacia.estoque.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.farmacia.estoque.model.PessoaFuncionario;

public class PessoaFuncionarioRepository extends Repository<PessoaFuncionario> {
	
	public PessoaFuncionarioRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFuncionario> getFuncionarios(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From PessoaFuncionario p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<PessoaFuncionario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<PessoaFuncionario>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFuncionario> getFuncionarios() {
		List<PessoaFuncionario> lista = getEntityManager().
				createQuery("Select p From PessoaFuncionario p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<PessoaFuncionario>();
		return lista;
	}
}
