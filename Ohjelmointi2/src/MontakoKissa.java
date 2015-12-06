import java.util.Scanner;
import java.util.*;

public class MontakoKissa {

	/**
	 * @param args
	 * 
	 * Teht‰v‰ B4, sanojen lukum‰‰r‰
	 * Ohjlema joka laskee syˆtetyst‰ rivist‰ kissa sanojen m‰‰r‰n ja
	 * tulostaa lasketun tuloksen
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   String rivi=""; 
		   System.out.print("Anna rivi >");
		   Scanner lukija = new java.util.Scanner(System.in);
		   rivi = lukija.nextLine();
		   
		   int kissoja = laskeRivinKissat(rivi);
		   
		   System.out.println("Rivill‰ oli " + kissoja + " kissa sanaa.");
		   

	}
	
	public static int laskeRivinKissat(String rivi){
	// Aliohjelma laskee kissa sanojen m‰‰r‰n p‰‰ohjelman antamasta rivist‰
		int kissojaOn = 0;
		String kissaSana = "kissa";
		StringTokenizer erotaSanat = new StringTokenizer(rivi," ,");
		
		while(erotaSanat.hasMoreTokens()){
			
			String tutkiSana = erotaSanat.nextToken();
			
			if (tutkiSana.equals(kissaSana)){
				kissojaOn++;
			}
		}
		
		return kissojaOn;
	}
}


