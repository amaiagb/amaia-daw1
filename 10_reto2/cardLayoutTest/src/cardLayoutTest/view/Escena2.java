package cardLayoutTest.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Escena2 extends JPanel {

	public Escena2(Ventana ventana) {
		setBounds(0,0,590,360);
		setBackground(Color.ORANGE);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblEscena2 = new JLabel("Escena 2");
		lblEscena2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscena2.setBounds(234, 62, 119, 14);
		add(lblEscena2);
		
		JButton btnCogerObjeto = new JButton("Coger objeto");
		btnCogerObjeto.setBounds(234, 135, 119, 23);
		add(btnCogerObjeto);
		
		JButton btnIzq = new JButton("<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarEscena("Escena 1");
			}
		});
		btnIzq.setBounds(10, 135, 89, 23);
		add(btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.setBounds(491, 135, 89, 23);
		add(btnDer);

		
	}
}
