package projetJava;

import java.util.Scanner;

public class Morpion extends TicTacToe {

	public Morpion(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	
	
	@Override
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
		
		if (coupValide(ligne-1, colonne-1)) {
			grille[ligne-1][colonne-1] = lettreJoueur;
			cpt++;
			joueur = !joueur;
		} else {
			System.err.println("COUP ILLEGAL REJOUEZ");
		}
		
		
		
		//la partie se termine si le compteur est supérieur ou égal au nombre de cases
		return cpt >= largeur * hauteur;
	}
	
	public boolean coupValide(int i, int j) {
		System.out.println("coupValide("+i+", "+j+")");
		if (cpt == 0) {
			return true;
		}
		
		//on vérifie les conditions qui font qu'un coup n'est pas valide
		if (i<0 || j<0 || i>hauteur-1 || j>largeur-1 || grille[i][j] != " ") {
			return false;
		} 
		
		//on vérifie si une des cases adjacentes sont occupées
		boolean hautGauche = i-1 >= 0 && j-1 >= 0 && grille[i-1][j-1] != " ";
		boolean gauche = j-1 >= 0 && grille[i][j-1] != " ";	
		boolean basGauche = i+1 < hauteur && j-1 >= 0 && grille[i+1][j-1] != " ";
		boolean haut = i-1 >= 0 && grille[i-1][j] != " ";
		boolean bas = i+1 < hauteur && grille[i+1][j] != " ";
		boolean hautDroite = i-1 >= 0 && j+1 < largeur && grille[i-1][j+1] != " ";
		boolean droite = j+1 < largeur && grille[i][j+1] != " ";
		boolean basDroite = i+1 < hauteur && j+1 < largeur && grille[i+1][j+1] != " ";
		//return true
		return hautGauche || gauche || basGauche || haut || bas || hautDroite || droite || basDroite;
	}
	
	public boolean alignVertical() {
		int cpt = 1;
		for (int j = 0; j < largeur; j++) {
			cpt = 1;
			for (int i = 0; i + 1 < hauteur; i++) {
				if (grille[i][j] == grille[i + 1][j] && grille[i][j] != " " && !estCaseFermee(grille[i][j])) {
					cpt++;
				}
				else {
					cpt = 1;
				}
				//on veut un alignement de 3
				if (cpt == 3) {
					//a faire : fermer les cases ici
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean alignHorizontal() {
		int cpt = 1;
		for (int i = 0; i < hauteur; i++) { 
			//on initialise le cpt à 1 car au début on est sur une case donc il n'y a qu'une seule case qui est alignée
			cpt = 1;
			for (int j = 0; j + 1 < largeur; j++) {
				if (grille[i][j] == grille[i][j + 1] && grille[i][j] != " ") {
					cpt++;
				}
				else { 
					cpt = 1;
				}
				if (cpt == 3) { 
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean alignDiagonalG() {
		int cpt = 1;
		int i = 0, j = largeur - 1;
		while (i + 1 < hauteur && j - 1 >= 0) {
			if (grille[i][j] == grille[i + 1][j - 1] && grille[i][j] != " ") {
				cpt++;
				if (cpt == 3) { 
					return true;
				}
				i = i + 1;
				j = j - 1;
				continue; // passe au tour de boucle suivant directement sans executer les instructions en dessous
			}
			else {
				cpt = 1;
				if (j - 1 == 0) {
					j = largeur - 1;
					i = i + 1;
				}
				else {
					j = j - 1;
				}
			}
		}
		return cpt == 3;
	}
	
	public boolean alignDiagonalD() {
		int cpt = 1;
		int i = 0, j = 0;
		while (i + 1 < hauteur && j + 1 < largeur) {
			if (grille[i][j] == grille[i + 1][j + 1] && grille[i][j] != " ") {
				cpt++;
				if (cpt == 3) { 
					return true;
				}
				i = i + 1;
				j = j + 1;
				continue; // passer au tour de boucle suivant directement sans executer les instructions en dessous
			}
			else {
				cpt = 1;
				if (j + 1 == largeur - 1) {
					j = 0;
					i = i + 1;
				}
				else {
					j = j + 1;
				}
			}
		}
		return cpt == 3 ;
	}
	
	public boolean estCaseFermee(String caseATester) {
		return caseATester != "x" && caseATester != "o"; 
	}
	
	
	@Override
	public boolean alignDiagonal(String joueur) {
		return false;
	}
	
	

}	

