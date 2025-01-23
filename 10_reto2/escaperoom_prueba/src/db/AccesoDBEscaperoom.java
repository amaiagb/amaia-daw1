package db;

import java.sql.SQLException;
import java.util.ArrayList;


public class AccesoDBEscaperoom extends AccesoDB{
	public AccesoDBEscaperoom() throws ClassNotFoundException, SQLException {
		super(AccesoDB.DRIVER_MYSQL, "escaperoom", "root", "");
	}
	
	public Mensaje getMensaje(int id, String idioma) throws ClassNotFoundException, SQLException {
		conectar();
		String sql = "SELECT * FROM mensajes WHERE id="+id;
		rs = st.executeQuery(sql);
		
		while (rs.next()) {
			Mensaje mensaje = new Mensaje();
			mensaje.setIdioma(idioma);
			mensaje.setLocutor(rs.getString("locutor"));
			mensaje.setTexto(rs.getString("texto_"+idioma));
			mensaje.setId(Integer.parseInt(rs.getString("id")));
			return mensaje;
		}
		desconectar();
		return null;
	}

}
