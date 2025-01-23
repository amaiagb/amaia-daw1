package escaperoom_prueba.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import db.AccesoDBEscaperoom;
import db.Mensaje;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimer;
	private static int segundos = 3600; // Contador de segundos
    private static Timer timer; // Temporizador
    private static final String IMG_DIR = System.getProperty("user.dir")+"\\resources\\";
    private JPanel escena1;
    private JPanel escena2;
    private JPanel escena3;
    AccesoDBEscaperoom bd;
    private String idioma = "EN";
    
	public Ventana1(int segundosRestantes) {
		
		try {
			bd = new AccesoDBEscaperoom();

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		setResizable(false);
		
		segundos = segundosRestantes;		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEsc4 = new JButton("Escena4");
		
		btnEsc4.setBounds(102, 339, 89, 23);
		contentPane.add(btnEsc4);
		
		JTextArea textArea = new JTextArea(5, 30);
		textArea.setBackground(Color.ORANGE);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(5, 10, 0, 10));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(150, 450, 576, 100);
		getContentPane().add(scroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setText("texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba texto de prueba");
		Mensaje m;
		try {
			m = bd.getMensaje(2, idioma);
			textArea.setText(m.getLocutor()+": "+m.getTexto());
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 784, 50);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JButton btnIzq = new JButton("<");
		btnIzq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIzq.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
			}
		});
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(escena1.isVisible()) {
					escena2.setVisible(true);
					escena1.setVisible(false);
					escena3.setVisible(false);
				} else if(escena3.isVisible()) {
					escena1.setVisible(true);
					escena2.setVisible(false);
					escena3.setVisible(false);
				}
			}
		});
		
		JPanel inventario = new JPanel();
		inventario.setBackground(Color.LIGHT_GRAY);
		inventario.setBounds(92, 74, 595, 303);
		contentPane.add(inventario);
		inventario.setLayout(null);
		inventario.setVisible(false);
		
		JButton btnCerrarInventario = new JButton("X");
		btnCerrarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventario.setVisible(false);
			}
		});
		btnCerrarInventario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarInventario.setBounds(550, 1, 45, 40);
		inventario.add(btnCerrarInventario);
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(Color.WHITE);
		lblInventario.setBackground(Color.DARK_GRAY);
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInventario.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblInventario.setBounds(0, 0, 595, 40);
		lblInventario.setOpaque(true);
		inventario.add(lblInventario);
		
		JLabel lblMochila = new JLabel("");
		lblMochila.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\mochilaIcon.png"));
		lblMochila.setBounds(10, 450, 96, 96);
		contentPane.add(lblMochila);
		lblMochila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMochila.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				inventario.setVisible(true);
			}
		});

		
		JButton btnDer = new JButton(">");
		btnDer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDer.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
			}
		});
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(escena1.isVisible()) {
					escena3.setVisible(true);
					escena1.setVisible(false);
					escena2.setVisible(false);
				} else if(escena2.isVisible()) {
					escena1.setVisible(true);
					escena2.setVisible(false);
					escena3.setVisible(false);
				}
			}
		});
		btnDer.setForeground(Color.WHITE);
		btnDer.setBackground(Color.BLACK);
		btnDer.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDer.setBounds(734, 184, 50, 120);
		contentPane.add(btnDer);
		
		btnIzq.setOpaque(true);	
		btnIzq.setForeground(Color.WHITE);
		btnIzq.setBackground(Color.BLACK);
		btnIzq.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIzq.setBounds(0, 184, 50, 120);
		contentPane.add(btnIzq);
		
		
		txtTimer = new JTextField();
		txtTimer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setEditable(false);
		txtTimer.setBounds(10, 5, 240, 40);
		menu.add(txtTimer);
		txtTimer.setColumns(10);
		
		timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(segundos > 0) {
            		segundos--;
                    String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
                    txtTimer.setText(time);
            	} else {
            		timer.stop();
            		JOptionPane.showMessageDialog(txtTimer,"FIN","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            	}
            	
                
            }
        });
		
		timer.start();
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setOpaque(true);
		lblMenu.setBackground(Color.DARK_GRAY);
		lblMenu.setBounds(0, 0, 784, 55);
		menu.add(lblMenu);	
		
		escena1 = new JPanel();
		escena1.setBounds(0, 53, 784, 508);
		escena1.setLayout(null);
		contentPane.add(escena1);
		
		JLabel zoomMapa = new JLabel();
		zoomMapa.setBounds(170, 40, 448, 336);
		zoomMapa.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\mapa_xs.png"));
		zoomMapa.setVisible(false);
		escena1.add(zoomMapa);
		
		JButton btnCerrarMapa = new JButton("X");
		btnCerrarMapa.setBackground(Color.RED);
		btnCerrarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoomMapa.setVisible(false);
			}
		});
		btnCerrarMapa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarMapa.setBounds(500, 80, 45, 40);
		btnCerrarMapa.setVisible(false);
		escena1.add(btnCerrarMapa);
		
		JLabel lblMapa = new JLabel("");
		lblMapa.setBounds(10, 21, 90, 89);
		escena1.add(lblMapa);
		lblMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMapa.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				zoomMapa.setVisible(true);
				btnCerrarMapa.setVisible(true);
			}
		});
		
		
	
		JLabel lblfondo = new JLabel("");
		lblfondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\bus0.jpg"));
		lblfondo.setBounds(0, 0, 784, 505);
		escena1.add(lblfondo);
		
		
		
		escena2 = new JPanel();
		escena2.setBounds(0, 53, 784, 508);
		contentPane.add(escena2);
		escena2.setLayout(null);
		
		JLabel lblfondo2 = new JLabel("");
		lblfondo2.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\bus1.jpg"));
		lblfondo2.setBounds(0, 0, 784, 505);
		escena2.add(lblfondo2);
		
		escena3 = new JPanel();
		escena3.setBounds(0, 53, 784, 508);
		contentPane.add(escena3);
		escena3.setLayout(null);
		
		JLabel lblfondo3 = new JLabel("");
		lblfondo3.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\bus2.jpg"));
		lblfondo3.setBounds(0, 0, 784, 505);
		escena3.add(lblfondo3);
		
		btnEsc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Escena4 e4 = new Escena4(contentPane);
				e4.setVisible(true);
				escena1.setVisible(false);
				escena2.setVisible(false);
				escena3.setVisible(false);
			}
		});
	}
}
