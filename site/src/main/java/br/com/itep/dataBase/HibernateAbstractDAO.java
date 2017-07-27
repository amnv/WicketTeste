package br.com.itep.dataBase;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.itep.entity.Baker;


/**
 * Those functions must be overridden: list, findByCPF, resetDatabase
 * @author allyson.manoel
 * @param <T> type of Entity DAO related with database
 */

@Repository
public class HibernateAbstractDAO<T> implements IAbstractDAO<T> {
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateAbstractDAO(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void insert(T t) {
			this.sessionFactory.getCurrentSession().save(t);	
	}

	@Override
	@Transactional
	public void delete(String id) {
			T t = this.findById(id);
			sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public List list() {
		// must be overridden
		return null;
	}

	@Override
	public T findById(String id) {
		// must be overridden
		return null;
	}

	@Override
	public void resetDatabase() {
		// must be overridden
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
