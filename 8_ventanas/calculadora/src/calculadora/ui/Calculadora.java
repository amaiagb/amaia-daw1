package calculadora.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import calculadora.enums.Operacion;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JLabel lblPantalla;
	private JLabel lblCalculo;
	
	static Operacion operacion;
	static double primerValor;
	static double segundoValor;
	static double valorResultado;
	static boolean pantallaVacia = true;
	static boolean estadoInicial = true;

	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 330, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 30, 30));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPantalla = new JLabel("0");
		lblPantalla.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
		lblPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPantalla.setForeground(new Color(255, 255, 255));
		lblPantalla.setOpaque(true);
		lblPantalla.setBackground(new Color(102, 102, 102));
		lblPantalla.setBounds(20, 50, 270, 50);
		contentPane.add(lblPantalla);

		JButton btn1 = new JButton("1");
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn1.setBounds(20, 110, 60, 60);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setForeground(new Color(0, 0, 0));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn2.setBounds(90, 110, 60, 60);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setForeground(new Color(0, 0, 0));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn3.setBounds(160, 110, 60, 60);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setForeground(new Color(0, 0, 0));
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn4.setBounds(20, 180, 60, 60);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setForeground(new Color(0, 0, 0));
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn5.setBounds(90, 180, 60, 60);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setForeground(new Color(0, 0, 0));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn6.setBounds(160, 180, 60, 60);
		contentPane.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn7.setBounds(20, 250, 60, 60);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setForeground(new Color(0, 0, 0));
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn8.setBounds(90, 250, 60, 60);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setForeground(new Color(0, 0, 0));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn9.setBounds(160, 250, 60, 60);
		contentPane.add(btn9);

		JButton btn0 = new JButton("0");
		btn0.setForeground(new Color(0, 0, 0));
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn0.setBounds(90, 320, 60, 60);
		contentPane.add(btn0);

		JButton btnSumar = new JButton("+");
		btnSumar.setOpaque(true);
		btnSumar.setForeground(new Color(255, 255, 255));
		btnSumar.setBackground(new Color(255, 153, 51));
		btnSumar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnSumar.setBounds(230, 110, 60, 60);
		contentPane.add(btnSumar);

		JButton btnRestar = new JButton("-");
		btnRestar.setOpaque(true);
		btnRestar.setForeground(new Color(255, 255, 255));
		btnRestar.setBackground(new Color(255, 153, 51));
		btnRestar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRestar.setBounds(230, 180, 60, 60);
		contentPane.add(btnRestar);

		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.setOpaque(true);
		btnMultiplicar.setForeground(new Color(255, 255, 255));
		btnMultiplicar.setBackground(new Color(255, 153, 51));
		btnMultiplicar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnMultiplicar.setBounds(230, 250, 60, 60);
		contentPane.add(btnMultiplicar);

		JButton btnDividir = new JButton("/");
		btnDividir.setOpaque(true);
		btnDividir.setForeground(new Color(255, 255, 255));
		btnDividir.setBackground(new Color(255, 153, 51));
		btnDividir.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDividir.setBounds(230, 320, 60, 60);
		contentPane.add(btnDividir);

		JButton btnBorrar = new JButton("C");
		btnBorrar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(new Color(102, 102, 102));
		btnBorrar.setBounds(20, 320, 60, 60);
		contentPane.add(btnBorrar);

		JButton btnCalcular = new JButton("=");
		btnCalcular.setForeground(new Color(0, 0, 0));
		btnCalcular.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCalcular.setBackground(new Color(255, 204, 102));
		btnCalcular.setOpaque(true);
		btnCalcular.setBounds(20, 390, 270, 50);
		contentPane.add(btnCalcular);

		JButton btnComa = new JButton(",");
		btnComa.setForeground(new Color(255, 255, 255));
		btnComa.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnComa.setBackground(new Color(102, 102, 102));
		btnComa.setBounds(160, 320, 60, 60);
		contentPane.add(btnComa);
		
		lblCalculo = new JLabel("");
		lblCalculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCalculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalculo.setForeground(new Color(199, 199, 199));
		lblCalculo.setBounds(160, 20, 130, 14);
		contentPane.add(lblCalculo);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("1");
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("2");
			}
		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("3");
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("4");
			}
		});

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("5");
			}
		});

		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("6");
			}
		});

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("7");
			}
		});

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("8");
			}
		});

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("9");
			}
		});

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero("0");

			}
		});
		
		btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pantallaVacia) {
					lblPantalla.setText("0.");
					pantallaVacia = false;
				} else {
					if (!lblPantalla.getText().contains(".")) {
						lblPantalla.setText(lblPantalla.getText() + ".");
					}
				}

			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetearValores();
				lblPantalla.setText("0");
			}
		});

		btnSumar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					asignarOperacion(Operacion.SUMA);
				} catch (NumberFormatException e1) {

				} catch (Exception e2) {
					lblPantalla.setText("Error inesperado");
				}
			}
		});

		btnRestar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					asignarOperacion(Operacion.RESTA);
				} catch (NumberFormatException e1) {

				} catch (Exception e2) {
					lblPantalla.setText("Error inesperado");
				}
			}
		});
		btnMultiplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					asignarOperacion(Operacion.MULTIPLICACION);
				} catch (NumberFormatException e1) {

				} catch (Exception e2) {
					lblPantalla.setText("Error inesperado");
				}
			}
		});
		btnDividir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					asignarOperacion(Operacion.DIVISION);
				} catch (NumberFormatException e1) {

				} catch (Exception e2) {
					lblPantalla.setText("Error inesperado");
				}
			}
		});
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				realizarCalculo();
			}

			

		});

	}

	// *********************** MÉTODOS *******************

	private void mostrarNumero(String numeroSeleccionado) {
		try {
			Double numeroPantalla = Double.parseDouble(lblPantalla.getText());

			if ((numeroPantalla != 0 || lblPantalla.getText().contains(".")) && !pantallaVacia) {
				lblPantalla.setText(lblPantalla.getText() + numeroSeleccionado);
			} else {
				lblPantalla.setText(numeroSeleccionado);
				pantallaVacia = false;
			}
		} catch (NumberFormatException e) {
			resetearValores();
			lblPantalla.setText("0");
		}
	}

	private void resetearValores() {
		primerValor = 0;
		segundoValor = 0;
		pantallaVacia = true;
		estadoInicial = true;
		lblCalculo.setText("");
	}

	private void asignarOperacion(Operacion operacionSeleccionada) {

		//TODO: Arreglar Cálculo
		//Al encadenar operaciones guardar en alguna variable el valor de la operación anterior para poder mostrar el cálculo encima del resultado
		//Ahora sólo muestra el un valor que se sobreescribe continuamente
		//Si se calcula la operación pulsando el = sí que funciona correctamente
		
		if(!estadoInicial) {
			realizarCalculo();
		}
		primerValor = Double.parseDouble(lblPantalla.getText());
		operacion = operacionSeleccionada;
		String calculo = formatearDecimal(primerValor)+operacion.getSimbolo();
		lblCalculo.setText(calculo);
		pantallaVacia = true;
		estadoInicial = false;
		
	}
	
	private void realizarCalculo() {
		try {
			segundoValor = Double.parseDouble(lblPantalla.getText());
			lblCalculo.setText(lblCalculo.getText()+formatearDecimal(segundoValor)+"=");
			switch (operacion) {
				case SUMA -> {
					valorResultado = primerValor + segundoValor;
					lblPantalla.setText(formatearDecimal(valorResultado));
				}
				case RESTA -> {
					valorResultado = primerValor - segundoValor;
					lblPantalla.setText(formatearDecimal(valorResultado));
				}
				case MULTIPLICACION -> {
					valorResultado = primerValor * segundoValor;
					lblPantalla.setText(formatearDecimal(valorResultado));
				}
				case DIVISION -> {
					if (segundoValor != 0) {
						valorResultado = primerValor / segundoValor;
						lblPantalla.setText(formatearDecimal(valorResultado));
					} else {
						lblPantalla.setText("Error");
						resetearValores();
					}
				}
			}
			
			pantallaVacia = true;
			estadoInicial = true;

		} catch (NullPointerException e1) {

		} catch (NumberFormatException e2) {

		} catch (Exception e3) {
			lblPantalla.setText("Error inesperado");
		}
	}

	private static String formatearDecimal(double numero) {
		if (numero % 1 != 0) {
			return Double.toString(numero);
		} else {
			return Integer.toString((int) (numero));
		}
	}
	
	
}
