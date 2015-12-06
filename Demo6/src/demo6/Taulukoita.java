package demo6;

public class Taulukoita {


	/**
	 * 
	 * @param a
	 * @return pienin arvo
	 * @example
	 * <pre name="test">
	 * 
	 * </pre>
	 */
	public static int pienin(int[]a){
		int i = 0;
		int pienin = a[i];
		for(i = 0; i < a.length; i++){
			if(a[i] < pienin)pienin = a[i];
		}
		
		return pienin;
	}
	
	/**
	 * 
	 * @param a
	 * @return pienimmän alkion paikka
	 * @example
	 * <pre name="test">
	 * int a[1,2,3,4]; pienimmanpaikka(a) === 0;
	 * </pre>
	 */
	public static int pienimmanPaikka(int[]a){
			int i = 0;
			int pienimmanpaikka = i;
			for(i = 0; i < a.length; i++){
				if(a[i] < a [pienimmanpaikka])pienimmanpaikka = i;
			}
			
			return pienimmanpaikka;
	}
	
	public static void main (String[] args){
		
        /*ta,he,ma,hu,to,ke,he,el,sy,lo,ma,jo*/
	    int kPituudet[] = {31,28,31,30,31,30,31,31,30,31,30,31};

	    int i = pienimmanPaikka(kPituudet); /* => i=1 */
	    int n = pienin(kPituudet);         // => n = 28 
	    
	    System.out.println("Taulukon pienimmän paikka: " + i);
	    System.out.println("Taulukon pienin: " + n);
	}

}


