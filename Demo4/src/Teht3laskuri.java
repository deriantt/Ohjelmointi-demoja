import java.util.Scanner;

public class Teht3laskuri {
private static Scanner lukija = new Scanner (System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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
		
	}
	
	private static int lukujenVertailu( int luku1, int luku2, int luku3){
	
	int laskuri = 0;
		
	if (luku1%2 == 0) laskuri++; //laskuri = laskuri +1;
	if (luku2%2 == 0) laskuri++;
	if (luku3%2 == 0) laskuri++;
	
	return laskuri;
	 
	}
}
