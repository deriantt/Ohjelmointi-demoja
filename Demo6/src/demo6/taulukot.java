package demo6;

public class taulukot {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        /*ta,he,ma,hu,to,ke,he,el,sy,lo,ma,jo*/
		int kPituudet[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		pienimmanPaikka(kPituudet);
		 int i = pienimmanPaikka(kPituudet); /* => i=1 */
		 System.out.println("Pienin kuukausi on " + i + ":s kuukausi");
	}
	/**
	 * Aliohjelma etsim‰‰n taulukon pienin arvo
	 * @param kPituudet taulukko josta pienin etsit‰‰n
	 * @return
	 * @example
	 * <pre name="test">
	 * int kPituudet[] = {31,27,31,30,31,30,31,31,30,31,30,31};
	 * pienimm‰nPaikka(int[] kPituudet; === 27; 
	 * </pre>
	 */
	public static int pienimmanPaikka(int[] a){
		int pienin = 0;
		for(int i=0; i < a.length - 1; i++){
		if(i == 0)pienin = a[i];
		if(a[i] < pienin){
			pienin = a[i];
		    }

	}
		return pienin;
	}
}
