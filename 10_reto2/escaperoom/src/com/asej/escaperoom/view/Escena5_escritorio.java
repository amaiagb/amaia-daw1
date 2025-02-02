package com.asej.escaperoom.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Escena5_escritorio extends JPanel {

	private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";

	public Escena5_escritorio(Ventana ventana) {

		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		
		Escena5_papelera papelera = new Escena5_papelera(ventana);
		papelera.setSize(760, 524);
		papelera.setLocation(166, 100);
		papelera.setBounds(160, 100, 759, 524);
		add(papelera);
		papelera.setVisible(false);
		
		
		Escena5_galeria galeria = new Escena5_galeria(ventana);
		galeria.setBounds(85, 77, 920, 540);
		add(galeria);
		galeria.setVisible(false);
		
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
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMenu.setIcon(new ImageIcon(RUTA+"resources\\images\\btnSalir.png"));
		lblMenu.setBounds(0, 604, 253, 65);
		add(lblMenu);
		lblMenu.setVisible(false);
		
		JLabel lblSalir = new JLabel("");
		lblSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSalir.setBounds(0, 594, 253, 65);
		add(lblSalir);
		lblSalir.setVisible(false);
		
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
	}
}
