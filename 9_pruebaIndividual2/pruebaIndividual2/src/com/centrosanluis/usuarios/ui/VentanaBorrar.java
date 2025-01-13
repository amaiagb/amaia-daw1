package com.centrosanluis.usuarios.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.centrosanluis.usuarios.bd.AccesoBDUsuarios;
import com.centrosanluis.usuarios.dto.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaBorrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;

	public VentanaBorrar(AccesoBDUsuarios bd) {
		setTitle("Borrar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 210, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI del usuario a borrar:");
		lblDNI.setBounds(10, 50, 163, 14);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(10, 75, 163, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bd.borrarUsuario(txtDNI.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setBounds(10, 106, 163, 23);
		contentPane.add(btnBorrar);
	}
}
