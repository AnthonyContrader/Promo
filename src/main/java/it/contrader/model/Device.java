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
public class Device {

	@Id
	@Column(name = "iddevice")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddevice;

	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client idclient;
	
	@Column(name = "mac")
	@NotNull
	private String mac;

	@Column(name = "devtype")
	@NotNull
	private String devtype;

	@NotNull
	@Column(name = "position")
	private String position;
}