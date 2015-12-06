import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Locale;

public class MyyntiMatriisi {

	/**Oletetaan, ett‰ tavaratalossa on viisi (yleisemmin N) osastoa: Osastot 1-5(N).
        Kunkin osaston kuukausittaiset myynnit on ker‰tty vuoden ajalta.
        Muodosta tavaratalon myyntianalyysi‰ varten 5(N)-rivinen, 12-sarakkeinen
        2-ulotteinen taulukko (matriisi) ja t‰yt‰ taulukko j‰rkevill‰ satunnaisilla
        myyntiluvuilla. (Arvot esim. v‰lill‰ 1500-15000 euroa.)
        Taulukossa siis rivi sis‰lt‰‰ yhden osaston 12 kuukauden myynnit.
        Analysoi sitten t‰t‰ myyntitaulukkoa tekem‰ll‰ metodeja, joilla saadaan
        esimerkiksi
          a) tietyn osaston tietyn kuukauden myynti (tietty yksitt‰inen alkio)
          b) tietyn osaston vuoden kokonaismyynti (tietyn rivin alkioiden rivisumma)
          c) tietyn kuukauden kokonaismyynti (tietyn sarakkeen alkioiden sarakesumma)
          d) tietyn osaston parhaan kuukauden myynti (tietyn rivin alkioiden maksimi)
          e) tietyn kuukauden parhaan myynnin tehnyt osasto (tietyn sarakkeen alkioiden maksimi)
        Jatka viel‰ tekem‰ll‰ metodit, joilla saadaan selville
          f) mink‰ osaston vuosimyynti on paras (rivisummien maksimin haku)
          g) mink‰ kuukauden kokonaismyynti on paras (sarakesummien maksimin haku)
	 * @return 
	 */
	private static final Scanner lukija = new Scanner(System.in);	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		int[][] myynti = new int[5][12];
		for(int i=0 ; i<5 ; i++){
			System.out.println("\n" + "Osasto: " + (1+i));
			for(int j=0 ; j<12 ; j++){
				myynti[i][j] = (int)(Math.random()*15000);
				if(myynti[i][j]<1500)myynti[i][j]=1500;
				System.out.println(" Kuu: " + (j + 1) + " "  + myynti[i][j]);}
	

		
	}

// a) kohta	
		}
	}
					
}

				
		
		
		