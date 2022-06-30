package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static Connection con;

	// add a static method to open the FIXED DB Connection
	public static Connection openConnection() throws /* ClassNotFoundException, */ SQLException {
		// Load TypeIV JDBC Driver.
		// Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hardik1703?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		con = DriverManager.getConnection(url, "root", "root");
		return con;
	}

	// add a static method to return db con to the caller
	public static Connection getCon() {
		return con;
	}

	// add a static method to close db connection
	public static void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}