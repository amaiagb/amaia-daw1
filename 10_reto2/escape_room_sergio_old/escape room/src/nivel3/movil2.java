package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class movil2 extends JFrame {

	private JPanel contentPane;
	  private static Timer timer;   
	  private static Timer timer2; 
	  
	public movil2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaderechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaDerecha.png"));
			}
			
		});
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaDerecha.png"));
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conversacion conversacion = new conversacion();
				conversacion.setVisible(true);
				dispose();
			}
		});
		btnFlecha.setBounds(960, 331, 89, 51);
		btnFlecha.setVisible(false);
		contentPane.add(btnFlecha);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 1a.png"));
		lblNewLabel.setBounds(293, 95, 360, 548);
		contentPane.add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\parque difuminado.png"));
		lblFondo.setBounds(0, 0, 1084, 711);
		contentPane.add(lblFondo);
		
		JButton btnconver2 = new JButton("Preguntar a Manuel donde esta");
		btnconver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 2a.png"));
				btnconver2.setVisible(false);
				timer.start();
				timer2.start();
			}
		});
		btnconver2.setBounds(706, 274, 133, 51);
		contentPane.add(btnconver2);
		
		timer2 = new Timer(2000, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 3a.png"));
            	timer2.stop();
            }
        });
		
		 timer = new Timer(6000, new ActionListener() { 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            	lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 4a.png"));
	            	btnFlecha.setVisible(true);
	            }
	        });
		
	}

}
