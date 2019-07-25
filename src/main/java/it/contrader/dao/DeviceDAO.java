package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Device;

public class DeviceDAO implements DAO<Device> {

	private final String QUERY_ALL = "SELECT * FROM device";
	private final String QUERY_CREATE = "INSERT INTO device (iddevice, mac, devtype, position) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM device WHERE iddevice=?";
	private final String QUERY_UPDATE = "UPDATE device SET mac=?, devtype=?, position=? WHERE iddevice=?";
	private final String QUERY_DELETE = "DELETE FROM device WHERE iddevice=?";

	public DeviceDAO() {

	}

	public List<Device> getAll() {
		List<Device> devicesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Device device;
			while (resultSet.next()) {
				
				int iddevice = resultSet.getInt("iddevice");
				String mac = resultSet.getString("mac");
				String devtype = resultSet.getString("devtype");
				String position = resultSet.getString("position");
				device = new Device(mac, devtype, position);
				device.setIddevice(iddevice);
				devicesList.add(device);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}

	public boolean insert(Device deviceToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, deviceToInsert.getMac());
			preparedStatement.setString(2, deviceToInsert.getDevtype());
			preparedStatement.setString(3, deviceToInsert.getPosition());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Device read(int deviceId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, deviceId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String mac, devtype, position;

			mac = resultSet.getString("mac");
			devtype = resultSet.getString("devtype");
			position = resultSet.getString("position");
			Device device = new Device(mac, devtype, position);
			device.setIddevice(resultSet.getInt("iddevice"));

			return device;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Device deviceToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (deviceToUpdate.getIddevice() == 0)
			return false;

		Device deviceRead = read(deviceToUpdate.getIddevice());
		if (!deviceRead.equals(deviceToUpdate)) {
			try {
				// Fill the deviceToUpdate object
				if (deviceToUpdate.getMac() == null || deviceToUpdate.getMac().equals("")) {
					deviceToUpdate.setMac(deviceRead.getMac());
				}

				if (deviceToUpdate.getDevtype() == null || deviceToUpdate.getDevtype().equals("")) {
					deviceToUpdate.setDevtype(deviceRead.getDevtype());
				}

				if (deviceToUpdate.getPosition() == null || deviceToUpdate.getPosition().equals("")) {
					deviceToUpdate.setPosition(deviceRead.getPosition());
				}

				// Update the device
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, deviceToUpdate.getMac());
				preparedStatement.setString(2, deviceToUpdate.getDevtype());
				preparedStatement.setString(3, deviceToUpdate.getPosition());
				preparedStatement.setInt(4, deviceToUpdate.getIddevice());
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

	public boolean delete(int idDevice) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idDevice);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
