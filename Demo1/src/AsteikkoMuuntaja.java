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
		
		double Celsius�;
		double Fahrenheit�;
		
		System.out.print("Aseta Fahrenheit� :");
		Fahrenheit� = lukija.nextDouble();
		
		Celsius� = asteikkoMuuntajaCode(Fahrenheit�);
		
		System.out.printf(fi, +Fahrenheit�+ " astetta Fahrenheit� on %.2f Celsiuksina",Celsius�);
		
		
		

	}
	public static double asteikkoMuuntajaCode(double Fahrenheit�){
		double Celsius�;
		Celsius� = (5./9)*(Fahrenheit� - 32);
		return Celsius�;
	}

}
