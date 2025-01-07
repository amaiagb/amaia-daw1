package model;

public class Prestamo {
	
	private Libro libro;
	private Usuario usuario;
	
	public Prestamo(Libro libro, Usuario usuario) {
		this.libro = libro;
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
