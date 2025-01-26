package panelsTest.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import panelTest.model.Objeto;

public class Esc1 extends JPanel {


	public Esc1() {
		
		setLayout(null);
		setBounds(0, 0, 1400, 1000);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\panelsTest\\resources\\Leonardo_Phoenix_10_a_scene_of_the_bedroom_of_a_teen_boy_in_th_2(3).jpg"));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, 0, 1400, 1000);
		add(lblFondo);
		
		JLabel lblAlmohada = new JLabel("");
		lblAlmohada.setBounds(143, 617, 222, 116);
		add(lblAlmohada);
		
		lblAlmohada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¡Objeto encontrado!");
				Objeto moneda = new Objeto("moneda", "moneda.png", "Una moneda de 1 euro"); 
			}
		});

	}
}
