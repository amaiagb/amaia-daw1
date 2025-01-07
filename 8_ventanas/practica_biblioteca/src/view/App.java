package view;

import model.excepciones.LibroNoDisponibleException;
import model.excepciones.UsuarioNoRegistradoException;
import service.Biblioteca;
import ui.Listado;

public class App {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.registrarLibro(1, "El descontento", "Beatriz Serrano");
		biblioteca.registrarLibro(2, "La mala costumbre", "Alana Portero");
		biblioteca.registrarLibro(3, "La mancha", "Enrique Aparicio");
		
		biblioteca.registrarUsuario(1, "Miren Gómez");
		biblioteca.registrarUsuario(2, "Alex Aguirre");
		
		try {
			biblioteca.prestarLibro(1, 2);
			biblioteca.prestarLibro(2, 1);
			biblioteca.devolverLibro(1);
		} catch (LibroNoDisponibleException | UsuarioNoRegistradoException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		Listado ventana = new Listado(biblioteca.getLibros(), biblioteca.getUsuarios(), biblioteca.getPrestamos());
		ventana.setVisible(true);
		
		
	}

}
