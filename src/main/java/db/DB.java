package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import db.exceptions.DbException;

public class DB {

	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties properties = loadProperties();
				String url = properties.getProperty("url");
				connection = DriverManager.getConnection(url, properties);
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try /* (FileInputStream fs = new FileInputStream("db.properties")) */ {
			FileInputStream fs = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(fs);
			fs.close();
			return properties;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
