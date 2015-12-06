package demo;


public class MatriisinSuurin {

	/**
	 * @param args
	 * @example
	 * <pre name="test">
	 * 
	 * </pre>
	 */
	public static void main(String[] args) {

	 	int[][] taulukko = {{1,2}, {7,4}, {5,6}};
	 	int suurin = matriisinSuurin(taulukko);
	    int summa = Rajat.summa(taulukko);
	 	
	    System.out.println(summa);
	    System.out.println(suurin);
	}
	/**
	 * @param matriisin suurin löydetty arvo
	 * @example
	 * <pre name="test">
	 * matriisinSuurin(int[][] matriisi) = {{1,2}, {7,10}, {5,6}}) === 10;
	 * matriisinSuurin(int[][] matriisi) = {{1,25}, {7,1}, {5,6}}) === 25;
	 * </pre>
	 */
	public static int matriisinSuurin(int[][] matriisi){
		
		int suurin = matriisi[0][0];
		for(int i = 0; i < matriisi.length; i++){
			for(int t = 0; t < 2; t++){
				int apu = matriisi[i][t];
				if(suurin < apu)suurin = apu;
				
			}
		}
		
		return suurin;
	}

}
