package escaperoom_prueba.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimer;
	private static Timer timer;
	private int segundos;

	public Ventana2(int segundosRestantes) {
		segundos = segundosRestantes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTimer = new JTextField();
		txtTimer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setEditable(false);
		txtTimer.setBounds(10, 11, 180, 30);
		contentPane.add(txtTimer);
		txtTimer.setColumns(10);
		timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
            @Override
            public void actionPerformed(ActionEvent e) {
            	segundos--;
                String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
                txtTimer.setText(time);
                
            }
        });
		
		timer.start();

		JButton btnIzq = new JButton("<");
		btnIzq.setOpaque(true);	
		btnIzq.setForeground(Color.WHITE);
		btnIzq.setBackground(Color.BLACK);
		btnIzq.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIzq.setBounds(0, 240, 50, 120);
		contentPane.add(btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana1 ventana = new Ventana1(segundos);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnDer.setForeground(Color.WHITE);
		btnDer.setBackground(Color.BLACK);
		btnDer.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDer.setBounds(734, 240, 50, 120);
		contentPane.add(btnDer);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setOpaque(true);
		lblMenu.setBackground(Color.DARK_GRAY);
		lblMenu.setBounds(0, 0, 784, 55);
		contentPane.add(lblMenu);
		
		JLabel lblMochila = new JLabel("");
		lblMochila.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\mochila_xs.png"));
		lblMochila.setBounds(10, 422, 128, 128);
		contentPane.add(lblMochila);
		
		JLabel lblfondo = new JLabel("");
		lblfondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\bus1.jpg"));
		lblfondo.setBounds(0, 56, 800, 505);
		contentPane.add(lblfondo);
	}

}
