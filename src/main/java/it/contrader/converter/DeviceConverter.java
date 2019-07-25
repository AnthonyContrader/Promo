package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe DeviceConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class DeviceConverter  implements Converter<Device, DeviceDTO> {
	
	/**
	 * Crea un oggetto di tipo DeviceDTO e lo riempie con i campi del parametro Device di tipo Device.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = new DeviceDTO(device.getIddevice(), device.getIdclient(), device.getMac(), device.getDevtype(), device.getPosition());
		return deviceDTO;
	}

	/**
	 * Crea un oggetto di tipo Device e lo riempie con i campi del parametro Device di tipo DeviceDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Device toEntity(DeviceDTO deviceDTO) {
		Device device = new Device(deviceDTO.getIddevice(), deviceDTO.getIdclient(), deviceDTO.getMac(), deviceDTO.getDevtype(), deviceDTO.getPosition());
		return device;
	}
	
	/**
	 * Metodo per convertire le liste di Device.
	 */
	@Override
	public List<DeviceDTO> toDTOList(List<Device> deviceList) {
		//Crea una lista vuota.
		List<DeviceDTO> deviceDTOList = new ArrayList<DeviceDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Device device : deviceList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			deviceDTOList.add(toDTO(device));
		}
		return deviceDTOList;
	}

	
	
}
