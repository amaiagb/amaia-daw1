import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige el tipo de árbol (1.- Arbol o 2.-Arbol de navidad)");
		int tipoArbol = entrada.nextInt();
		
		System.out.println("Introduce la altura del árbol");
		int altura = entrada.nextInt();
		int columnas = altura*2-1;
		String[][] arbol = new String[altura][columnas];
		
		switch(tipoArbol) {
		case 1:
			for(int i=0; i<altura; i++) {
				int limitIzq = ((columnas-(2*i+1)))/2;
				
				for(int j=0; j<limitIzq; j++) {
					arbol[i][j]=" ";
				}
				for(int j=limitIzq; j<(limitIzq+(2*i+1)); j++) {
					arbol[i][j]="*";
				}
				for(int j=(limitIzq+(2*i+1)); j<columnas; j++) {
					arbol[i][j]=" ";
				}
			}
			mostrarArbol(altura, columnas, arbol);
			break;
		case 2:
			for(int i=0; i<altura; i++) {
				int limitIzq = ((columnas-(2*i+1)))/2;
				
				for(int j=0; j<limitIzq; j++) {
					arbol[i][j]=" ";
				}
				for(int j=limitIzq; j<(limitIzq+(2*i+1)); j++) {
					Random random = new Random();
					int aleatorio = random.nextInt(2);
					if(aleatorio == 0) {
						arbol[i][j]="0";
					} else {
						arbol[i][j]="*";
					}
				}
				for(int j=(limitIzq+(2*i+1)); j<columnas; j++) {
					arbol[i][j]=" ";
				}
			}
			
			mostrarArbol(altura, columnas, arbol);
			break;
			
		default:
			System.out.println("Tipo de arbol no válido");
			break;
		}
		entrada.close();
	}

	private static void mostrarArbol(int altura, int columnas, String[][] arbol) {
		for(int i=0; i<altura; i++) {
			for(int j=0; j<columnas; j++) {
				System.out.print(arbol[i][j]);
			}
			System.out.println();
		}
	}

}
