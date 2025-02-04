package resources;

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoBDJuego extends AccesoBD{

	public AccesoBDJuego() throws ClassNotFoundException, SQLException {
		super(AccesoBD.DRIVER_MYSQL, "escaperoom", "root", "");
		
	

	}

}
