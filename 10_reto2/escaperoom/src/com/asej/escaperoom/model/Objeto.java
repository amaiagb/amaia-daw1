package com.asej.escaperoom.model;

public class Objeto {
	
	private String nombre;
	private String urlImg;
	private String descripcion;
	private boolean usado;
	
	public Objeto(String nombre, String urlImg, String descripcion) {
		this.nombre = nombre;
		this.urlImg = urlImg;
		this.descripcion = descripcion;
		this.usado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
