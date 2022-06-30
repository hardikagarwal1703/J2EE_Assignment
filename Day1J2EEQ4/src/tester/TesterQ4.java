package tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import utils.DBUtils;

public class TesterQ4 {

	public static void main(String[] args) {

		String sqlQuery = "insert into my_emp values(default,?,?,?,?,?)";

		try (Connection con = DBUtils.openConnection();
				PreparedStatement stmt = con.prepareStatement(sqlQuery);
				Scanner scan = new Scanner(System.in)) {

			System.out.println("Enter (name,addr,salary,deptid,join_date)");

			stmt.setString(1, scan.nextLine());
			stmt.setString(2, scan.nextLine());
			stmt.setDouble(3, Double.parseDouble(scan.nextLine()));
			stmt.setString(4, scan.nextLine());
			stmt.setDate(5, Date.valueOf(scan.nextLine()));

			if (stmt.executeUpdate() > 0) {
				System.out.println("***Record Inserted***");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
