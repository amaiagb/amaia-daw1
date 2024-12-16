package colegio.ui.estudiante;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import colegio.model.Estudiante;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEstudiante extends JFrame{

	private JTable tblAlumnos;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JLabel lblFechaNacimiento;
	private JTextField txtFechaNacimiento;
	private JLabel lblGenero;
	private JTextField txtGenero;
	private JTextField txtCurso;
	
	public ListadoEstudiante(ArrayList<Estudiante> estudiantes) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//DATOS ALUMNO
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 30, 80, 14);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(100, 24, 110, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 58, 80, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 52, 110, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 86, 80, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 80, 110, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 114, 80, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 108, 110, 20);
		contentPane.add(txtEmail);
		
		lblFechaNacimiento = new JLabel("Fecha Nac.");
		lblFechaNacimiento.setBounds(285, 30, 80, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(375, 24, 110, 20);
		contentPane.add(txtFechaNacimiento);
		
		lblGenero = new JLabel("Género");
		lblGenero.setBounds(285, 64, 80, 14);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(375, 58, 110, 20);
		contentPane.add(txtGenero);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(285, 94, 80, 14);
		contentPane.add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(375, 88, 110, 20);
		contentPane.add(txtCurso);
		
		//TABLA LISTADO ALUMNOS
		tblAlumnos = new JTable();
		tblAlumnos.setBounds(20, 20, 700, 100);
		
		//Columnas de la tabla
		String[] nombreColumnas = {"DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Email", "Curso", "Genero"};
		
		//Modelo de la tabla
		DefaultTableModel modeloTabla = new  DefaultTableModel(nombreColumnas,0);
			
		//añadir estudiantes al modelo		
		for (Estudiante e : estudiantes) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fechaNacimiento = e.getFechaNacimiento().format(formatter);
			String genero = "";
			switch(e.getGenero()) {
				case 0 -> {
					genero = "Masculino";
				}
				case 1 -> {
					genero = "Femenino";
				}
				case 2 -> {
					genero = "Otro";
				}
			}

			Object[] fila = {e.getDni(), e.getNombre(), e.getApellidos(),fechaNacimiento,e.getEmail(),e.getCurso(),genero};
			modeloTabla.addRow(fila);
		}
		
		tblAlumnos.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tblAlumnos);
		scrollPane.setBounds(10, 200, 700, 150);
		contentPane.add(scrollPane);
		
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(10, 152, 200, 23);
		contentPane.add(btnGuardar);
		
		//Seleccionar datos de la fila clicada
		//Crear modelo de seleccion
		ListSelectionModel modeloSeleccion = tblAlumnos.getSelectionModel();
		modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Evento listener
		modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int filaSeleccionada = tblAlumnos.getSelectedRow();
				txtDNI.setText(tblAlumnos.getValueAt(filaSeleccionada, 0).toString());
				txtNombre.setText(tblAlumnos.getValueAt(filaSeleccionada, 1).toString());
				txtApellidos.setText(tblAlumnos.getValueAt(filaSeleccionada, 2).toString());
				txtFechaNacimiento.setText(tblAlumnos.getValueAt(filaSeleccionada, 3).toString());
				txtEmail.setText(tblAlumnos.getValueAt(filaSeleccionada, 4).toString());
				txtCurso.setText(tblAlumnos.getValueAt(filaSeleccionada, 5).toString());
				txtGenero.setText(tblAlumnos.getValueAt(filaSeleccionada, 6).toString());
				
				
			}
		});

		//Listener boton guardar datos
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tblAlumnos.getSelectedRow();
				if(filaSeleccionada >= 0) {
					tblAlumnos.setValueAt(txtDNI.getText(), filaSeleccionada, 0);
					tblAlumnos.setValueAt(txtNombre.getText(), filaSeleccionada, 1);
					tblAlumnos.setValueAt(txtApellidos.getText(), filaSeleccionada, 2);
					tblAlumnos.setValueAt(txtFechaNacimiento.getText(), filaSeleccionada, 3);
					tblAlumnos.setValueAt(txtEmail.getText(), filaSeleccionada, 4);
					tblAlumnos.setValueAt(txtCurso.getText(), filaSeleccionada, 5);
					tblAlumnos.setValueAt(txtGenero.getText(), filaSeleccionada, 6);
				}
				
			}
		});
		
	}
}
