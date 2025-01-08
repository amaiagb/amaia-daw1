package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
	public static final String DRIVER_MYSQL="com.mysql.jdbc.Driver";
	public static final String DRIVER_GENERICO="sun.jdbc.odbc.JdbcOdbc.Driver";
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	
		// Test MySQL
		try {
			//0.Cargar driver
			Class.forName(DRIVER_MYSQL);
			//1.Conectar
			con = DriverManager.getConnection("jdbc:mysql://localhost/coches" ,"admincoches" ,"z");
			System.out.println("Conexión establecida");
			//2.Crear flujo (autopista!!)
			st = con.createStatement();
			
			//3.Consulta unidireccional
			st.executeUpdate("INSERT INTO coches (marca, modelo, color) VALUES ('Renalut', 'Clio', 'Azul');");
			System.out.println("Coche introducido correctamente");
		}catch(Exception e) {
			System.out.println("La hemos liado...");
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		

	}

}
