package br.itep.dataBase.hibernateImplementation;
/**
 * @author allyson.manoel
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.IPersonDAO;
import br.itep.entity.Person;
import br.itep.exception.NonExistentException;

@Repository
public class HibernatePersonDAO extends HibernateAbstractDAO<Person> implements IPersonDAO {
	
	public HibernatePersonDAO(final SessionFactory factory) {
		super(factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Person> list() {
		return super.getSession().createQuery("FROM Person").list(); 
	}

	@Override
	@Transactional(readOnly = true)
	public Person findById(String cpf) {
		Person p = (Person) super.getSession().get(Person.class, cpf);
		if (p == null) throw new NonExistentException();
		
		return p;
	}
	
	@Override
	@Transactional
	public void resetDatabase() {
		List<Person> list = this.list();
		
		for (Person person : list) 
			super.delete(person.getCpf());
	}

}
