package jdbc_practice_2.jdbc_practice_two;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import db.DB;
import db.exceptions.DbIntegrityException;
import model.entities.Department;
import model.entities.Seller;

public class AppTest {

	@Test
	public void test() {
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(obj);
		System.out.println(seller);
	}
	
//	@Test
	public void apagandoDados() {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DB.getConnection();
			statement = connection.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "id = ?"
					);
			
			statement.setInt(1, 3);
			
			int rowsAffected = statement.executeUpdate();
			
			connection.commit();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
//	@Test
	public void atualizandoDados() {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DB.getConnection();
			statement = connection.prepareStatement("UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			statement.setDouble(1, 200);
			statement.setInt(2, 2);
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			System.out.println("Done! Affected rows: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
	
//	@Test
	public void inserindoDados() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DB.getConnection();
			
			statement = connection.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
			
			statement.setString(1, "Ana Green");
			statement.setString(2, "carl@gmail.com");
			statement.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			statement.setDouble(4, 3000.0);
			statement.setInt(5, 4);
			
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			
			if(rowsAffected>0) {
				ResultSet rs = statement.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(statement);
			DB.closeConnection();
			
		}
	}
	
//	@Test
	public void lendoDados() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DB.getConnection();
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from department");
		
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+", "+resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(resultSet);;
			DB.closeStatement(statement);
			DB.closeConnection();
		}
		
	}
	
}
