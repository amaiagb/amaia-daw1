package com.asej.escaperoom.view.lvl5;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Escena5_papelera extends JPanel {

	private Ventana ventana;
	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	
	private JLabel docRestaurado;
	
	public Escena5_papelera(Ventana ventana, JLabel docRestaurado) {
		
		this.ventana = ventana;
		this.docRestaurado = docRestaurado;
		setBounds(85, 77, 920, 540);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblCerrarPapelera = new JLabel("");
		lblCerrarPapelera.setBounds(722, 0, 36, 35);
		add(lblCerrarPapelera);
		
		JLabel lblDocSecreto = new JLabel("");
		lblDocSecreto.setBounds(57, 95, 140, 123);
		add(lblDocSecreto);
		
		JLabel btnRestaurar = new JLabel("");
		add(btnRestaurar);
		btnRestaurar.setBounds(196, 288, 159, 43);
		btnRestaurar.setOpaque(false);
		
		JLabel btnCancelarRestauracion = new JLabel("");
		add(btnCancelarRestauracion);
		btnCancelarRestauracion.setBounds(378, 288, 159, 43);
		btnCancelarRestauracion.setOpaque(false);
		
		JLabel lblAvisoRestaurar = new JLabel();
		lblAvisoRestaurar.setIcon(new ImageIcon(RUTA+"resources\\images\\restaurar.png"));
		lblAvisoRestaurar.setLocation(99, 126);
		lblAvisoRestaurar.setSize(550, 271);
		add(lblAvisoRestaurar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon(RUTA+"resources\\images\\papelera.png"));
		add(lblFondo);
		lblAvisoRestaurar.setVisible(false);

		lblDocSecreto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDocSecreto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAvisoRestaurar.setVisible(true);
			}
		});
		

		btnRestaurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRestaurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(RUTA+"resources\\images\\papelera_vacia.png"));
				lblAvisoRestaurar.setVisible(false);
				docRestaurado.setVisible(true);
				//docRestaurado.setIcon(new ImageIcon(RUTA+"resources\\images\\docSecreto.png"));
				
			}
		});
		
		btnCancelarRestauracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelarRestauracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAvisoRestaurar.setVisible(false);
			}
		});
		
		lblCerrarPapelera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarPapelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}


}
