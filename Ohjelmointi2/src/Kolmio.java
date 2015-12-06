
public class Kolmio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a = 2.0; // kateettien pituudet
		double b = 3.0;
		double hyp = kolmionHypotenuusa(a, b);
		double ala = kolmionAla(a, b);
	
	}
	/**
	 *Palauttaa suorakulmaisen kolmion pituuden
	 *paremetreina keteettien pituudet 
	 * @param a
	 * @param b
	 * @return
	 * @example
	 * <pre name="test">
	 * #TOLERANCE=0.01
	 * Kolmio.kolmionHypotenuusa(3 ,2) ~~~ 3.60;
	 * Kolmio.kolmionHypotenuusa(4 ,3) ~~~ 5.00;
	 * </pre>
	 */
	
	public static double kolmionHypotenuusa(double a, double b){
		
		double hyppituus = (a * a) + (b * b);
		hyppituus = Math.sqrt(hyppituus);
		
		return hyppituus;
	}
	/**
	 *Palauttaa suorakulmaisen kolmion pinta-alan
	 *paremetreina keteettien pituudet 
	 * @param a
	 * @param b
	 * @return
	 * @example
	 * <pre name="test">
	 * #TOLERANCE=0.01
	 * Kolmio.kolmionAla(3 ,2) ~~~ 3.0;
	 * Kolmio.kolmionAla(4 ,3) ~~~ 6.0;
	 * </pre>
	 */
	public static double kolmionAla(double a, double b){
		
		double alamaara = 0.5 * (a * b);
		
		return alamaara;
	}

}
