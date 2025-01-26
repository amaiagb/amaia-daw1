package tests;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class PanelInventario extends JPanel {

	private JPanel contentPane;
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
		//setBounds(100, 100, 443, 324);
		//contentPane = new JPanel();
		//setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//setLayout(null);
		
		//JPanel panelInventario = new JPanel();
		setBackground(new Color(153, 204, 204));
		setBounds(10, 10, 319, 248);
		setOpaque(true);
		//getContentPane().add(panelInventario);
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

		mostrarObjetosInventario(objetos);
		
		lblInventarioObjeto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println(objetoSeleccionado);
				if(objetoSeleccionado == -1) {
					System.out.println("cursor");
					//lblInventarioObjeto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionado!= 0) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto1, 0);
				} else if(objetoSeleccionado == 0) {
					resetearInventario();
				}
			}
		});
		
		lblInventarioObjeto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionado == -1) {
					lblInventarioObjeto2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionado!= 1) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto2, 1);
				} else if(objetoSeleccionado == 1) {
					resetearInventario();
				}
			}
		});
		
		lblInventarioObjeto3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(objetoSeleccionado == -1) {
					lblInventarioObjeto3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoSeleccionado!= 2) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto3, 2);
				} else if(objetoSeleccionado == 2) {
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
				if(objetoSeleccionado!= 3) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}
					*/
					mostrarObjetoSeleccionado(lblInventarioObjeto4, 3);
				} else if(objetoSeleccionado == 3) {
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
				if(objetoSeleccionado!= 4) { // si no está seleccionado ya este objeto -> seleccionarlo
					/*
					if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
						labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
						labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
					}*/
					mostrarObjetoSeleccionado(lblInventarioObjeto5, 4);
				} else if(objetoSeleccionado == 4) {
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
				if(objetoSeleccionado!= 5) {
					mostrarObjetoSeleccionado(lblInventarioObjeto6, 5);
				} else if(objetoSeleccionado == 5) {
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
			lblInventarioObjeto.setBackground(Color.ORANGE);
			lblInventarioObjeto.setOpaque(true);
			
			//Mostrar descripción
			txtObjDescripcion.setText(objetos.get(i).getDescripcion());
			
			//Poner imagen en cursor
			Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(IMG_FOLDER+objetos.get(i).getUrlImg()).getImage(), new Point(10, 10), "customCursor");
			setCursor(customCursor);
			
			//Deseleccionar objeto seleccionado anterior
			if(objetoSeleccionado != -1) { // si hay otro objeto seleccionado -> deseleccionarlo
				labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
				labels.get(objetoSeleccionado).setBackground(null);
			}
			
			//Actualizar objeto seleccionado
			objetoSeleccionado = i;
		}
	}
	private void resetearInventario() {
		labels.get(objetoSeleccionado).setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		labels.get(objetoSeleccionado).setIcon(new ImageIcon(IMG_FOLDER+objetos.get(objetoSeleccionado).getUrlImg()));
		labels.get(objetoSeleccionado).setBackground(null);
		objetoSeleccionado = -1;
		setCursor(null);
		txtObjDescripcion.setText("Selecciona un objeto del inventario para ver su descripción");
	}
}
