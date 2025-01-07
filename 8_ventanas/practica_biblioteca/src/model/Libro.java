package model;

import model.interfaces.Prestable;

public class Libro extends Entidad implements Prestable {
	//private int id;
	private String titulo;
	private String autor;
	private boolean disponible;

	@Override
	public boolean estaDisponible() {
		if(disponible) {
			return true;
		} else {
			return false;	
		}
	}

	public Libro(int id, String titulo, String autor, boolean disponible) {
		super(id);
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponible() {
		return disponible;
	}


	
	
	
}
