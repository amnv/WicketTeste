package br.itep.dataBase;

import java.util.List;

import br.itep.entity.Baker;
import br.itep.entity.Product;

public interface IBakerDAO extends IAbstractDAO<Baker> {
	List<Product> listProductsAllMade();

	void addProducts(List<Product> products);

	List<Baker> listBakerProducedMoreThan(int qnt);
}
