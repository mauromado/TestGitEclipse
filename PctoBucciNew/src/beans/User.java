package beans;

public class User {
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private String paese;

	public User(String nome, String cognome, String paese) {
		this.nome = nome;
		this.cognome = cognome;
		this.paese = paese;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return nome;
	}

	public void setFirstname(String nome) {
		this.nome = nome;
	}

	public String getLastname() {
		return cognome;
	}

	public void setLastname(String cognome) {
		this.cognome = cognome;
	}

	public String getCountry() {
		return paese;
	}

	public void setCountry(String paese) {
		this.paese = paese;
	}

}
