import java.util.Scanner;

public class Erilukuja {

private static Scanner lukija = new Scanner(System.in);	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		System.out.println("Anna ensimmäinen luku: ");
		int a = lukija.nextInt();
		
		System.out.println("Anna toinen luku: ");
		int b = lukija.nextInt();
		
		System.out.println("Anna kolmas luku: ");
		int c = lukija.nextInt();
		
		int eriLukuja = 1;
		
		if (a != b){
			eriLukuja++;
		}
		
		if (a != c && b != c){
			eriLukuja++;
			}
		System.out.println(" Eri arvoja oli: " +eriLukuja);	
	}

}