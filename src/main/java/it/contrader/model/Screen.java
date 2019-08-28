package it.contrader.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	private String output;
	
	private String position;
	
	
}

	

