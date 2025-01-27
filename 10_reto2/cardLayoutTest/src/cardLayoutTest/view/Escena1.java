package cardLayoutTest.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Escena1 extends JPanel {

	public Escena1(Ventana ventana) {
		setBounds(0,0,590,360);
		setBackground(Color.PINK);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblEscena1 = new JLabel("Escena 1");
		lblEscena1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscena1.setBounds(230, 76, 119, 14);
		add(lblEscena1);
		
		JButton btnCogerObjeto = new JButton("Coger objeto");
		btnCogerObjeto.setBounds(230, 135, 119, 23);
		add(btnCogerObjeto);
		
		JButton btnIzq = new JButton("<");
		btnIzq.setBounds(10, 135, 89, 23);
		add(btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarEscena("Escena 2");
			}
		});
		btnDer.setBounds(491, 135, 89, 23);
		add(btnDer);

		
	}

}
