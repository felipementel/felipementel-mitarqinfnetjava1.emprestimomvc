package br.com.emprestimomvc.model.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(name = "Nome")
	private String Nome;

	private String Login;

	private String Senha;

	public Usuario() {

	};

	public Usuario(String nome, String login, String senha) {
		this();
		Nome = nome;
		Login = login;
		Senha = senha;
	};

	public Usuario(Integer id, String nome, String login, String senha) {
		this(nome, login, senha);
		this.Id = id;
	};

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s", this.getId(), this.getLogin(), this.getNome(), this.getSenha());
	}
}
