import java.util.Scanner;
import java.util.*;

public class JokeriMerkki {
	private static final Scanner lukija = new Scanner(System.in);

	/**Kirjoita algoritmi joka tarkistaa onko merkkijono sama kuin kysymysmerkkej‰ sis‰lt‰v‰ merkkijono 
	 * (? = mik‰ merkki vaan). Kysymysmerkki tarkoittaa siis mit‰ tahansa yht‰ merkki‰. 
	 * TDD: keksi lis‰‰ erilaisia testattavia asioita.

 		jono        maski
		"Kissa"     "K?ss?"    => samat
		"Kiss"      "K?ss?"    => ei samat
		"Kissa"     "Kassa"    => ei samat

	 * @param args
	 */
	public static void main(String[] args) {

		//1. Pyyd‰ k‰ytt‰j‰lt‰ sana ja nime‰ se "ekasana".
		System.out.println("Anna sana: ");
		String ekasana = lukija.nextLine();

		//2. Pyyd‰ toinen sana ja nime‰ se "tokasana".
		System.out.println("Anna toinen sana: ");
		String tokasana = lukija.nextLine();
		
		if ( onkoSamatKys(ekasana,tokasana) ){
			System.out.println("Sama sana.");
		}
		//if ( onkoSamatKys("Kissa","K?ss?") ){
			
		//	System.out.println("Sama sana.");
		//}
		

	}
	public static boolean onkoSamatKys(String jono, String maski){
		
		int ekasanamaara = jono.length();
		int laskuri = 0;
		
		//3.Jos ekasana ja tokasana ovat yht‰ pitk‰t niin toimi seuraavasti
		//		1. k‰y ekasana:n kirjaimet l‰pi ja vertaa niit‰ tokasana:n kirjaimiin
		if(jono.length() == maski.length()){
		
			//System.out.println("Sanat on saman pitusia");
			//	1.Jos samat tai sama kuin "?", niin lis‰‰ laskuriin yksi
			//	2. Jos ei niin tulosta "ei ole sama sana".
			for(int i = 0; i < jono.length(); i++){
				
				
				char a = Character.toLowerCase(maski.charAt(i));
				char b = Character.toLowerCase(jono.charAt(i));
				char c = ('?');
				if(a == b || a== c){
					
					laskuri++;
					
					
				}

				else{
					
					System.out.println("Ei ole sama sana.");
					return false;
					}
			//	2. Jos laskurin arvo on yht‰ kuin ekasanan kirjaiten arvo niin
			//	   tulosta "sama sana".
				if (laskuri == ekasanamaara){
				//System.out.println("Sama sana.");
					return true;
				}
		}
		
	}
		//4. Jos ei saman pituisia niin tulosta "Ei ole sama sana".
		else{
			System.out.println("Ei ole sama sana.");
			return false;
			
			}
		
		return true;
		
		
		
	}
	}

