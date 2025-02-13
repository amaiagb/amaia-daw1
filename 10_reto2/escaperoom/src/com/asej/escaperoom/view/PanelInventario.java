package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.model.Objeto;

public class PanelInventario extends JPanel {
	
	private ArrayList<Objeto> objetos;
	private JLabel lblInventarioObjeto1;
	private JLabel lblInventarioObjeto2;
	private JLabel lblInventarioObjeto3;
	private JLabel lblInventarioObjeto4;
	private JLabel lblInventarioObjeto5;
	private JLabel lblInventarioObjeto6;
	private JLabel lblInventarioObjeto7;
	private JLabel lblInventarioObjeto8;
	private JLabel lblInventarioObjeto9;
	private JLabel lblInventarioObjeto10;
	private JTextPane txtObjDescripcion;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private final String IMG_FOLDER = System.getProperty("user.dir")+"\\resources\\images\\";
	public static int objetoSeleccionadoId = -1;
	public static String objetoSeleccionado;
	
	private JLabel lblInventarioTitle;

	public PanelInventario(Ventana ventana) {
		
		this.objetos = ventana.getObjetosInventario();

		setBackground(new Color(153, 204, 204));
		setBounds(320, 200, 486, 352);
		setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		//setOpaque(true);
		setLayout(null);
		
		JButton btnCerrarInventario = new JButton("x");
		btnCerrarInventario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCerrarInventario.setBackground(Color.WHITE);
		btnCerrarInventario.setForeground(Color.BLACK);
		btnCerrarInventario.setBounds(441, 0, 45, 30);
		btnCerrarInventario.setOpaque(true);
		add(btnCerrarInventario);
		
		lblInventarioTitle = new JLabel("Inventario");
		lblInventarioTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInventarioTitle.setBackground(Color.BLACK);
		lblInventarioTitle.setForeground(Color.WHITE);
		lblInventarioTitle.setBounds(0, 0, 486, 30);
		lblInventarioTitle.setBorder(new EmptyBorder(5, 10, 5, 5));
		lblInventarioTitle.setOpaque(true);
		add(lblInventarioTitle);
		
		lblInventarioObjeto1 = new JLabel("");
		lblInventarioObjeto1.setBackground(new Color(240, 240, 240));
		lblInventarioObjeto1.setBounds(35, 61, 60, 60);
		lblInventarioObjeto1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto1.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto1.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto1);
		labels.add(lblInventarioObjeto1);
		
