package br.com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.projeto.model.PostagemModel;
import br.com.projeto.repository.PostagemRepository;

@RestController

public class PostagemController implements WebMvcConfigurer
{
	
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	
	@Autowired
	private PostagemRepository repository;
// FAÇO O GET DO HTTP e o Read DO CRUD COM O COMANDO .findAll()
	
	@GetMapping ("/postagem")
	public List<PostagemModel> findAllPostagem() 
	{		
		return repository.findAll();
	}
	
	@GetMapping ("/postagem/{id}")
	public Optional<PostagemModel>findByIdPostagem(@PathVariable Long id) 
	{		
		return repository.findById(id);
	}
	
	@GetMapping ("/postagem2/{titulo}")
	public Optional<PostagemModel>getByTitulo(@PathVariable String titulo) 
	{		
		return repository.findByTitulo(titulo);
	}
	
	
	@PostMapping ("/postagem")
	public PostagemModel criar (@RequestBody PostagemModel  postagem)
	{
		repository.save(postagem);
		return	postagem;		
	}


	
	
}
