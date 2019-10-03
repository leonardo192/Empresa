package br.com.empresa.site.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.site.entity.Departamento;
import br.com.empresa.site.service.DepartamentoService;


@Component
public class StringToDepartamentoConvertor implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
		return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}

}
