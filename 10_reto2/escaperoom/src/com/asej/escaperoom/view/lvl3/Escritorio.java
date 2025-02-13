package com.asej.escaperoom.view.lvl3;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Escritorio extends JPanel {

	private JLabel lblDocRestaurado;
	private ImageIcon imageIcon;
	private JLabel lblDocAbierto;
	private JTextField txtCorreo;
	private JTextField txtPass;
	private Timer timer;
	JButton btnCapturar;
	
	public Escritorio(Ventana ventana) {

		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ventana.getPanelTextos().setVisible(false);
				
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
		btnCapturar = new JButton();
		btnCapturar.setIcon(new ImageIcon("resources\\images\\btnCapturas.png"));
		btnCapturar.setBounds(850, 293, 210, 70);
		add(btnCapturar);
		btnCapturar.setVisible(false);
		
		JLabel lblErrorDoc = new JLabel(Ventana.mensajes.getString("docError"));
		lblErrorDoc.setBackground(new Color(255, 250, 205));
		lblErrorDoc.setBounds(150, 380,253,40);
		lblErrorDoc.setOpaque(true);
		add(lblErrorDoc);
		lblErrorDoc.setVisible(false);
		
		Bandeja bandeja = new Bandeja(ventana);
		bandeja.setBounds(85, 77, 758, 521);
		add(bandeja);
		bandeja.setVisible(false);

		Correo correo = new Correo(ventana, bandeja, btnCapturar);
		correo.setBounds(85, 77, 758, 521);
		add(correo);
		correo.setVisible(false);
		
		Galeria galeria = new Galeria(ventana);
		galeria.setBounds(85, 77, 920, 540);
		add(galeria);
		galeria.setVisible(false);
		
		JLabel lblCerrarCarpeta = new JLabel("");
		lblCerrarCarpeta.setBounds(880, 100, 40, 36);
		add(lblCerrarCarpeta);
		lblCerrarCarpeta.setVisible(false);
		
		JLabel lblCarpeta = new JLabel();
		lblCarpeta.setIcon(new ImageIcon("resources\\images\\carpeta.png"));
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
		lblDocAbierto.setIcon(new ImageIcon("resources\\images\\docRestaurado.png"));
		add(lblDocAbierto);
		lblDocAbierto.setVisible(false);

		lblDocRestaurado = new JLabel("");
		lblDocRestaurado.setVerticalAlignment(SwingConstants.TOP);
		lblDocRestaurado.setIcon(new ImageIcon("resources\\images\\docSecreto.png"));
		lblDocRestaurado.setBounds(929, 306, 145, 131);
		add(lblDocRestaurado);
		lblDocRestaurado.setVisible(false);
		
		Papelera papelera = new Papelera(ventana, lblDocRestaurado);
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
		lblMenu.setIcon(new ImageIcon("resources\\images\\btnSalir.png"));
		lblMenu.setBounds(0, 604, 253, 65);
		add(lblMenu);
		lblMenu.setVisible(false);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFondo.setIcon(new ImageIcon("resources\\images\\desktop.png"));
		lblFondo.setBounds(0, -39, 1100, 750);
		add(lblFondo);

		btnCapturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("capturasTxt"));
				btnCapturar.setVisible(false);
				Audio.reproducirEfectoSonido(Audio.COIN);
				ventana.getObjetosInventario().add(new Objeto("capturas","capturas.png", Ventana.mensajes.getString("capturasDesc")));
				Ordenador.capturasConseguidas = true;
				timer = new Timer(3000, new ActionListener() {
			        public void actionPerformed(ActionEvent evt) {
			           timer.stop();
			           Ventana.quitarTextoPantalla();			           
			        }
			    });
				timer.start();
			}
		});
		
		lblBtnDocumento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblErrorDoc.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblErrorDoc.setVisible(false);
			}
		});

		lblBtnDocumento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lblErrorDoc.setVisible(false);
			}
		});
		
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
				ventana.getCardLayout().show(ventana.getPanelPrincipal(),"Ordenador");
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
				correo.setVisible(true);
				/*
				lblCorreoLogin.setVisible(true);
				txtCorreo.setVisible(true);
				txtPass.setVisible(true);
				btnLogin.setVisible(true);
				lblCerrarLogin.setVisible(true);
				*/
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
