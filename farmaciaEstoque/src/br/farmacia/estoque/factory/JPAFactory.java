package br.farmacia.estoque.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	//garante que a classe nao pode ser instanciada
	private JPAFactory() {}
	
	private static EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("farmaciaEstoque");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
