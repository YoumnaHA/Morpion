package projetJava;


import java.util.Scanner;

public class TicTacToe{
	protected boolean joueur;
	protected boolean gagnant;
	protected int cpt;
	protected String[][] grille;
	protected int largeur;
	protected int hauteur;

	public TicTacToe() {
		this(3, 3);
	}
	
	public TicTacToe(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		grille = new String[hauteur][];
		for (int i = 0; i < hauteur; i++) {
			grille[i] = new String[largeur];
		}
		this.gagnant = false;
		resetGame();
	}
	
	public boolean getJoueur() {
		return joueur;
	}

	public boolean isGagnant() {
		return gagnant;
	}

	public int getCpt() {
		return cpt;
	}

	public String[][] getGrille() {
		return grille;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	//Initialiser la grille et rejouer
	public void resetGame() {
		cpt = 0;
		for (int i = 0; i < hauteur; ++i) {
			for (int j = 0; j < largeur; ++j) {
				grille[i][j] = " ";
			}
		}
		joueur = true;
	}

	//Afficher la grille
	public void afficherGrille() {
		System.out.print("  ");
		for (int j = 1 ; j <= this.largeur; j++) {
			System.out.print(j+"   ");
		}
		System.out.println();
		for (int i = 0; i < hauteur; ++i) {
			System.out.print(i + 1);
			for (int j = 0; j < largeur; ++j) {
				System.out.print("["+grille[i][j]+"] ");
			}
			System.out.println(); //saut de ligne
		}
	}
	/**
	 * 
	 * @param ligne
	 * @param colonne
	 * @return un boolean a true si la partie est finie (cpt = 9 ou un joueur a gagne)
	 */
	public boolean jouerCoup() {

		String lettreJoueur;
		if (this.getJoueur()) {
			System.out.print("Au joueur X de jouer : ");
			lettreJoueur = "X";
		} else {
			System.out.print("Au joueur O de jouer : ");
			lettreJoueur = "O";
		}

		Coup coup = null;
		while (coup == null) {
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextLine()) {
				String saisie = scanner.nextLine();
				System.out.println("saisie = "+saisie);
				coup = analyse(saisie);
			}
		}
		int ligne = coup.getLigne();
		int colonne = coup.getColonne();
		if (grille[ligne-1][colonne-1] == " ") {
			grille[ligne-1][colonne-1] = lettreJoueur; // -1 car le tableau commence à 0
			joueur = !joueur;
			cpt++;
		} else {
			System.out.println("La case est occupée, choisissez une autre case :");
			return false;
		}
		//appelle methode alignement bool
		return alignVertical(lettreJoueur) || alignHorizontal(lettreJoueur) || alignDiagonal(lettreJoueur) || cpt >= 9;
	}

	//Vérifie le format de la saisie
	public static Coup analyse(String s) {
		s = s.trim();
		if (s.matches("\\d+\\s*-\\s*\\d+")) {
			Scanner sc = new Scanner(s);
			sc.useDelimiter("\\s*-\\s*");
			int ligne = sc.nextInt();
			int colonne = sc.nextInt();
			//System.out.println("ligne = " + ligne + ", colonne = " + colonne);
			sc.close();
			return new Coup(ligne, colonne);
		}
		else {
			System.out.println("Coup invalide");
			return null;
		}
	}

	//Vérifie l'alignement en diagonal
	public boolean alignDiagonal(String joueur) {
		if((grille[0][0] == grille[1][1] && grille[1][1] == grille[2][2]) && grille[0][0] != " ") {
			System.out.println("Le joueur "+joueur+" remporte la partie");
			this.gagnant = true;
			return true;
		}
		if((grille[0][2] == grille[1][1] && grille[1][1] == grille[2][0]) && grille[0][2] != " ") {
			System.out.println("Le joueur "+joueur+" remporte la partie");
			this.gagnant = true;
			return true;
		}
		return false;
	}

	//Vérifie l'alignement horizontal
	public boolean alignHorizontal(String joueur) {
		for (int i = 0; i < 3; ++i) {
			if((grille[i][0] == grille[i][1] && grille[i][1] == grille[i][2]) && grille[i][0] != " ") {
				System.out.println("Le joueur "+joueur+" remporte la partie");
				this.gagnant = true;
				return true;
			}
		}
		return false;
	}

	//Vérifie l'alignement vertical
	public boolean alignVertical(String joueur) {
		for (int j = 0; j < 3; ++j) {
			if((grille[0][j] == grille[1][j] && grille[1][j] == grille[2][j]) && grille[0][j] != " ") {
				System.out.println("Le joueur "+joueur+" remporte la partie");
				this.gagnant = true;
				return true;
			}
		} 
		return false;
	}

}

