package br.itep.dataBase;

import java.util.List;

import org.hibernate.Session;

public interface IAbstractDAO<T> {
	void insert(T t);
	void delete(String id);
	List<T> list();
	T findById(String id);
	void resetDatabase();
	void update(T t);
}
