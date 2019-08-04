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
@Table(name = "device")

public class Device {

	@Id
	@Column(name = "iddevice")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddevice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idclient")
	@NotNull
	private Client client;
	
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