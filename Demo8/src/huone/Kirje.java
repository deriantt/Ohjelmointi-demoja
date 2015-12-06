package huone;

/**
 * Ohjelmalla tutkitaan postimaksun suuruutta
 * @author Deniz Anttila
 * @version 1.0, 3.3.2013
 */
public class Kirje {

    private static int painot[]    = {   50 , 100,  250,  500, 1000, 2000, 0 };
    private static double hinnat[] = { 0.60, 0.90, 1.30, 2.10, 3.50, 5.50, 0 };
    private static Hinta[] hinnatJaPainot = {
    	new Hinta(0.60, 50),
    	new Hinta(0.90, 100),
    	new Hinta(1.30, 250),
    	new Hinta(2.10, 500),
    	new Hinta(3.50, 1000),
    	new Hinta(5.50, 2000),
    	new Hinta(0.0, 0),};
    private static double[][] hinnatJaPainot2Ulot = {
    	{50, 100, 250, 500, 1000, 2000, 0 }, hinnat};

    public static void main(String args[]){
    	
    }
    	/**
    	 * Palauttaa kirjeen hinnan sen painon mukaan
    	 * @param paino
    	 * @return hinta
    	 * @example
    	 * @example
    	 * <pre name="test">
    	 * postimaksu(0) ~~~ 0
    	 * postimaksu(45) ~~~ 0.60
    	 * postimaksu(50) ~~~ 0.60
    	 * postimaksu(60) ~~~ 0.90
    	 * </pre>
    	 */
    	public static double postimaksu(int paino){
    		if(paino <= 0)return 0.0;
    		int i;
    		double hinta = 0;
    		
    		for(i = 0; hinnatJaPainot[i].getPaino() > 0 ; i++){
    			if(hinnatJaPainot[i].getPaino() >= paino){
    				hinta = hinnatJaPainot[i].getHinta();
    				return hinta;
    			}
    		}
    		return hinta;
    	}
    	
    	/**
    	 * Palauttaa kirjeen hinnan sen painon mukaan
    	 * @param paino
    	 * @return hinta
    	 * @example
    	 * <pre name="test">
    	 * postimaksu2Ulot(0) ~~~ 0
    	 * postimaksu2Ulot(45) ~~~ 0.60
    	 * postimaksu2Ulot(50) ~~~ 0.60
    	 * postimaksu2Ulot(60) ~~~ 0.90
    	 * </pre>
    	 */
    	public static double postimaksu2Ulot(int paino){
    		if(paino <= 0)return 0.0;
    		int i;
    		double hinta = 0;
    		
    		for(i = 0; hinnatJaPainot2Ulot[0][i] > 0 ; i++){
    			if(hinnatJaPainot2Ulot[0][i] >= paino){
    				hinta = hinnatJaPainot2Ulot[1][i];
    				return hinta;
    			}
    		}
    		return hinta;
    	}
    	
    
    

    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus if-lauseiden avulla.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     * @example
     * <pre name="test">
     * suurinKirjeenPainoIf($rahaa) ~~~ $paino;
     * 
     *   $rahaa | $paino
     * -------------------
     *    10.00 | 2000
     *     3.60 | 1000
     *     3.50 | 1000
     *     3.40 |  500
     *     0.50 |    0
     * </pre>
     */
    public static int suurinKirjeenPainoIf(double rahaa) {
        if (5.50 <= rahaa) return 2000;
        if (3.50 <= rahaa) return 1000;
        if (2.10 <= rahaa) return 500;
        if (1.30 <= rahaa) return 250;
        if (0.90 <= rahaa) return 100;
        if (0.60 <= rahaa) return 50;
        return 0;
    }


    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus taulukoiden avulla.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     * 
     * @example
     * <pre name="test">
     * suurinKirjeenPaino($rahaa) ~~~ $paino;
     * suurinKirjeenPaino2($rahaa) ~~~ $paino;
     * suurinKirjeenPainoIf($rahaa) ~~~ $paino;
     * 
     *   $rahaa | $paino
     * -------------------
     *    10.00 | 2000
     *     5.50 | 2000
     *     5.49 | 1000
     *     3.50 | 1000
     *     3.49 |  500
     *     2.10 |  500
     *     2.09 |  250  
     *     1.30 |  250
     *     1.29 |  100
     *     0.90 |  100
     *     0.89 |   50
     *     0.60 |   50
     *     0.59 |    0
     *     0.50 |    0
     * </pre>
     */
    public static int suurinKirjeenPaino(double rahaa) {
        int i;
        int paino = 0;

        for (i = hinnat.length - 2; i >= 0; i--)
            if (hinnat[i] <= rahaa) return painot[i];
        return paino;
    }


    /**
     * Palautetaan suurin kirjeen paino, joka voidaan raham‰‰r‰ll‰ l‰hett‰‰<br>
     * Toteutus taulukoiden avulla joissa loppumerkki.
     * @param rahaa k‰ytˆss‰ oleva raham‰‰r‰
     * @return suurin kirjeen paino joka voidaan l‰hett‰‰
     */
    public static int suurinKirjeenPaino2(double rahaa) {
        int i;
        int paino = 0;

        for (i = 0; hinnat[i] > 0; i++)
            if (hinnat[i] <= rahaa) paino = painot[i];
        return paino;
    }
    
}
    /**
     * Hinta olioita
     * @author Deniz
     *
     */
    public static class Hinta {
    	private double hinta;
    	private int paino;
    	
    	public double getHinta(){
    		return this.hinta;
    	}
    	
    	public double getPaino(){
    		return this.paino;
    	}
    	
    	public Hinta(double hinta, int paino){
    		this.hinta = hinta;
    		this.paino =paino;
    	}
    	
    }


