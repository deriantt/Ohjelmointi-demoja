import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.Locale;
import java.lang.String;

public class Kokeiluja {
	Locale fin = new Locale("fi", "FI");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

int[] luvut;



// Luodaan kokonaislukutaulukko
							// jonka koko on 7 alkiota

luvut = new int [7];

luvut[0] = 1;
luvut[2] = 15;
int[] taulu;
taulu = luvut;
taulu[3] = 12;
luvut[5] = -luvut[0];
int arvo = luvut.length;

//for (int i=0; i<luvut.length; i++);{
	System.out.println("Testi: " + luvut[0]);
//}


System.out.println("Lukuja on: " + arvo);
System.out.println();
/**
String[] mjonot = new String[5];{

mjonot[0] = "Kukka";
mjonot[2] = "Kakku";
mjonot[4] = "Kukkia";
mjonot[1] = mjonot[0];
mjonot[2] = null;
*/
int [] lukuja = {10, 4, 5, 7};
for (int i=0; i<lukuja.length; i++){
	System.out.println("Luku indeksissä " + i + " on " +  lukuja[i]);
	
int summa = 0;
for (int luku : lukuja)
	summa += luku;


int suurin = Math.max(lukuja[0], lukuja[1]);
System.out.println("Suurempi " + suurin);
}

if ( lukuja == taulu ) System.out.println("Viittaavat samaan! ");
else System.out.println("Ei viittaa samaan");

}




public static void tulostaLuvut(lukuja){
	if (luvut == null) return;
	for (int i=0; i<luvut.length; i++);
	 System.out.println("Indeksissä " + i + "on " + luvut[i]);
int[] lukuja = {2,4,5,6,78};
tulostaLuvut(lukuja);
}

}

}



