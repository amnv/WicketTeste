package br.itep.dataBase.hibernateImplementation;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IAbstractDAO;


/**
 * Those functions must be overridden: list, findByCPF, resetDatabase
 * @author allyson.manoel
 * @param <T> type of Entity DAO related with database
 */

@Repository
public abstract class HibernateAbstractDAO<T> implements IAbstractDAO<T> {
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
	abstract public List<T> list();

	@Override
	abstract public T findById(String id);

	@Override
	abstract public void resetDatabase();

	@Transactional
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Transactional
	public Session getSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void update(T t)
	{
		this.getSession().update(t);
	}
}
