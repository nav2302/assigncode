package com.heapdump.analysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// The connection is not closed for the DB resulting in Open DB connection
public class UnclosedDBConnection {

	public static void main(String[] args) throws SQLException, InterruptedException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName", "root", "root");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			// con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(con !=null)
				con.close();
			if(stmt !=null)
				stmt.close();
			if(rs !=null)
				rs.close();
			Thread.sleep(10000); // To perform GC
		}
	}
}
