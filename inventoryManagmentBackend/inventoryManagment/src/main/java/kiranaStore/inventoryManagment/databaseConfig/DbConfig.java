package kiranaStore.inventoryManagment.databaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	private Connection con;
	private static DbConfig dbConfig;

	private DbConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/inventoryStore?autoReconnect=true&useSSL=false", "root",
					"mukesh@21");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static DbConfig getDbConfig() {
		if (dbConfig == null) {
			dbConfig = new DbConfig();
			return dbConfig;
		} else {
			return dbConfig;
		}
	}

	public Connection getCon() {
		return con;
	}

	public void finalize() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}