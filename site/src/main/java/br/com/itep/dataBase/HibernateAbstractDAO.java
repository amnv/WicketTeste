package br.com.itep.dataBase;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.itep.entity.Baker;


/**
 * Those functions must be overridden: list, findByCPF, resetDatabase
 * @author allyson.manoel
 * @param <T> type of Entity DAO related with database
 */
public class HibernateAbstractDAO<T> implements IAbstractDAO<T> {
	private static HibernateBakerDAO hibernateBakerDAO;
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;
	
	public HibernateAbstractDAO() {
		Configuration configuration = new Configuration().configure();

		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	@Override
	public void insert(T t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String id) {
		Transaction tx = null;
		Session session = null;

		try {
			T t = this.findByCPF(id);
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(t);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public List<T> list() {
		// must be overridden
		return null;
	}

	@Override
	public T findByCPF(String id) {
		// must be overridden
		return null;
	}

	@Override
	public void resetDatabase() {
		//// must be overridden
	}
	 
	@Override
	public void disconect() {
		this.sessionFactory.close();
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
