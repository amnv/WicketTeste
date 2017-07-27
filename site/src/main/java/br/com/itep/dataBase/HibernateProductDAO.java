package br.com.itep.dataBase;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.itep.entity.Product;

public class HibernateProductDAO extends HibernateAbstractDAO<Product> implements IProductDAO {

	public HibernateProductDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<Product> list() {
		// must be overridden
		return null;
	}

	@Override
	public Product findById(String id) {
		// must be overridden
		return null;
	}

	@Override
	public void resetDatabase() {
		// must be overridden
	}

}
