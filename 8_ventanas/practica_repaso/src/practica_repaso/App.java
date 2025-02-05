package practica_repaso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

	
	
	public static void main(String[] args) {
		String fecha = "24/12/1991";
		LocalDate fecha2;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fecha2 = LocalDate.parse(fecha, formatter);
		String fecha3 = fecha2.toString();
		System.out.println(fecha3);
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
			st = con.createStatement();
			String sql = "SELECT * FROM productos";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
