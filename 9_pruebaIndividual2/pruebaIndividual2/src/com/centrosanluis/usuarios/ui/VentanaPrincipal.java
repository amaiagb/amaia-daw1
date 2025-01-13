package com.centrosanluis.usuarios.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.centrosanluis.usuarios.bd.AccesoBDUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	public VentanaPrincipal(AccesoBDUsuarios bd) {
		setTitle("Gesti\u00F3n de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUsuario = new JButton("A\u00F1adir Usuario");
		btnAddUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdd ventanaAdd = new VentanaAdd(bd);
				ventanaAdd.setVisible(true);
				
			}
		});
		btnAddUsuario.setBounds(20, 50, 200, 40);
		contentPane.add(btnAddUsuario);
		
		JButton btnVerUsuarios = new JButton("Ver Usuarios");
		btnVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVer frame;
				try {
					frame = new VentanaVer(bd);
					frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnVerUsuarios.setBounds(20, 100, 200, 40);
		contentPane.add(btnVerUsuarios);
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBorrar frame;
				frame = new VentanaBorrar(bd);
				frame.setVisible(true);
			}
		});
		btnBorrarUsuario.setBounds(20, 150, 200, 40);
		contentPane.add(btnBorrarUsuario);
	}
}
