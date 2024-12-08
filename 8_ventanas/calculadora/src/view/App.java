package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Font;

public class App {

	static String operacion;
	static double primerValor;
	static double segundoValor;
	static double valorResultado;
	static boolean resetPantalla = true;

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Calculadora");
		ventana.getContentPane().setBackground(new Color(51, 51, 51));
		ventana.setBounds(0, 0, 307, 498);
		ventana.getContentPane().setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblPantalla = new JLabel("0");
		lblPantalla.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
		lblPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPantalla.setForeground(new Color(255, 255, 255));
		lblPantalla.setOpaque(true);
		lblPantalla.setBackground(new Color(102, 102, 102));
		lblPantalla.setBounds(30, 44, 230, 50);
		ventana.getContentPane().add(lblPantalla);

		JButton btn1 = new JButton("1");
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn1.setBounds(30, 110, 50, 50);
		ventana.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setForeground(new Color(0, 0, 0));
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn2.setBounds(90, 110, 50, 50);
		ventana.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setForeground(new Color(0, 0, 0));
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn3.setBounds(150, 110, 50, 50);
		ventana.getContentPane().add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setForeground(new Color(0, 0, 0));
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn4.setBounds(30, 170, 50, 50);
		ventana.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setForeground(new Color(0, 0, 0));
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn5.setBounds(90, 170, 50, 50);
		ventana.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setForeground(new Color(0, 0, 0));
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn6.setBounds(150, 170, 50, 50);
		ventana.getContentPane().add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setForeground(new Color(0, 0, 0));
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn7.setBounds(30, 230, 50, 50);
		ventana.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setForeground(new Color(0, 0, 0));
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn8.setBounds(90, 230, 50, 50);
		ventana.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setForeground(new Color(0, 0, 0));
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn9.setBounds(150, 230, 50, 50);
		ventana.getContentPane().add(btn9);

		JButton btn0 = new JButton("0");
		btn0.setForeground(new Color(0, 0, 0));
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setFont(new Font("Dialog", Font.PLAIN, 20));
		btn0.setBounds(90, 290, 50, 50);
		ventana.getContentPane().add(btn0);

		JButton btnSumar = new JButton("+");
		btnSumar.setOpaque(true);
		btnSumar.setForeground(new Color(255, 255, 255));
		btnSumar.setBackground(new Color(255, 153, 51));
		btnSumar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnSumar.setBounds(210, 110, 50, 50);
		ventana.getContentPane().add(btnSumar);

		JButton btnRestar = new JButton("-");
		btnRestar.setOpaque(true);
		btnRestar.setForeground(new Color(255, 255, 255));
		btnRestar.setBackground(new Color(255, 153, 51));
		btnRestar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRestar.setBounds(210, 170, 50, 50);
		ventana.getContentPane().add(btnRestar);

		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.setOpaque(true);
		btnMultiplicar.setForeground(new Color(255, 255, 255));
		btnMultiplicar.setBackground(new Color(255, 153, 51));
		btnMultiplicar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnMultiplicar.setBounds(210, 230, 50, 50);
		ventana.getContentPane().add(btnMultiplicar);

		JButton btnDividir = new JButton("/");
		btnDividir.setOpaque(true);
		btnDividir.setForeground(new Color(255, 255, 255));
		btnDividir.setBackground(new Color(255, 153, 51));
		btnDividir.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDividir.setBounds(210, 290, 50, 50);
		ventana.getContentPane().add(btnDividir);

		JButton btnBorrar = new JButton("C");
		btnBorrar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(new Color(102, 102, 102));
		btnBorrar.setBounds(30, 290, 50, 50);
		ventana.getContentPane().add(btnBorrar);

		JButton btnCalcular = new JButton("=");
		btnCalcular.setForeground(new Color(0, 0, 0));
		btnCalcular.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCalcular.setBackground(new Color(255, 204, 102));
		btnCalcular.setOpaque(true);
		btnCalcular.setBounds(30, 350, 230, 50);
		ventana.getContentPane().add(btnCalcular);

		JButton btnComa = new JButton(",");
		btnComa.setForeground(new Color(255, 255, 255));
		btnComa.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnComa.setBackground(new Color(102, 102, 102));
		btnComa.setBounds(150, 290, 50, 50);
		ventana.getContentPane().add(btnComa);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "1");
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "2");
			}
		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "3");
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "4");
			}
		});

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "5");
			}
		});

		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "6");
			}
		});

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "7");
			}
		});

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "8");
			}
		});

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "9");
			}
		});

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarNumero(lblPantalla, "0");

			}
		});

		btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resetPantalla) {
					lblPantalla.setText("0.");
					resetPantalla = false;
				} else {
					if (!lblPantalla.getText().contains(".")) {
						lblPantalla.setText(lblPantalla.getText() + ".");
					}
				}

			}
		});

		btnSumar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					primerValor = Double.parseDouble(lblPantalla.getText());
					operacion = "suma";
					resetPantalla = true;
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
					primerValor = Double.parseDouble(lblPantalla.getText());
					operacion = "resta";
					resetPantalla = true;
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
					primerValor = Double.parseDouble(lblPantalla.getText());
					operacion = "multiplicacion";
					resetPantalla = true;
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
					primerValor = Double.parseDouble(lblPantalla.getText());
					operacion = "division";
					resetPantalla = true;
				} catch (NumberFormatException e1) {

				} catch (Exception e2) {
					lblPantalla.setText("Error inesperado");
				}
			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				lblPantalla.setText("0");
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					calcularResultado(lblPantalla);
				} catch (NullPointerException e1) {

				} catch (NumberFormatException e2) {

				} catch (Exception e3) {
					lblPantalla.setText("Error inesperado");
				}
			}

		});

		ventana.setVisible(true);

	}

	// ************* MÉTODOS *************

	private static void mostrarNumero(JLabel lblPantalla, String numero) {
		if (!resetPantalla) {
			lblPantalla.setText(lblPantalla.getText() + numero);
		} else {
			lblPantalla.setText(numero);
			resetPantalla = false;
		}
	}

	private static void reset() {
		primerValor = 0;
		segundoValor = 0;
		resetPantalla = true;
	}

	private static void calcularResultado(JLabel lblPantalla) {

		segundoValor = Double.parseDouble(lblPantalla.getText());

		switch (operacion) {
		case "suma":
			valorResultado = primerValor + segundoValor;
			lblPantalla.setText(formatearDecimal(valorResultado));
			break;
		case "resta":
			valorResultado = primerValor - segundoValor;
			lblPantalla.setText(formatearDecimal(valorResultado));
			break;
		case "multiplicacion":
			valorResultado = primerValor * segundoValor;
			lblPantalla.setText(formatearDecimal(valorResultado));
			break;
		case "division":
			if (segundoValor != 0) {
				valorResultado = primerValor / segundoValor;
				lblPantalla.setText(formatearDecimal(valorResultado));
			} else {
				lblPantalla.setText("Error");
				reset();
			}
			break;
		default:

			break;
		}
		operacion = "";
		resetPantalla = true;
	}

	private static String formatearDecimal(double numero) {
		if (numero % 1 != 0) {
			return Double.toString(numero);
		} else {
			return Integer.toString((int) (numero));
		}
	}

}
