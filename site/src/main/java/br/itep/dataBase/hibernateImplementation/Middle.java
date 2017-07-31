package br.itep.dataBase.hibernateImplementation;

import org.springframework.beans.factory.annotation.Autowired;

import br.itep.entity.Baker;
import br.itep.entity.Product;

public class Middle {
	@Autowired
	private HibernateBakerDAO baker;
	@Autowired
	private HibernateProductDAO product;

	public void add(Baker b, Product p)
	{
		baker.insert(b);
		product.insert(p);
	}

	public HibernateBakerDAO getBaker() {
		return baker;
	}

	public void setBaker(HibernateBakerDAO baker) {
		this.baker = baker;
	}

	public HibernateProductDAO getProduct() {
		return product;
	}

	public void setProduct(HibernateProductDAO product) {
		this.product = product;
	}	
}
