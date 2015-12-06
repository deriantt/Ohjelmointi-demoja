import java.util.Scanner;

public class TenttiHarjoitusta {

	private static Scanner lukija = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println("Anna kaksi lukua: ");
		int a = lukija.nextInt();
		int b = lukija.nextInt();
		
		if (a==b){
			System.out.println("Annoit kaksi samaa lukua");
		}
		if (a<b){
			System.out.println("Eka luku oli pienempi");
		}
	
	
		
	}

}