		lblInventarioObjeto2 = new JLabel("");
		lblInventarioObjeto2.setBackground(SystemColor.menu);
		lblInventarioObjeto2.setBounds(124, 61, 60, 60);
		lblInventarioObjeto2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto2.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto2.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto2);
		labels.add(lblInventarioObjeto2);
		
		lblInventarioObjeto3 = new JLabel("");
		lblInventarioObjeto3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto3.setBackground(SystemColor.menu);
		lblInventarioObjeto3.setBounds(211, 61, 60, 60);
		lblInventarioObjeto3.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto3.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto3);
		labels.add(lblInventarioObjeto3);
		
		lblInventarioObjeto4 = new JLabel("");
		lblInventarioObjeto4.setBackground(SystemColor.menu);
		lblInventarioObjeto4.setBounds(302, 61, 60, 60);
		lblInventarioObjeto4.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto4.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto4.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto4);
		labels.add(lblInventarioObjeto4);
		
		lblInventarioObjeto5 = new JLabel("");
		lblInventarioObjeto5.setBackground(SystemColor.menu);
		lblInventarioObjeto5.setBounds(385, 61, 60, 60);
		lblInventarioObjeto5.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto5.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto5.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto5);
		labels.add(lblInventarioObjeto5);
		
		lblInventarioObjeto6 = new JLabel("");
		lblInventarioObjeto6.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto6.setBackground(SystemColor.menu);
		lblInventarioObjeto6.setBounds(35, 143, 60, 60);
		lblInventarioObjeto6.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto6.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto6);
		labels.add(lblInventarioObjeto6);
		
		lblInventarioObjeto7 = new JLabel("");
		lblInventarioObjeto7.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto7.setBackground(SystemColor.menu);
		lblInventarioObjeto7.setBounds(124, 143, 60, 60);
		lblInventarioObjeto7.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto7.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto7);
		labels.add(lblInventarioObjeto7);
		
		lblInventarioObjeto8 = new JLabel("");
		lblInventarioObjeto8.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto8.setBackground(SystemColor.menu);
		lblInventarioObjeto8.setBounds(211, 143, 60, 60);
		lblInventarioObjeto8.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto8.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto8);
		labels.add(lblInventarioObjeto8);
		
		lblInventarioObjeto9 = new JLabel("");
		lblInventarioObjeto9.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto9.setBackground(SystemColor.menu);
		lblInventarioObjeto9.setBounds(302, 143, 60, 60);
		lblInventarioObjeto9.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto9.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto9);
		labels.add(lblInventarioObjeto9);
		
		lblInventarioObjeto10 = new JLabel("");
		lblInventarioObjeto10.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto10.setBackground(SystemColor.menu);
		lblInventarioObjeto10.setBounds(385, 143, 60, 60);
		lblInventarioObjeto10.setHorizontalAlignment(JLabel.CENTER); 
		lblInventarioObjeto10.setVerticalAlignment(JLabel.CENTER);
		add(lblInventarioObjeto10);
		labels.add(lblInventarioObjeto10);
		
		txtObjDescripcion = new JTextPane();
		txtObjDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtObjDescripcion.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtObjDescripcion.setEditable(false);
		txtObjDescripcion.setBackground(new Color(255, 255, 255));
		txtObjDescripcion.setBounds(35, 240, 290, 70);
		add(txtObjDescripcion);
		txtObjDescripcion.setText(Ventana.mensajes.getString("panelInventario"));
		
		JButton btnUsarObjeto = new JButton(Ventana.mensajes.getString("btnUsar"));
		btnUsarObjeto.setForeground(Color.WHITE);
		btnUsarObjeto.setBackground(Color.DARK_GRAY);
		btnUsarObjeto.setOpaque(true);
		btnUsarObjeto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUsarObjeto.setBounds(345, 240, 100, 70);
		add(btnUsarObjeto);

		mostrarObjetosInventario(objetos);
		

		btnCerrarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				objetoSeleccionadoId =-1;
				objetoSeleccionado = "";
			}
		});
		

		btnUsarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(objetoSeleccionadoId != -1) {
					//Poner imagen del objeto en cursor
					Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionadoId).getUrlImg()).getImage(), new Point(10, 10), "customCursor");
					ventana.getPanelPrincipal().setCursor(customCursor);
					//Cerrar inventario
					setVisible(false);
					ventana.getBtnSoltarObjeto().setVisible(true);
					objetoSeleccionado = objetos.get(objetoSeleccionadoId).getNombre();
				}
				
			}
		});
		
		lblInventarioObjeto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionadoId == -1) {
					//lblInventarioObjeto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 0) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto1, 0);
				} else if(objetoSeleccionadoId == 0) {
					resetearInventario();
				}
			}
		});
		
		lblInventarioObjeto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionadoId == -1) {
					lblInventarioObjeto2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 1) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto2, 1);
				} else if(objetoSeleccionadoId == 1) {
					resetearInventario();
				}
			}
		});
		
		lblInventarioObjeto3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionadoId == -1) {
					lblInventarioObjeto3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 2) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto3, 2);
				} else if(objetoSeleccionadoId == 2) {
					resetearInventario();
				}
			}
		});

		lblInventarioObjeto4.addMouseListener(new MouseAdapter() {
			/*
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionado == -1) {
					lblInventarioObjeto4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 3) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto4, 3);
				} else if(objetoSeleccionadoId == 3) {
					resetearInventario();
				}
			}
		});

		lblInventarioObjeto5.addMouseListener(new MouseAdapter() {
			/*
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionado == -1) {
					lblInventarioObjeto5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 4) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}*/
					mostrarObjetoSeleccionado(lblInventarioObjeto5, 4);
				} else if(objetoSeleccionadoId == 4) {
					resetearInventario();
				}
			}
		});
		
		lblInventarioObjeto6.addMouseListener(new MouseAdapter() {
			/*
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionado == -1) {
					lblInventarioObjeto6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			*/
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionadoId!= 5) {
					mostrarObjetoSeleccionado(lblInventarioObjeto6, 5);
				} else if(objetoSeleccionadoId == 5) {
					resetearInventario();
				}
			}
		});
		
	}

	private void mostrarObjetosInventario(ArrayList<Objeto> objetos) {
		for (int i = 0; i < objetos.size(); i++) {
			String urlImg = IMG_FOLDER+objetos.get(i).getUrlImg();
			labels.get(i).setIcon(new ImageIcon(urlImg));
			/*
			labels.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if(objetoSeleccionado == -1) {
						
					}
				}
			});
			*/
		}
	}
	private void mostrarObjetoSeleccionado(JLabel lblInventarioObjeto, int i) {
		if(i< objetos.size()) {
			
			//Cambiar apariencia icono
			lblInventarioObjeto.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			ImageIcon icon = new ImageIcon(lblInventarioObjeto.getIcon().toString());
			Image imgEscalada = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			icon = new ImageIcon(imgEscalada);			
			lblInventarioObjeto.setIcon(icon);
			//lblInventarioObjeto.setBackground(Color.ORANGE);
			lblInventarioObjeto.setOpaque(false);
			
			//Mostrar descripción
			txtObjDescripcion.setText(objetos.get(i).getDescripcion());
			
			
			
			//Deseleccionar objeto seleccionado anterior
			if(objetoSeleccionadoId != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
				labels.get(objetoSeleccionadoId).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				labels.get(objetoSeleccionadoId).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionadoId).getUrlImg()));
				labels.get(objetoSeleccionadoId).setBackground(null);
			}
			
			//Actualizar objeto seleccionado
			objetoSeleccionadoId = i;
		}
	}
	public void resetearInventario() {
		System.out.println("reset, "+objetoSeleccionadoId);
		labels.get(objetoSeleccionadoId).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		labels.get(objetoSeleccionadoId).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionadoId).getUrlImg()));
		labels.get(objetoSeleccionadoId).setBackground(null);
		objetoSeleccionadoId = -1;
		setCursor(null);
		txtObjDescripcion.setText("Selecciona un objeto del inventario para ver su descripción");
	}
}
