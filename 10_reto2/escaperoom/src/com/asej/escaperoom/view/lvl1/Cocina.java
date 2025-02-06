package com.asej.escaperoom.view.lvl1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.view.PanelInventario;
import com.asej.escaperoom.view.Ventana;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre3;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina3;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre3;

public class Cocina extends JPanel {

	private JTextField tiempo_textField;
	private JLabel lblFondoBotones;
	private JTextPane textPane;
	private int contador = 0;
	private int contadorPadre = 0;
	private int contadorMadre = 0;
	private int contadorHija = 0;
	private int contadorPreguntaPadre = 0;
	private int contadorPreguntaMadre = 0;
	private int contadorPreguntaHija = 0;
	private int segundos = 3600;
	private JTextPane txtDialogo;
	private Clip clipPrincipal;
	private Clip clipBoton;
	private Clip clipClick;
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
	private boolean hijaPeticionHecha = false;
	private String objetoPadre = "destornillador";
	private String objetoMadre = "mochila";
	private String objetoHija = "sopa de letras";
	private String mensajePantalla = "";
	private final int OBJETIVO_MISIONES = 4; // encontrar mochila, entregar objetos a padre, madre e hija.
	private int misionesCompletadas = 0;

	public Cocina(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		this.ventana = ventana;
		// ventana.getPanelTextos().setVisible(false);
		System.out.println(ventana.getPanelTextos().isVisible());

		Border roundedBorder = new LineBorder(Color.BLACK, 3, true);

		JButton btnIrSalon = new JButton("<");
		btnIrSalon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIrSalon.setBounds(10, 317, 46, 69);
		add(btnIrSalon);

		/*
		 * ventana.getPanelTextos().setBounds(0,640,0,10);
		 * ventana.getTxtDialogo().setBounds(0,10,1084,70);
		 */
		/*
		 * mensajes = new JPanel(); mensajes.setBounds(0, 600, 1084, 130);
		 * mensajes.setBackground(Color.DARK_GRAY); add(mensajes,
		 * JLayeredPane.PALETTE_LAYER); mensajes.setLayout(null);
		 * 
		 * txtDialogo = new JTextPane(); txtDialogo.setEditable(false);
		 * txtDialogo.setOpaque(false); txtDialogo.setAlignmentX(CENTER_ALIGNMENT);
		 * txtDialogo.setForeground(Color.white); txtDialogo.setBounds(0, 0, 745, 60);
		 * mensajes.add(txtDialogo); StyledDocument doc =
		 * txtDialogo.getStyledDocument(); SimpleAttributeSet center = new
		 * SimpleAttributeSet(); StyleConstants.setAlignment(center,
		 * StyleConstants.ALIGN_CENTER); doc.setParagraphAttributes(0, doc.getLength(),
		 * center, false);
		 */
		btnOpcion1 = new JButton("");
		btnOpcion1.setBounds(20, 660, 340, 40);
		btnOpcion1.setBackground(Color.ORANGE);
		add(btnOpcion1);
		btnOpcion1.setVisible(false);

		btnOpcion2 = new JButton("");
		btnOpcion2.setBounds(370, 660, 340, 40);
		btnOpcion2.setBackground(Color.ORANGE);
		add(btnOpcion2);
		btnOpcion2.setVisible(false);

		btnOpcion3 = new JButton("");
		btnOpcion3.setBounds(720, 660, 340, 40);
		btnOpcion3.setBackground(Color.ORANGE);
		add(btnOpcion3);
		btnOpcion3.setVisible(false);

		btnPadre = new JButton("");
		btnPadre.setBounds(175, 176, 125, 481);
		btnPadre.setOpaque(true);
		btnPadre.setContentAreaFilled(false);
		btnPadre.setBorderPainted(false);
		add(btnPadre);

		btnMadre = new JButton("");
		btnMadre.setBounds(806, 295, 109, 284);
		btnMadre.setOpaque(true);
		btnMadre.setContentAreaFilled(false);
		btnMadre.setBorderPainted(false);
		add(btnMadre);

		btnHija = new JButton("");
		btnHija.setBounds(342, 317, 84, 264);
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
		lblFondo.setIcon(new ImageIcon("resources\\images\\cocina.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnIrSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnOpcion1.isVisible()) {
					reproducirMusicaBoton();
					Ventana.quitarTextoPantalla();
					ventana.showEscena("Salon");
				}
			}
		});

		btnPadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaPadre();
			}
		});

		btnMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaMadre();
			}
		});

		btnHija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaHija();
			}
		});

		btnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (mensajePantalla.equals("padre")) {
					btnPadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					mostrarBotones("¡Claro, ahora mismo!", "No me apetece mucho", "opción 3");
					mensajePantalla = "";

				} else if (mensajePantalla.equals("madre")) {
					btnMadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					mostrarBotones("¡Claro, ahora mismo!", "No me apetece mucho", "opción 3");
					mensajePantalla = "";

				} else if (mensajePantalla.equals("hija")) {
					btnHija.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Niña: Hermano, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					mostrarBotones("¡Claro, ahora mismo!", "No me apetece mucho", "opción 3");
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
		});
		btnOpcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mensajePantalla.equals("padre")) {
					btnPadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";

				} else if (mensajePantalla.equals("madre")) {
					btnMadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";

				} else if (mensajePantalla.equals("hija")) {
					btnHija.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
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
		});

		btnOpcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mensajePantalla.equals("padre")) {
					btnPadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";

				} else if (mensajePantalla.equals("madre")) {
					btnMadre.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";

				} else if (mensajePantalla.equals("hija")) {
					btnHija.setEnabled(false);
					Ventana.mostrarTextoPantalla(
							"Niña: Hermano, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
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
		});

		reproducirMusicaPrincipal();
		setVisible(true);
	}

	public void pasarPreguntaPadre() {
		System.out.println("padre");
		
		if (!padrePeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla(
					"Aita: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
			mostrarBotones("Ay, qué sueño tengo", "Egun on aita!", "Zzzzz");
			padrePeticionHecha = true;
			mensajePantalla = "padre";

		} else if (padrePeticionHecha && !objetoPadre.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla("Aita: Sigo esperando que me traigas la caja de herramientas\n");

		} else if (padrePeticionHecha && objetoPadre.equals(PanelInventario.objetoSeleccionado)) { // Entregar herramientas a padre
			Ventana.mostrarTextoPantalla(
					"Aita: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnPadre.setVisible(false);
			ventana.entregarObjeto(PanelInventario.objetoSeleccionadoId);
		}
	}

	public void pasarPreguntaMadre() {
		if (!madrePeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla(
					"Ama: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
			mostrarBotones("Ay, qué sueño tengo", "Egun on ama!", "Zzzzz");
			madrePeticionHecha = true;
			mensajePantalla = "madre";

		} else if (madrePeticionHecha && !objetoMadre.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla("Ama: Sigo esperando que me traigas la caja de herramientas\n");

		} else if (madrePeticionHecha && objetoMadre.equals(PanelInventario.objetoSeleccionado)) { // Entregar objeto a madre
			Ventana.mostrarTextoPantalla(
					"Ama: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnMadre.setVisible(false);
		}
	}

	public void pasarPreguntaHija() {
		if (!hijaPeticionHecha) {
			ventana.getPanelTextos().setLocation(0, 600);
			Ventana.mostrarTextoPantalla("Hija: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
			mostrarBotones("Ay, qué sueño tengo", "Egun on hermana!", "Zzzzz");
			hijaPeticionHecha = true;
			mensajePantalla = "hija";

		} else if (hijaPeticionHecha && !objetoHija.equals(PanelInventario.objetoSeleccionado)) {
			Ventana.mostrarTextoPantalla("Hija: Sigo esperando que me traigas la caja de herramientas\n");

		} else if (hijaPeticionHecha && objetoHija.equals(PanelInventario.objetoSeleccionado)) { // Entregar sopa de letras
			Ventana.mostrarTextoPantalla(
					"Hija: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnHija.setVisible(false);
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

	public void reproducirMusicaPrincipal() {
		if (clipPrincipal != null && clipPrincipal.isRunning()) {
			clipPrincipal.stop(); // Detén la música anterior si está sonando
		}

		new Thread(() -> {
			try {
				File musica = new File("D:\\music\\casa.wav");
				if (!musica.exists()) {
					System.err.println("El archivo no existe: " + musica.getAbsolutePath());
					return;
				}

				try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
					clipPrincipal = (Clip) AudioSystem
							.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
					clipPrincipal.open(audioInputStream);
					clipPrincipal.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce en bucle
					clipPrincipal.start(); // Inicia la reproducción
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void reproducirMusicaBoton() {
		if (clipBoton != null && clipBoton.isRunning()) {
			clipBoton.stop(); // Detén la música anterior si está sonando
		}

		new Thread(() -> {
			try {
				File musica = new File("D:\\music\\boton.wav");
				if (!musica.exists()) {
					System.err.println("El archivo no existe: " + musica.getAbsolutePath());
					return;
				}

				try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
					clipBoton = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
					clipBoton.open(audioInputStream);
					clipBoton.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void reproducirMusicaClick() {
		if (clipClick != null && clipClick.isRunning()) {
			clipClick.stop(); // Detén la música anterior si está sonando
		}

		new Thread(() -> {
			try {
				File musica = new File("D:\\music\\click.wav");
				if (!musica.exists()) {
					System.err.println("El archivo no existe: " + musica.getAbsolutePath());
					return;
				}

				try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
					clipClick = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
					clipClick.open(audioInputStream);
					clipClick.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

}
