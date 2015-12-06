
public class Demo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int luku1 = laskeSummaWhile();
		//int luku2 = laskeSummaDoWhile();
		int luku3 = laskeSummaFor();
		
		//System.out.println(luku1);
		//System.out.println(luku2);
		System.out.println(luku3);
	}	

	
	private static int laskeSummaFor() {
		
		int summa = 0;
		
		for(int i = 0; i<=1000; i++ ){
		if(i%2 == 1 && i%9 !=0) summa += i;
			
		}
		
		return summa;
		
		
	}
	
	private static int laskeSummaDoWhile() {
		
		int laskuri = 0; int summa = 0;
		
		do{
			if(laskuri%2 ==1 && laskuri%9 !=0 ) summa += laskuri; //summa = summa + laskuri;
			laskuri++;
		}while ( laskuri <=1000);
		
		return summa;
		
		}
	
	private static int laskeSummaWhile() {
		
		int laskuri = 0; int summa = 0;
		
		while( laskuri <= 1000) {
			if(laskuri%2 == 1 && laskuri%9 !=0) summa += laskuri; //summa = summa + laskuri;
			laskuri++;
		}
		
		return summa;
	}
	
	private static int laske
		
		
}