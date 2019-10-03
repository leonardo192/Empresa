package br.com.empresa.site.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.site.dao.DepartamentoDao;
import br.com.empresa.site.entity.Departamento;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	DepartamentoDao dao;

	@Override
	public void save(Departamento departamento) {
		dao.save(departamento);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public void update(Departamento departamento) {
		dao.update(departamento);
		
	}

	@Override
	public Departamento findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Departamento> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if(findById(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
