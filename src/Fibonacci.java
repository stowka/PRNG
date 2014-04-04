import java.util.Scanner;

/**
 * PRNG = pseudorandom number generator
 * Generateur de nombres pseudo-aleatoires
 * 
 * <strong>Suite de Fibonacci :</strong>
 * Definie par :
 * 		X(n) = X(n-1) + X(n-2)
 * 
 * La methode de generation de nombres pseudo aleatoires
 * avec la suite de Fibonacci reprend le meme principe en y ajoutant
 * un modulo permettant d'eviter la croissance des nombres
 * et limitant les nombres generes a un maximum egal au modulo - 1.
 * 
 * @author Antoine De Gieter
 *
 */
public class Fibonacci {
	public static Scanner scanner = new Scanner(System.in);
	
	/*
	 * CONFIGURATION 
	 */
	public static final int X0 = 1; /* indice 0 de la suite de Fibonacci */
	public static final int X1 = 2; /* indice 1 de la suite de Fibonacci */
	public static final int M = 97; /* modulo (valeur maximale + 1) */
	
	public static void main(String[] args) {
		System.out.println("Generation de nombres pseudo aleatoires");
		System.out.println("\t- selon la methode Fibonacci");
		
		char c = '0';
		
		int x0 = X0;
		int x1 = X1;
		int m = M;
		
		/*
		 * x2 variera entre 0 et m - 1
		 */
		int x2 = (x0 + x1) % m;
		
		/*
		 * Autre solution avec x2 
		 * variant entre 1 et m :
		 * 
		 * int x2 = 1 + ((x0 + x1) % m);
		 */
		
		/**
		 * Boucle de generation des nombres pseudo-aleatoires
		 */
		do {
			System.out.println("Nombre genere: " + x2);

			/*
			 * Proposition pour arreter la boucle
			 * repondre 'y' ou 'Y'
			 */
			System.out.print("Stop [y - N]? ");
			c = (scanner.next() + " ").charAt(0);
			
			x0 = x1;
			x1 = x2;
			x2 = (x0 + x1) % m;
			/*
			 * Solution alternative : x2 = 1 + ((x0 + x1) % m);
			 */
		} while('y' != c && 'Y' != c);
	}
}
