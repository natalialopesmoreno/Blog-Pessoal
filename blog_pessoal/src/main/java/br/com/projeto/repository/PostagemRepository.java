package br.com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	Optional<PostagemModel> findByTitulo(String titulo);

}
