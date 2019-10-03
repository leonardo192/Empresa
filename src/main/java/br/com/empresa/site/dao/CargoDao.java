package br.com.empresa.site.dao;

import java.util.List;

import br.com.empresa.site.entity.Cargo;



public interface CargoDao {

	
	void save(Cargo cargo);

	void delete(Long id);

	void update(Cargo cargo);

	Cargo findById(Long id);

	List<Cargo> findAll();
}
