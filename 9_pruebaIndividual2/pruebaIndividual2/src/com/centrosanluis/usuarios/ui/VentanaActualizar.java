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

public class VentanaActualizar extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFecha;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();

	public VentanaActualizar(AccesoBDUsuarios bd) {
		setTitle("Actualizar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 355, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 24, 106, 14);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(131, 21, 163, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 49, 163, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 52, 106, 14);
		contentPane.add(lblNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(131, 81, 163, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 84, 106, 14);
		contentPane.add(lblApellidos);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(131, 151, 163, 20);
		contentPane.add(txtFecha);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 154, 146, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 119, 106, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnF = new JRadioButton("Femenino");
		buttonGroupSexo.add(rdbtnF);
		rdbtnF.setBounds(131, 108, 93, 23);
		contentPane.add(rdbtnF);
		
		JRadioButton rdbtnM = new JRadioButton("Masculino");
		buttonGroupSexo.add(rdbtnM);
		rdbtnM.setBounds(226, 108, 93, 23);
		contentPane.add(rdbtnM);
		
		JLabel lblFechaFormato = new JLabel("(YYY-MM-DD)");
		lblFechaFormato.setBounds(10, 168, 106, 14);
		contentPane.add(lblFechaFormato);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dni = txtDNI.getText();
					String nombre = txtNombre.getText();
					String apellidos = txtApellidos.getText();
					String sexo = "";
					LocalDate fechaNacimiento;
					
					if(rdbtnF.isSelected()) {
						sexo = "Femenino";
					} else if(rdbtnM.isSelected()) {
						sexo = "Masculino";
					}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					fechaNacimiento = LocalDate.parse(txtFecha.getText(), formatter);
					
					Usuario u = new Usuario(dni,nombre,apellidos,sexo,fechaNacimiento);
					bd.addUsuario(u);
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnGuardar.setBounds(135, 194, 159, 23);
		contentPane.add(btnGuardar);
	}
}
