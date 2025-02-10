package com.asej.escaperoom.juegos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.asej.escaperoom.view.Ventana;

public class PiedraPapelTijera extends JPanel {
	
	private JTextField txtPlayer1;
	private JTextField txtPlayer2;
	private JLabel lblP1Img;
	private JLabel lblP2Img;
	private JLabel lblP1Puntos;
	private JTextField txtP1Puntos;
	private JLabel lblP2Puntos;
	private JTextField txtP2Puntos;
	private JLabel lblSeleccion;
	private JLabel lblP1Gana;
	private JLabel lblP2Gana;
	private int p1Seleccion;
	private String p1SeleccionTxt;
	private String p2SeleccionTxt;
	private int ganador;
	private 
	JLabel puntosA1, puntosA2, puntosA3, puntosA4, puntosA5;
	JLabel puntosB1, puntosB2, puntosB3, puntosB4, puntosB5;
	

	public PiedraPapelTijera(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblP1 = new JLabel("Bruno");
		lblP1.setForeground(Color.WHITE);
		lblP1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblP1.setBounds(30, 80, 95, 33);
		add(lblP1);
		
		puntosA1 = new JLabel("");
		puntosA1.setBackground(Color.DARK_GRAY);
		puntosA1.setBounds(130, 80, 10, 30);
		puntosA1.setOpaque(true);
		add(puntosA1);

		puntosA2 = new JLabel("");
		puntosA2.setBackground(Color.DARK_GRAY);
		puntosA2.setBounds(145, 80, 10, 30);
		puntosA2.setOpaque(true);
		add(puntosA2);

		puntosA3 = new JLabel("");
		puntosA3.setBackground(Color.DARK_GRAY);
		puntosA3.setBounds(160, 80, 10, 30);
		puntosA3.setOpaque(true);
		add(puntosA3);

		puntosA4 = new JLabel("");
		puntosA4.setBackground(Color.DARK_GRAY);
		puntosA4.setBounds(175, 80, 10, 30);
		puntosA4.setOpaque(true);
		add(puntosA4);

		puntosA5 = new JLabel("");
		puntosA5.setBackground(Color.DARK_GRAY);
		puntosA5.setBounds(190, 80, 10, 30);
		puntosA5.setOpaque(true);
		add(puntosA5);

		JLabel lblP1Fondo = new JLabel("");
		lblP1Fondo.setBackground(Color.BLACK);
		lblP1Fondo.setBounds(10, 70, 210, 54);
		lblP1Fondo.setOpaque(true);
		add(lblP1Fondo);
		
		JLabel lblP2 = new JLabel("Manuel");
		lblP2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblP2.setForeground(Color.WHITE);
		lblP2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblP2.setBounds(955, 80, 105, 33);
		add(lblP2);
		
		puntosB1 = new JLabel("");
		puntosB1.setBackground(Color.DARK_GRAY);
		puntosB1.setBounds(942, 80, 10, 30);
		puntosB1.setOpaque(true);
		add(puntosB1);

		puntosB2 = new JLabel("");
		puntosB2.setBackground(Color.DARK_GRAY);
		puntosB2.setBounds(927, 80, 10, 30);
		puntosB2.setOpaque(true);
		add(puntosB2);

		puntosB3 = new JLabel("");
		puntosB3.setBackground(Color.DARK_GRAY);
		puntosB3.setBounds(912, 80, 10, 30);
		puntosB3.setOpaque(true);
		add(puntosB3);

		puntosB4 = new JLabel("");
		puntosB4.setBackground(Color.DARK_GRAY);
		puntosB4.setBounds(897, 80, 10, 30);
		puntosB4.setOpaque(true);
		add(puntosB4);

		puntosB5 = new JLabel("");
		puntosB5.setBackground(Color.DARK_GRAY);
		puntosB5.setBounds(882, 80, 10, 30);
		puntosB5.setOpaque(true);
		add(puntosB5);
		
		JLabel lblP2Fondo = new JLabel("");
		lblP2Fondo.setBackground(Color.BLACK);
		lblP2Fondo.setBounds(864, 70, 240, 54);
		lblP2Fondo.setOpaque(true);
		add(lblP2Fondo);
		
		JLabel btnPapel = new JLabel("");
		btnPapel.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\btn2.png"));
		btnPapel.setBounds(490, 539, 135, 135);
		add(btnPapel);
		
		JLabel btnPiedra = new JLabel("");
		btnPiedra.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\btn1.png"));
		btnPiedra.setBounds(306, 539, 135, 135);
		add(btnPiedra);
		
		JLabel btnTijera = new JLabel("");
		btnTijera.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\btn3.png"));
		btnTijera.setBounds(672, 539, 135, 135);
		add(btnTijera);
		
		lblP1Img = new JLabel();
		lblP1Img.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\mano1aaa.png"));
		lblP1Img.setBounds(-5, 200, 261, 242);
		add(lblP1Img);

		lblP2Img = new JLabel();
		lblP2Img.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\mano1bbb.png"));
		lblP2Img.setBounds(843, 200, 261, 242);
		add(lblP2Img);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\ppt_bg.png"));
		lblFondo.setBounds(0, 0, 1100, 750);
		add(lblFondo);
		
		ventana.quitarTextoPantalla();
		ventana.getPanelTextos().setVisible(false);
		System.out.println(ventana.getPanelTextos().isVisible());
		
		btnPiedra.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnPiedra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnPiedra.setIcon(new ImageIcon("resources\\images\\btn1a.png"));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnPiedra.setIcon(new ImageIcon("resources\\images\\btn1.png"));
        	}
        });

		btnPapel.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnPapel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnPapel.setIcon(new ImageIcon("resources\\images\\btn2a.png"));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnPapel.setIcon(new ImageIcon("resources\\images\\btn2.png"));
        	}
        });

		btnTijera.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnTijera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnTijera.setIcon(new ImageIcon("resources\\images\\btn3a.png"));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnTijera.setIcon(new ImageIcon("resources\\images\\btn3.png"));
        	}
        });
		
		btnPiedra.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		p1Seleccion = 1;
        		lblP1Img.setIcon(new ImageIcon("resources\\images\\piedra.png"));
				hacerBatalla(p1Seleccion);
			}
        });
		
		btnPapel.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		p1Seleccion = 2;
        		lblP1Img.setIcon(new ImageIcon("resources\\images\\papel.png"));
				hacerBatalla(p1Seleccion);
			}
        });
		
		btnTijera.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		p1Seleccion = 3;
        		lblP1Img.setIcon(new ImageIcon("resources\\images\\tijera.png"));
				hacerBatalla(p1Seleccion);
			}
        });
	}
	
