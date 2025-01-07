package service;

import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Prestamo;
import model.Usuario;
import model.excepciones.LibroNoDisponibleException;
import model.excepciones.UsuarioNoRegistradoException;

public class Biblioteca {

	private ArrayList<Libro> libros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Prestamo> prestamos;

	public Biblioteca() {
		libros = new ArrayList<>();
		usuarios = new ArrayList<>();
		prestamos = new ArrayList<>();
	}

	public void registrarLibro(int id, String titulo, String autor) {
		libros.add(new Libro(id, titulo, autor, true));
	}

	public void registrarUsuario(int id, String nombre) {
		usuarios.add(new Usuario(id, nombre));
	}

	public void prestarLibro(int idLibro, int idUsuario) throws LibroNoDisponibleException, UsuarioNoRegistradoException {
		
		Libro libro = buscarLibro(idLibro);
		Usuario usuario = buscarUsuario(idUsuario);
		
		if(libro == null) {
			throw new LibroNoDisponibleException("Libro no disponible");
		}
		if(usuario == null ) {
			throw new UsuarioNoRegistradoException("Usuario no registrado");
		}
		
		if(libro.estaDisponible()) {
			Prestamo prestamo = new Prestamo(libro, usuario);
			prestamos.add(prestamo);
			libro.setDisponible(false);
			System.out.println("Libro: "+libro.getTitulo()+", prestado a: "+usuario.getNombre());
		} else {
			System.out.println("Libro no disponible para préstamo");
		}
		
	}
	
	public void devolverLibro(int idLibro) {
		for (Prestamo prestamo : prestamos) {
			if(prestamo.getLibro().id == idLibro) {
				prestamo.getLibro().setDisponible(true);
				prestamos.remove(prestamo);
				
			}
		}
	}

	private Libro buscarLibro(int idLibro){
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).id == idLibro) {
				return libros.get(i);
			}
		}
		return null;
	}
	
	private Usuario buscarUsuario(int idUsuario) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).id == idUsuario) {
				return usuarios.get(i);
			}
		}
		return null;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	
}
