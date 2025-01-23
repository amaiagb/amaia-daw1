package db;

public class Mensaje {
	private String idioma;
	private String texto;
	private String locutor;
	private int id;
	
	public Mensaje() {}
	
	public Mensaje(String idioma, String texto, String locutor, int id) {
		super();
		this.idioma = idioma;
		this.texto = texto;
		this.locutor = locutor;
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLocutor() {
		return locutor;
	}

	public void setLocutor(String locutor) {
		this.locutor = locutor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
