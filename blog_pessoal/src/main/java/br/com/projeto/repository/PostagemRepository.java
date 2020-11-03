package br.com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	//INSERINDO MÉTODOS PERSONALIZADOS
	
	
	public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);

}
