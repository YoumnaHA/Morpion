package projetJava;

import java.util.Scanner;

public class Partie {
	
	public static void main(String[] args) {
		//Choix du nombre de lignes et du nombre de colonnes
		if (args.length == 0 || args[0].equals("Morpion")) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Saisissez le nombre de lignes : ");
			int largeur = sc.nextInt();
			
			System.out.print("Saisissez le nombre de colonnes : ");
			int hauteur = sc.nextInt();
			
			Morpion morpion = new Morpion(largeur, hauteur);
			morpion.afficherGrille();
			boolean partieFinie = false;
			while (!partieFinie) {
				partieFinie = morpion.jouerCoup();
				morpion.afficherGrille();
			}
			//Partie nulle
			if (!morpion.isGagnant()) {
				System.out.println("Partie nulle");
			}
		} else {
			TicTacToe ticTacToe = new TicTacToe();
			ticTacToe.afficherGrille();
		}
	}

}
