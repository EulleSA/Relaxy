package br.imd.modelo.Patricia;

public class NoPatricio {
	
	private char caracter;
	private int tamanho;
	private boolean caracterfinal;
	
	public NoPatricio(char caracter) {
		
		this.caracter = caracter;
		this.caracterfinal = false;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isCaracterfinal() {
		return caracterfinal;
	}

	public void setCaracterfinal(boolean caracterfinal) {
		this.caracterfinal = caracterfinal;
	}
	
	

}