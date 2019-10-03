package br.com.empresa.site.service;

import java.util.List;

import br.com.empresa.site.entity.Cargo;


public interface CargoService {

	
	void save(Cargo cargo);

	void delete(Long id);

	void update(Cargo cargo);

	Cargo findById(Long id);

	List<Cargo> findAll();
}
