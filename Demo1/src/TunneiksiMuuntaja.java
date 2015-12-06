
import java.util.Scanner; 
import java.util.Locale;

public class TunneiksiMuuntaja {

	private static Scanner lukija = new Scanner (System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale fi = new Locale("fi", "FI");
		// TODO Auto-generated method stub
		int minuutit; 
		int sekunnit;
		double tunnit; 
		
		System.out.print("Anna minuutit:");
		minuutit = lukija.nextInt();
		
		System.out.print("Anna sekunnit:");
		sekunnit = lukija.nextInt();
		
		tunnit = (minuutit + sekunnit/60.0)/60;
		
		System.out.print(minuutit+" minuuttia ja " +sekunnit+" sekunttia on "+ tunnit+" tuntia.");
		System.out.printf(fi,"\n" +minuutit+" minuuttia ja %d sekunttia on %.2f tuntia.", sekunnit, tunnit);
	}

}
