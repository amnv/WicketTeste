package br.com.itep.dataBase;

import java.util.List;

import br.com.itep.entity.Baker;
import br.com.itep.entity.Product;

public interface IBakerDAO extends IAbstractDAO<Baker> {
	List<Product> listProductsAllMade();

	void addProducts(List<Product> products);

	List<Baker> listBakerProducedMoreThan(int qnt);
}
