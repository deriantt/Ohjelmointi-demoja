
public class KirjeenHinta {

	/**
	 * @param args
	 */
	
	/**
	 * @param rahaa
	 * <pre name="test">
	 * suurinKirjeenPaino(2.00) ~~~ 250.0;
	 * </pre>
	 */
	public static double suurinKirjeenPaino(double rahaa){
		if (rahaa >= 5.50) return 2000;
		else if (rahaa >= 3.50) return 1000;
		else if (rahaa >= 2.10) return 500;
		else if (rahaa >= 1.30) return 250;
		else if (rahaa >= 0.90) return 100;
		else if (rahaa >= 0.60) return 50;
		else return 0;
		
	}
	
	/**
	 * @param rahaa
	 * <pre name="test">
	 * suurinKirjeenPainoTaulukolla(3.00) ~~~ 500.0;
	 * </pre>
	 */	
	public static double suurinKirjeenPainoTaulukolla(double rahaa){
		
		double[] hinnat = {0,0,0,0,0};	double[] grammat = {0,0,0,0,0};
		hinnat[4] = 0.60;	grammat[4] = 50.0;
		hinnat[3] = 0.90;	grammat[3] = 100.0;
		hinnat[2] = 1.30;	grammat[2] = 250.0;
		hinnat[1] = 2.10;	grammat[1] = 500.0;
		hinnat[0] = 3.50;	grammat[0] = 1000.0;
		
		for(int i = 0; i < hinnat.length; i ++){
			if(rahaa >= hinnat[i])return grammat[i];
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double rahaa = 2.00;
		System.out.println("Saat " + rahaa + " eurolla " + suurinKirjeenPaino(rahaa) + " grammaa painavan kirjeen lähetettyä");
		
		rahaa = 3.00;
		System.out.println("Saat " + rahaa + " eurolla " + suurinKirjeenPainoTaulukolla(rahaa) + " grammaa painavan kirjeen lähetettyä");
	}

}
