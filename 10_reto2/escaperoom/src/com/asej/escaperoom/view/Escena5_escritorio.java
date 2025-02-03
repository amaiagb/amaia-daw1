package com.asej.escaperoom.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Escena5_escritorio extends JPanel {

	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private JLabel lblDocRestaurado;
	private ImageIcon imageIcon;
	private JLabel lblDocAbierto;
	private JTextField txtCorreo;
	private JTextField txtPass;
	private final String CORREO_USER = "asd";
	private final String CORREO_PASS = "123";
	
	public Escena5_escritorio(Ventana ventana) {

		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(390, 280, 289, 47);
		txtCorreo.setOpaque(false);
		txtCorreo.setBorder(null);
		add(txtCorreo);
		txtCorreo.setColumns(10);
		txtCorreo.setVisible(false);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(390, 360, 289, 47);
		txtPass.setOpaque(false);
		txtPass.setBorder(null);
		add(txtPass);
		txtPass.setVisible(false);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(450, 440, 184, 47);
		btnLogin.setOpaque(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		add(btnLogin);
		btnLogin.setVisible(false);
		
		JLabel lblLoginError = new JLabel();
		lblLoginError.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblLoginError.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginError.setBounds(330,500, 400, 47);
		add(lblLoginError);
		lblLoginError.setVisible(false);

		JLabel lblCorreoLogin = new JLabel();
		lblCorreoLogin.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\email_login.png"));
		lblCorreoLogin.setBounds(166,100,760,524);
		add(lblCorreoLogin);
		lblCorreoLogin.setVisible(false);
		
		Escena5_correo correo = new Escena5_correo(ventana);
		correo.setBounds(85, 77, 758, 521);
		add(correo);
		correo.setVisible(false);
		
		Escena5_galeria galeria = new Escena5_galeria(ventana);
		galeria.setBounds(85, 77, 920, 540);
		add(galeria);
		galeria.setVisible(false);
		
		JLabel lblCerrarCarpeta = new JLabel("");
		lblCerrarCarpeta.setBounds(880, 100, 40, 36);
		add(lblCerrarCarpeta);
		lblCerrarCarpeta.setVisible(false);
		
		JLabel lblCarpeta = new JLabel();
		lblCarpeta.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\carpeta.png"));
		lblCarpeta.setBounds(160, 100, 760, 524);
		add(lblCarpeta);
		lblCarpeta.setVisible(false);
		
		JLabel lblCerrarRestaurado = new JLabel("");
		lblCerrarRestaurado.setBounds(760, 100, 40, 36);
		add(lblCerrarRestaurado);
		lblCerrarRestaurado.setVisible(false);
		
		lblDocAbierto = new JLabel();
		lblDocAbierto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDocAbierto.setBounds(250, 100, 550, 526);
		lblDocAbierto.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\docRestaurado.png"));
		add(lblDocAbierto);
		lblDocAbierto.setVisible(false);

		lblDocRestaurado = new JLabel("");
		lblDocRestaurado.setVerticalAlignment(SwingConstants.TOP);
		lblDocRestaurado.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\docSecreto.png"));
		lblDocRestaurado.setBounds(929, 306, 145, 131);
		add(lblDocRestaurado);
		lblDocRestaurado.setVisible(false);
		
		
		Escena5_papelera papelera = new Escena5_papelera(ventana, lblDocRestaurado);
		papelera.setSize(760, 524);
		papelera.setLocation(166, 100);
		add(papelera);
		papelera.setVisible(false);
		
		JLabel lblBtnInicio = new JLabel("");
		lblBtnInicio.setBounds(0, 667, 156, 33);
		add(lblBtnInicio);
		
		JLabel lblBtnGaleria = new JLabel("");
		lblBtnGaleria.setBounds(25, 116, 104, 106);
		add(lblBtnGaleria);
		
		JLabel lblBtnCorreo = new JLabel("");
		lblBtnCorreo.setBounds(25, 233, 104, 90);
		add(lblBtnCorreo);
		
		JLabel lblBtnDocumento = new JLabel("");
		lblBtnDocumento.setBounds(25, 351, 104, 90);
		add(lblBtnDocumento);
		
		JLabel lblBtnArchivos = new JLabel("");
		lblBtnArchivos.setBounds(25, 468, 104, 96);
		add(lblBtnArchivos);
		
		JLabel lblBtnPapelera = new JLabel("");
		lblBtnPapelera.setBounds(977, 458, 97, 106);
		add(lblBtnPapelera);
		
		JLabel lblSalir = new JLabel("");
		lblSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalir.setBounds(0, 607, 253, 65);
		add(lblSalir);
		lblSalir.setVisible(false);

		JLabel lblMenu = new JLabel("");
		lblMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMenu.setIcon(new ImageIcon(RUTA+"resources\\images\\btnSalir.png"));
		lblMenu.setBounds(0, 604, 253, 65);
		add(lblMenu);
		lblMenu.setVisible(false);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFondo.setIcon(new ImageIcon(RUTA+"resources\\images\\desktop.png"));
		lblFondo.setBounds(0, -39, 1100, 750);
		add(lblFondo);
		
		lblBtnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMenu.setVisible(true);
				lblSalir.setVisible(true);
			}
		});
		
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.getCardLayout().show(ventana.getPanelPrincipal(),"Escena 5 Ordenador");
				lblMenu.setVisible(false);
				lblSalir.setVisible(false);
				galeria.setVisible(false);
				lblDocAbierto.setVisible(false);
				lblCerrarRestaurado.setVisible(false);
				papelera.setVisible(false);
				lblCarpeta.setVisible(false);
				lblCerrarCarpeta.setVisible(false);
			}
		});

		lblBtnGaleria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnGaleria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				galeria.setVisible(true);
			}
		});
		lblBtnPapelera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnPapelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				papelera.setVisible(true);
			}
		});
		lblDocRestaurado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDocRestaurado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDocAbierto.setVisible(true);
				lblCerrarRestaurado.setVisible(true);
			}
		});

		lblCerrarRestaurado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarRestaurado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDocAbierto.setVisible(false);
				lblCerrarRestaurado.setVisible(false);
			}
		});

		lblBtnArchivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnArchivos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblCarpeta.setVisible(true);
				lblCerrarCarpeta.setVisible(true);
			}
		});
		
		lblBtnCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnCorreo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblCorreoLogin.setVisible(true);
				txtCorreo.setVisible(true);
				txtPass.setVisible(true);
				btnLogin.setVisible(true);
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
					
					correo.setVisible(true);
					
					lblCorreoLogin.setVisible(false);
					txtCorreo.setVisible(false);
					txtPass.setVisible(false);
					btnLogin.setVisible(false);
					lblLoginError.setVisible(false);
				}else {
					lblLoginError.setText("Correo o contraseņa incorrectos");
					lblLoginError.setVisible(true);
					
				}
				
			}
		});

		lblCerrarCarpeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarCarpeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblCarpeta.setVisible(false);
				lblCerrarCarpeta.setVisible(false);
			}
		});
	}
	public JLabel getDocRestaurado() {
		return lblDocRestaurado;
	}
}
