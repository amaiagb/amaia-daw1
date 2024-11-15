import java.util.Scanner;

public class App extends Operaciones{

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int seleccion;
		
		do {
			System.out.println("Seleccione una operación:");
			System.out.println("1. Suma");
			System.out.println("2. Resta");
			System.out.println("3. Multiplicación");
			System.out.println("4. Media de un array");
			System.out.println("5. Numero más alto en un array");
			System.out.println("6. Numero más bajo en un array");
			System.out.println("7. Factorial");
			System.out.println("8. Comprobar si es impar");
			System.out.println("9. Comprobar si es primo");
			System.out.println("10.Crear matriz NxM con números aleatorios");
			System.out.println("0. Salir");
			
			seleccion = entrada.nextInt();
			
			switch (seleccion) {
			case 1: {
				System.out.println("Ingresa el primer numero");
				int num1 = entrada.nextInt();
				System.out.println("Ingresa el segundo numero");
				int num2 = entrada.nextInt();
				int suma = sumar(num1, num2);
				System.out.println(num1+" + "+num2+" = "+suma);
				break;
			}
			case 2: {
				System.out.println("Ingresa el primer numero");
				int num1 = entrada.nextInt();
				System.out.println("Ingresa el segundo numero");
				int num2 = entrada.nextInt();
				int resta = restar(num1, num2);
				System.out.println(num1+" - "+num2+" = "+resta);
				break;
			}
			case 3: {
				System.out.println("Ingresa el primer numero");
				int num1 = entrada.nextInt();
				System.out.println("Ingresa el segundo numero");
				int num2 = entrada.nextInt();
				int mult = multiplicar(num1, num2);
				System.out.println(num1+" * "+num2+" = "+mult);
				break;
			}
			case 4: {
				System.out.println("Ingresa el tamaño del array");
				int dimensionArray = entrada.nextInt();
				int[] numeros = new int[dimensionArray];
				for (int i = 0; i < dimensionArray; i++) {
					System.out.println("Numero "+(i+1)+":");
					numeros[i] = entrada.nextInt();
				}
				System.out.println(calcularMedia(numeros));
				break;
			}
			case 5: {
				System.out.println("Ingresa el tamaño del array");
				int dimensionArray = entrada.nextInt();
				int[] numeros = new int[dimensionArray];
				for (int i = 0; i < dimensionArray; i++) {
					System.out.println("Numero "+(i+1)+":");
					numeros[i] = entrada.nextInt();
				}
				System.out.println(obtenerMayor(numeros));
				break;
			}
			case 6: {
				System.out.println("Ingresa el tamaño del array");
				int dimensionArray = entrada.nextInt();
				int[] numeros = new int[dimensionArray];
				for (int i = 0; i < dimensionArray; i++) {
					System.out.println("Numero "+(i+1)+":");
					numeros[i] = entrada.nextInt();
				}
				System.out.println(obtenerMenor(numeros));
				break;
			}
			case 7: {
				System.out.println("Ingresa el numero para el factorial: ");
				int num = entrada.nextInt();
				System.out.println(calcularFactorial(num));
				break;
			}
			case 8: {
				System.out.println("Ingresa el numero para comprobar si es impar: ");
				int num = entrada.nextInt();
				System.out.println("impar: "+esImpar(num));
				break;
			}
			case 9: {
				System.out.println("Ingresa el numero para comprobar si es primo: ");
				int num = entrada.nextInt();
				System.out.println("primo: "+esPrimo(num));
				break;
			}
			case 10: {
				System.out.println("Ingresa el numero de filas: ");
				int filas = entrada.nextInt();
				System.out.println("Ingresa el numero de columnas: ");
				int columnas = entrada.nextInt();
				
				int[][] matriz = crearMatriz(filas, columnas);
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[0].length; j++) {
						System.out.print(matriz[i][j]+" ");
					}
					System.out.println();
				}
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Número incorrecto");
			}
			System.out.println();
		} while (seleccion != 0);
		
		entrada.close();
	}

}
