package model.dao;

import model.dao.impl.SellerDaoImpl;

public class DaoFactory {
	public static GenericDao createSellerDao() {
		return new SellerDaoImpl();
	}
}
