import java.util.Random;



public class TaulukkoEsimerkki {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] taulu = luoSatunnaistaulu(8);
//*		int [] lukuja = luoLis‰‰lukuja (7);
		tulostaTaulu (taulu);
//*		tulostaLukuja (lukuja);

	}
	
	private static void tulostaTaulu (int [] taulu){
		for(int i = 1; i < taulu.length; i++){
			System.out.print(taulu[i] + " ");
		}
	}
/*	private static void tulostaLukuja (int [] lukuja){
		for(int i = 1; i < lukuja.length; i++){
			System.out.println(lukuja[i] + " ");
*/			
	
	

	/**
	 * Luo satunnaislukutaulukon
	 * @param koko Luotavan taulukon koko
	 * @return Satunnaisluvuilla t‰ytetty taulukko
	 * 
	 * 
	 */
	
	private static int [] luoSatunnaistaulu(int koko){
		int [] taulu = new int [koko];
		Random rand = new Random();
		
		for (int i = 0; i < taulu.length; i++){
			taulu[i] = rand.nextInt(39);
			}
		return taulu;
		
		while(kierros < taulu.length) {
			int luku = rand.nextInt();
			if( tarkastaTaulu(taulu, luku)) {
				
			}
		}
	}

private static boolean tarkastaTaulu(int[] taulu, int luku) {
	// TODO Auto-generated method stub
	return false;
}
	
	/**private static int [] luoLis‰‰lukuja(int koko){
		int [] lukuja = new int [koko];
		Random rand = new Random();
		
		for (int i = 0; i < lukuja.length; i++){
			lukuja[i] = rand.nextInt(39);
			}
		return lukuja;
	*/
	}

