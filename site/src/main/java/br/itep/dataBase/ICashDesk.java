package br.itep.dataBase;

import br.itep.entity.CashDesk;

public interface ICashDesk extends IAbstractDAO<CashDesk> {
	void addShopPrice(double value);
}
