package com.centrosanluis.tiendaBD.app;

import java.sql.SQLException;

import com.centrosanluis.tiendaBD.bd.AccesoBD;
import com.centrosanluis.tiendaBD.dto.ProductoDTO;
import com.centrosanluis.tiendaBD.ui.VentanaProductos;

public class App {

	public static void main(String[] args) {
		
		AccesoBD bd = new AccesoBD();
		
		try {
			VentanaProductos ventana = new VentanaProductos(bd);
			ventana.setVisible(true);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
