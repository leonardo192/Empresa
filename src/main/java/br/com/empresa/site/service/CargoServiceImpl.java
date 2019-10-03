package br.com.empresa.site.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.site.dao.CargoDao;
import br.com.empresa.site.entity.Cargo;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao dao;
	
	@Override
	public void save(Cargo cargo) {
		dao.save(cargo);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public void update(Cargo cargo) {
		dao.update(cargo);
		
	}

	@Override
	public Cargo findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	
	public List<Cargo> findAll() {
		
		return dao.findAll();
	}

}
