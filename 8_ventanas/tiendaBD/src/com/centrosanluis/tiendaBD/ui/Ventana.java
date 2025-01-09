package com.centrosanluis.tiendaBD.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.centrosanluis.tiendaBD.dto.AccesoBDTienda;
import com.centrosanluis.tiendaBD.dto.ProductoDTO;

import javax.swing.JTable;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Ventana(AccesoBDTienda bd) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(39, 94, 318, 118);
		
		String[] nombreColumnas = {"id","nombre","descripcion","color"};
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas,0);
		int index = 1;
		
		while(bd.getProducto(index) != null) {
			ProductoDTO p = bd.getProducto(index);
			Object[] fila = {p.getId(),p.getNombre(),p.getDescripcion(),p.getColor()};
			modeloTabla.addRow(fila);
			index++;
		}
		
		table.setModel(modeloTabla);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 94, 318, 118);
		contentPane.add(scrollPane);
	}
}
