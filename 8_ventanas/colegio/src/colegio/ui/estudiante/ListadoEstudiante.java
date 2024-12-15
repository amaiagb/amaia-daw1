package colegio.ui.estudiante;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import colegio.model.Estudiante;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListadoEstudiante extends JFrame{

	private JPanel contentPane;
	private JTable tabla;
	
	public ListadoEstudiante(ArrayList<Estudiante> estudiantes) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] nombreColumnas = {"DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Email", "Curso", "Genero", "Necesidades especiales", "Terminos"};
		
		DefaultTableModel modelo = new  DefaultTableModel(nombreColumnas,0);
			
		tabla = new JTable(modelo);
		tabla.setBounds(20, 20, 800, 400);
		contentPane.add(tabla);
				
		for (Estudiante estudiante : estudiantes) {

			Object[] fila = {estudiante.getDni(), estudiante.getNombre(), estudiante.getApellidos(),estudiante.getFechaNacimiento(),estudiante.getEmail(),estudiante.getCurso(),estudiante.getGenero(), estudiante.getNecesidadesEspeciales(),estudiante.isTerminosAceptados()};
			modelo.addRow(fila);
		}
		
	}
}
