package com.asej.escaperoom.juegos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.asej.escaperoom.view.Ventana;

public class PiedraPapelTijera extends JPanel {
	
	//private JTextField txtPlayer1;
	//private JTextField txtPlayer2;
	private JLabel lblP1Img;
	private JLabel lblP2Img;
	//private JLabel lblP1Puntos;
	//private JTextField txtP1Puntos;
	//private JLabel lblP2Puntos;
	//private JTextField txtP2Puntos;
	//private JLabel lblSeleccion;
	//private JLabel lblP1Gana;
	//private JLabel lblP2Gana;
	private int p1Seleccion;
	private String p1;
	private String p2;
	private String ganador;
	private 
	JLabel puntosA1, puntosA2, puntosA3, puntosA4, puntosA5;
	JLabel puntosB1, puntosB2, puntosB3, puntosB4, puntosB5;
	private int puntosP1 = 0;
	private int puntosP2 = 0;
	private JLabel lblTimer;
	private JLabel lblResultado;
	private Ventana ventana;
	private Timer timer;
	private int contadorTimer;
	private JLabel btnPiedra;
	private JLabel btnPapel;
	private JLabel btnTijera;

	public PiedraPapelTijera(Ventana ventana) {
		
		this.ventana = ventana;
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		lblTimer = new JLabel("Selecciona una opci\u00F3n");
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimer.setBackground(new Color(122, 201, 67));
		lblTimer.setOpaque(true);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(451, 219, 210, 135);
		add(lblTimer);
		
		lblResultado = new JLabel();
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblResultado.setBackground(new Color(122, 201, 67));
		lblResultado.setOpaque(true);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(451, 137, 210, 71);
		add(lblResultado);
		lblResultado.setVisible(false);
		
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
		
		btnPapel = new JLabel("");
		btnPapel.setIcon(new ImageIcon("resources\\images\\btn2.png"));
		btnPapel.setBounds(490, 539, 135, 135);
		add(btnPapel);
		
		btnPiedra = new JLabel("");
		btnPiedra.setIcon(new ImageIcon("resources\\images\\btn1.png"));
		btnPiedra.setBounds(306, 539, 135, 135);
		add(btnPiedra);
		
		btnTijera = new JLabel("");
		btnTijera.setIcon(new ImageIcon("resources\\images\\btn3.png"));
		btnTijera.setBounds(672, 539, 135, 135);
		add(btnTijera);
		
		lblP1Img = new JLabel();
		lblP1Img.setIcon(new ImageIcon("resources\\images\\mano1aaa.png"));
		lblP1Img.setBounds(-5, 200, 261, 242);
		add(lblP1Img);

		lblP2Img = new JLabel();
		lblP2Img.setIcon(new ImageIcon("resources\\images\\mano1bbb.png"));
		lblP2Img.setBounds(843, 200, 261, 242);
		add(lblP2Img);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\ppt_bg.png"));
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
        		lblResultado.setVisible(false);
        		p1Seleccion = 1;
        		cuentaAtras("piedra");
			}
        });
		
		btnPapel.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		lblResultado.setVisible(false);
        		p1Seleccion = 2;
        		cuentaAtras("papel");
			}
        });
		
		btnTijera.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
        		lblResultado.setVisible(false);
        		p1Seleccion = 3;
        		cuentaAtras("tijera");
			}
        });
	}
	
	private void hacerBatalla(int p1Seleccion) {
		
		// generar seleccion de p2 aleatoriamente
	
		int p2Seleccion;
		Random random = new Random();
		p2Seleccion = random.nextInt(3) + 1;
		p1 = obtenerTxtSeleccion(p1Seleccion);
		p2 = obtenerTxtSeleccion(p2Seleccion);
		mostrarImagen(p2Seleccion);
		
		// comparar

		if (p1.equals("piedra")) { 
			
			if (p2.equals("papel")) { 
				ganador = "p2";
			} else if (p2.equals("tijera")) {
				ganador = "p1";
			} else {
				ganador = "empate";
			}
		} else if (p1.equals("papel")) { 
			
			if (p2.equals("piedra")) { 
				ganador = "p1";
			} else if (p2.equals("tijera")) {
				ganador = "p2";
			} else {
				ganador = "empate";
			}
		} else if (p1.equals("tijera")) {
			
			if (p2.equals("piedra")) { 
				ganador = "p2";
			} else if (p2.equals("papel")) {
				ganador = "p1";
			} else {
				ganador = "empate";
			}
		}

		// gestionar ganador
		switch (ganador) {
		
			case "p1" -> { 
				puntosP1++;
				pintarPuntosP1(puntosP1);
				if(puntosP1 <5) {
					lblResultado.setText("Ganas");
				} else {
					lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblResultado.setText("¡Enhorabuena!\nHas ganado la partida");
					ventana.showEscena("Calle"); // Cambiar por alguna del nivel 2
					btnPiedra.setVisible(false);
					btnPapel.setVisible(false);
					btnTijera.setVisible(false);
				}
			}
			case "p2" -> { 
				puntosP2++;
				pintarPuntosP2(puntosP2);
				if(puntosP2 <5) {
					lblResultado.setText("Pierdes");
				} else {
					lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblResultado.setText("¡Oh no!\nInténtalo de nuevo");
					reiniciarPartida();
				}
			}
			case "empate" -> { 
				lblResultado.setText("Empate");
			}
		}
	}
	
	private void reiniciarPartida() {
		puntosA1.setBackground(Color.DARK_GRAY);
		puntosA2.setBackground(Color.DARK_GRAY);
		puntosA3.setBackground(Color.DARK_GRAY);
		puntosA4.setBackground(Color.DARK_GRAY);
		puntosA5.setBackground(Color.DARK_GRAY);
		puntosB1.setBackground(Color.DARK_GRAY);
		puntosB2.setBackground(Color.DARK_GRAY);
		puntosB3.setBackground(Color.DARK_GRAY);
		puntosB4.setBackground(Color.DARK_GRAY);
		puntosB5.setBackground(Color.DARK_GRAY);
		puntosP1 = 0;
		puntosP2 = 0;
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimer.setText("Selecciona una opción");
		
	}

	private void cuentaAtras(String opcion) {
		contadorTimer = 3; 
		lblTimer.setVisible(true);
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblTimer.setText("3");
		timer = new Timer(300, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            if (contadorTimer == 3) {
	                lblTimer.setText("2");
	            } else if(contadorTimer == 2)  {
	            	 lblTimer.setText("1");
	            } else if(contadorTimer == 1) {
	            	 lblTimer.setText("");
	            	 lblTimer.setVisible(false);
	            	 lblResultado.setVisible(true);
	            	 timer.stop();
	            	 lblP1Img.setIcon(new ImageIcon("resources\\images\\"+opcion+".png"));
	            	 hacerBatalla(p1Seleccion);
	            }
	            contadorTimer--;
	        }
	    });
		timer.start();
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
	
	
	private void pintarPuntosP2(int puntos) {
		switch(puntos) {
		case 1 -> puntosB1.setBackground(Color.GREEN);
		case 2 -> puntosB2.setBackground(Color.GREEN);
		case 3 -> puntosB3.setBackground(Color.GREEN);
		case 4 -> puntosB4.setBackground(Color.GREEN);
		case 5 -> puntosB5.setBackground(Color.GREEN);
		}
	}
	
	private String obtenerTxtSeleccion(int seleccion) {
		String seleccionTxt = "";
		switch (seleccion) {
		case 1 -> {
			seleccionTxt = "piedra";
		}
		case 2 -> {
			seleccionTxt = "papel";
		}
		case 3 -> {
			seleccionTxt = "tijera";
		}
		case 0 -> {
			seleccionTxt = "error";
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
