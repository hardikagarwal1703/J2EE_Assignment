package tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import utils.DBUtils;

public class TesterQ1 {
	public static void main(String[] args) {
		try (Connection con = DBUtils.openConnection();
				PreparedStatement stmt = con.prepareStatement("select * from my_emp where salary>=? and join_datae<=?");
				Scanner scan = new Scanner(System.in)) {

			System.out.println("Enter Salary & Join Date");

			stmt.setDouble(1, Double.parseDouble(scan.nextLine()));
			stmt.setDate(2, Date.valueOf(scan.nextLine()));

			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					System.out.println(rs.getDouble(1));
					System.out.println(rs.getString("name"));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
