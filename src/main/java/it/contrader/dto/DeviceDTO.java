package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

	private Integer iddevice;

//	private int idclient;
	private ClientDTO client;
	
	private String mac;
	
	private String devtype;

	private String position;
	
}
