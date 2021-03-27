package br.edu.fatecourinhos.exitus.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.edu.fatecourinhos.exitus.domain.Egresso;

public class EgressoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 3 , max = 100, message = "O nome deve ter entre 3 a 5 caracteres")
	private String nome;
	private String rg;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String usuario;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String senha;
	
	public EgressoNewDTO() {
		
	}

	public EgressoNewDTO(Egresso egresso) {
		nome = egresso.getNome();
		rg = egresso.getRg();
		cpf = egresso.getCpf();
		email = egresso.getEmail();
		usuario = egresso.getUsuario();
		senha = egresso.getSenha();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
