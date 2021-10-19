package br.edu.facthus.jpa.bean;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.facthus.jpa.entity.Contato;

@Stateless
public class ContatosBean {
	
	@SuppressWarnings("unused")
	private static final Logger logger = 
			Logger.getLogger(ContatosBean.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Insert
	public void cadastra(Contato contato) {
		entityManager.persist(contato);
	}
	
	// Update
	public void atualiza(Contato contato) {
		entityManager.merge(contato);
	}
	
	// Delete
	public void remove(Contato contato) {
		Contato c = entityManager.find(Contato.class, contato.getId());
		
		if (c != null)
			entityManager.remove(c);
	}
	
	public List<Contato> lista() {
		return entityManager
				.createNamedQuery("Contato.findAll", Contato.class)
				.getResultList();
	}
	
	public List<Contato> buscaPorNome(String nome) {
		return entityManager
				.createNamedQuery("Contato.findByNome", Contato.class)
				.setParameter("nome", String.format("%%%s%%", nome.toUpperCase()))
				.getResultList();
	}

}
