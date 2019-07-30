package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	//PERMETTE DI INIETTARE LE ISTANZE ALL'INTERNO DI UNA CLASSE, SOSTITUISCE IL COSTRUTTORE 
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	//OTTIENI LISTA 
	public List<UserDTO> getListaUserDTO() {
		return ConverterUser.toListDTO((List<User>) userRepository.findAll());
	}
	//OTTINI LO USER DALL'ID
	public UserDTO getUserDTOById(Integer id) {
		return ConverterUser.toDTO(userRepository.findById(id).get());
	}
    //OTTIENI USERNAME E PASSWORD
	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(user);
	}
	//INSERT
	public boolean insertUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	//UPDATE	
	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	//DELETE
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	//LISTA
	public List<UserDTO> findUserDTOByUsername(String username) {
		
		final List<User> list = userRepository.findAllByUsername(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
		return userDTOs;
		
	
	}
}
