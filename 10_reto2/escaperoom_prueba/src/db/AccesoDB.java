package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoDB {
	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_GENERICO = "sun.jdbc.odbc.JdbcOdbc.Driver";
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	// variables conexion:
	String bd, user, pass;
	String tipoBD;

	public AccesoDB(String tipoBD, String bd, String user, String pass) throws ClassNotFoundException, SQLException {
		super();
		this.bd = bd;
		this.user = user;
		this.pass = pass;
		this.tipoBD = tipoBD;
	}

	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName(tipoBD);
		con = DriverManager.getConnection("jdbc:mysql://localhost/"+bd, user, pass);
		//System.out.println("Conexión establecida");
		st = con.createStatement();
	}

	public void desconectar() throws SQLException {
		st.close();
		con.close();
	}

}
