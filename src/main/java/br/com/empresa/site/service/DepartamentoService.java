package br.com.empresa.site.service;

import java.util.List;

import br.com.empresa.site.entity.Departamento;

public interface DepartamentoService {
	
	void save(Departamento departamento);

	void delete(Long id);

	void update(Departamento departamento);

	Departamento findById(Long id);

	List<Departamento> findAll();

	boolean departamentoTemCargos(Long id);

}
