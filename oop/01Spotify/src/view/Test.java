package view;

public class Test {

	public static void main(String[] args) {
		
		int total = sumar(2,6);
		System.out.println(total);
		sumar(3,9);
		sumar(4,1);

	}
	public static int sumar(int primerNumero, int segundoNumero) {
		int resultado = primerNumero+segundoNumero;
		return resultado;
		//se podr�a poner en la misma l�nea:
		//return primerNumero+segundoNumero;
		
	}
}
