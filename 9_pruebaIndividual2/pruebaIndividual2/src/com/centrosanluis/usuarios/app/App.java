package com.centrosanluis.usuarios.app;

import java.sql.SQLException;

import com.centrosanluis.usuarios.bd.AccesoBDUsuarios;
import com.centrosanluis.usuarios.ui.VentanaPrincipal;

public class App {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		AccesoBDUsuarios bd = new AccesoBDUsuarios();
		//bd.getUsuario();
		
		VentanaPrincipal frame = new VentanaPrincipal(bd);
		frame.setVisible(true);
		
		
	}

}
