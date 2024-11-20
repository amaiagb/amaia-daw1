package excepciones;

import java.util.Scanner;

public class MainUserException {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");

        try {
            int edad = scanner.nextInt();

            validarEdad(edad);
            System.out.println("Acceso permitido. Tienes " + edad + " a�os.");

        } catch (EdadException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Debes introducir un n�mero v�lido.");
        } finally {
            scanner.close();
        }
    }

    public static void validarEdad(int edad) throws EdadException {
        if (edad < 18) {
            throw new EdadException("La edad introducida es menor a 18. Acceso denegado.");
        }

	}

}
