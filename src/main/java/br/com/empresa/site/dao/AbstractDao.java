package br.com.empresa.site.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public abstract class AbstractDao <T,PK extends Serializable> {
	
	@SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) 
            ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	
	@PersistenceContext
	private EntityManager manager;
	
	
	protected EntityManager getManager() {
		return manager;
	}
	
	public void save(T entity) {
		manager.persist(entity);

	}
	
	public void delete(PK id) {
		manager.remove(manager.getReference(entityClass, id));

	}
	
	public void update(T entity) {
		manager.merge(entity);
	}
	
	
	public T findById(PK id) {
	 return manager.find(entityClass, id);

	}
	
	
	public List<T> findAll(){
		return manager.createQuery("from "+ entityClass.getSimpleName(),entityClass).getResultList();
	}

}
