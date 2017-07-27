package br.com.itep.dataBase;

import br.com.itep.entity.Seller;

public interface ISellerDAO extends IAbstractDAO<Seller> {
	void addQNTProductSold(int qnt);
}
