package br.com.projeto.postagem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.model.Usuario;
import br.com.projeto.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuarioRepositoryIntegrationTest {

	

	@Autowired
	private UsuarioRepository repository;
	
	
	@Before
	public void start() {
		Usuario user = new Usuario("jose.lopes", "1234", "José");
		repository.save(user);
		Usuario user2 = new Usuario("maria.soares", "1234", "Maria");
		repository.save(user2);
		Usuario user3 = new Usuario("helena.lordello", "1234", "Helena");
		repository.save(user3);
		
	}
	
	@Test
	public void testeFindByLogin() 
	{
		
		Usuario user = repository.findByLogin("maria.soares");
		Assert.assertEquals("Maria", user.getNome());
	}
	
}
