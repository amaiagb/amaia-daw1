package com.asej.escaperoom.view.lvl3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Galeria extends JPanel {

	private Ventana ventana;
	private ImageIcon imageIcon;
	private JLabel lblFotoNombre;
	private JLabel lblFoto;
	
	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	
	public Galeria(Ventana ventana) {

		this.ventana = ventana;
		
		setLayout(null);
		setBounds(0, 0, 920, 540);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel archivos = new JPanel();
		archivos.setBounds(41, 95, 434, 336);
		archivos.setOpaque(false);
		add(archivos);
		archivos.setLayout(null);
		
		JLabel lblFoto1 = new JLabel("24_12_img");
		lblFoto1.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setBounds(26,30,103,120);
		archivos.add(lblFoto1);
		
		JLabel lblFoto2 = new JLabel("07_03_img");
		lblFoto2.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto2.setBounds(175, 30, 103, 120);
		archivos.add(lblFoto2);
		
		JLabel lblFoto3 = new JLabel("15_05_img");
		lblFoto3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto3.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto3.setBounds(314, 32, 110, 118);
		archivos.add(lblFoto3);
		
		JLabel lblFoto4 = new JLabel("19_08_img");
		lblFoto4.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto4.setBounds(25, 181, 103, 109);
		archivos.add(lblFoto4);
		
		JLabel lblFoto5 = new JLabel("05_01_img");
		lblFoto5.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto5.setBounds(175, 181, 103, 109);
		archivos.add(lblFoto5);
		
		JLabel lblFoto6 = new JLabel("27_09_img");
		lblFoto6.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFoto6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFoto6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto6.setBounds(321, 181, 103, 109);
		archivos.add(lblFoto6);
		
		lblFoto = new JLabel("");
		lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setText("Vista Previa");
		lblFoto.setBounds(570, 95, 330, 336);
		add(lblFoto);		
		
		lblFotoNombre = new JLabel("");
		lblFotoNombre.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
		lblFotoNombre.setBackground(Color.WHITE);
		lblFotoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoNombre.setBounds(570, 442, 330, 36);
		add(lblFotoNombre);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		//lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\ventana_galeria.png"));
		lblFondo.setBounds(0, 0, 920, 540);
		Image image = new ImageIcon(RUTA+"resources\\images\\galeria.png").getImage();
		ImageIcon imageIconEscalada = new ImageIcon(image.getScaledInstance(920, 540, Image.SCALE_SMOOTH));	
		
		JLabel lblCerrarGaleria = new JLabel("");
		lblCerrarGaleria.setBounds(891, 0, 29, 36);
		add(lblCerrarGaleria);
		

		lblCerrarGaleria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarGaleria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblFondo.setIcon(imageIconEscalada);
		add(lblFondo);

		lblFoto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto1, "futbol.jpg", "24_12.jpg");
			}
		});
		
		lblFoto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto2, "puerta.jpg", "07_03.jpg");
			}
		});
		
		lblFoto3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto1, "tarta.jpg", "15_05.jpg");
			}
		});
		
		lblFoto4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto4, "coche.jpg", "19_08.jpg");
			}
		});
		
		lblFoto5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto5,  "coche.jpg", "05_01.jpg");
			}
		});
		
		lblFoto6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFoto6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarFoto(lblFoto6,  "coche.jpg", "27_09.jpg");
			}
		});
		
	}
	
	private void mostrarFoto(JLabel lblFotoSeleccionada, String rutaImg, String nombreFoto) {
		imageIcon = new ImageIcon("resources\\images\\galeria_"+rutaImg);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		ImageIcon imageIconEscalada = new ImageIcon(newimg);	
		lblFoto.setIcon(imageIconEscalada);
		lblFotoNombre.setText(nombreFoto);
	}
}
