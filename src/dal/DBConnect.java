/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ruchina
 */
public class DBConnect {
    private Connection connect = null;

    public Connection connect(){
      
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Error: Driver Not Found.");
		return null;
	}
	try {
		connect = DriverManager
		.getConnection("jdbc:mysql://localhost/ams","root", "");
                return connect;

	} catch (SQLException e) {
		System.out.println("Error: Connection Failed.");
		return null;
	}
    }
}
