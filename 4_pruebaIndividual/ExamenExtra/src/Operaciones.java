import java.util.Random;

public class Operaciones {

	
	public static int sumar(int num1, int num2) {
		int suma = num1+num2;
		return suma;
	}
	
	public static int restar(int num1, int num2) {
		int resta = num1-num2;
		return resta;
	}
	
	public static int multiplicar(int num1, int num2) {
		int total = num1*num2;
		return total;
	}
	
	public static float calcularMedia(int[] numeros) {
		float media = 0;
		int suma = 0;
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}
		media = (float) suma/numeros.length;
		return media;
	}
	
	public static int obtenerMayor(int[] numeros) {
		int mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if(numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	public static int obtenerMenor(int[] numeros) {
		int menor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if(numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	public static int calcularFactorial(int num) {
		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	public static boolean esImpar(int num) {
		boolean impar = false;
		if(num%2 != 0) {
			impar = true;
		}
		return impar;
	}
	
	public static boolean esPrimo(int num) {
		boolean primo = false;
		int divisores = 0;
		for (int i = 1; i <= num; i++) {
			if(num%i == 0) {
				divisores++;
			}
		}
		if(divisores <= 2) {
			primo = true;
		}
		return primo;
	}
	
	public static int[][] crearMatriz(int filas, int columnas) {
		int[][] matriz = new int[filas][columnas];
		for(int i=0; i<filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Random random = new Random();
				matriz[i][j] = random.nextInt(100);
			}
		}
		return matriz;
	}
	
}
