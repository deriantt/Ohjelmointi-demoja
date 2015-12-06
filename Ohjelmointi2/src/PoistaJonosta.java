import java.util.*;


public class PoistaJonosta {
	private static final Scanner lukija = new Scanner(System.in);
	/**
	 * @param args
	 * @example
	 * <pre name="test">

	 * </pre>
	 */
	public static void main(String[] args) {
		
		//System.out.println("Anna sana: ");
		//StringBuilder kokosana = new StringBuilder(lukija.nextLine());
		
		//System.out.println("Anna poistettava merkkiyhdistelmä: ");
		//String poisto = new String(lukija.nextLine());
		
		StringBuilder kokosana = new StringBuilder("catcatcat");
		String poisto = ("at");
		
		
		String testipala = ("");
		poistaja(kokosana, poisto, testipala);
		
		
	}
	private static void poistaja(StringBuilder sana, String poisto, String testipala){	 
		
		for(int i=0; i <= sana.length(); i++){
			
			if(sana.length() >= i + 1){
				testipala = sana.substring( i, (i + 2));}
			else{break;}
			//System.out.println(testipala);
			if(testipala.equalsIgnoreCase(poisto)){
				sana = sana.delete(i, (i +2));
				i = 0;
			}
			System.out.println(sana);
		}
	
	}
}
