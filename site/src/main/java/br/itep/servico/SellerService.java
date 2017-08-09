package br.itep.servico;

import org.springframework.beans.factory.annotation.Autowired;

import br.itep.dataBase.IAbstractDAO;
import br.itep.entity.Seller;

public class SellerService extends AbstractService<Seller> {

	@Autowired
	private IAbstractDAO<Seller> dao;
	
	@Override
	public IAbstractDAO<Seller> getDAO() {
		return this.dao;
	}

}
