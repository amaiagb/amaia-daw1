package arrays10;

public class Main {

	public static void main(String[] args) {
		// Crea un programa que genere una matriz 3x3 y que intercambie las filas por las columnas, obteniendo así la matriz transpuesta.
		
		//Generar matriz 
		int[][] matriz = new int[2][3];
		
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				matriz[i][j] = (int) ((Math.random()*10)+1);
			}
		}
		
		System.out.println("Matriz original");

		//Mostrar matriz
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
		//Generar matriz transpuesta
		int[][] transpuesta = new int[3][2];
		
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				transpuesta[j][i] = matriz[i][j];
			}
		}
		
		System.out.println("Matriz transpuesta");
		
		//Mostrar transpuesta
		for(int i=0; i<transpuesta.length; i++) {
			for(int j=0; j<transpuesta[i].length; j++) {
				System.out.print(transpuesta[i][j]+" ");
			}
			System.out.println();
		}
	}
}
