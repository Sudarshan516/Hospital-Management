package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Doctor {
	
private Connection connection;
	
	
	
	public Doctor(Connection connection) {
		this.connection = connection;
		
	}
	
	
	public void viewDoctors() {
		String query = "select * from doctors";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
			    System.out.println("Column Name: " + metaData.getColumnName(i));
			}

			System.out.println("Doctors :");
			System.out.println("+------------+-------------------+---------------------+");
			System.out.println("| Doctor Id  | Name              | Specialization      |");
			System.out.println("+------------+-------------------+---------------------+");
			while(resultSet.next()) {
				int id  = resultSet.getInt("id2");
				String name = resultSet.getString("name");
				String specialization = resultSet.getString("specialization");
				System.out.printf("|%-12s|%-19s|%-21s|\n", id, name, specialization);
				System.out.println("+------------+-------------------+---------------------+");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean getPatientById(int id) {
		String query = "SELECT * FROM patients WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false; 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	
	}


	public boolean getDoctorById(int doctorId) {
		String query = "SELECT * FROM doctors WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,doctorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false; 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}



