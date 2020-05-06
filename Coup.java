package projetJava;

public class Coup {
	private int ligne;
	private int colonne;
	
	public Coup(int ligne, int colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public int getLigne() {
		return ligne;
	}
	
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	
	public int getColonne() {
		return colonne;
	}
	
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	@Override
	public String toString() {
		return ligne+"-"+colonne;
	}
	
}
