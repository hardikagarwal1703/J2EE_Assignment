package tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import utils.DBUtils;

public class TesterQ3 {

	public static void main(String[] args) {

		String sqlQuery = "delete from my_emp where empid=?";

		try (Connection con = DBUtils.openConnection();
				PreparedStatement stmt = con.prepareStatement(sqlQuery);
				Scanner scan = new Scanner(System.in)) {

			System.out.println("Enter EmpId");

			stmt.setInt(1, Integer.parseInt(scan.nextLine()));
			if (stmt.executeUpdate() > 0) {
				System.out.println("***Record Deleted***");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
