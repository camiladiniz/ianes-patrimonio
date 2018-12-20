package br.senai.sp.info.patrimonio.ianes.models;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.DigestUtils;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue//auto_increment
	private Long id;
	
	@Column(length = 20, nullable = false, unique = false)
	@NotNull
	@Size(min = 1, max = 20)
	private String nome;
	
	@Column(length = 40, nullable = false, unique = false)
	@NotNull
	@Size(min = 1, max = 40)
	private String sobrenome;
	
	@Column(length = 120, nullable = false, unique = true)
	@NotNull
	@Email
	@Size(min = 1, max = 120)
	private String email;
	
	@Column(length = 32, nullable = false, unique = false)
	@NotNull
	//@Size(min = 6, max = 20)
	private String senha;
	
	@Column(nullable = false, unique = false)
	private TipoUsuario tipo;
	
	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	@Transient
	private String caminhoFoto;
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	public void hashearSenha() {
		this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes());
	}
	
	
}
