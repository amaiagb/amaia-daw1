package com.asej.escaperoom.view.lvl1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.PanelInventario;
import com.asej.escaperoom.view.Ventana;

public class Cocina extends JPanel {

	//private JTextField tiempo_textField;
	private JLabel lblFondoBotones;
	//private JTextPane textPane;
	private int contador = 0;
	private Ventana ventana;
	private JPanel mensajes;
	private JButton btnPadre;
	private JButton btnMadre;
	private JButton btnHija;
	private JButton btnOpcion1;
	private JButton btnOpcion2;
	private JButton btnOpcion3;
	private boolean padrePeticionHecha = false;
	private boolean madrePeticionHecha = false;
	private boolean madreInteraccion = false; //hasta que no termine la tarea de madre no puede empezar las otras
	private boolean hijaPeticionHecha = false;
	private String objetoPadre = "destornillador";
	private String objetoMadre = "mochila";
	private String objetoHija = "revista";
	private String mensajePantalla = "";
	static final int OBJETIVO_MISIONES = 3; // encontrar mochila, entregar objetos a padre y a hermana.
	static int misionesCompletadas = 0;
	private Timer timer;

	public Cocina(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		this.ventana = ventana;

		//Border roundedBorder = new LineBorder(Color.BLACK, 3, true);

		JButton btnIrSalon = new JButton();
		btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrSalon.setBounds(10, 350, 70, 65);
		btnIrSalon.setContentAreaFilled(false); 
		btnIrSalon.setBorderPainted(false); 
		btnIrSalon.setFocusable(false);
		add(btnIrSalon);

		btnOpcion1 = new JButton("");
		btnOpcion1.setBounds(20, 660, 340, 40);
		btnOpcion1.setBackground(Color.ORANGE);
		btnOpcion1.setFont(new Font("Tahoma",0,15));
		add(btnOpcion1);
		btnOpcion1.setVisible(false);

		btnOpcion2 = new JButton("");
		btnOpcion2.setBounds(370, 660, 340, 40);
		btnOpcion2.setBackground(Color.ORANGE);
		btnOpcion2.setFont(new Font("Tahoma",0,15));
		add(btnOpcion2);
		btnOpcion2.setVisible(false);

		btnOpcion3 = new JButton("");
		btnOpcion3.setBounds(720, 660, 340, 40);
		btnOpcion3.setBackground(Color.ORANGE);
		btnOpcion3.setFont(new Font("Tahoma",0,15));
		add(btnOpcion3);
		btnOpcion3.setVisible(false);

		btnPadre = new JButton("");
		btnPadre.setBounds(135, 76, 281, 481);
		btnPadre.setOpaque(true);
		btnPadre.setContentAreaFilled(false);
		btnPadre.setBorderPainted(false);
		add(btnPadre);

		btnMadre = new JButton("");
		btnMadre.setBounds(752, 104, 262, 475);
		btnMadre.setOpaque(true);
		btnMadre.setContentAreaFilled(false);
		btnMadre.setBorderPainted(false);
		add(btnMadre);

		btnHija = new JButton("");
		btnHija.setBounds(481, 275, 156, 262);
		btnHija.setOpaque(true);
		btnHija.setContentAreaFilled(false);
		btnHija.setBorderPainted(false);
		add(btnHija);

		lblFondoBotones = new JLabel("");
		lblFondoBotones.setBackground(Color.DARK_GRAY);
		lblFondoBotones.setOpaque(true);
		lblFondoBotones.setBounds(0, 660, 1084, 90);
		add(lblFondoBotones);
		lblFondoBotones.setVisible(false);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\cocina2.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnIrSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnOpcion1.isVisible()) {
					Audio.reproducirEfectoSonido(Audio.BOTON);
					Ventana.quitarTextoPantalla();
					ventana.showEscena("Salon");
				}
			}
		});

		btnPadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnPadre.getCursor().getType() == 0 || (btnPadre.getCursor().getType() != 0 && objetoPadre.equals(PanelInventario.objetoSeleccionado))) {
					if(madreInteraccion) {
						pasarPreguntaPadre();
					} else {
						Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina1"));
					}
					
				}
			}
		});

		btnMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnMadre.getCursor().getType() == 0 || (btnMadre.getCursor().getType() != 0 && objetoMadre.equals(PanelInventario.objetoSeleccionado))) {
					pasarPreguntaMadre();
				}
			}
		});

		btnHija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnHija.getCursor().getType() == 0 || (btnHija.getCursor().getType() != 0 && objetoHija.equals(PanelInventario.objetoSeleccionado))) {
					if(madreInteraccion) {
						pasarPreguntaHija();
					} else {
						Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina2"));
					}
				}
			}
		});

		btnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegundoDialogo();
			}

		});
		btnOpcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegundoDialogo();
			}
		});

		btnOpcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSegundoDialogo();
			}
		 });
		
		 btnIrSalon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
				}
		 });
		 
		setVisible(true);
	}

	public void pasarPreguntaPadre() {
		
		if (!padrePeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina3"));
			mostrarBotones(Ventana.mensajes.getString("cocina4"),Ventana.mensajes.getString("cocina5"),Ventana.mensajes.getString("cocina6"));
			padrePeticionHecha = true;
			mensajePantalla = "padre";

		} else if (padrePeticionHecha && !objetoPadre.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina7"));

		} else if (padrePeticionHecha && objetoPadre.equals(PanelInventario.objetoSeleccionado)) { // Entregar herramientas a padre
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina8"));
			btnPadre.setVisible(false);
			ventana.entregarObjeto(PanelInventario.objetoSeleccionadoId);
			Audio.reproducirEfectoSonido(Audio.COIN);
			misionesCompletadas++;
		}
	}

	public void pasarPreguntaMadre() {
		if (!madrePeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina9"));
			mostrarBotones(Ventana.mensajes.getString("cocina10"),Ventana.mensajes.getString("cocina11"),Ventana.mensajes.getString("cocina12"));
			madrePeticionHecha = true;
			mensajePantalla = "madre";
			Habitacion.btnCama.setVisible(true);

		} else if (madrePeticionHecha && !Cama.mochilaEncontrada) {
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina13"));

		} else if (madrePeticionHecha && Cama.mochilaEncontrada) { // Entregar objeto a madre
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina14"));
			ventana.getObjetosInventario().add(new Objeto("sandwich","sandwich.png", Ventana.mensajes.getString("cocina15")));
			btnMadre.setVisible(false);
			timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	ventana.mostrarInventario(ventana);
	            	ventana.getBtnInventario().setVisible(true);
	                Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina16"));
	            	
	                if (ventana.getPanelInventario().isVisible()) {
	                    timer.stop();
	                }
	            }
	        });
			timer.start();
			madreInteraccion = true;
			misionesCompletadas++;
		}
	}

	public void pasarPreguntaHija() {
		if (!hijaPeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina17"));
			mostrarBotones(Ventana.mensajes.getString("cocina18"),Ventana.mensajes.getString("cocina19"),Ventana.mensajes.getString("cocina20"));
			hijaPeticionHecha = true;
			mensajePantalla = "hija";

		} else if (hijaPeticionHecha && !objetoHija.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina21"));

		} else if (hijaPeticionHecha && objetoHija.equals(PanelInventario.objetoSeleccionado)) { // Entregar sopa de letras
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("cocina22"));
			btnHija.setVisible(false);
			ventana.entregarObjeto(PanelInventario.objetoSeleccionadoId);
			Audio.reproducirEfectoSonido(Audio.COIN);
			misionesCompletadas++;
		}
	}
	private void mostrarBotones(String txtBoton1, String txtBoton2, String txtBoton3) {
		btnOpcion1.setText(txtBoton1);
		btnOpcion2.setText(txtBoton2);
		btnOpcion3.setText(txtBoton3);
		btnOpcion1.setVisible(true);
		btnOpcion2.setVisible(true);
		btnOpcion3.setVisible(true);
		btnPadre.setEnabled(false);
		btnMadre.setEnabled(false);
		btnHija.setEnabled(false);
		lblFondoBotones.setVisible(true);
	}
	private void mostrarSegundoDialogo() {
		if (mensajePantalla.equals("padre")) {
			btnPadre.setEnabled(false);
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina23"));
			mostrarBotones(Ventana.mensajes.getString("cocina24"), Ventana.mensajes.getString("cocina25"),Ventana.mensajes.getString("cocina26"));
			mensajePantalla = "";

		} else if (mensajePantalla.equals("madre")) {
			btnMadre.setEnabled(false);
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina27"));
			mostrarBotones(Ventana.mensajes.getString("cocina28"),Ventana.mensajes.getString("cocina29"),Ventana.mensajes.getString("cocina30"));
			mensajePantalla = "";

		} else if (mensajePantalla.equals("hija")) {
			btnHija.setEnabled(false);
			Ventana.mostrarTextoPantalla(
					Ventana.mensajes.getString("cocina31"));
			mostrarBotones(Ventana.mensajes.getString("cocina32"),Ventana.mensajes.getString("cocina33"),Ventana.mensajes.getString("cocina34"));
			mensajePantalla = "";

		} else {
			Ventana.quitarTextoPantalla();
			ventana.getPanelTextos().setLocation(0,650);
			lblFondoBotones.setVisible(false);
			btnOpcion1.setVisible(false);
			btnOpcion2.setVisible(false);
			btnOpcion3.setVisible(false);
			btnPadre.setEnabled(true);
			btnMadre.setEnabled(true);
			btnHija.setEnabled(true);
		}
	}

}
