package model.dao;

import model.impl.DepartmentDaoImpl;
import model.impl.SellerDaoImpl;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoImpl();
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoImpl();
	}
	
}
