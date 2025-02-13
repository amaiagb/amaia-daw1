package nivel3;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pasillo extends JFrame {

	private JPanel contentPane;
 
	public pasillo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPuertaClase = new JButton("");
		btnPuertaClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaClase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnPuertaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clase clase = new clase();
				clase.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblFlecha = new JLabel("");
		lblFlecha.setVisible(false);
		
		lblFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonamarilla.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonblanco.png"));
			}
		});
		JTextArea txtrDeberiamosEntrarPrimero = new JTextArea();
		txtrDeberiamosEntrarPrimero.setText("Deberiamos entrar primero a clase ");
		txtrDeberiamosEntrarPrimero.setBounds(146, 652, 763, 59);
		contentPane.add(txtrDeberiamosEntrarPrimero);
		txtrDeberiamosEntrarPrimero.setVisible(false);
		
		
		JButton btnMensaje = new JButton("");
		btnMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMensaje.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}
		});
		btnMensaje.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				txtrDeberiamosEntrarPrimero.setVisible(true);
				lblFlecha.setVisible(true);
			}
		});
		btnMensaje.setBounds(119, 251, 48, 277);
		contentPane.add(btnMensaje);
		btnMensaje.setOpaque(true);
		btnMensaje.setContentAreaFilled(false);
		btnMensaje.setBorderPainted(false);	
		
		
		
		
		
		
		lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonblanco.png"));
		lblFlecha.setBounds(778, 371, 131, 84);
		contentPane.add(lblFlecha);
		btnPuertaClase.setBounds(919, 263, 48, 265);
		btnPuertaClase.setOpaque(true);
		btnPuertaClase.setContentAreaFilled(false);
		btnPuertaClase.setBorderPainted(false);
		contentPane.add(btnPuertaClase);
		
		JLabel lblPasillo = new JLabel("New label");
		lblPasillo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pasilloOriginal.jpg"));
		lblPasillo.setBounds(0, 0, 1084, 711);
		contentPane.add(lblPasillo);
}
}
