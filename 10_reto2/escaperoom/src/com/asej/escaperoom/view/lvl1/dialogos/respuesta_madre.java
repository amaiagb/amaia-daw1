package com.asej.escaperoom.view.lvl1.dialogos;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class respuesta_madre extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public respuesta_madre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(318, 611, 605, 120);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		setUndecorated(true);

		
		JButton respuesta1_Button = new JButton("Hola mami");
		respuesta1_Button.setBackground(new Color(255, 182, 193));
		respuesta1_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta1_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta1_Button.setBounds(10, 11, 274, 39);
		contentPane.add(respuesta1_Button);
		
		JButton respuesta_Button = new JButton("Buenos dias");
		respuesta_Button.setBackground(new Color(255, 182, 193));
		respuesta_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta_Button.setBounds(10, 80, 274, 39);
		contentPane.add(respuesta_Button);
		
		JButton respuesta3_Button = new JButton("Graciasss");
		respuesta3_Button.setBackground(new Color(255, 182, 193));
		respuesta3_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta3_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta3_Button.setBounds(330, 80, 265, 40);
		contentPane.add(respuesta3_Button);
		
		JButton respuesta4_Button = new JButton("Cuando zarpa el amor");
		respuesta4_Button.setBackground(new Color(255, 182, 193));
		respuesta4_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		respuesta4_Button.setFont(new Font("Noto Sans Cond", Font.BOLD, 16));
		respuesta4_Button.setBounds(330, 11, 265, 39);
		contentPane.add(respuesta4_Button);
		
		
		
		
		setVisible(true);
	}
}
