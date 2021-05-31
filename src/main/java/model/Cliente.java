package model;

public class Cliente {

	private String id;
	private String nome;
	private String email;
	private String credito;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getCredito() {
		return credito;
	}
	public void setCredito(String credito) {
		this.credito = credito;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
}
