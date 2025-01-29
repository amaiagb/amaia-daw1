package com.asej.escaperoom.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Controlador;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private PanelOpciones panelOpciones;
	private PanelInstrucciones panelInstrucciones;
	private JTextField txtTimer;
	private Timer timer;
	private int segundos = 3600;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1084, 711);
		contentPane.add(layeredPane);
		setLocationRelativeTo(null);
		
		Portada portada = new Portada(this);
		layeredPane.add(portada, JLayeredPane.MODAL_LAYER);
		
		panelOpciones = new PanelOpciones();
		layeredPane.add(panelOpciones, JLayeredPane.POPUP_LAYER);
		panelOpciones.setVisible(false);
		
		panelInstrucciones = new PanelInstrucciones();
		layeredPane.add(panelInstrucciones, JLayeredPane.POPUP_LAYER);
		panelInstrucciones.setVisible(false);

		JPanel panelNav = new JPanel();
		panelNav.setBounds(0, 0, 1084, 60);
		panelNav.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelNav, JLayeredPane.PALETTE_LAYER);
		
		JPanel panelTextos = new JPanel();
		panelTextos.setBounds(0, 570, 1084, 180);
		panelTextos.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelTextos, JLayeredPane.PALETTE_LAYER);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1084, 711);
		layeredPane.add(panelPrincipal, JLayeredPane.DEFAULT_LAYER);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
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
		
		JLabel btnPista = new JLabel();
		btnPista.setHorizontalAlignment(SwingConstants.CENTER);
		btnPista.setForeground(Color.WHITE);
		btnPista.setBackground(Color.GRAY);
		btnPista.setLocation(860, 10);
		btnPista.setSize(100, 40);
		btnPista.setText("Pista");
		btnPista.setOpaque(true);
		panelNav.add(btnPista);
		
		JLabel btnOpciones = new JLabel();
		btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpciones.setText("Opciones");
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setBackground(Color.GRAY);
		btnOpciones.setBounds(970, 10, 100, 40);
		btnOpciones.setOpaque(true);
		panelNav.add(btnOpciones);
		
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
		

		Escena1 escena1 = new Escena1();
		panelPrincipal.add(escena1, "Escena1");
		panelNav.setLayout(null);
		
		

	}

	public PanelOpciones getPanelOpciones() {
		return panelOpciones;
	}
	
	public PanelInstrucciones getPanelInstrucciones() {
		return panelInstrucciones;
	}
	
	public Timer getTimer() {
		return timer;
	}

	
}
