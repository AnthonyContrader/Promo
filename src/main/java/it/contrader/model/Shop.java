package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shop {

	@Id
	@Column(name = "idshop")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idshop;

	@ManyToOne
	@JoinColumn(name = "iduser")
	private Integer iduser ;

	@Column(name = "name")
	@NotNull
	private String name;
	
    @Column(name = "type")
	@NotNull
    private String type;

	@NotNull
	@Column(name = "position")
	private String position;
	
	@NotNull
	@Column(name = "barcode")
	private String barcode;
}