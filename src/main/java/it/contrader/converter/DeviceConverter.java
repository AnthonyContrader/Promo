package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class DeviceConverter extends AbstractConverter<Device,DeviceDTO> {
 @Autowired
 private ClientConverter converter;

 
	@Override
	public Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device();		
			device.setId(deviceDTO.getId());
			if(deviceDTO.getClientDTO()!= null) {
				device.setClient(converter.toEntity(deviceDTO.getClientDTO()));
			}
			device.setMac(deviceDTO.getMac());
			device.setDevtype(deviceDTO.getDevtype());
			device.setPosition(deviceDTO.getPosition());		
		}
		return device;
	}

	@Override
	public DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO();
			deviceDTO.setId(device.getId());
			if(device.getClient()!= null) {
				deviceDTO.setClientDTO(converter.toDTO(device.getClient()));
			}
			deviceDTO.setMac(device.getMac());
			deviceDTO.setDevtype(device.getDevtype());
			deviceDTO.setPosition(device.getPosition());			
		}
		return deviceDTO;
	}
}
	