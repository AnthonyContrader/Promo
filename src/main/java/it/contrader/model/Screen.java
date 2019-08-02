package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Screen {
	
	@Id
	@Column(name = "idscreen")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idscreen;
	
	@Column(name = "output")
	@NotNull
	private String output;
	
	@Column(name = "position")
	@NotNull
	private String position;
	
	
	
}
