package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Client;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ClientDAO implements DAO<Client> {

	private final String QUERY_ALL = "SELECT * FROM client";
	private final String QUERY_CREATE = "INSERT INTO client (idadmin, username, password, scode, email) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM client WHERE idclient=?";
	private final String QUERY_UPDATE = "UPDATE client SET idadmin=?, username=?, password=?, email=?, scode=?  WHERE idclient=?";
	private final String QUERY_DELETE = "DELETE FROM client WHERE idclient=?";

	public ClientDAO() {

	}

	public List<Client> getAll() {
		List<Client> clientsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Client client;
			while (resultSet.next()) {
				int idclient = resultSet.getInt("idclient");
				int idadmin = resultSet.getInt("idadmin");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String scode = resultSet.getString("scode");				
				String email = resultSet.getString("email");
				
				client = new Client(idclient,idadmin, username, password, scode, email);
				client.setId(idclient);
				clientsList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsList;
	}

	public boolean insert(Client clientToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, clientToInsert.getIdAdmin());
			preparedStatement.setString(2, clientToInsert.getUsername());
			preparedStatement.setString(3, clientToInsert.getPassword());
			preparedStatement.setString(4, clientToInsert.getScode());
			preparedStatement.setString(5, clientToInsert.getEmail());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Client read(int clientId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, clientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, scode, email;
            int idadmin;
			
            username = resultSet.getString("username");
			password = resultSet.getString("password");
			scode = resultSet.getString("scode");
			email= resultSet.getString("email");
			idadmin= Integer.parseInt(resultSet.getString("idadmin"));
			
			Client client = new Client(idadmin, username, password, scode, email);
			client.setId(resultSet.getInt("idclient"));

			return client;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Client clientToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if idclient is present
		if (clientToUpdate.getId() == 0)
			return false;
		Client clientRead = read(clientToUpdate.getId());
		if (!clientRead.equals(clientToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (clientToUpdate.getIdAdmin() == 0) {
					clientToUpdate.setIdAdmin(clientRead.getIdAdmin());
				}
				
				if (clientToUpdate.getUsername() == null || clientToUpdate.getUsername().equals("")) {
					clientToUpdate.setUsername(clientRead.getUsername());
				}

				if (clientToUpdate.getPassword() == null || clientToUpdate.getPassword().equals("")) {
					clientToUpdate.setPassword(clientRead.getPassword());
				}

				if (clientToUpdate.getScode() == null || clientToUpdate.getScode().equals("")) {
					clientToUpdate.setScode(clientRead.getScode());
				}
				
				if (clientToUpdate.getEmail() == null || clientToUpdate.getEmail().equals("")) {
					clientToUpdate.setScode(clientRead.getEmail());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, clientToUpdate.getIdAdmin());
				preparedStatement.setString(2, clientToUpdate.getUsername());
				preparedStatement.setString(3, clientToUpdate.getPassword());
				preparedStatement.setString(4, clientToUpdate.getScode());
				preparedStatement.setString(5, clientToUpdate.getEmail());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}

