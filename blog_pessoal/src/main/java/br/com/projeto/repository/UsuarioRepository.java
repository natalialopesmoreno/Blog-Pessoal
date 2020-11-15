package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> 
{

	public Usuario findByLogin(String usuario);
	
}
