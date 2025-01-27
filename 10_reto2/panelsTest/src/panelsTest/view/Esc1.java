package panelsTest.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import panelTest.model.Objeto;

public class Esc1 extends JPanel {

	//private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
	public Esc1(ArrayList<Objeto> objetos) {

		//this.objetos = objetos;

		setLayout(null);
		setBounds(0, 0, 1200, 600);
		
		JLabel lblAlmohada = new JLabel("");
		lblAlmohada.setBounds(35, 412, 222, 116);
		add(lblAlmohada);
		
		lblAlmohada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¡Objeto encontrado!");
				Objeto moneda = new Objeto("moneda", "euro.png", "Una moneda de 1 euro"); 
				objetos.add(moneda);
				System.out.println("Inventario: "+objetos.size());
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAlmohada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\panelsTest\\resources\\Leonardo_Phoenix_10_a_scene_of_the_bedroom_of_a_teen_boy_in_th_2(3).jpg"));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, 0, 1200, 600);
		add(lblFondo);

	}
}
