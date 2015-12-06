
import java.util.Scanner;

public class Ohj1Luento {
	
	private static final Scanner lukija = new Scanner (System.in);

	public static void main(String[] args) {


		int kanta;
		int korkeus;
		double ala;
		
		// kanta = 5;
		// korkeus = 3;

		System.out.println("Laske kolmion aloja annetuista kokonaisluvuista ");
		int kierros = 1;
		while(kierros <= 3 ) {
		
		System.out.println("Anna kanta: ");
		kanta = lukija.nextInt();
		System.out.println("Anna korkeus: ");
		korkeus = lukija.nextInt();
		
		if ( (kanta> 0) && (korkeus > 0)) {
		
		ala = ohj1LuentoAliohj(kanta, korkeus);
		System.out.println("Kolmion pinta-ala on " + ala);

		kierros++;
		}
		else{
		System.out.println("Kanta ja korkeus oltava positiivisiä");

		}
		}
	}
	
	public static double ohj1LuentoAliohj(int kanta, int korkeus) {
	
		//ala = (kanta*korkeus)/2.0;
	double ala;
	ala = (kanta * (double) korkeus) / 2;
	return ala;
	}
}
