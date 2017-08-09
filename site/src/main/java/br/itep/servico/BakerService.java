package br.itep.servico;

import org.springframework.beans.factory.annotation.Autowired;

import br.itep.dataBase.IAbstractDAO;
import br.itep.entity.Baker;

public class BakerService extends AbstractService<Baker> {
	
	@Autowired
	private IAbstractDAO<Baker> dao;
	
	@Override
	public IAbstractDAO<Baker> getDAO() {
		return this.dao;
	}

}
