package br.com.fiap.VistoriaPS.model.entity;

import jakarta.validation.constraints.NotNull;

public class Cadastro {
	
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String senha;
	@NotNull
	private String email;
	
	public Cadastro() {
		
	}


	
	public Cadastro(Long id, @NotNull String nome, @NotNull String senha, @NotNull String email) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


	
	

}
