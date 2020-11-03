package br.com.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="tb_postagem")
public class PostagemModel 
{
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String titulo;
	
	@Column
	@NotNull
	private String autor;
	
	@Column
	private String descricao;
	
	@Column
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date data;
	
	
	
	//GETTERS AND SETTERS
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
	
}
