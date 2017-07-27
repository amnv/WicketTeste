package br.com.itep.dataBase;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.itep.entity.Baker;
import br.com.itep.entity.Product;
import br.com.itep.exception.NonExistentException;

@Repository
public class HibernateBakerDAO extends HibernateAbstractDAO<Baker> implements IBakerDAO {
	
	@Autowired
	public HibernateBakerDAO(final SessionFactory factory) {
		super(factory);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Baker> list()
	{
		return super.getSessionFactory().getCurrentSession().createQuery("FROM Baker").list(); 
	}
	
	@Override
	@Transactional(readOnly = true)
	public Baker findById(String cpf) {
		Baker baker = (Baker) super.getSessionFactory().getCurrentSession().get(Baker.class, cpf);
		if (baker == null)
			throw new NonExistentException();
		return baker;
	}

	@Override
	@Transactional
	public void resetDatabase() {
		List<Baker> list = this.list();
		
		for (Baker baker : list) super.delete(baker.getCpf());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Baker> listBakerProducedMoreThan(int qnt)
	{
		return  super.getSessionFactory().getCurrentSession().createQuery("FROM Baker B WHERE B.madeProductAmount > :qnt")
				.setParameter("qnt", qnt).list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> listProductsAllMade() {
		return null;
	}

	@Override
	public void addProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}
}