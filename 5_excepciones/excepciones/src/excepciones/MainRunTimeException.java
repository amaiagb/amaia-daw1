package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRunTimeException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        //RunTimeExceptions - el compilador no las marca como error

        try {
            System.out.println("Introduzca el primer numero: ");
            int num1 = sc.nextInt();
            System.out.println("Introduzca el segundo numero: ");
            int num2 = sc.nextInt();

            System.out.println(num1 / num2);
            
            int[] array = {1,2};
            array[4] = 5;
            
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0");
        } catch(InputMismatchException e){
            System.out.println("Has introducido un valor no numerico");
        }catch(Exception e) {
        	System.out.println("Error: "+e.getLocalizedMessage());
        }finally{
            sc.close();
        }

        
        //Si el manejo de una excepcion es igual para varias excepciones diferentes: se pueden agrupar
        /*
        try {
            System.out.println("Introduzca el primer numero: ");
            int num1 = sc.nextInt();
            System.out.println("Introduzca el segundo numero: ");
            int num2 = sc.nextInt();
            
            System.out.println(num1 / num2);
            
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Solo se pueden introducir numeros >0");
        }finally{
            sc.close();
        }
         */
        System.out.println("FIN DEL PROGRAMA");

	}

}
