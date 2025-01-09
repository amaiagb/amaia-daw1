package com.centrosanluis.tiendaBD.view;

import java.sql.SQLException;

import com.centrosanluis.tiendaBD.dto.AccesoBDTienda;
import com.centrosanluis.tiendaBD.dto.ProductoDTO;
import com.centrosanluis.tiendaBD.ui.Ventana;

public class App {

	public static void main(String[] args) {

		try {
			AccesoBDTienda bd = new AccesoBDTienda();
			ProductoDTO p = bd.getProducto(2);
			//System.out.println(p.getId()+". "+p.getNombre()+": "+p.getDescripcion()+" ("+p.getColor()+")");
			Ventana ventana = new Ventana(bd);
			ventana.setVisible(true);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
		} catch (SQLException e) {
			System.out.println("Error al conectar con la BD");
		}

	}

}
