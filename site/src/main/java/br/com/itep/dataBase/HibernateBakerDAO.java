package br.com.itep.dataBase;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.itep.entity.Baker;
import br.com.itep.exception.NonExistentException;

public class HibernateBakerDAO extends HibernateAbstractDAO<Baker> implements IBakerDAO {
	private static HibernateBakerDAO hibernateBakerDAO;

	private HibernateBakerDAO() {
		
	}

	public static HibernateBakerDAO getInstance() {
		if (hibernateBakerDAO == null)
			hibernateBakerDAO = new HibernateBakerDAO();
		return hibernateBakerDAO;
	}

	@Override
	public List list()
	{
		Session session = super.getSessionFactory().openSession();
		try {
			return session.createQuery("FROM Baker").list(); 
		}
		finally {
			session.close();
		}
	}
	
	@Override
	public Baker findByCPF(String cpf) {
		Session session = super.getSessionFactory().openSession();
		Baker baker = null;
		try {
			baker = (Baker) session.get(Baker.class, cpf);
			if (baker == null)
				throw new NonExistentException();
		} finally {
			session.close();
		}
		return baker;
	}

	@Override
	public void resetDatabase() {
		List<Baker> list = this.list();
		
		for (Baker baker : list) {
			System.out.println(baker.getName());
			this.delete(baker.getCpf());
		}
	}
	
	public List<Baker> listBakerProducerMoreThan(int qnt)
	{
		return  super.getSession().createQuery("FROM Baker B WHERE B.madeProductAmount > :qnt")
				.setParameter("qnt", qnt).list();
	}
}
