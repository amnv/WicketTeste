package br.itep.dataBase.hibernateImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IProductDAO;
import br.itep.entity.Product;

@Repository
public class HibernateProductDAO extends HibernateAbstractDAO<Product> implements IProductDAO {

	@Autowired
	public HibernateProductDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Product> list() {
		return super.getSession().createCriteria(Product.class).list();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(String id) {
		return (Product) super.getSession().get(Product.class, id); 
	}

	@Override
	public void resetDatabase() {
		List<Product> p = this.list();
		
		for (Product product : p) this.delete(product.getId());
	}

}
