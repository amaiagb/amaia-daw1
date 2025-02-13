package com.asej.escaperoom.view.lvl3;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;
import javax.swing.JTextField;

public class Correo extends JPanel {

	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	private final String CORREO_USER = "aitor2012@centro.eus";
	private final String CORREO_PASS = "2025Docs";
	
	private Ventana ventana;
	private JTextField txtCorreo;
	private JTextField txtPass;
	private JButton btnCapturar;
	
	public Correo(Ventana ventana, Bandeja bandeja, JButton btnCapturar) {

		this.ventana = ventana;
		this.btnCapturar = btnCapturar;
		setBounds(85, 77, 759, 522);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(281, 341, 184, 47);
		btnLogin.setOpaque(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		add(btnLogin);
		//btnLogin.setVisible(true);
		
		JLabel lblLoginError = new JLabel();
		lblLoginError.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblLoginError.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginError.setBounds(166,404, 400, 47);
		add(lblLoginError);
		//lblLoginError.setVisible(true);

		JLabel lblCerrarLogin = new JLabel();
		lblCerrarLogin.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblCerrarLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarLogin.setBounds(718,0, 40, 40);
		add(lblCerrarLogin);
		//lblCerrarLogin.setVisible(true);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\email_login.png"));
		add(lblFondo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(231, 185, 285, 40);
		txtCorreo.setBorder(null);
		txtCorreo.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBorder(null);
		txtPass.setBounds(231, 264, 285, 40);
		txtPass.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		add(txtPass);
		
		txtCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtCorreo.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			}
		});
		txtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtPass.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			}
		});
		
		lblCerrarLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				lblLoginError.setVisible(false);
			}
		});
		
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(CORREO_USER.equals(txtCorreo.getText()) && CORREO_PASS.equals(txtPass.getText())) {
					bandeja.setVisible(true);
					setVisible(false);
					txtCorreo.setVisible(false);
					txtPass.setVisible(false);
					btnLogin.setVisible(false);
					Ventana.mostrarTextoPantalla("¡Oh no! Le están escribiendo cosas horribles a Aitor... Voy a hacer capturas de esto para enseñárselo al tutor, este acoso no puede quedar así.");
					btnCapturar.setVisible(true);
					Audio.reproducirEfectoSonido(Audio.BOTON);
					lblLoginError.setVisible(false);
				}else {
					lblLoginError.setText("Correo o contraseña incorrectos");
					lblLoginError.setVisible(true);
					
				}
				
			}
		});
	}
}
