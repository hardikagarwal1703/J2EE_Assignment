package tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import utils.DBUtils;

public class TesterQ2 {

	public static void main(String[] args) {
		
		String sqlQuery = "update my_emp set salary = salary + ? where empid=?";
		
		try (Connection con = DBUtils.openConnection();
				PreparedStatement stmt = con.prepareStatement(sqlQuery);
				Scanner scan = new Scanner(System.in)) {

			System.out.println("Enter EmpId & Incremenet");

			stmt.setString(2, scan.nextLine());
			stmt.setDouble(1, Double.parseDouble(scan.nextLine()));
			if(stmt.executeUpdate()>0) {
				System.out.println("Updated Record");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
