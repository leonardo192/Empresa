package br.com.empresa.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.empresa.site.dao.FuncionarioDao;
import br.com.empresa.site.entity.Funcionario;


@Repository
@org.springframework.transaction.annotation.Transactional(readOnly=false)
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	FuncionarioDao dao;

	@Override
	public void save(Funcionario funcionario) {
		dao.save(funcionario);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public void update(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public Funcionario findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public List<Funcionario> findAll() {
		
		return dao.findAll();
	}

}
