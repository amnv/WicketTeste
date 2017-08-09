package br.itep.servico;

import org.springframework.beans.factory.annotation.Autowired;

import br.itep.dataBase.IAbstractDAO;
import br.itep.entity.Buyer;

public class BuyerService extends AbstractService<Buyer> {
	
	@Autowired
	private IAbstractDAO<Buyer> dao;
	
	
	@Override
	public IAbstractDAO<Buyer> getDAO() {
		return this.dao;
	}

}
