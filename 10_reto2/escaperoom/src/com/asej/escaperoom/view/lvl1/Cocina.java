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
						Ventana.mostrarTextoPantalla("Haz caso a ama primero, hijo");
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
						Ventana.mostrarTextoPantalla("Cuando termines lo de ama te cuento una cosa");
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
					"Se nos han pegado las sábanas hoy, eh... Menos mal que todavía llegas al autobús");
			mostrarBotones("Ay, qué sueño tengo", "Egun on aita!", "Qué buena pinta tienen esas tostadas");
			padrePeticionHecha = true;
			mensajePantalla = "padre";

		} else if (padrePeticionHecha && !objetoPadre.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla("Sigo esperando que me traigas el destornillador");

		} else if (padrePeticionHecha && objetoPadre.equals(PanelInventario.objetoSeleccionado)) { // Entregar herramientas a padre
			Ventana.mostrarTextoPantalla(
					"Muchas gracias campeón, cuando vuelvas del colegio te llevo al cine como recompensa, que seguro ya habré arreglado el coche");
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
					"Buenos días hijo, no sé si has oído la alarma así que he ido a despertarte");
			mostrarBotones("Estaba durmiendo como una marmota", "Egun on ama!", "Odio esa alarma");
			madrePeticionHecha = true;
			mensajePantalla = "madre";
			Habitacion.btnCama.setVisible(true);

		} else if (madrePeticionHecha && !Cama.mochilaEncontrada) {
			Ventana.mostrarTextoPantalla("¿Todavía no has encontrado la mochila? Esa habitación tuya es una leonera...");

		} else if (madrePeticionHecha && Cama.mochilaEncontrada) { // Entregar objeto a madre
			Ventana.mostrarTextoPantalla("¡Bien! Te meto el sandwich en el bolsillo grande, ¿vale? Hoy te he hecho tu favorito, para que estés contento");
			ventana.getObjetosInventario().add(new Objeto("sandwich","sandwich.png", "El sandwich para comer en el recreo"));
			btnMadre.setVisible(false);
			timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	ventana.mostrarInventario(ventana);
	            	ventana.getBtnInventario().setVisible(true);
	                Ventana.mostrarTextoPantalla("Ahora puedes acceder a tu mochila en cualquier momento, \nahí se guardarán todos los objetos útiles que encuentres para usarlos cuando necesites");
	            	
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
			Ventana.mostrarTextoPantalla("Egun on hermanito! ");
			mostrarBotones("Hola hermanita", "No te comas todos los cereales, eh", "Qué madrugadora estás hoy");
			hijaPeticionHecha = true;
			mensajePantalla = "hija";

		} else if (hijaPeticionHecha && !objetoHija.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla("¿Has podido terminar mi sopa de letras?");

		} else if (hijaPeticionHecha && objetoHija.equals(PanelInventario.objetoSeleccionado)) { // Entregar sopa de letras
			Ventana.mostrarTextoPantalla("Muchas gracias, eres es el hermano más listo de todos");
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
					"La tostadora siempre dando problemas... Hijo, ya que estas aquí hazme un favor, ve al garaje y traeme mi destronillador a ver si puedo arreglarla");
			mostrarBotones("Vale, aita", "¡Bien, a por las herramientas!", "Vaya momento para ponerse...");
			mensajePantalla = "";

		} else if (mensajePantalla.equals("madre")) {
			btnMadre.setEnabled(false);
			Ventana.mostrarTextoPantalla(
					"Vete a coger tu mochila y traémela anda, que ya tengo tu bocata del recreo preparado");
			mostrarBotones("¡Claro, ahora mismo!", "Bueeeno, vale, voy", "Uf, pues a ver dónde está...");
			mensajePantalla = "";

		} else if (mensajePantalla.equals("hija")) {
			btnHija.setEnabled(false);
			Ventana.mostrarTextoPantalla(
					" Oye, antes estaba en el salón haciendo los pasatiempos de mi revista y jo... no he encontrado ni una palabra de la sopa de letras... ¿Me ayudarías porfa?");
			mostrarBotones("Venga, voy a por la revista", "A estas horas... bueno, va", "¡Sí! ¡Me encantan!");
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
