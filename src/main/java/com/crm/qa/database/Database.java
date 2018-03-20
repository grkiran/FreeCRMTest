package com.crm.qa.database;

import java.sql.*;


public class Database {

	
	public void checkUser() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/sampledatabase?autoReconnect=true&useSSL=false";
		String uname = "root";
		String pass = "root";
		Connection con;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pass);
			System.out.println("connection established");
			statement = con.createStatement();
			
			String sqlquery= "Select * from sampledatabase.userdetails";
			ResultSet rs =statement.executeQuery(sqlquery);
		while(	rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2));
			
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		
		Database obj = new Database();
		obj.checkUser();
	}
}
