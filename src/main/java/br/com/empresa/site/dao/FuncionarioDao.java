package br.com.empresa.site.dao;

import java.util.List;

import br.com.empresa.site.entity.Funcionario;



public interface FuncionarioDao {

	
	
	void save(Funcionario funcionario);

	void delete(Long id);

	void update(Funcionario funcionario);

	Funcionario findById(Long id);

	List<Funcionario> findAll();
}
