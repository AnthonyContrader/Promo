
package it.contrader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDevice;
import it.contrader.dao.ClientRepository;
import it.contrader.dao.DeviceRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.dto.DeviceDTO;
import it.contrader.model.Client;
import it.contrader.model.Device;

@Service
public class DeviceService {

	//private final DeviceRepository deviceRepository;
	//private final ClientRepository clientRepository;

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<DeviceDTO> getListaDeviceDTO() {
		return ConverterDevice.toListDTO((List<Device>) deviceRepository.findAll());
	}

	public DeviceDTO getDeviceDTOById(Integer id) {
		return ConverterDevice.toDTO(deviceRepository.findById(id).get());
	}

	/*public DeviceDTO getByDevicenameAndPassword(String mac, String password) {

		final Device device = deviceRepository.findDeviceByDevicenameAndPassword(mac, password);

		return ConverterDevice.toDTO(device);
	}
*/
	public boolean insertDevice(DeviceDTO deviceDTO) {
		return deviceRepository.save(ConverterDevice.toEntity(deviceDTO)) != null;
	}

	public boolean updateDevice(DeviceDTO deviceDTO) {
		return deviceRepository.save(ConverterDevice.toEntity(deviceDTO)) != null;
	}
	
	public void deleteDeviceById(Integer id) {
		deviceRepository.deleteById(id);
	}
	
	public List<DeviceDTO> findDeviceDTOByMac(String mac) {
		
		final List<Device> list = deviceRepository.findAllByMac(mac);
		final List<DeviceDTO> deviceDTOs = new ArrayList<>();
		list.forEach(i -> deviceDTOs.add(ConverterDevice.toDTO(i)));
		return deviceDTOs;
		
	
	}
	
	public List<DeviceDTO> findDevicesByClient(Integer idclient){
		Optional<Client> client = clientRepository.findById(idclient);
		final List<Device> list = deviceRepository.findAllByClient(client);
		final List<DeviceDTO> deviceDTOs = new ArrayList<>();
		list.forEach(i -> deviceDTOs.add(ConverterDevice.toDTO(i)));
		return deviceDTOs;
	}
}
