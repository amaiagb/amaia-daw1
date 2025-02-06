package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.asej.escaperoom.model.Objeto;

public class PanelInventario extends JPanel {
	
	private JLabel lblInventarioObjeto1;
	private JLabel lblInventarioObjeto2;
	private JLabel lblInventarioObjeto3;
	private JLabel lblInventarioObjeto4;
	private JLabel lblInventarioObjeto5;
	private JLabel lblInventarioObjeto6;
	private JTextPane txtObjDescripcion;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<Objeto> objetos;
	private final String IMG_FOLDER = System.getProperty("user.dir")+"\\resources\\";
	private int objetoSeleccionado = -1;

	public PanelInventario(ArrayList<Objeto> objetos) {
		
		this.objetos = objetos;

		setBackground(new Color(153, 204, 204));
		setBounds(10, 10, 319, 248);
		//setOpaque(true);
		setLayout(null);
		
		lblInventarioObjeto1 = new JLabel("");
		lblInventarioObjeto1.setBackground(new Color(240, 240, 240));
		lblInventarioObjeto1.setBounds(32, 33, 50, 50);
		lblInventarioObjeto1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto1.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto1.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto1);
		labels.add(lblInventarioObjeto1);
		
		lblInventarioObjeto2 = new JLabel("");
		lblInventarioObjeto2.setBackground(SystemColor.menu);
		lblInventarioObjeto2.setBounds(88, 33, 50, 50);
		lblInventarioObjeto2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto2.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto2.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto2);
		labels.add(lblInventarioObjeto2);
		
		lblInventarioObjeto3 = new JLabel("");
		lblInventarioObjeto3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto3.setBackground(SystemColor.menu);
		lblInventarioObjeto3.setBounds(148, 33, 50, 50);
		lblInventarioObjeto3.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto3.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto3);
		labels.add(lblInventarioObjeto3);
		
		lblInventarioObjeto4 = new JLabel("");
		lblInventarioObjeto4.setBackground(SystemColor.menu);
		lblInventarioObjeto4.setBounds(32, 90, 50, 50);
		lblInventarioObjeto4.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto4.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto4.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto4);
		labels.add(lblInventarioObjeto4);
		
		lblInventarioObjeto5 = new JLabel("");
		lblInventarioObjeto5.setBackground(SystemColor.menu);
		lblInventarioObjeto5.setBounds(88, 90, 50, 50);
		lblInventarioObjeto5.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto5.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto5.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto5);
		labels.add(lblInventarioObjeto5);
		
		lblInventarioObjeto6 = new JLabel("");
		lblInventarioObjeto6.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto6.setBackground(SystemColor.menu);
		lblInventarioObjeto6.setBounds(148, 90, 50, 50);
		lblInventarioObjeto6.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto6.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto6);
		labels.add(lblInventarioObjeto6);
		
		txtObjDescripcion = new JTextPane();
		txtObjDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtObjDescripcion.setEditable(false);
		txtObjDescripcion.setBackground(new Color(255, 255, 255));
		txtObjDescripcion.setBounds(32, 151, 166, 66);
		add(txtObjDescripcion);
		txtObjDescripcion.setText("Selecciona un objeto del inventario para ver su descripción");
	}

}
