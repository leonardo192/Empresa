package br.com.empresa.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.empresa.site.entity.Departamento;
import br.com.empresa.site.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.findAll());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar (Departamento departamento , RedirectAttributes redirect) {
		service.save(departamento);
		redirect.addFlashAttribute("success", "Departamento cadastrado com sucesso!");
		ModelAndView mv = new ModelAndView("redirect:/departamentos/cadastrar");
		return mv;
	}	
	
	@GetMapping("/editar/{id}")
	public ModelAndView preEditar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/departamento/cadastro");
		mv.addObject("departamento", service.findById(id));
		
		return mv;
		
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes redirect) {
		service.update(departamento);
		redirect.addFlashAttribute("success", "Departamento atualizado com sucesso!");
		return "redirect:/departamentos/cadastrar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id, ModelMap model , RedirectAttributes redirect) {
		if(!service.departamentoTemCargos(id)) {
			service.delete(id);
			model.addAttribute("success", "Departamento excluido com sucesso!");
		} else {
			model.addAttribute("fail", "Erro ao tentar excluir o departamento, verifique se o mesmo possui cargos cadastrados!");
		}
			return listar(model);
			
	}
	
	/*
	 * @PostMapping("/salvar") public String salvar(Departamento departamento,
	 * RedirectAttributes attr) { service.save(departamento);
	 * attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
	 * return "redirect:/departamentos/cadastrar"; }
	 */
	
}
