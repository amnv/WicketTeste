package br.itep.dataBase.hibernateImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IBuyerDAO;
import br.itep.entity.Buyer;

@Repository
public class HibernateBuyerDAO extends HibernateAbstractDAO<Buyer> implements IBuyerDAO {

	@Autowired
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
	@Transactional(readOnly = true)
	public Buyer findById(String id) {
		return (Buyer) super.getSession().get(Buyer.class, id);
	}

	@Override
	@Transactional
	public void resetDatabase() {
		List<Buyer> l = this.list();
		
		for (Buyer buyer : l) super.delete(buyer.getCpf());
	}

	

}
