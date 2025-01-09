package com.centrosanluis.tiendaBD.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBDTienda extends AccesoBD{

	public AccesoBDTienda() throws ClassNotFoundException, SQLException {
		super(AccesoBD.DRIVER_MYSQL, "tienda", "root", "");
	}
	
	
	public ProductoDTO getProducto(int id) throws SQLException {
		ProductoDTO p = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM productos WHERE id="+id+";";
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			p = new ProductoDTO(rs.getString("id"),rs.getString("nombre"), rs.getString("descripcion"), rs.getString("color"));
		}
		return p;
	}

}