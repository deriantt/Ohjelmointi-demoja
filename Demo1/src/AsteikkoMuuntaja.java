import java.util.Locale;
import java.util.Scanner; 



	public class AsteikkoMuuntaja {
	private static Scanner lukija = new Scanner (System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale fi = new Locale("fi", "FI");
		// TODO Auto-generated method stub
		
		double Celsiusº;
		double Fahrenheitº;
		
		System.out.print("Aseta Fahrenheitº :");
		Fahrenheitº = lukija.nextDouble();
		
		Celsiusº = asteikkoMuuntajaCode(Fahrenheitº);
		
		System.out.printf(fi, +Fahrenheitº+ " astetta Fahrenheitº on %.2f Celsiuksina",Celsiusº);
		
		
		

	}
	public static double asteikkoMuuntajaCode(double Fahrenheitº){
		double Celsiusº;
		Celsiusº = (5./9)*(Fahrenheitº - 32);
		return Celsiusº;
	}

}
