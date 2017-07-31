package br.itep.dataBase.hibernateImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.ICashDeskDAO;
import br.itep.entity.CashDesk;

@Repository
public class HibernateCashDeskDAO extends HibernateAbstractDAO<CashDesk> implements ICashDeskDAO {

	@Autowired
	public HibernateCashDeskDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


	@Override
	@Transactional(readOnly = true)
	public List<CashDesk> list() {
		return super.getSession().createCriteria(CashDesk.class).list();
	}

	@Override
	@Transactional(readOnly = true)
	public CashDesk findById(String id) {
		return (CashDesk) super.getSession().get(CashDesk.class, id);
	}

	@Override
	@Transactional
	public void resetDatabase() {
		List<CashDesk> l = this.list();
		
		for (CashDesk cashDesk : l) super.delete(cashDesk.getId());
	}


}
