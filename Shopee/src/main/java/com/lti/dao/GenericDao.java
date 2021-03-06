package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public Object save(Object obj) {
		return entityManager.merge(obj);
	}

	public <E> E fetchById(Class<E> clazz, int id) {
		return entityManager.find(clazz, id);
	}

	public <E> List<E> fetchAll(Class<E> clazz) {
		String q = "select obj from " + clazz.getName() + " as obj";
		return entityManager.createQuery(q).getResultList();
	}
	
	public void delete(Object obj) {
		entityManager.remove(obj);
	}
}
