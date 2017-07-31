package br.itep.dataBase;

import java.util.List;

import org.hibernate.Session;

public interface IAbstractDAO <T> {
	public void insert(T t);
	public void delete(String id);
	public List<T> list();
	public T findById(String id);
	public void resetDatabase();
}