private void hacerBatalla(int p1Seleccion) {
		/*
		//resetear
		lblP1Gana.setVisible(false);
		lblP2Gana.setVisible(false);
		lblP1Gana.setText("Gana");
		lblP2Gana.setText("Gana");
		//txtPlayer1.setBackground(Color.LIGHT_GRAY);
		//txtPlayer2.setBackground(Color.LIGHT_GRAY);
		*/
		// mostrar seleccion de p1
		
		p1SeleccionTxt = obtenerTxtSeleccion(p1Seleccion);
		//lblP1Img.setText(p1SeleccionTxt);

		// generar seleccion de p2 aleatoriamente
		int p2Seleccion;
		Random random = new Random();
		p2Seleccion = random.nextInt(3) + 1;
		System.out.println(p2Seleccion);
		p2SeleccionTxt = obtenerTxtSeleccion(p2Seleccion);
		System.out.println(p2SeleccionTxt);
		//lblP2Img.setText(p2SeleccionTxt);
		mostrarImagen(p2Seleccion);
		
		// comparar

		if (p1Seleccion == 1) { // piedra
			if (p2Seleccion == 2) { // papel
				ganador = 2;
			} else if (p2Seleccion == 3) { // tijera
				ganador = 1;
			} else {
				ganador = 0;
			}
		} else if (p1Seleccion == 2) { // papel
			if (p2Seleccion == 1) { // piedra
				ganador = 1;
			} else if (p2Seleccion == 3) { // tijera
				ganador = 2;
			} else {
				ganador = 0;
			}
		} else if (p1Seleccion == 3) { // tijera
			if (p2Seleccion == 1) { // piedra
				ganador = 2;
			} else if (p2Seleccion == 2) { // papel
				ganador = 1;
			} else {
				ganador = 0;
			}
		}

		// gestionar ganador
		System.out.println("Ganador: "+ganador);
		switch (ganador) {
		
			case 1 -> { //gana P1
				int puntos = Integer.parseInt(txtP1Puntos.getText())+1;
				//txtP1Puntos.setText(String.valueOf(puntos));
				//lblP1Gana.setVisible(true);
				//txtPlayer1.setBackground(Color.ORANGE);
				pintarPuntosP1(puntos);
				
			}
			case 2 -> { //gana P2
				/*
				int puntos = Integer.parseInt(txtP2Puntos.getText())+1;
				txtP2Puntos.setText(String.valueOf(puntos));
				lblP2Gana.setVisible(true);
				txtPlayer2.setBackground(Color.ORANGE);
				*/
			}
			case 0 -> { //empate
				/*
				lblP1Gana.setText("Empate");
				lblP2Gana.setText("Empate");
				lblP1Gana.setVisible(true);
				lblP2Gana.setVisible(true);
				*/
			}
		}

	}

private void pintarPuntosP1(int puntos) {
	switch(puntos) {
	case 1 -> puntosA1.setBackground(Color.GREEN);
	case 2 -> puntosA2.setBackground(Color.GREEN);
	case 3 -> puntosA3.setBackground(Color.GREEN);
	case 4 -> puntosA4.setBackground(Color.GREEN);
	case 5 -> puntosA5.setBackground(Color.GREEN);
	}
	
}

private String obtenerTxtSeleccion(int seleccion) {
	String seleccionTxt = "";
	switch (seleccion) {
	case 1 -> {
		seleccionTxt = "Piedra";
	}
	case 2 -> {
		seleccionTxt = "Papel";
	}
	case 3 -> {
		seleccionTxt = "Tijera";
	}
	case 0 -> {
		seleccionTxt = "Error";
	}
	}
	return seleccionTxt;

}
private void mostrarImagen(int seleccion){
	switch(seleccion) {
	case 1->{
		lblP2Img.setIcon(new ImageIcon("resources\\images\\piedra2.png"));
	}
	case 2->{
		lblP2Img.setIcon(new ImageIcon("resources\\images\\papel2.png"));
	}
	case 3->{
		lblP2Img.setIcon(new ImageIcon("resources\\images\\tijera2.png"));
	}
	}
}
}
