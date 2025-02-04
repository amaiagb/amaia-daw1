package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

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
		con = DriverManager.getConnection("jdbc:mysql://localhost/"+bd, user, pass);
		System.out.println("Esto va cuesta abajo y sin frenosss");
		st = con.createStatement();
	}

	private void desconectar() throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		st.close();
		con.close();
	}

	
}
