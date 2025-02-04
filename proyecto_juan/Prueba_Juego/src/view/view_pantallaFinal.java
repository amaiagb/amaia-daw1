//
//
//package view;
//
//import javax.swing.ButtonGroup;    
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//import java.awt.Font;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Color;
//import java.applet.AudioClip;
//
//public class view_pantallaFinal extends JFrame{
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//
//	public view_pantallaFinal(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(0, 0, 800, 600);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		contentPane.setLayout(null);
//		
//		JLabel lblATuCasa = new JLabel("A comer chokocripi");
//		lblATuCasa.setForeground(Color.CYAN);
//		lblATuCasa.setFont(new Font("Arial", Font.BOLD, 37));
//		lblATuCasa.setHorizontalAlignment(SwingConstants.CENTER);
//		lblATuCasa.setBounds(23, 50, 373, 278);
//		contentPane.add(lblATuCasa);
//		
//		JButton Button_Jugar = new JButton("Jugar");
//		Button_Jugar.setFont(new Font("Arial", Font.BOLD, 16));
//		Button_Jugar.setBackground(Color.RED);
//		Button_Jugar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//					dispose(); // Cierra la ventana actual
//	                new view_portada();
//				}
//			
//		});
//		Button_Jugar.setBounds(76, 339, 89, 23);
//		contentPane.add(Button_Jugar);
//		
//		JButton Button_Jugar_1 = new JButton("Salir");
//		Button_Jugar_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose(); // Libera los recursos del JFrame
//			    System.exit(0);  // Finaliza la aplicación
//			}
//		});
//		Button_Jugar_1.setFont(new Font("Arial", Font.BOLD, 16));
//		Button_Jugar_1.setBackground(Color.WHITE);
//		Button_Jugar_1.setBounds(257, 339, 89, 23);
//		contentPane.add(Button_Jugar_1);
//		
//		setVisible(true);
//
//	}
//}
//
