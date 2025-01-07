package colegio.ui.estudiante;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import colegio.App;
import colegio.model.Estudiante;
import java.awt.Color;

public class AltaEstudiante extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JLabel lblFechaNacimiento;
	private JTextField txtFechaNacimiento;
	private JLabel lblError;
	private final ButtonGroup btnGroupGenero = new ButtonGroup();

	public AltaEstudiante(ArrayList<Estudiante> estudiantes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(21, 62, 80, 14);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(111, 56, 110, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 90, 80, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(111, 84, 110, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(21, 118, 80, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(111, 112, 110, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 146, 80, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(111, 140, 110, 20);
		contentPane.add(txtEmail);
		
		lblFechaNacimiento = new JLabel("Fecha Nac.");
		lblFechaNacimiento.setBounds(247, 62, 80, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(337, 56, 110, 20);
		contentPane.add(txtFechaNacimiento);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		btnGroupGenero.add(rdbtnFemenino);
		rdbtnFemenino.setBounds(110, 179, 92, 23);
		contentPane.add(rdbtnFemenino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		btnGroupGenero.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(219, 179, 92, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnOtro = new JRadioButton("Otro");
		btnGroupGenero.add(rdbtnOtro);
		rdbtnOtro.setBounds(330, 179, 92, 23);
		contentPane.add(rdbtnOtro);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(247, 87, 80, 14);
		contentPane.add(lblCurso);
		
		JComboBox<String> cmbCurso = new JComboBox<String>();
		cmbCurso.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecciona", "DAW", "ASIR", "Integración Social"}));
		cmbCurso.setBounds(337, 86, 110, 22);
		contentPane.add(cmbCurso);
		
		JTextPane textAreaNecesidades = new JTextPane();
		textAreaNecesidades.setBounds(21, 244, 426, 53);
		contentPane.add(textAreaNecesidades);
		
		JCheckBox chckbxTerminos = new JCheckBox("Aceptar Terminos");
		chckbxTerminos.setBounds(326, 293, 121, 23);
		contentPane.add(chckbxTerminos);
		
		JButton btnAlta = new JButton("Dar de Alta");
		btnAlta.setBounds(21, 327, 426, 23);
		contentPane.add(btnAlta);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(20, 179, 80, 23);
		contentPane.add(lblGenero);
		
		JLabel lblNecesidadesEspeciales = new JLabel("Necesidades Especiales");
		lblNecesidadesEspeciales.setBounds(21, 219, 128, 14);
		contentPane.add(lblNecesidadesEspeciales);
		
		JLabel lblAltaDeEstudiante = new JLabel("Alta de Estudiante");
		lblAltaDeEstudiante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAltaDeEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeEstudiante.setBounds(21, 11, 426, 27);
		contentPane.add(lblAltaDeEstudiante);
		
		lblError = new JLabel("Errores en los datos introducidos");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(new Color(139, 0, 0));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(21, 357, 426, 14);
		lblError.setVisible(false);
		contentPane.add(lblError);
		
		
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = txtDNI.getText();
				String nombre = txtNombre.getText();
				String apellidos = txtApellidos.getText();
				String email = txtEmail.getText();
				String curso = cmbCurso.getSelectedItem().toString();
				String fechaNacimiento = txtFechaNacimiento.getText();
				String necesidadesEspeciales = textAreaNecesidades.getText();
				Boolean terminos = chckbxTerminos.isSelected();
				JRadioButton radioSeleccionado;
				
				Enumeration<AbstractButton> buttons = btnGroupGenero.getElements();
				String genero = "";
				
				while(buttons.hasMoreElements()) {
					AbstractButton button = buttons.nextElement();
					if(button.isSelected()) {
						radioSeleccionado = (JRadioButton) button;
						genero = radioSeleccionado.getText();
						break;
					}
					
				}
				
				if(validarCampos(dni,nombre,apellidos,email,curso,fechaNacimiento,terminos,genero)) {
					lblError.setVisible(false);
					
					Estudiante estudiante = new Estudiante();
					estudiante.setNombre(nombre);
					estudiante.setApellidos(apellidos);
					estudiante.setDni(dni);
					estudiante.setEmail(email);
					estudiante.setNecesidadesEspeciales(necesidadesEspeciales);
					estudiante.setTerminosAceptados(terminos);
					
					//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					estudiante.setFechaNacimiento(LocalDate.parse(fechaNacimiento, formatter));
					
					switch (genero) {
						case "Masculino" -> {
							estudiante.setGenero(0);
						}
						case "Femenino" -> {
							estudiante.setGenero(1);
						}
						case "Otro" -> {
							estudiante.setGenero(2);
						}
					}
					estudiantes.add(estudiante);

				} else {
					lblError.setVisible(true);
				}
			}
		});
	}
	
	private boolean validarCampos(String dni, String nombre, String apellidos, String email, String curso, String fechaNacimiento, Boolean terminos, String genero) {
		
		if(dni.equals("") || dni.length() != 9) { //Se podría validar también que el dni no esté repetido o que tenga el formato correcto
			lblError.setText("Error en DNI");
			return false;
		}
		if(nombre.equals("")) { 
			lblError.setText("Error en nombre");
			return false;
		}
		if(apellidos.equals("")) { 
			
			return false;
		}
		if(curso.equals("Selecciona")) { 
			lblError.setText("Error en curso");
			return false;
		}
		if(email.equals("")) { //Comprobar que el email tenga formato correcto
			lblError.setText("Error en email");
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			format.parse(fechaNacimiento);
		} catch (ParseException e) {
			lblError.setText("Error en fecha");
			return false;
		}
		if(!terminos) {
			lblError.setText("Error en terminos");
			return false;
		}
		if(genero.equals("")) { 
			lblError.setText("Error en genero");
			return false;
		}
		return true;
		
	}
}
