package com.centrosanluis.tiendaBD.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.centrosanluis.tiendaBD.dto.ProductoDTO;

public class AccesoBD {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	
	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","");
		st = con.createStatement();
		System.out.println("Conexión establecida");
	}
	
	public void desconectar() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		st.close();
		con.close();
	}
	
	public ProductoDTO getProducto(int id) throws SQLException, ClassNotFoundException{
		ProductoDTO p = new ProductoDTO();
		conectar();
		String sql = "SELECT * FROM productos WHERE id="+id+";";
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setCategoria(rs.getString("categoria"));
			p.setColor(rs.getString("color"));
			p.setDescripcion(rs.getString("descripcion"));
			p.setEstado(rs.getString("estado"));
			p.setPrecio(rs.getFloat("precio"));
			p.setValorDescuento(rs.getInt("valor_dto"));
			if(rs.getInt("descuento") == 1) {
				p.setDescuento(true);
			} else {
				p.setDescuento(false);
			}
		}
		desconectar();
		return p;
	}
	public ArrayList<ProductoDTO> getProductosbyName(String nombre) throws SQLException {
		ArrayList<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		
		String sql = "SELECT * FROM productos WHERE nombre like '%"+nombre+"%'";
		rs = st.executeQuery(sql);
		
		while(rs.next()){
			boolean estado = false;
			if(rs.getInt("descuento") == 1) {
				estado = true;
			}
			ProductoDTO p = new ProductoDTO(rs.getString("nombre"), rs.getString("categoria"), rs.getString("descripcion"), rs.getString("color"), rs.getString("estado"), rs.getFloat("precio"), estado, rs.getInt("valor_dto"));
			productos.add(p);
		}
		
		return productos;
	}
	
	public void addProducto(ProductoDTO p) throws SQLException, ClassNotFoundException {
		conectar();
		int descuento = 0;
		if(p.isDescuento()) {
			descuento = 1;
		}
		String sql = "INSERT INTO productos (nombre,precio,descuento,valor_dto,categoria,descripcion,color,estado)"
				+ "VALUES('"+p.getNombre()+"',"+p.getPrecio()+","+descuento+","+p.getValorDescuento()+",'"+p.getCategoria()+"','"+p.getDescripcion()+"','"+p.getColor()+"','"+p.getEstado()+"');";
		st.execute(sql);
		desconectar();
	}

	public ArrayList<ProductoDTO> getProductosFiltrados(String sql) throws SQLException {
		
		ArrayList<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			ProductoDTO p = new ProductoDTO();
			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setCategoria(rs.getString("categoria"));
			p.setColor(rs.getString("color"));
			p.setDescripcion(rs.getString("descripcion"));
			p.setEstado(rs.getString("estado"));
			p.setPrecio(rs.getFloat("precio"));
			p.setValorDescuento(rs.getInt("valor_dto"));
			if(rs.getInt("descuento") == 1) {
				p.setDescuento(true);
			} else {
				p.setDescuento(false);
			}
			productos.add(p);
		}
		return productos;
	}
	
}
