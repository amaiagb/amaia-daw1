package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Libro;
import model.Prestamo;
import model.Usuario;
import java.awt.Component;
import javax.swing.table.TableModel;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable tablaLibros;
	private JTable tablaUsuarios;
	private JTable tablaPrestamos;


	public Listado(ArrayList<Libro> libros, ArrayList<Usuario> usuarios, ArrayList<Prestamo> prestamos) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setBounds(27, 48, 121, 14);
		contentPane.add(lblLibros);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(483, 48, 121, 14);
		contentPane.add(lblUsuarios);
		
		JLabel lblPrestamos = new JLabel("Prestamos");
		lblPrestamos.setBounds(27, 279, 121, 14);
		contentPane.add(lblPrestamos);
		
		// TABLA: Libros
		String[] columnasLibros = {"id","Titulo","Autor","Disponible"};
		DefaultTableModel modeloTablaLibros = new DefaultTableModel(columnasLibros,0);
		
		tablaLibros = new JTable(modeloTablaLibros);
		tablaLibros.setBounds(27, 87, 411, 156);
		
		for (Libro libro : libros) {
			Object[] fila = {libro.getId(),libro.getTitulo(),libro.getAutor(),libro.estaDisponible()};
			modeloTablaLibros.addRow(fila);
		}
		JScrollPane scrollPane = new JScrollPane(tablaLibros);
		scrollPane.setBounds(27, 87, 411, 156);
		contentPane.add(scrollPane);
		
		// TABLA: Usuarios
		String[] columnasUsuarios = {"id","Nombre"};
		DefaultTableModel modeloTablaUsuarios = new DefaultTableModel(columnasUsuarios,0);
		
		tablaUsuarios = new JTable(modeloTablaUsuarios);
		tablaUsuarios.setBounds(200, 200, 411, 156);
		
		for (Usuario usuario : usuarios) {
			Object[] fila = {usuario.getId(),usuario.getNombre()};
			modeloTablaUsuarios.addRow(fila);
		}
		JScrollPane scrollPaneU = new JScrollPane(tablaUsuarios);
		scrollPaneU.setBounds(483, 87, 200, 156);
		contentPane.add(scrollPaneU);
		
		// TABLA: Prestamos
		String[] columnasPrestamos = {"Libro","Usuario"};
		DefaultTableModel modeloTablaPrestamos = new DefaultTableModel(columnasPrestamos,0);
		
		tablaPrestamos = new JTable(modeloTablaPrestamos);
		tablaPrestamos.setBounds(0, 0, 409, 1);
		
		for (Prestamo prestamo : prestamos) {
			Object[] fila = {prestamo.getLibro().getTitulo(),prestamo.getUsuario().getNombre()};
			modeloTablaPrestamos.addRow(fila);
		}
		
		JScrollPane scrollPaneP = new JScrollPane(tablaPrestamos);
		scrollPaneP.setBounds(27, 304, 411, 156);
		contentPane.add(scrollPaneP);

	}
}
