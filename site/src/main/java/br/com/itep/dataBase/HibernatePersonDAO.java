package br.com.itep.dataBase;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.itep.entity.Person;
import br.com.itep.exception.AlreadyInsertedException;
import br.com.itep.exception.NonExistentException;

public class HibernatePersonDAO implements IPersonDAO {
	private SessionFactory sessionFactory;
	private static HibernatePersonDAO hibernatePersonDAO;
	
	private HibernatePersonDAO() {
		 this.sessionFactory = new Configuration().configure()
					.buildSessionFactory();
	}
	
	public static HibernatePersonDAO getInstance()
	{
		if (hibernatePersonDAO == null) return new HibernatePersonDAO();
		return hibernatePersonDAO; 
	}
	
	@Override
	public void insert(Person person) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(person);
			session.getTransaction();
		} catch (Exception e) {
			throw new AlreadyInsertedException();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(String cpf) {
		Transaction tx = null;
		Session session = null;
		
		try {
			Person p = this.findByCPF(cpf);
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(p);
			tx.commit();
			
		} catch (NonExistentException e1)
		{
			throw new NonExistentException();
		}
		catch (Exception e) {
			if (!tx.wasCommitted())
			{
				tx.rollback();
			}
		}
		finally {
			 session.flush(); 
		     session.close();
		}
	}

	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		try {
			return session.createQuery("from person").list(); 
		}
		finally {
			session.close();
		}
	}

	@Override
	public Person findByCPF(String cpf) {
		Session session = this.sessionFactory.openSession();
		Person p =  null;
		try {
			p = (Person) session.get(Person.class, cpf);
			if (p == null) throw new NonExistentException();
		} finally {
			session.close();
		}
		return p;
	}
	
	@Override
	public void resetDatabase() {
		List<Person> list = this.list();
		for (Person person : list) {
			this.delete(person.getCpf());
		}
	}

}
