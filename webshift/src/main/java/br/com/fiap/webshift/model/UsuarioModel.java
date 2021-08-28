package br.com.fiap.webshift.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UsuarioModel {
	
    @Id
    @Column(name="ID_USUARIO")
	private int id;

    @Column(name="NOME")
	private String nome;

    @Column(name="EMAIL")
	private String email;

    @Column(name="SENHA")
	private String senha;

    @Column(name="FOTO")
	private String foto;

	public UsuarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioModel(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public UsuarioModel(int id, String nome, String email, String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
