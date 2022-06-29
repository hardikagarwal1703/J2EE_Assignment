package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestDBConnection {

	private static String joyString = "select * from joyDetails;";
	private static String joyDetails = "insert into joyDetails(id,name) values(?,?)";

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/joy22?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		String userName = "root";
		String password = "Joy@pahari10";
		try (Scanner scan = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded JDBC driver class in the method area....");
			Connection cn = DriverManager.getConnection(url, userName, password);
			System.out.println("DB connection established ... " + cn);

			PreparedStatement stmt1 = cn.prepareStatement(joyDetails);
			System.out.println("Enter Joy Id & Joy Name");
			stmt1.setString(1, scan.nextLine());
			stmt1.setString(2, scan.nextLine());
			stmt1.execute();
			stmt1.close();

			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(joyString);
			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
			}
			rs.close();
			stmt.close();
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}