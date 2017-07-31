package br.itep.dataBase.hibernateImplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IBakerDAO;
import br.itep.entity.Baker;
import br.itep.entity.Product;
import br.itep.exception.NonExistentException;

@Repository
public class HibernateBakerDAO extends HibernateAbstractDAO<Baker> implements IBakerDAO {
	
	@Autowired
	public HibernateBakerDAO(final SessionFactory factory) {
		super(factory);
	}

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
		List<Baker> bakers = this.list();
		List<Product> product = new ArrayList<>();
	
		for (Baker baker : bakers) product.addAll(baker.getProduct());
		
		return product;
	}

}
