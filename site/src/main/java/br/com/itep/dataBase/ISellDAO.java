package br.com.itep.dataBase;

import java.util.List;

import br.com.itep.entity.CashDesk;
import br.com.itep.entity.Sell;

public interface ISellDAO extends IAbstractDAO<Sell> {
	List<CashDesk> listAvailableCashDesk();
}
