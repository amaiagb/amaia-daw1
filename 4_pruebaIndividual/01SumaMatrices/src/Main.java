import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final int FILAS = 3;
		final int COLUMNAS = 3;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa valores a la matriz");
		int[][] numeros = new int[3][3];
		
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<COLUMNAS; j++) {
				System.out.println("Elemento ["+i+"]["+j+"]: ");
				numeros[i][j] = entrada.nextInt();
			}
		}
		
		System.out.println("Suma de las filas");
		for(int i=0; i<FILAS; i++) {
			int suma = 0;
			for(int j=0; j<COLUMNAS; j++) {
				suma += numeros[i][j];
			}
			System.out.println("Suma de la fila "+i+": "+suma);
		}
		
		System.out.println("\nSuma de las columnas");
		for(int i=0; i<FILAS; i++) {
			int suma = 0;
			for(int j=0; j<COLUMNAS; j++) {
				suma += numeros[j][i];
			}
			System.out.println("Suma de la columna "+i+": "+suma);
		}
		
		int suma = 0;
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<COLUMNAS; j++) {
				suma += numeros[i][j];
			}
			
		}
		System.out.println("\nSuma total de todos los elementos: "+suma);
		entrada.close();
	}

}
