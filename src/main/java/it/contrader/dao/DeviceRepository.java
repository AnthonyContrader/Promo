package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Device;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

	public List<Device> findAllByMac(String mac);
}
