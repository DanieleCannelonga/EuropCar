package main.java.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public abstract class AbstractService<T extends AbstractDAO<E>,E> {

	/*
	 * Classe Service Astratta per la gestione
	 * di tutte le altre classi Service presenti
	 * in questo package (extends)
	 */
	
	private T dao;

	public AbstractService() {
		dao = createDAO();
	}

	public void persistOrUpdate(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.perOrUp(entity);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public void persist(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void update(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public E findById(Serializable id) {
		dao.openCurrentSession();
		E aula = dao.findById(id);
		dao.closeCurrentSession();
		return aula;
	}

	public void deleteObj (E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.delete(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void delete(Serializable id) {
		dao.openCurrentSessionwithTransaction();
		E aula = dao.findById(id);
		dao.delete(aula);
		dao.closeCurrentSessionwithTransaction();
	}

	public void refresh(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.getCurrentSession().refresh(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	@Transactional
	public List<E> findAll() {
		dao.openCurrentSession();
		List<E> all = dao.findAll();
		dao.closeCurrentSession();
		return all;
	}

	public void deleteAll() {
		dao.openCurrentSessionwithTransaction();
		dao.deleteAll();
		dao.closeCurrentSessionwithTransaction();
	}

	public T getDao() {
		return dao;
	}

	public abstract T createDAO();

	public List<E> executeHQLQueryDef(String hql) {
		dao.openCurrentSessionwithTransaction();
		List<E> result = dao.getCurrentSession().createQuery(hql, dao.getPersistentClass()).getResultList();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public <TYPE extends Object> List<TYPE> executeHQLHyperGeneric(String hql, Class<TYPE> returntype) {
		getDao().openCurrentSessionwithTransaction();
		List<TYPE> result = getDao().getCurrentSession().createQuery(hql, returntype).getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}
	
	public <TYPE extends Object> List<TYPE>executeParamizedHQLQuery(String hql, Class<TYPE> returntype) {
		  getDao().openCurrentSessionwithTransaction();
		  List<TYPE> result = getDao().getCurrentSession().createQuery(hql, returntype).getResultList();
		  getDao().closeCurrentSessionwithTransaction();
		  return result;
		 }

	public List<E> findWithCriteria(Criterion... criterions) {

		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria c = dao.getCurrentSession().createCriteria(dao.getPersistentClass());

		for (Criterion pippo : criterions) {
			c.add(pippo);
		}

		@SuppressWarnings("unchecked")
		List<E> result = c.list();
		dao.closeCurrentSessionwithTransaction();

		return result;
	}

	public List<E> findWithCriteriaAndOrder(Order order, Criterion... criterions) {

		dao.openCurrentSessionwithTransaction();
		@SuppressWarnings("deprecation")
		Criteria c = dao.getCurrentSession().createCriteria(dao.getPersistentClass());
		for (Criterion pippo : criterions) {
			c.add(pippo);
		}
		c.addOrder(order); //Order.asc("id");
		@SuppressWarnings("unchecked")
		List<E> result = c.list();
		dao.closeCurrentSessionwithTransaction();

		return result;
	}
}