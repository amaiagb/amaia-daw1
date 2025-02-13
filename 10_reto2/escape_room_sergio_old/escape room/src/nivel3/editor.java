package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class editor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int segundos = 3600; 
	private inventario inv = null;
	
	public editor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel llave = new JLabel("New label");
		llave.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 JOptionPane.showMessageDialog(llave, "Has encontrado una llave", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
			}
		});
		
		JButton btnbotonllave = new JButton("New button");
		btnbotonllave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llave.setVisible(true);
				requestFocusInWindow();
			}
		});
		
		
		JButton pista = new JButton("?");
		pista.setBackground(Color.ORANGE);
		pista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(llave, "Busca bien por los arbustos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				requestFocusInWindow();
			}
		});
		
	
		
		JTextArea txtencontrarcromo = new JTextArea();
		txtencontrarcromo.setForeground(Color.WHITE);
		txtencontrarcromo.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtencontrarcromo.setBackground(new Color(255, 102, 0));
		txtencontrarcromo.setText("Accede al interior del colegio");
		txtencontrarcromo.setBounds(0, 649, 1084, 62);
		contentPane.add(txtencontrarcromo);
		txtencontrarcromo.setVisible(true);
		
		JTextArea txtrI = new JTextArea();
		txtrI.setEnabled(false);
		txtrI.setEditable(false);
		txtrI.setForeground(Color.WHITE);
		txtrI.setBackground(Color.BLACK);
		txtrI.setText("I");
		txtrI.setBounds(40, 522, 13, 22);
		contentPane.add(txtrI);
		
		JLabel lblMochila = new JLabel("New label");
		lblMochila.addKeyListener(new KeyAdapter() {
		
		});
		/*lblMochila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new inventario ();
			}
		});*/
		lblMochila.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\mochila sin fondo.png"));
		lblMochila.setBounds(0, 555, 77, 83);
		contentPane.add(lblMochila);
		
		inv = new inventario();
		inv.setVisible(false);
		
		//si pulsas la I se abre inventario
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_I) {
					 if (inv.isVisible()) {
	                        inv.setVisible(false); // Cerrar el inventario
	                    } else {
	                        inv.setLocationRelativeTo(contentPane); // Centrar respecto al JFrame principal
	                        inv.setVisible(true);
	                        
				}
				}
			}
		});
	
		
		 setFocusable(true);
	
		 
		JTextField txtTimer = new JTextField();
		txtTimer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setEditable(false);
		txtTimer.setBounds(20, 17, 183, 40);
		contentPane.add(txtTimer);
		txtTimer.setColumns(10);
		pista.setFont(new Font("Arial", Font.PLAIN, 30));
		pista.setBounds(1001, 17, 59, 36);
		contentPane.add(pista);
		btnbotonllave.setBounds(587, 384, 59, 42);
		contentPane.add(btnbotonllave);
		btnbotonllave.setOpaque(true);
		btnbotonllave.setContentAreaFilled(false);
		btnbotonllave.setBorderPainted(false);
		
		
		
		llave.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\llave-removebg-preview (1).png"));
		llave.setBounds(325, 9, 41, 51);
		contentPane.add(llave);
		llave.setVisible(false);
		
		JLabel lblcromo = new JLabel("New label");
		lblcromo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		
		
		JButton btnesconditecromo = new JButton("New button");
		btnesconditecromo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lblcromo.setVisible(true);
			requestFocusInWindow();
			}
		});
		
		
		btnesconditecromo.setBounds(75, 384, 59, 42);
		contentPane.add(btnesconditecromo);
		btnesconditecromo.setOpaque(true);
		btnesconditecromo.setBorderPainted(false);
		btnesconditecromo.setContentAreaFilled(false);
		
		lblcromo.setIcon(new ImageIcon("D:\\SERGIO\\fotos escape room\\iniestaaa.jpg"));
		lblcromo.setBounds(236, 10, 69, 49);
		contentPane.add(lblcromo);
		lblcromo.setVisible(false);
		
		JLabel fondo_inventario = new JLabel();
		fondo_inventario.setForeground(Color.WHITE);
		fondo_inventario.setBackground(Color.DARK_GRAY);
		fondo_inventario.setBounds(0, -11, 1084, 76);
		fondo_inventario.setOpaque(true);
		contentPane.add(fondo_inventario);
		
		JButton btnhablar = new JButton("New button");
		btnhablar.setBounds(401, 354, 41, 83);
		contentPane.add(btnhablar);
		btnhablar.setOpaque(true);
		btnhablar.setContentAreaFilled(false);
		btnhablar.setBorderPainted(false);
		
		JLabel fondo = new JLabel("foto exterior");
		fondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\Leonardo_Phoenix_10_estilo_animado_3d_de_un_instituto_moderno_0.jpg"));
		fondo.setBounds(0, 0, 1084, 711);
		contentPane.add(fondo);
		
		
		btnhablar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtrHablaConBruno.setVisible(false);
            	txtencontrarcromo.setVisible(true);
            	requestFocusInWindow();
            }
		
		});

	Timer timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	       		 segundos--;
	            	String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
	            	txtTimer.setText(time);
	           	 
	        	}
	    	});
	   	 
	timer.start();
	
}
}