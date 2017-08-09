package br.itep.servico;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IAbstractDAO;

@Service
@Transactional(readOnly = false)
public abstract class AbstractService <T> implements IAbastractService<T> {
	
	public abstract IAbstractDAO<T> getDAO();

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public T findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
