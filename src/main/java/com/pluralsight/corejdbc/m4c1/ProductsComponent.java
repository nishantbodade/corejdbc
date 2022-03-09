package com.pluralsight.corejdbc.m4c1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;


public class ProductsComponent {

	public void printProductList() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=root&serverTimezone=UTC");
		
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from products");
		
		while(resultset.next()) {
			String name=resultset.getString("productName");
			System.out.println(name);
		}
		
		resultset.close();
		statement.close();
		connection.close();
		
	}
}
