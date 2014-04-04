import java.util.Scanner;

/**
 * PRNG = pseudorandom number generator
 * Generateur de nombres pseudo-aleatoires
 * 
 * <strong>Algorithme de Von Neumann :</strong>
 * 1. Choisir un nombre arbitrairement
 * 2. L'elever au carre
 * 3. Puis prendre une partie de ce nombre
 * 		=> ce sera le nombre pseudo-aleatoire genere
 * 4. Effectuer 2. et 3. a partir du nombre genere
 * 5. Recommencer autant de fois que la periode 
 * 		du <em>middle-square</em> le permet 
 * 
 * @author Antoine De Gieter
 * @see Math.pow()
 * @voc middle-square: morceau du carre utilise comme nombre pseudo aleatoire
 *
 */
public class VonNeumann {
	public static Scanner scanner = new Scanner(System.in);
	
	/*
	 * CONFIGURATION
	 */
	public static final int START = 4673; /* Nombre de depart (choisi arbitrairement) */
	public static final int INDEX_ST = 2; /* Index de la position du premier chiffre du nombre aleatoire */
	public static final int LENGTH = 4; /* Taille du nombre aleatoire */
	public static final int POWER = 2; /* Puissance a laquelle le nombre est eleve */
	
	public static void main(String[] args) {
		System.out.println("Generation de nombres pseudo aleatoires");
		System.out.println("\t- selon la methode John Von Neumann");
		
		int number = START, square;
		char c = '0';
		String numberStr, squareStr;

		/*
		 * Boucle de generation des nombres pseudo-aleatoires
		 */
		do {
			/*
			 * Calcul du carre du dernier nombre
			 */
			square = (int) Math.pow(number, POWER);
			
			/*
			 * Utilisation d'un objet de type java.lang.String
			 * intermediaire representant le nombre sous forme
			 * d'une chaine de caracteres, afin de faciliter la
			 * recuperation du <em>middle-square</em>
			 */
			squareStr = "" + square;
			
			/*
			 * Gestion de l'exception si la chaine de caracteres
			 * est trop petite pour les index donnes
			 * 
			 * Generalement cela se traduit par un nombre 0 genere
			 * causant une generation de 0 infinie (0^2 = 0)
			 * 
			 * Cela definit la fin de la periode
			 */
			try {
				numberStr = squareStr.substring(INDEX_ST, INDEX_ST + LENGTH);
			} catch(StringIndexOutOfBoundsException e) {
				/*
				 * Affichage d'un message d'erreur
				 */
				System.err.println("/!\\ Fin de la periode.");
				numberStr = "" + START;
			}
			number = Integer.parseInt(numberStr);
			
			/*
			 * Affichage du nombre genere
			 */
			System.out.println("Nombre genere: " + number);

			/*
			 * Proposition pour arreter la boucle
			 * repondre 'y' ou 'Y'
			 */
			System.out.print("Stop [y - N]? ");
			c = (scanner.next() + " ").charAt(0);
		} while('y' != c && 'Y' != c);
	}
}
