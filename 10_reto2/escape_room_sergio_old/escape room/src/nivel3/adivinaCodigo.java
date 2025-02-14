package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class adivinaCodigo extends JFrame {

	private JPanel contentPane;
	int contador = 0;
	private JLabel lblCirculo1;
	private JLabel lblCirculo2;
	private JLabel lblCirculo3;
	private JLabel lblCirculo4;
 
	public adivinaCodigo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JButton btnNublado = new JButton("");
		btnNublado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnNublado.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\nublado2.png"));
		btnNublado.setBounds(163, 250, 55, 53);
		contentPane.add(btnNublado);
		
		JButton btnCopoNieve = new JButton("");
		btnCopoNieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnCopoNieve.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\copo-de-nieve2.png"));
		btnCopoNieve.setBounds(163, 314, 55, 53);
		contentPane.add(btnCopoNieve);
		
		JButton btnLuna = new JButton("");
		btnLuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (contador == 0) {
					    contador++;
					    lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo3.png"));	   
				 }
				 
				 
				 pasarPuzzle();
			}
		});
		btnLuna.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\luna.png"));
		btnLuna.setBounds(358, 378, 55, 53);
		contentPane.add(btnLuna);
		
		JButton btnLuna2 = new JButton("");
		btnLuna2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\luna.png"));
		btnLuna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnLuna2.setBounds(228, 250, 55, 53);
		contentPane.add(btnLuna2);
		
		JButton btnLluvia = new JButton("");
		btnLluvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnLluvia.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\lluvia2.png"));
		btnLluvia.setBounds(228, 314, 55, 53);
		contentPane.add(btnLluvia);
		
		JButton btnSol = new JButton("");
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnSol.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\sol.png"));
		btnSol.setBounds(163, 378, 55, 53);
		contentPane.add(btnSol);
		
		JButton btnSol2 = new JButton("");
		btnSol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (contador == 3) {
					    contador++;
					    lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo3.png"));
					    setVisible(false);
					    taquillaAbierta taquillaAbierta = new taquillaAbierta();
					    taquillaAbierta.setVisible(true);
				 } 
				 pasarPuzzle();			
			}
			
		});
		btnSol2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\sol.png"));
		btnSol2.setBounds(293, 250, 55, 53);
		contentPane.add(btnSol2);
		
		JButton btTsunami = new JButton("");
		btTsunami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btTsunami.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\tsunami2.png"));
		btTsunami.setBounds(293, 314, 55, 53);
		contentPane.add(btTsunami);
		
		JButton btnTornado = new JButton("");
		btnTornado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnTornado.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\tornado2.png"));
		btnTornado.setBounds(228, 378, 55, 53);
		contentPane.add(btnTornado);
		
		JButton btnNube = new JButton("");
		btnNube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (contador == 2 ) {
					    contador++;
					    lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo3.png"));	    
				 }
				
				 pasarPuzzle();

			}
			
		});
		btnNube.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\nube2.png"));
		btnNube.setBounds(358, 250, 55, 53);
		contentPane.add(btnNube);
		
		JButton btnRayo = new JButton("");
		btnRayo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (contador == 1) {
					    contador++;
					    lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo3.png"));	  
				 }
				 pasarPuzzle();
					  
			}
		});
		btnRayo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\rayo.png"));
		btnRayo.setBounds(358, 314, 55, 53);
		contentPane.add(btnRayo);
		
		JButton btnCopoNieve2 = new JButton("");
		btnCopoNieve2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
				contador = 0;
			}
		});
		btnCopoNieve2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\copo-de-nieve2.png"));
		btnCopoNieve2.setBounds(293, 378, 55, 53);
		contentPane.add(btnCopoNieve2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\cuadroTOP2.jpg"));
		lblNewLabel.setBounds(89, 21, 409, 204);
		contentPane.add(lblNewLabel);
		
		lblCirculo1 = new JLabel("");
		lblCirculo1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
		lblCirculo1.setBounds(184, 442, 18, 14);
		contentPane.add(lblCirculo1);
		
		lblCirculo2 = new JLabel("");
		lblCirculo2.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
		lblCirculo2.setBounds(248, 442, 18, 14);
		contentPane.add(lblCirculo2);
		
		lblCirculo3 = new JLabel("");
		lblCirculo3.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
		lblCirculo3.setBounds(314, 442, 18, 14);
		contentPane.add(lblCirculo3);
		
		lblCirculo4 = new JLabel("");
		lblCirculo4.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\circulo2.jpg"));
		lblCirculo4.setBounds(380, 442, 18, 14);
		contentPane.add(lblCirculo4);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolver.setBounds(28, 442, 89, 29);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\fondoCodigo.png"));
		lblNewLabel_1.setBounds(0, 0, 600, 500);
		contentPane.add(lblNewLabel_1);

	
	}

	
	 private void pasarPuzzle() {
		 if (contador == 4) {
		 System.out.println("ContrASEŅA COrrecta");
		 }
		 }

}
