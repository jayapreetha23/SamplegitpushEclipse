package com.prac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnecPrac {

	public static void main(String[] args) {

		String conn_String = "jdbc:mysql://localhost:3306/mysqlprac";
		String qry = "Select * from employeetable where name='Ravi'";
		try {
			Connection connection = DriverManager.getConnection(conn_String, "root", "Rythm@2394");
			Statement statement = connection.createStatement();
			System.out.println("Connected to DB");
			ResultSet rs = statement.executeQuery(qry);

			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("profile"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not connected");
		}

	}

}
