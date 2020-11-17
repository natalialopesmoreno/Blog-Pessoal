package br.com.projeto.postagem;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projeto.repository.TemaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemaRepositoryIntegrationTest 
{

	
	@Autowired
	private TemaRepository repository;
	
	
	
	
}
