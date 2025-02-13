package com.asej.escaperoom.view.lvl2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class Codigo extends JPanel {

	private int contador = 0;
	private JLabel lblCirculo1;
	private JLabel lblCirculo2;
	private JLabel lblCirculo3;
	private JLabel lblCirculo4;

	public Codigo(Ventana ventana) {
		setBounds(0, 0, 600, 500);
		setLayout(null);

		JButton btnNublado = new JButton("");
		btnNublado.setIcon(new ImageIcon("resources\\images\\lvl2\\nublado2.png"));
		btnNublado.setBounds(163, 250, 55, 53);
		add(btnNublado);

		JButton btnCopoNieve = new JButton("");
		btnCopoNieve.setIcon(new ImageIcon("resources\\images\\lvl2\\copo-de-nieve2.png"));
		btnCopoNieve.setBounds(163, 314, 55, 53);
		add(btnCopoNieve);

		JButton btnLuna = new JButton("");
		btnLuna.setIcon(new ImageIcon("resources\\images\\lvl2\\luna.png"));
		btnLuna.setBounds(358, 378, 55, 53);
		add(btnLuna);

		JButton btnLuna2 = new JButton("");
		btnLuna2.setIcon(new ImageIcon("resources\\images\\lvl2\\luna.png"));
		btnLuna2.setBounds(228, 250, 55, 53);
		add(btnLuna2);

		JButton btnLluvia = new JButton("");
		btnLluvia.setIcon(new ImageIcon("resources\\images\\lvl2\\lluvia2.png"));
		btnLluvia.setBounds(228, 314, 55, 53);
		add(btnLluvia);

		JButton btnSol = new JButton("");
		btnSol.setIcon(new ImageIcon("resources\\images\\lvl2\\sol.png"));
		btnSol.setBounds(163, 378, 55, 53);
		add(btnSol);

		JButton btnSol2 = new JButton("");
		btnSol2.setIcon(new ImageIcon("resources\\images\\lvl2\\sol.png"));
		btnSol2.setBounds(293, 250, 55, 53);
		add(btnSol2);

		JButton btnTsunami = new JButton("");
		btnTsunami.setIcon(new ImageIcon("resources\\images\\lvl2\\tsunami2.png"));
		btnTsunami.setBounds(293, 314, 55, 53);
		add(btnTsunami);

		JButton btnTornado = new JButton("");
		btnTornado.setIcon(new ImageIcon("resources\\images\\lvl2\\tornado2.png"));
		btnTornado.setBounds(228, 378, 55, 53);
		add(btnTornado);

		JButton btnNube = new JButton("");
		btnNube.setIcon(new ImageIcon("resources\\images\\lvl2\\nube2.png"));
		btnNube.setBounds(358, 250, 55, 53);
		add(btnNube);

		JButton btnRayo = new JButton("");
		btnRayo.setIcon(new ImageIcon("resources\\images\\lvl2\\rayo.png"));
		btnRayo.setBounds(358, 314, 55, 53);
		add(btnRayo);

		JButton btnCopoNieve2 = new JButton("");
		btnCopoNieve2.setIcon(new ImageIcon("resources\\images\\lvl2\\copo-de-nieve2.png"));
		btnCopoNieve2.setBounds(293, 378, 55, 53);
		add(btnCopoNieve2);

		JLabel lblCuadro = new JLabel("");
		lblCuadro.setIcon(new ImageIcon("resources\\images\\lvl2\\cuadroTOP2.jpg"));
		lblCuadro.setBounds(89, 21, 409, 204);
		add(lblCuadro);

		lblCirculo1 = new JLabel("");
		lblCirculo1.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo1.setBounds(184, 442, 18, 14);
		add(lblCirculo1);

		lblCirculo2 = new JLabel("");
		lblCirculo2.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo2.setBounds(248, 442, 18, 14);
		add(lblCirculo2);

		lblCirculo3 = new JLabel("");
		lblCirculo3.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo3.setBounds(314, 442, 18, 14);
		add(lblCirculo3);

		lblCirculo4 = new JLabel("");
		lblCirculo4.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo4.setBounds(380, 442, 18, 14);
		add(lblCirculo4);

		JButton btnVolver = new JButton(Ventana.mensajes.getString("btnVolver"));
		btnVolver.setBounds(28, 442, 89, 29);
		add(btnVolver);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(Color.DARK_GRAY);
		lblFondo.setOpaque(true);
		lblFondo.setBounds(240, 100, 600, 500);
		add(lblFondo);

		btnLuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 0) {
					contador++;
					lblCirculo1.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo3.png"));
				}
				pasarPuzzle();
			}
		});
		
		btnRayo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 1) {
					contador++;
					lblCirculo2.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo3.png"));
				}
				pasarPuzzle();
			}
		});
		btnNube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (contador == 2 ) {
					    contador++;
					    lblCirculo3.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo3.png"));	    
				 }
				 pasarPuzzle();
			}
		});

		btnSol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 3) {
					contador++;
					lblCirculo4.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo3.png"));
					setVisible(false);
					ventana.showEscena("Taquilla Abierta");
				}
				pasarPuzzle();
			}
		});

		btnLuna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		btnLluvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		btnSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		btnTsunami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		btnCopoNieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		btnNublado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});

		btnTornado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		
		btnCopoNieve2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCodigo();
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private void pasarPuzzle() {
		if (contador == 4) {
			setVisible(false);
		}
	}

	public void resetCodigo() {
		lblCirculo1.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo2.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo3.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		lblCirculo4.setIcon(new ImageIcon("resources\\images\\lvl2\\circulo2.jpg"));
		contador = 0;
	}

}
