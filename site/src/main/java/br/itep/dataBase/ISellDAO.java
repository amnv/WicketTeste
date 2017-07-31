package br.itep.dataBase;

import java.util.List;

import br.itep.entity.CashDesk;
import br.itep.entity.Sell;
import br.itep.entity.Sell_composed_key;

public interface ISellDAO extends IAbstractDAO<Sell> {
	List<CashDesk> listAvailableCashDesk();
	
	/**
	 * alternative findById for Sell entity
	 * @param pk a wrapper of four entities
	 * Product, seller, buyer and cashdesk
	 * and a date for make a key  
	 * @return Return a Sell from the table
	 */
	Sell findById(Sell_composed_key pk);
	
	/**
	 * alternative delete for Sell entity
	 * @param pk a wrapper of four entities
	 * Product, seller, buyer and cashdesk
	 * and a date for make a key  
	 */
	void delete(Sell_composed_key pk);
}
