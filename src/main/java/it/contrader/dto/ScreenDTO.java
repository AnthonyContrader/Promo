package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class ScreenDTO {
	
	private int idscreen;

	private String output;
	
		
	public ScreenDTO() {
		
	}

	public ScreenDTO (String output) {
		this.output = output;
	}

	public ScreenDTO (int idscreen, String output) {
		this.idscreen = idscreen;
		this.output = output;
	}

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

	@Override
	public String toString() {
		return  idscreen + "\t\t"  + output;
	}
}
