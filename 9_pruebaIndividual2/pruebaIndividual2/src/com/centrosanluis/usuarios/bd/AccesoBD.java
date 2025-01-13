package com.centrosanluis.usuarios.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_MYSQL);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_usuarios","root", "");
		System.out.println("Conexión establecida");
		st = con.createStatement();
	}
	
	public void desconectar() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		st.close();
		con.close();
	}
	
	
	
}
