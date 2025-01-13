package com.centrosanluis.usuarios.bd;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.centrosanluis.usuarios.dto.Usuario;

public class AccesoBDUsuarios extends AccesoBD {
	/*
	 * public Usuario getUsuario(int id) throws SQLException, ClassNotFoundException
	 * { conectar(); String sql = "SELECT * FROM usuarios WHERE id = "+id+";"; rs =
	 * st.executeQuery(sql);
	 * 
	 * while(rs.next()) { Usuario u = new Usuario(); } desconectar(); return u; }
	 */

	public ArrayList<Usuario> getUsuarios() throws SQLException, ClassNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		conectar();
		String sql = "SELECT * FROM usuarios";
		rs = st.executeQuery(sql);

		while (rs.next()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fechaNacimiento = LocalDate.parse(rs.getString("Fecha_nacimiento"), formatter);
			Usuario u = new Usuario(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"),
					rs.getString("Sexo"), fechaNacimiento);
			usuarios.add(u);
		}
		desconectar();
		return usuarios;
	}

	public void addUsuario(Usuario u) throws ClassNotFoundException, SQLException {
		conectar();
		String dni = u.getDni();
		String nombre = u.getNombre();
		String apellidos = u.getApellidos();
		String sexo = u.getSexo();
		String fechaNacimiento = u.getFechaNacimiento().toString();
		String sql = "INSERT INTO usuarios (DNI,Nombre,Apellidos,Sexo,Fecha_nacimiento) VALUES ('" + dni + "','"
				+ nombre + "','" + apellidos + "','" + sexo + "','" + fechaNacimiento + "')";
		st.execute(sql);
		desconectar();
	}

	public ArrayList<Usuario> getUsuarios(String sexo) throws ClassNotFoundException, SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		conectar();
		String sql = "";
		switch (sexo) {
		case "Todos" -> {
			sql = "SELECT * FROM usuarios";
		}
		case "Femenino" -> {
			sql = "SELECT * FROM usuarios WHERE sexo = 'Femenino'";
		}
		case "Masculino" -> {
			sql = "SELECT * FROM usuarios WHERE sexo = 'Masculino'";
		}
		}
		rs = st.executeQuery(sql);
		while (rs.next()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fechaNacimiento = LocalDate.parse(rs.getString("Fecha_nacimiento"), formatter);
			Usuario u = new Usuario(rs.getString("DNI"), rs.getString("Nombre"), rs.getString("Apellidos"),
					rs.getString("Sexo"), fechaNacimiento);
			usuarios.add(u);
		}
		desconectar();
		return usuarios;
	}
	public void borrarUsuario(String dni) throws ClassNotFoundException, SQLException {
		conectar();
		String sql = "DELETE FROM usuarios WHERE DNI='"+dni+"'"; 
		st.execute(sql);
		desconectar();
	}

}
