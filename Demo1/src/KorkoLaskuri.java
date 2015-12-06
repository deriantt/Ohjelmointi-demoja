import java.util.Scanner;
import java.util.Locale;

public class KorkoLaskuri {

	private static Scanner lukija = new Scanner (System.in);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale fi = new Locale("fi", "FI");
		// TODO Auto-generated method stub
		double p‰‰oma;
		double korko;
		double rahaa;
		
		System.out.print("P‰‰omasi on :");
		p‰‰oma = lukija.nextDouble();
		
		System.out.print("Korkoprosenttisi on :");
		korko = lukija.nextDouble();

		rahaa = korkoLaskuriCode(p‰‰oma, korko);		

		System.out.printf(fi, +p‰‰oma+":n euron p‰‰omalla ja "+korko+" korkoprosentilla p‰‰omasi tulee olemaan %.2f euron arvoinen vuoden kuluttua.",rahaa );
	}
	public static double korkoLaskuriCode (double p‰‰oma, double korko){
		double rahaa;
		rahaa = p‰‰oma *(1+(korko/100));
		return rahaa;
	}

}
