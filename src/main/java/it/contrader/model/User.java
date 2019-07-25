package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class User {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String username;
	
	private String password;
	
	private String usertype;
	
	private int barcode;
	
	private String scode;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public User() {
		
	}

	public User (String username, String password, String usertype, int barcode, String scode) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.barcode = barcode;
		this.scode = scode;
	}

	public User (int id, String username, String password, String usertype, int barcode, String scode) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.barcode = barcode;
		this.scode = scode;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public int getBarcode() {
		return barcode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getScode() {
		return scode;
	}
	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + username +"\t\t" +   password + "\t\t" + usertype + "\t\t" + barcode + "\t\t" + scode;
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
		User other = (User) obj;
		if (id != other.id)
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
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		if (barcode == 0) {
			if (other.barcode != 0)
				return false;
		} else if (barcode != other.barcode)
			return false;
		if (scode == null) {
			if (other.scode != null)
				return false;
		} else if (!scode.equals(other.scode))
			return false;
		return true;
	}
}
