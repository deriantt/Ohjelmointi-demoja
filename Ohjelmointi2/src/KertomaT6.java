import java.util.Scanner;

public class KertomaT6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Minkä luvun haluut kertoa?");
		Scanner lukija = new java.util.Scanner(System.in);
		int b = lukija.nextInt();
		
		int a = 1;
		//int b = 10;
		
		doWhileSilmukalla(a, b);
		whileSilmukalla(a, b);
	}		
		public static void doWhileSilmukalla(int a, int b){
			
			int kertoma = a;
			do{
				
				kertoma = kertoma * a;
				a++;
			  }
			while(a <= b);
			
		System.out.println(kertoma);
			
		}
		public static void whileSilmukalla(int a, int b){
			
			int kertoma = a;
			while(a <= b){
				kertoma = kertoma * a;
				a++;
				}
			System.out.println(kertoma);
			
		}
	}

