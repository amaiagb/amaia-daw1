package com.centrosanluis.tiendaBD.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_GENERICO = "sun.jdbc.odbc.JdbcOdbc.Driver";
	Connection con = null;
	Statement st = null;
	// variables conexion:
	String bd, user, pass;
	String tipoBD;

	public AccesoBD(String tipoBD, String bd, String user, String pass) throws ClassNotFoundException, SQLException {
		super();
		this.bd = bd;
		this.user = user;
		this.pass = pass;
		this.tipoBD = tipoBD;
		conectar();
	}

	private void conectar() throws ClassNotFoundException, SQLException {
		Class.forName(tipoBD);
		//Para que sea reutilizable habría que hacer un switch para poner la ruta correspondiente con cada tipo de BD
		con = DriverManager.getConnection("jdbc:mysql://localhost/"+bd, user, pass);
		System.out.println("Conexión establecida");
		st = con.createStatement();
	}

	private void desconectar() throws SQLException {
		st.close();
		//con.close();
	}

	
}