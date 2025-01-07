package model;

public class Usuario extends Entidad {
	
	private String nombre;
	
	public Usuario (int id, String nombre) {
		super(id);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
