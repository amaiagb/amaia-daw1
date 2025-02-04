package view_respuestas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class respuesta_niña extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public respuesta_niña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(125, 150, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton respuesta1_Button = new JButton("Que conste, que te recogimos de un contenedor inorganico");
		respuesta1_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta1_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta1_Button.setBounds(10, 11, 364, 39);
		contentPane.add(respuesta1_Button);
		
		JButton respuesta_Button = new JButton("Buenos dias a ti tambien");
		respuesta_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta_Button.setBounds(10, 80, 364, 39);
		contentPane.add(respuesta_Button);
		
		JButton respuesta3_Button = new JButton("Ja... ja... Que graciosa");
		respuesta3_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta3_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta3_Button.setBounds(10, 148, 364, 39);
		contentPane.add(respuesta3_Button);
		
		JButton respuesta4_Button = new JButton("Eres adoptada");
		respuesta4_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta4_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta4_Button.setBounds(10, 211, 364, 39);
		contentPane.add(respuesta4_Button);
		
		
		
		
		setVisible(true);
	}
}
