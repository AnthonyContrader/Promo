package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Screen;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ScreenDAO implements DAO<Screen> {

	private final String QUERY_ALL = "SELECT * FROM screen"
			+ "";
	private final String QUERY_CREATE = "INSERT INTO screen (output) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM screen WHERE idscreen=?";
	private final String QUERY_UPDATE = "UPDATE screen SET output=?";
	private final String QUERY_DELETE = "DELETE FROM screen WHERE idscreen=?";

	public ScreenDAO() {

	}

	public List<Screen> getAll() {
		List<Screen> screensList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Screen screen;
			while (resultSet.next()) {
				int idscreen = resultSet.getInt("idscreen");
				String output = resultSet.getString("output");
				screen = new Screen(output);
				screen.setIdscreen(idscreen);
				screensList.add(screen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return screensList;
	}

	public boolean insert(Screen screenToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, screenToInsert.getOutput());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Screen read(int idscreen) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idscreen);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String output;

			output = resultSet.getString("output");
			Screen screen = new Screen(output);
			screen.setIdscreen(resultSet.getInt("idscreen"));

			return screen;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Screen screenToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (screenToUpdate.getIdscreen() == 0)
			return false;

		Screen screenRead = read(screenToUpdate.getIdscreen());
		if (!screenRead.equals(screenToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (screenToUpdate.getOutput() == null || screenToUpdate.getOutput().equals("")) {
					screenToUpdate.setOutput(screenRead.getOutput());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, screenToUpdate.getOutput());
				preparedStatement.setInt(4, screenToUpdate.getIdscreen());
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

	public boolean delete(int idscreen) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idscreen);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

	
}
