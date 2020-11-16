package br.com.projeto.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projeto.model.TemaModel;
import br.com.projeto.repository.TemaRepository;

@Controller
public class ControllerGeral
{

	@Autowired
	private TemaRepository repository;
	
	@GetMapping("/")
	public String login()
	{
		return "index";
	}
	
	@RequestMapping(value = "/cadastrarTema", method=RequestMethod.GET)
	public String form() 
	{
		return "formTema";
	}
	
	@PostMapping(value="/cadastrarTema")
	public String form(TemaModel tema) 
	{
		repository.save(tema);
		return "redirect:/cadastrarTema";
	}
	
	
	
	
}
