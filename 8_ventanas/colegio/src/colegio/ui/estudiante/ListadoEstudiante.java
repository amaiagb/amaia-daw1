package colegio.ui.estudiante;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import colegio.model.Estudiante;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListadoEstudiante extends JFrame{

	private JPanel contentPane;
	private JTable table;
	
	public ListadoEstudiante(ArrayList<Estudiante> estudiantes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
								
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Email", "Curso", "G\u00E9nero", "Necesidades especiales", "T\u00E9rminos"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(20, 20, 490, 269);
		contentPane.add(table);
		
		for (Estudiante estudiante : estudiantes) {
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{estudiante.getDni(), estudiante.getNombre(), estudiante.getApellidos(),estudiante.getFechaNacimiento(),estudiante.getEmail(),estudiante.getCurso(),estudiante.getGenero(), estudiante.getNecesidadesEspeciales(),estudiante.isTerminosAceptados()});
		}
		
		
		
	}
}
