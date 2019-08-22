package it.contrader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Client;
import it.contrader.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

	public List<Device> findAllByMac(String mac);
	public List<Device> findAllByClient(Optional<Client> client);
}
