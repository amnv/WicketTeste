package br.itep.dataBase.hibernateImplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.itep.dataBase.ISellDAO;
import br.itep.entity.CashDesk;
import br.itep.entity.Sell;
import br.itep.entity.Sell_composed_key;

@Repository
public class HibernateSellDAO extends HibernateAbstractDAO<Sell> implements ISellDAO {

	@Autowired
	public HibernateSellDAO(SessionFactory factory) {
		super(factory);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<CashDesk> listAvailableCashDesk() {
		List<CashDesk> cashdesck = new ArrayList<>();
		List<Sell> sells = super.getSession().createCriteria(Sell.class).list();
		
		for (Sell sell : sells) {
			CashDesk cdAux = sell.getPK().getCashDesk(); 
			if (cdAux.isAvailable())
			{
				cashdesck.add(cdAux);
			}
		}
		return cashdesck;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sell> list() {
		return super.getSession().createCriteria(Sell.class).list();
	}

	/**
	 * this method don't work
	 * use findById(Sell_composed_key) one
	 * @return return null
	 */
	@Deprecated
	@Override
	public Sell findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void resetDatabase() {
		List<Sell> l = this.list();
		
		for (Sell sell : l) this.delete(sell.getPK());
	}

	@Override
	@Transactional(readOnly = true)
	public Sell findById(Sell_composed_key pk) {
		return (Sell) super.getSession().get(Sell.class, pk);
	}

	@Override
	@Transactional
	public void delete(Sell_composed_key pk) {
		super.getSession().delete(this.findById(pk));
	}
}
