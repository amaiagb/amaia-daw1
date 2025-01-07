package model.excepciones;

public class UsuarioNoRegistradoException extends Throwable {

	public UsuarioNoRegistradoException() {
		
	}

	public UsuarioNoRegistradoException(String message) {
		super(message);
	}
}
