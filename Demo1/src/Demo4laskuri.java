import java.util.Scanner;


public class Demo4laskuri {
	
	public static void main(String[] args){
		Scanner lukija = new Scanner (System.in);
		
				int luku1;
				int luku2;
				int luku3;
				
				
				System.out.print("Anna eka kokonaisluku :");
				luku1 = lukija.nextInt();
				System.out.print("Anna toka kokonaisluku :");
				luku2 = lukija.nextInt();
				System.out.print("Anna kola kokonaisluku :");
				luku3 = lukija.nextInt();
				
				
				int parillisia = lukujenVertailu( luku1, luku2, luku3);
				
				System.out.println("Parillisia oli: " + parillisia);
				
				int positiiviset = positiiviLuku( luku1, luku2, luku3);
				
				System.out.println("Positiivisia oli: " + positiiviset);
				
				int parilPosit = parPos( luku1, luku2, luku3);
				
				System.out.println("Par/Pos määrä: " + parilPosit);
			}
			
			private static int lukujenVertailu( int luku1, int luku2, int luku3){
			
			int laskuri = 0;
				
			if (luku1%2 == 0) laskuri++; //laskuri = laskuri +1;
			if (luku2%2 == 0) laskuri++;
			if (luku3%2 == 0) laskuri++;
			
			return laskuri;
			 
			}
			private static int positiiviLuku( int luku1, int luku2, int luku3){
				
				int laskuri = 0;
			if (luku1 > 0) laskuri++;
			if (luku2 > 0) laskuri++;
			if (luku3 > 0) laskuri++;
			 
			return laskuri;
			
			}
			
			private static int parPos( int luku1, int luku2, int luku3){
				
				int laskuri = 0;
				
				if( luku1%2 ==0 && luku1 > 0) laskuri++;
				if( luku2%2 ==0 && luku2 > 0) laskuri++;
				if( luku3%2 ==0 && luku3 > 0) laskuri++;
		
			return laskuri;
				
			}
		}
