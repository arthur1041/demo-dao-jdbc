package model.dao;

import java.util.List;

import model.entities.Entity;

public interface GenericDao {
	void insert(Entity entity);

	void update(Entity entity);
	
	void deleteById(Integer id);
	
	Entity findById(Integer id);

	List<Entity> findAll();
}
