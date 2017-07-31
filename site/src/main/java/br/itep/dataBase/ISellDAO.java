package br.itep.dataBase;

import java.util.List;

import br.itep.entity.CashDesk;
import br.itep.entity.Sell;

public interface ISellDAO extends IAbstractDAO<Sell> {
	List<CashDesk> listAvailableCashDesk();
}
