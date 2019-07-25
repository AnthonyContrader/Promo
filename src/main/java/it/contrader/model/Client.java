package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Client {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int idclient;
	
	private int idmoderator;

	private String username;
	
	private String password;
	
	private String scode;
	
	private String email;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Client() {
		
	}

	public Client (int idmoderator, String username, String password,String scode, String email) {
		this.idmoderator = idmoderator;
		this.username = username;
		this.password = password;
		this.scode = scode;
		this.email = email;
	}

	public Client (int idclient, int idmoderator, String username, String password, String scode, String email) {
		this.idclient = idclient;
		this.idmoderator = idmoderator;
		this.username = username;
		this.password = password;
		this.scode = scode;
		this.email = email;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.idclient;
	}
	public void setId(int idclient) {
		this.idclient = idclient;
	}
	public int getIdmoderator() {
		return this.idmoderator;
	}
	public void setIdmoderator(int idmoderator) {
		this.idmoderator = idmoderator;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getScode() {
		return scode;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idclient + "\t" + idmoderator +"\t\t" + username +"\t\t" +   password + "\t\t" + scode + "\t\t" +   password + "\t\t" ;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idclient != other.idclient)
			return false;
		if (idmoderator != other.idmoderator)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (scode == null) {
			if (other.scode != null)
				return false;
		} else if (!scode.equals(other.scode))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		
		return true;
	}
}
