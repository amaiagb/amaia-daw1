package model;

public class Carta {
	private int id;
	private String color;
	private String imgFile;
	private boolean mostrada;
	private boolean resuelta;
	
	public Carta(int id, String color, String imgFile, boolean mostrada, boolean resuelta) {
		super();
		this.id = id;
		this.color = color;
		this.imgFile = imgFile;
		this.mostrada = mostrada;
		this.resuelta = resuelta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}

	public boolean isMostrada() {
		return mostrada;
	}

	public void setMostrada(boolean mostrada) {
		this.mostrada = mostrada;
	}

	public boolean isResuelta() {
		return resuelta;
	}

	public void setResuelta(boolean resuelta) {
		this.resuelta = resuelta;
	}
	
	
	
}
