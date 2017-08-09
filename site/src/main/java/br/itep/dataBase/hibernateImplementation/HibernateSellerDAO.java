package br.itep.dataBase.hibernateImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.ISellerDAO;
import br.itep.entity.Seller;

@Repository
public class HibernateSellerDAO extends HibernateAbstractDAO<Seller> implements ISellerDAO {

	public HibernateSellerDAO() {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Seller> list() {
		return super.getSession().createCriteria(Seller.class).list();
	}

	@Override
	@Transactional(readOnly = true)
	public Seller findById(String id) {
		return (Seller) super.getSession().get(Seller.class, id);
	}

	@Override
	@Transactional
	public void resetDatabase() {
		List<Seller> s = this.list();
		
		for(Seller seller : s) super.delete(seller.getCpf());
	}

}
