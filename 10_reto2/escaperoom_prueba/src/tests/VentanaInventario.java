package tests;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

public class VentanaInventario extends JFrame{
	
	private JPanel contentPane;
	private JLabel lblInventarioObjeto1;
	private JLabel lblInventarioObjeto2;
	private JLabel lblInventarioObjeto3;
	private JLabel lblInventarioObjeto4;
	private JLabel lblInventarioObjeto5;
	private JLabel lblInventarioObjeto6;
	private JTextPane txtObjDescripcion;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private final String IMG_FOLDER = System.getProperty("user.dir")+"\\resources\\";
	
	public VentanaInventario(ArrayList<Objeto> objetos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelInventario = new JPanel();
		panelInventario.setBackground(new Color(153, 204, 204));
		panelInventario.setBounds(49, 11, 319, 248);
		getContentPane().add(panelInventario);
		panelInventario.setLayout(null);
		
		lblInventarioObjeto1 = new JLabel("");
		lblInventarioObjeto1.setBackground(new Color(240, 240, 240));
		lblInventarioObjeto1.setBounds(32, 33, 50, 50);
		lblInventarioObjeto1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto1.setHorizontalAlignment(JLabel.CENTER);  // Centra la imagen horizontalmente
		lblInventarioObjeto1.setVerticalAlignment(JLabel.CENTER);
		panelInventario.add(lblInventarioObjeto1);
		labels.add(lblInventarioObjeto1);
		
		lblInventarioObjeto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblInventarioObjeto1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInventarioObjeto1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

				ImageIcon icon = new ImageIcon(lblInventarioObjeto1.getIcon().toString());
				Image imgEscalada = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
				icon = new ImageIcon(imgEscalada);  // Crear un nuevo ImageIcon con la imagen escalada				
				lblInventarioObjeto1.setIcon(icon);
				txtObjDescripcion.setText(objetos.get(0).getDescripcion());
			}
		});
		
		lblInventarioObjeto2 = new JLabel("");
		lblInventarioObjeto2.setBackground(SystemColor.menu);
		lblInventarioObjeto2.setBounds(88, 33, 50, 50);
		lblInventarioObjeto2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panelInventario.add(lblInventarioObjeto2);
		labels.add(lblInventarioObjeto2);
		
		lblInventarioObjeto3 = new JLabel("");
		lblInventarioObjeto3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto3.setBackground(SystemColor.menu);
		lblInventarioObjeto3.setBounds(148, 33, 50, 50);
		panelInventario.add(lblInventarioObjeto3);
		labels.add(lblInventarioObjeto3);
		
		lblInventarioObjeto4 = new JLabel("");
		lblInventarioObjeto4.setBackground(SystemColor.menu);
		lblInventarioObjeto4.setBounds(32, 90, 50, 50);
		lblInventarioObjeto4.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panelInventario.add(lblInventarioObjeto4);
		labels.add(lblInventarioObjeto4);
		
		lblInventarioObjeto5 = new JLabel("");
		lblInventarioObjeto5.setBackground(SystemColor.menu);
		lblInventarioObjeto5.setBounds(88, 90, 50, 50);
		lblInventarioObjeto5.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panelInventario.add(lblInventarioObjeto5);
		labels.add(lblInventarioObjeto5);
		
		lblInventarioObjeto6 = new JLabel("");
		lblInventarioObjeto6.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblInventarioObjeto6.setBackground(SystemColor.menu);
		lblInventarioObjeto6.setBounds(148, 90, 50, 50);
		panelInventario.add(lblInventarioObjeto6);
		labels.add(lblInventarioObjeto6);
		
		txtObjDescripcion = new JTextPane();
		txtObjDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtObjDescripcion.setEditable(false);
		txtObjDescripcion.setBackground(new Color(255, 255, 255));
		txtObjDescripcion.setBounds(32, 151, 166, 66);
		panelInventario.add(txtObjDescripcion);
		txtObjDescripcion.setText("Selecciona un objeto del inventario para ver su descripción");
		mostrarObjetosInventario(objetos);
	}

	private void mostrarObjetosInventario(ArrayList<Objeto> objetos) {
		for (int i = 0; i < objetos.size(); i++) {
			String urlImg = IMG_FOLDER+objetos.get(i).getUrlImg();
			labels.get(i).setIcon(new ImageIcon(urlImg));
		}
	}
}
