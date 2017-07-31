package br.itep.dataBase.hibernateImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IBuyerDAO;
import br.itep.entity.Buyer;

public class HibernateBuyerDAO extends HibernateAbstractDAO<Buyer> implements IBuyerDAO {

	public HibernateBuyerDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Buyer> list() {
		return super.getSessionFactory().getCurrentSession().createCriteria(Buyer.class).list();
	}

	@Override
	public Buyer findById(String id) {
		return (Buyer) super.getSession().get(Buyer.class, id);
	}

	@Override
	public void resetDatabase() {
		List<Buyer> l = this.list();
		
		for (Buyer buyer : l) super.delete(buyer.getCpf());
	}

	

}
