package formulario.ui;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Alumno;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblApellido1;
	private JTextField txtApellido1;
	private JLabel lblApellido2;
	private JTextField txtApellido2;
	private JLabel lblCiclo;
	private JComboBox comboBoxCiclo;
	private JRadioButton rdbtnCurso1;
	private JRadioButton rdbtnCurso2;
	private JRadioButton rdbtnEuskera;
	private JRadioButton rdbtnCastellano;
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private JCheckBox chckbxPintura;
	private JCheckBox chckbxDeporte;
	private JCheckBox chckbxMusica;
	private JTextArea txtObservaciones;
	private ButtonGroup curso;
	private ButtonGroup modelo;

	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 420, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 17, 46, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(29, 39, 154, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(29, 70, 86, 14);
		contentPane.add(lblApellido1);
		
		txtApellido1 = new JTextField();
		txtApellido1.setColumns(10);
		txtApellido1.setBounds(29, 92, 154, 20);
		contentPane.add(txtApellido1);
		
		lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(214, 70, 86, 14);
		contentPane.add(lblApellido2);
		
		txtApellido2 = new JTextField();
		txtApellido2.setColumns(10);
		txtApellido2.setBounds(214, 92, 154, 20);
		contentPane.add(txtApellido2);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(29, 130, 86, 14);
		contentPane.add(lblCiclo);
		
		comboBoxCiclo = new JComboBox();
		comboBoxCiclo.setModel(new DefaultComboBoxModel(new String[] {"DAW", "Administraci\u00F3n de Empresas", "Marketing", "Integraci\u00F3n social"}));
		comboBoxCiclo.setBounds(29, 150, 154, 20);
		contentPane.add(comboBoxCiclo);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(214, 130, 86, 14);
		contentPane.add(lblCurso);
		
		curso = new ButtonGroup();
		
		rdbtnCurso1 = new JRadioButton("1\u00BA");
		rdbtnCurso1.setBounds(214, 149, 54, 23);
		contentPane.add(rdbtnCurso1);
		
		rdbtnCurso2 = new JRadioButton("2\u00BA");
		rdbtnCurso2.setBounds(270, 149, 54, 23);
		contentPane.add(rdbtnCurso2);
		
		curso.add(rdbtnCurso1);
		curso.add(rdbtnCurso2);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(29, 191, 86, 14);
		contentPane.add(lblModelo);
		
		modelo = new ButtonGroup();
		
		rdbtnEuskera = new JRadioButton("Euskera");
		rdbtnEuskera.setBounds(29, 210, 98, 23);
		contentPane.add(rdbtnEuskera);
		
		rdbtnCastellano = new JRadioButton("Castellano");
		rdbtnCastellano.setBounds(129, 210, 98, 23);
		contentPane.add(rdbtnCastellano);
		
		modelo.add(rdbtnEuskera);
		modelo.add(rdbtnCastellano);
		
		JLabel lblHobbies = new JLabel("Hobbies");
		lblHobbies.setBounds(29, 253, 86, 14);
		contentPane.add(lblHobbies);
		
		chckbxPintura = new JCheckBox("Pintura");
		chckbxPintura.setBounds(29, 274, 97, 23);
		contentPane.add(chckbxPintura);
		
		chckbxDeporte = new JCheckBox("Deporte");
		chckbxDeporte.setBounds(29, 300, 97, 23);
		contentPane.add(chckbxDeporte);
		
		chckbxMusica = new JCheckBox("Musica");
		chckbxMusica.setBounds(30, 326, 97, 23);
		contentPane.add(chckbxMusica);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(29, 371, 154, 14);
		contentPane.add(lblObservaciones);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setBounds(29, 396, 339, 50);
		contentPane.add(txtObservaciones);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(26, 457, 89, 23);
		contentPane.add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Alumno alumno = crearAlumno();
					alumnos.add(alumno);
					System.out.println(alumnos.size());
					System.out.println(alumnos.get(alumnos.size()-1).toString());
					vaciarFormulario();
					System.out.println(alumnos.size());
				} catch (NullPointerException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
	
	public Alumno crearAlumno() throws Exception{
		Alumno alumno = new Alumno();
		alumno.setNombre(txtNombre.getText());
		alumno.setApellido1(txtApellido1.getText());
		alumno.setApellido2(txtApellido2.getText());
		alumno.setCiclo(comboBoxCiclo.getSelectedItem().toString());
		if(rdbtnCurso1.isSelected()) {alumno.setCurso("1");};
		if(rdbtnCurso2.isSelected()) {alumno.setCurso("2");}; 
		if(rdbtnEuskera.isSelected()) {alumno.setModelo("Euskera");};
		if(rdbtnCastellano.isSelected()) {alumno.setModelo("Castellano");};
		
		ArrayList<String> hobbies = new ArrayList<String>();
		if(chckbxPintura.isSelected()) {hobbies.add("Pintura");}
		if(chckbxDeporte.isSelected()) {hobbies.add("Deporte");}
		if(chckbxMusica.isSelected()) {hobbies.add("Musica");}
		alumno.setHobbies(hobbies);
		
		alumno.setObservaciones(txtObservaciones.getText());
		return alumno;
	}
	
	public void vaciarFormulario() {
		txtNombre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		comboBoxCiclo.setSelectedIndex(0);
		curso.clearSelection();
		modelo.clearSelection();
		chckbxPintura.setSelected(false);
		chckbxDeporte.setSelected(false);
		chckbxMusica.setSelected(false);
		txtObservaciones.setText("");
	}
	
	//TO DO: VALIDAR FORMULARIO
	
	
}
