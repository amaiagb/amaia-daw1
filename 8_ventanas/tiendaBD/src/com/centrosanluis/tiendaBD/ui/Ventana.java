package com.centrosanluis.tiendaBD.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.centrosanluis.tiendaBD.dto.AccesoBDTienda;
import com.centrosanluis.tiendaBD.dto.ProductoDTO;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtFiltroNombre;

	public Ventana(AccesoBDTienda bd) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(39, 94, 318, 118);
		
		String[] nombreColumnas = {"id","nombre","descripcion","color"};
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas,0);
		rellenarTodosProductos(bd, modeloTabla);
		
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 121, 541, 118);
		contentPane.add(scrollPane);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductos.setBounds(36, 35, 541, 27);
		lblProductos.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
		contentPane.add(lblProductos);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(36, 83, 76, 27);
		contentPane.add(lblFiltro);
		
		txtFiltroNombre = new JTextField();
		txtFiltroNombre.setBounds(115, 83, 140, 20);
		contentPane.add(txtFiltroNombre);
		txtFiltroNombre.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar por nombre");
		btnFiltrar.setBackground(Color.LIGHT_GRAY);
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int index = 1;
				String nombreFiltro = txtFiltroNombre.getText();
				modeloTabla.setRowCount(0);
				ArrayList<ProductoDTO> productosFiltrados;
				try {
					productosFiltrados = bd.getProducto(nombreFiltro);
					for (ProductoDTO producto : productosFiltrados) {
						Object[] fila = {producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getColor()};
						modeloTabla.addRow(fila);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnFiltrar.setBounds(265, 83, 148, 23);
		contentPane.add(btnFiltrar);
		
		JButton btnNoFiltrar = new JButton("Eliminar Filtro");
		btnNoFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modeloTabla.setRowCount(0);
					rellenarTodosProductos(bd, modeloTabla);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNoFiltrar.setForeground(Color.WHITE);
		btnNoFiltrar.setBackground(Color.DARK_GRAY);
		btnNoFiltrar.setOpaque(true);
		btnNoFiltrar.setBounds(423, 82, 154, 23);
		contentPane.add(btnNoFiltrar);
	}

	private void rellenarTodosProductos(AccesoBDTienda bd, DefaultTableModel modeloTabla) throws SQLException {
		int index = 1;
		while(bd.getProducto(index) != null) {
			ProductoDTO p = bd.getProducto(index);
			Object[] fila = {p.getId(),p.getNombre(),p.getDescripcion(),p.getColor()};
			modeloTabla.addRow(fila);
			index++;
		}
	}
}
