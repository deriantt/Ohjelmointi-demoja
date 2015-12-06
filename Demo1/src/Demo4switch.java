import java.util.Scanner;



public class Demo4switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner lukija = new Scanner (System.in); 
		
		System.out.println("Lasketaanko 1. C -> F vai 2. F -> C");
		int valinta = lukija.nextInt();
		
		System.out.println("Anna asteluku: ");
		double asteet = lukija.nextDouble();
	
		switch( valinta){
		case 1:
			double c = laskeCelsius(asteet);
			System.out.println("Celsiusta on: " + c);
			break;
			
		case 2:
		    double f = laskeFahrenheit(asteet);
		    System.out.println("Fahrenheit on: " + f);
		    break;
		    
		    
		}
	}		
	private static double laskeCelsius(double asteet) {
	
		double c;
		
		c = (5/9)*(asteet - 32);
		
		return c;
	}
	
	private static double laskeFahrenheit(double asteet){
		
		double f;
		
		f = (9/5)* asteet + 32;
		return f;
		
		
	}
}