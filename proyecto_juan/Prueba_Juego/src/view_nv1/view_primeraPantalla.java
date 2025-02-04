package view_nv1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import view_respuestas.respuesta_padre;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class view_primeraPantalla extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane textPane;
	private JTextField textField_1;
	private int contador = 0;
	private int segundos=3600;

	public view_primeraPantalla() {
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(800, 600); // Tamaño inicial
      getContentPane().setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton cuadro_Button = new JButton("");
		cuadro_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	            
			  try {
		            StyledDocument doc = textPane.getStyledDocument();
		            doc.insertString(doc.getLength(), " Al ver el cuadro raro lo inspeccionas y ves tus zapatos colgados detras, tu hermano te habra hecho una broma.\n", null);
		        } catch (BadLocationException ex) {
		            ex.printStackTrace();
		        }
			  cuadro_Button.setEnabled(false); // Deshabilitar el botón
			 // pasarNivel();
		    }
		});
		cuadro_Button.setBounds(255, 160, 97, 96);
		cuadro_Button.setOpaque(true); // Hacer transparente
		cuadro_Button.setContentAreaFilled(false); // Eliminar relleno
		cuadro_Button.setBorderPainted(false); // Sin borde
		contentPane.add(cuadro_Button);
		
		JTextField txtTimer = new JTextField();
	   	txtTimer.setFont(new Font("Tahoma", Font.PLAIN, 30));
	   	txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
	   	txtTimer.setEditable(false);
	   	txtTimer.setBounds(10, 5, 240, 84);
	   	contentPane.add(txtTimer);
	   	txtTimer.setColumns(10);
	   	

	   	Timer timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
        	

			@Override
        	public void actionPerformed(ActionEvent e) {
       		 segundos--;
            	String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
            	txtTimer.setText(time);
           	 
        	}
    	});
   	 
	   	timer.start();


		
		
		JButton lampara_Button = new JButton("");
		lampara_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
			            StyledDocument doc = textPane.getStyledDocument();
			            doc.insertString(doc.getLength(), " has visto tu sombra de tu camisa gracias a la lampara, la recoges y te vistes con cierta elegancia.\n", null);
			        } catch (BadLocationException ex) {
			            ex.printStackTrace();
			        }
			        lampara_Button.setEnabled(false); // Deshabilitar el botón
					 // pasarNivel();


			    }
		});
		lampara_Button.setBounds(529, 220, 45, 36);
		lampara_Button.setOpaque(false); // Hacer transparente
		lampara_Button.setContentAreaFilled(false); // Eliminar relleno
		lampara_Button.setBorderPainted(false); // Sin borde
		contentPane.add(lampara_Button);
		
		JButton silla_Button = new JButton("");
		silla_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            StyledDocument doc = textPane.getStyledDocument();
		            doc.insertString(doc.getLength(), " has encontrado tus calzoncillos en el respaldo de la silla de la sala, tu mama te regañara mas tarde.\n", null);
		        } catch (BadLocationException ex) {
		            ex.printStackTrace();
		        }
				silla_Button.setEnabled(false); // Deshabilitar el botón
				//  pasarNivel();


		    }
		});
		silla_Button.setBounds(51, 297, 63, 51);
		silla_Button.setOpaque(false); // Hacer transparente
		silla_Button.setContentAreaFilled(false); // Eliminar relleno
		silla_Button.setBorderPainted(false); // Sin borde
		contentPane.add(silla_Button);
		
		JButton cojin_Button = new JButton("");
		cojin_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            StyledDocument doc = textPane.getStyledDocument();
		            doc.insertString(doc.getLength(), "Encontraste tus pantalones tirados en el sofa, huelen un poco a rancio. \n", null);
		        } catch (BadLocationException ex) {
		            ex.printStackTrace();
		        }
				cojin_Button.setEnabled(false); // Deshabilitar el botón
				 // pasarNivel();


			}
		});
		cojin_Button.setBounds(350, 322, 164, 36);
		cojin_Button.setOpaque(false); // Hacer transparente
		cojin_Button.setContentAreaFilled(false); // Eliminar relleno
		cojin_Button.setBorderPainted(false); // Sin borde
		contentPane.add(cojin_Button);
		
		textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(0, 455, 612, 106);
		textPane.setEditable(false); // Hacerlo no editable, solo para mostrar texto
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\zImages\\bam-explosion-de-divertidos-dibujos-animados.jpg"));
		lblNewLabel_1.setBounds(621, 37, 153, 417);
		contentPane.add(lblNewLabel_1);
		
		
		JButton pista_Button = new JButton("?");
		pista_Button.setBackground(new Color(255, 204, 0));
		pista_Button.setFont(new Font("Tahoma", Font.BOLD, 64));
		pista_Button.setBounds(263, 11, 77, 78);
		contentPane.add(pista_Button);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(0, 0, 612, 106);
		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Noto Sans Cond", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon("D:\\zImages\\istockphoto-1300331505-612x612.jpg"));
		lblNewLabel.setBounds(0, 0, 612, 561);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		

      setVisible(true);
}
	/*
	public void pasarNivel() {
		contador++;
		if (contador == 4) {
			dispose();
			new view_pasoCocina(contadorPreguntaPadre,contadorPadre);
		}
	}
	*/
	public void pasarTiempo() {
		  Timer timer = new Timer(3000, null);
		  timer.setRepeats(false); // Asegurarse de que el temporizador solo se ejecute una vez
		  timer.start(); // Iniciar el temporizador
	}
	
	
	
}


