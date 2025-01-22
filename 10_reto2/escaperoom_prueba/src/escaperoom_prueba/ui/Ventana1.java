package escaperoom_prueba.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimer;
	private static int segundos = 3600; // Contador de segundos
    private static Timer timer; // Temporizador

	public Ventana1(int segundosRestantes) {
		segundos = segundosRestantes;
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnJugar.setBounds(373, 293, 160, 98);
		contentPane.add(btnJugar);
		*/
		
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
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana2 ventana = new Ventana2(segundos);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnIzq.setOpaque(true);	
		btnIzq.setForeground(Color.WHITE);
		btnIzq.setBackground(Color.BLACK);
		btnIzq.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIzq.setBounds(0, 240, 50, 120);
		contentPane.add(btnIzq);
		
		JButton btnDer = new JButton(">");
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
		lblfondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\programacion\\02\\escaperoom_prueba\\resources\\bus0.jpg"));
		lblfondo.setBounds(0, 56, 800, 505);
		contentPane.add(lblfondo);
		
		
	}

}
