package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

	public Client findClientByUsernameAndPassword(String username,String password);
	public List<Client> findAllByUsername(String username);
	
}
