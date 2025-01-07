package model.excepciones;

public class LibroNoDisponibleException extends Throwable{

	public LibroNoDisponibleException() {
		
	}
	
	public LibroNoDisponibleException(String message) {
		super(message);
	}
}
