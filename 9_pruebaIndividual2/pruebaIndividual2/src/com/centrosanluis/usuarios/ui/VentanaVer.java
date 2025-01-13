package com.centrosanluis.usuarios.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.centrosanluis.usuarios.bd.AccesoBDUsuarios;
import com.centrosanluis.usuarios.dto.Usuario;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VentanaVer extends JFrame {

	private JPanel contentPane;
	private JTable tablaUsuarios;
	private JLabel lblFiltrar;
	private JButton btnActualizar;

	public VentanaVer(AccesoBDUsuarios bd) throws ClassNotFoundException, SQLException {
		setTitle("Ver Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 541, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 101, 471, 146);
		contentPane.add(scrollPane);
		
		String[] nombreColumnas = {"DNI","Nombre","Apellidos","Sexo","Fecha de Nacimiento"};
		DefaultTableModel modelo = new DefaultTableModel(nombreColumnas, 0);		
		tablaUsuarios = new JTable(modelo);
		tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tablaUsuarios);

		
		lblFiltrar = new JLabel("Filtrar por sexo:");
		lblFiltrar.setBounds(131, 72, 91, 14);
		contentPane.add(lblFiltrar);
		
		JComboBox comboFiltroSexo = new JComboBox();
		comboFiltroSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.setRowCount(0);
					ArrayList<Usuario> usuariosObtenidos= bd.getUsuarios(comboFiltroSexo.getSelectedItem().toString());
					for (Usuario u : usuariosObtenidos) {
						Object[] fila = {u.getDni(), u.getNombre(), u.getApellidos(), u.getSexo(), u.getFechaNacimiento().toString()};	
						modelo.addRow(fila);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		comboFiltroSexo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Femenino", "Masculino"}));
		comboFiltroSexo.setBounds(232, 68, 113, 22);
		contentPane.add(comboFiltroSexo);
		
		btnActualizar = new JButton("Actualizar datos");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(tablaUsuarios.getSelectedRow());
			}
		});
		btnActualizar.setBounds(374, 256, 123, 23);
		contentPane.add(btnActualizar);
		
		ArrayList<Usuario> usuariosObtenidos = bd.getUsuarios();
		for (Usuario u : usuariosObtenidos) {
			Object[] fila = {u.getDni(), u.getNombre(), u.getApellidos(), u.getSexo(), u.getFechaNacimiento().toString()};	
			modelo.addRow(fila);
		}
	}
}
