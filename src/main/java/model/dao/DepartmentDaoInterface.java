package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDaoInterface {
	
	void insert(Department dep);
	void update(Department dep);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
	
}
