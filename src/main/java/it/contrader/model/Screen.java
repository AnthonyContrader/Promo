package it.contrader.model;

import javax.persistence.*;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmoderator")
	@NotNull
	private User user;
	
	@Column(name = "output")
	@NotNull
	private String output;
	
	@Column(name = "position")
	@NotNull
	private String position;
	
	
	
}
