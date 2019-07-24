package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Screen {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int idscreen;

	private String output;
	
	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Screen() {
		
	}

	public Screen (String output) {
		this.output = output;
	}

	public Screen (int idscreen, String output) {
		this.idscreen = idscreen;
		this.output = output;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getIdscreen() {
		return this.idscreen;
	}
	public void setIdscreen(int idscreen) {
		this.idscreen = idscreen;
	}

	
	public void setOutput(String output) {
		this.output = output;
	}

	public String getOutput() {
		return output;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idscreen + "\t"  + output;
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
		Screen other = (Screen) obj;
		if (idscreen != other.idscreen)
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		return true;
	}
}
