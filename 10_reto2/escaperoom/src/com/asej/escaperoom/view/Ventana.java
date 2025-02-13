package com.asej.escaperoom.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.juegos.PiedraPapelTijera;
import com.asej.escaperoom.juegos.SopaLetras;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.lvl1.Autobus;
import com.asej.escaperoom.view.lvl1.Calle;
import com.asej.escaperoom.view.lvl1.Cama;
import com.asej.escaperoom.view.lvl1.Cocina;
import com.asej.escaperoom.view.lvl1.Garaje;
import com.asej.escaperoom.view.lvl1.Habitacion;
import com.asej.escaperoom.view.lvl1.Intro;
import com.asej.escaperoom.view.lvl1.Pasillo;
import com.asej.escaperoom.view.lvl1.Salon;
import com.asej.escaperoom.view.lvl1.Terraza;
import com.asej.escaperoom.view.lvl2.Cajon;
import com.asej.escaperoom.view.lvl2.Clase;
import com.asej.escaperoom.view.lvl2.Codigo;
import com.asej.escaperoom.view.lvl2.ColegioExterior;
import com.asej.escaperoom.view.lvl2.ColegioPasillo;
import com.asej.escaperoom.view.lvl2.ColegioPasillo2;
import com.asej.escaperoom.view.lvl2.Conversacion;
import com.asej.escaperoom.view.lvl2.Conversacion2;
import com.asej.escaperoom.view.lvl2.Movil;
import com.asej.escaperoom.view.lvl2.Movil2;
import com.asej.escaperoom.view.lvl2.TaquillaAbierta;
import com.asej.escaperoom.view.lvl2.Taquillas;
import com.asej.escaperoom.view.lvl2.ZoomJarron;
import com.asej.escaperoom.view.lvl2.ZoomTaquillas;
import com.asej.escaperoom.view.lvl3.AulaOrdenadores;
import com.asej.escaperoom.view.lvl3.Escritorio;
import com.asej.escaperoom.view.lvl3.Ordenador;
import com.asej.escaperoom.view.lvl3.Pizarra;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private PanelOpciones panelOpciones;
	private PanelOpcionesJuego panelOpcionesJuego;
	private PanelInstrucciones panelInstrucciones;
	private PanelInventario panelInventario;
	private PanelPistas panelPistas;
	private static JPanel panelTextos;
    private JPanel panelNav;
    private JPanel panelPrincipal;
    private JPanel panelTransicion;
    private CardLayout cardLayout;
    private static JTextPane txtDialogo;
    public static JTextField txtTimer;
	private Timer timer;
	public static int segundos = 3600;
    private JButton btnSoltarObjeto;
    private ArrayList<Objeto> objetosInventario;
	private JLabel btnInventario;
    private static Locale locale;
    public static int nivelActual = 1;
    public static boolean juegoSuperado = false;
    public static boolean sonido;
    public static ResourceBundle mensajes;

	public Ventana(Locale locale, boolean sonido) {
		setTitle("BilboSKP | School Escape Room");
		setUndecorated(true);
		Ventana ventana = this;
		this.sonido = sonido;
		
		mensajes = ResourceBundle.getBundle("com.asej.escaperoom.language.Mensajes", locale);
		objetosInventario = new ArrayList<>();
		
		Audio.reproducirMusica(Audio.CANCION_PRINCIPAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1084, 711);
		contentPane.add(layeredPane);
		setLocationRelativeTo(null);
		//	LayeredPane layers: Default -> Palette -> Modal -> Popup -> Drag
		
		Portada portada = new Portada(this);
		layeredPane.add(portada, JLayeredPane.MODAL_LAYER);
		
		panelOpciones = new PanelOpciones(this);
		layeredPane.add(panelOpciones, JLayeredPane.POPUP_LAYER);
		panelOpciones.setVisible(false);
		
		panelOpcionesJuego = new PanelOpcionesJuego(this);
		layeredPane.add(panelOpcionesJuego, JLayeredPane.POPUP_LAYER);
		panelOpcionesJuego.setVisible(false);
		
		panelInstrucciones = new PanelInstrucciones();
		layeredPane.add(panelInstrucciones, JLayeredPane.POPUP_LAYER);
		panelInstrucciones.setVisible(false);
		
		panelTransicion = new PanelInstrucciones();
		layeredPane.add(panelTransicion, JLayeredPane.POPUP_LAYER);
		panelTransicion.setVisible(false);
		
		btnSoltarObjeto = new JButton("Soltar Objeto");
		btnSoltarObjeto.setBounds(456, 595, 185, 46);
		btnSoltarObjeto.setBackground(Color.ORANGE);
		btnSoltarObjeto.setForeground(Color.DARK_GRAY);
		btnSoltarObjeto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		layeredPane.add(btnSoltarObjeto);
		btnSoltarObjeto.setVisible(false);
		
		panelInventario = new PanelInventario(this);
		layeredPane.add(panelInventario, JLayeredPane.MODAL_LAYER);
		panelInventario.setVisible(false);

		panelPistas = new PanelPistas();
		layeredPane.add(panelPistas, JLayeredPane.MODAL_LAYER);
		panelPistas.setVisible(false);
		
		panelNav = new JPanel();
		panelNav.setBounds(0, 0, 1084, 60);
		panelNav.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelNav, JLayeredPane.PALETTE_LAYER);
		panelNav.setLayout(null);
		
		panelTextos = new JPanel();
		panelTextos.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelTextos, JLayeredPane.PALETTE_LAYER);
		panelTextos.setLayout(null);
		panelTextos.setVisible(false);
		panelTextos.setBounds(0, 650, 1084, 0);
		
		txtDialogo = new JTextPane(); 
		txtDialogo.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtDialogo.setEditable(false);
	    txtDialogo.setOpaque(false);
	    txtDialogo.setForeground(Color.white);
	    txtDialogo.setBounds(0, 10, 1084, 70);
	    StyledDocument doc = txtDialogo.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
		panelTextos.add(txtDialogo);
		//txtDialogo.setVisible(false);
	    
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1084, 711);
		layeredPane.add(panelPrincipal, JLayeredPane.DEFAULT_LAYER);
		cardLayout = new CardLayout();
		panelPrincipal.setLayout(cardLayout);
		
		txtTimer = new JTextField();
		txtTimer.setEnabled(false);
		txtTimer.setBackground(Color.BLACK);
		txtTimer.setForeground(Color.RED);
		txtTimer.setDisabledTextColor(Color.RED);
		txtTimer.setFont(new Font("OCR A Extended", Font.PLAIN, 36));
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setOpaque(true);
		txtTimer.setEditable(false);
		txtTimer.setBounds(10, 10, 180, 40);
		panelNav.add(txtTimer);
		txtTimer.setColumns(10);
		
		btnInventario = new JLabel();
		btnInventario.setHorizontalAlignment(SwingConstants.CENTER);
		btnInventario.setForeground(Color.WHITE);
		btnInventario.setBackground(Color.GRAY);
		btnInventario.setLocation(800, 10);
		btnInventario.setSize(100, 40);
		btnInventario.setText(mensajes.getString("btnInventario"));
		btnInventario.setOpaque(true);
		btnInventario.setVisible(false);
		//btnInventario.setVisible(true); //Visible para testeo
		panelNav.add(btnInventario);
		
		JLabel btnPista = new JLabel();
		btnPista.setHorizontalAlignment(SwingConstants.CENTER);
		btnPista.setForeground(Color.WHITE);
		btnPista.setBackground(Color.GRAY);
		btnPista.setLocation(910, 10);
		btnPista.setSize(100, 40);
		btnPista.setText(mensajes.getString("btnPista"));
		btnPista.setOpaque(true);
		panelNav.add(btnPista);
		
		JLabel btnOpciones = new JLabel();
		btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpciones.setIcon(new ImageIcon("resources\\images\\off.png"));
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setBackground(Color.GRAY);
		btnOpciones.setBounds(1020, 10, 60, 40);
		btnOpciones.setOpaque(true);
		panelNav.add(btnOpciones);
		
		timer = new Timer(1000, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(segundos > 0 &&  !juegoSuperado) {
            		segundos--;
                    String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
                    txtTimer.setText(time);
            	} else {
            		timer.stop();
            		JOptionPane.showMessageDialog(txtTimer,"FIN","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            	}
            }
        });

		// Registrar escenas:
		panelPrincipal.add(new Intro(this), "Intro");
		panelPrincipal.add(new Habitacion(this), "Habitacion");
		panelPrincipal.add(new Pasillo(this), "Pasillo");
		panelPrincipal.add(new Terraza(this), "Terraza");
		panelPrincipal.add(new Salon(this), "Salon");
		panelPrincipal.add(new Cocina(this), "Cocina");
		panelPrincipal.add(new Garaje(this), "Garaje");
		panelPrincipal.add(new SopaLetras(this), "Sopa de letras");
		panelPrincipal.add(new Calle(this), "Calle");
		panelPrincipal.add(new Cama(this), "Cama");
		panelPrincipal.add(new Autobus(this), "Bus");
		
		panelPrincipal.add(new Movil(this), "Movil");
		panelPrincipal.add(new Movil2(this), "Movil 2");
		panelPrincipal.add(new Conversacion(this), "Conversacion");
		panelPrincipal.add(new ColegioExterior(this), "Colegio Exterior");
		panelPrincipal.add(new ColegioPasillo(this), "Colegio Pasillo");
		panelPrincipal.add(new Clase(this), "Clase");
		panelPrincipal.add(new ZoomJarron(this), "Zoom Jarron");
		panelPrincipal.add(new Cajon(this), "Cajon");
		panelPrincipal.add(new ColegioPasillo2(this), "Colegio Pasillo2");
		panelPrincipal.add(new Taquillas(this), "Taquillas");
		panelPrincipal.add(new ZoomTaquillas(this), "Zoom Taquillas");
		//panelPrincipal.add(new Codigo(this), "Codigo");
		panelPrincipal.add(new TaquillaAbierta(this), "Taquilla Abierta");
		
		panelPrincipal.add(new PiedraPapelTijera(this), "Juego ppt");
		panelPrincipal.add(new Conversacion2(this), "Conversacion 2");
		
		panelPrincipal.add(new AulaOrdenadores(this), "Aula Ordenadores");
		panelPrincipal.add(new Ordenador(this), "Ordenador");
		panelPrincipal.add(new Escritorio(this), "Escritorio");
		panelPrincipal.add(new Pizarra(this), "Pizarra");
		//panelPrincipal.add(new FinDemo(this), "Fin Demo");
		

		btnOpciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnOpciones.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        });
		
		btnPista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPistas.setVisible(true);
				PanelPistas.pistas = PanelPistas.cargarPistas(nivelActual);
				System.out.println(PanelPistas.pistas);
			}
		});
		
		btnInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarInventario(ventana);
			}
		});

		btnSoltarObjeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPrincipal.setCursor(null);
				panelInventario.setVisible(true);
				panelInventario.resetearInventario();
				btnSoltarObjeto.setVisible(false);
				Audio.reproducirEfectoSonido(Audio.COIN);
			}
		});
		setFocusable(false);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("LETRA");
				if (e.getKeyCode() == KeyEvent.VK_I) {
					System.out.println("LETRA I");
					 if (panelInventario.isVisible()) {
						 panelInventario.setVisible(false); // Cerrar el inventario
	                    } else {
	                    	panelInventario.setVisible(true);
	                    }
				}
			}
		});

	}
	
	public void mostrarInventario(Ventana ventana) {
		if(panelInventario.isVisible()) {
			panelInventario.setVisible(false);
		}
		panelInventario = new PanelInventario(ventana);
		panelInventario.setVisible(true);
		getLayeredPane().add(panelInventario, JLayeredPane.MODAL_LAYER);
	}
	
	public void entregarObjeto(int objetoSeleccionadoId) {
		panelPrincipal.setCursor(null);
		panelInventario.setVisible(false);
		panelInventario.resetearInventario();
		btnSoltarObjeto.setVisible(false);
		objetosInventario.remove(objetoSeleccionadoId);
	}

	public static void mostrarTextoPantalla(String mensaje) {
		panelTextos.setSize(1084,60);
		panelTextos.setVisible(true);
		txtDialogo.setText(mensaje);
	}
	public static void quitarTextoPantalla() {
		panelTextos.setVisible(false);
		txtDialogo.setText("");
	}
	
	public void showEscena(String escena) {
		if(!btnSoltarObjeto.isVisible()) {
			cardLayout.show(panelPrincipal, escena);
		}
	}

	public PanelOpciones getPanelOpciones() {
		return panelOpciones;
	}
	
	public PanelInstrucciones getPanelInstrucciones() {
		return panelInstrucciones;
	}
	
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}
	
	public JPanel getPanelTextos() {
		return panelTextos;
	}
	
	public JTextPane getTxtDialogo() {
		return txtDialogo;
	}

	public JPanel getPanelInventario() {
		return panelInventario;
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public ResourceBundle getMensajes() {
		return mensajes;
	}
	public JButton getBtnSoltarObjeto() {
		return btnSoltarObjeto;
	}
	
	public ArrayList<Objeto> getObjetosInventario () {
		return objetosInventario;
	}

	public JLabel getBtnInventario() {
		return btnInventario;
	}

	
}
