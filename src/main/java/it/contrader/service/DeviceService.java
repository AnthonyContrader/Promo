package it.contrader.service;

import it.contrader.converter.DeviceConverter;
import it.contrader.dao.DeviceDAO;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class DeviceService extends AbstractService<Device, DeviceDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public DeviceService(){
		this.dao = new DeviceDAO();
		this.converter = new DeviceConverter();
	}
	

}
