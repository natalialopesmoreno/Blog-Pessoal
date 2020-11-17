package br.com.projeto.postagem;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.model.PostagemModel;
import br.com.projeto.repository.PostagemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostagemRepositoryIntegrationTest 
{

	@Autowired
	private PostagemRepository repository;
	
	@Before
	public void start() {
		PostagemModel postagem = new PostagemModel("Classe de Testes", 2020, "Admin", "Utilizando JUnity para Testes");
		repository.save(postagem);
		PostagemModel postagem2 = new PostagemModel("Classe de Testes 22", 2020, "Admin22", "Utilizando JUnity para Testes22");
		repository.save(postagem2);
		PostagemModel postagem3 = new PostagemModel("Classe de Testes 333", 2020, "Admin333", "Utilizando JUnity para Testes333");
		repository.save(postagem3);
		
	}
	
	@Test
	public void testeFindAllByTitulo() 
	{
		List<PostagemModel> postagens = repository.findAllByTituloIgnoreCaseContaining("Testes");
		Assert.assertEquals(3, postagens.size());
	}
	

	
}
