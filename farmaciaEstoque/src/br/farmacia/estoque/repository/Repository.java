package br.farmacia.estoque.repository;

import javax.persistence.EntityManager;

import br.farmacia.estoque.model.DefaultEntity;

public class Repository<T extends DefaultEntity<? super T>> {
	private EntityManager em = null;
	
	public Repository(EntityManager em) {
		this.em = em;
	}

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public T save(T entity) {
		return getEntityManager().merge(entity);
	}
	
	public void remove(T entity) {
		entity = getEntityManager().merge(entity);
		getEntityManager().remove(entity);
	}
	
	public T find(Integer id, Class<T> clazz) {
		return  getEntityManager().find(clazz, id);
	}
}
