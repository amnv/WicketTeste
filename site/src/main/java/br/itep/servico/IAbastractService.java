package br.itep.servico;

import java.util.List;

public interface IAbastractService <T> {
	void insert(T t);
	void delete(String id);
	List<T> list();
	T findById(String id);
	void resetDatabase();
	void update(T t);
}
