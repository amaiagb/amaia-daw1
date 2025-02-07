package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clase extends JFrame {

	private JPanel contentPane;
 
	public clase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBotonAtras = new JButton(">");
		btnBotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasillo2 pasillo2 = new pasillo2();
				pasillo2.setVisible(true);
				dispose();
			}
		});
		
		JButton btnJarron = new JButton("");
		btnJarron.setOpaque(true);
		btnJarron.setContentAreaFilled(false);
		btnJarron.setBorderPainted(false);
		btnJarron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoonJarron zoomjarron = new zoonJarron();
				zoomjarron.setVisible(true);
				
			}
		});
		
		JLabel lblDibujoJuan = new JLabel("New label");
		lblDibujoJuan.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\cuadroTOP.jpg"));
		lblDibujoJuan.setBounds(271, 145, 500, 400);
		lblDibujoJuan.setVisible(false);
		
		JButton btnGuardarCuadro = new JButton("A\u00F1adir al Inventario");
		
		btnGuardarCuadro.setBounds(601, 505, 156, 29);
		btnGuardarCuadro.setVisible(false);
		contentPane.add(btnGuardarCuadro);
		
		
		contentPane.add(lblDibujoJuan);
		btnJarron.setBounds(174, 341, 31, 49);
		contentPane.add(btnJarron);
		
		JButton btnCuadroJuan = new JButton("");
		btnCuadroJuan.setOpaque(true);
		btnCuadroJuan.setContentAreaFilled(false);
		btnCuadroJuan.setBorderPainted(false);
		btnCuadroJuan.setBounds(692, 355, 16, 23);
		contentPane.add(btnCuadroJuan);
		btnBotonAtras.setBounds(10, 331, 63, 71);
		contentPane.add(btnBotonAtras);
		
		JLabel lblClase = new JLabel("New label");
		lblClase.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\clase).jpg"));
		lblClase.setBounds(0, 0, 1084, 711);
		contentPane.add(lblClase);
		
		btnCuadroJuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDibujoJuan.setVisible(true);
				btnGuardarCuadro.setVisible(true);
			}
	});
		btnGuardarCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDibujoJuan.setVisible(false);
				btnGuardarCuadro.setVisible(false);
			}
		});
	}

}
