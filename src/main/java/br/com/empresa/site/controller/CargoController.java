package br.com.empresa.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.empresa.site.entity.Cargo;
import br.com.empresa.site.entity.Departamento;
import br.com.empresa.site.service.CargoService;
import br.com.empresa.site.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService service;
	
	@Autowired
	private DepartamentoService serviceDep;

	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return"/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap map) {
		map.addAttribute("cargos", service.findAll());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Cargo cargo , RedirectAttributes redirect) {
	/*	if(!serviceDep.findAll().isEmpty()) {*/
		service.save(cargo);
		redirect.addFlashAttribute("success", "Cargo inserido com sucesso!");
		
		return new ModelAndView("redirect:/cargos/cadastrar");
	
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> lista(){
		return serviceDep.findAll();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("redirect:/cargos/cadastrar");
		mv.addObject("cargos", service.findById(id));
		return mv;
		
	}
	@PostMapping("/editar")
	public String editar(Cargo cargo) {
		service.update(cargo);
		return "redirect:/cargos/cadastrar";
		
	}
	
}
