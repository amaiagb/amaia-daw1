package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static  final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static  final String DRIVER_GENERICO = "sun.jdbc.odbc.JdbcOdbc.Driver";
	
	public static void main(String[] args) {
		 
		//Test MySQL
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//0. Cargar drive
			Class.forName(DRIVER_MYSQL);
			
			//1. Conectar
			con = DriverManager.getConnection("jdbc:mysql://localhost/coches", "root", "");
			System.out.println("Conexión establecida");

			//2. Crear flujo
			st = con.createStatement();
			
			//3. Consulta unidireccional
			//st.executeUpdate("INSERT INTO coches (marca, modelo, color) VALUES ('Renault', 'Clio', 'Azul');");
			//System.out.println("Coche introducido correctamente");
			
			//3b. Consulta bidirecconal
			//TODO. No es seguro hacerlo así cuando se hace con un campo de texto de un formulario
			String sql = "SELECT * from coches";
			rs = st.executeQuery(sql);
			mostrarRegistros(rs);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void mostrarRegistros(ResultSet rs) throws SQLException {
		//Mirar el resultset mediante ResultSetMetadata
		ResultSetMetaData rsm = rs.getMetaData();
		int numColumnas = rsm.getColumnCount();
		System.out.println(numColumnas);
		
		//Imprimir cabecera
		String cabecera = "";
		for (int i = 1; i <= numColumnas; i++) {
			cabecera += rsm.getColumnName(i)+" | ";
		}
		System.out.println(cabecera);
		
		//Imprimir cuerpo
		
		while(rs.next()) {
			String linea = "";
			for (int i = 1; i <= numColumnas; i++) {
				linea += rs.getString(i)+" | ";
			}
			System.out.println(linea);

		}
		
	}

}
