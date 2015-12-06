import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class MyyntiAnalyysi {

	private static final int ALIN = 1500; //Pienin myynti
	private static final int YLIN = 15000; //Suurin myynti
	private static final int OSASTO_LKM = 5; // Osastojen lukum‰‰r‰
	
	private static final Scanner lukija = new Scanner(System.in);
	private static Locale loc = new Locale("fi", "FI");
	private static Random rand = new Random();
	
	
	
	public static void main(String[] args) {
		//Myyntimatriisin teko ja perustietojen tulostus
		
		double[][] myyntiMatriisi = teeVuosiMyyntiMatriisi();
		System.out.println("---------------------------------------------------------");
		System.out.println("---Vuosimyynnin perusmatriisi---");
		tulostaMatriisi(myyntiMatriisi);
		System.out.println("---------------------------------------------------------");
		tulostaOsastojenVuosiMyynnit(myyntiMatriisi);
		System.out.println("---------------------------------------------------------");
		tulostaKuukausiMyynnit(myyntiMatriisi);
		System.out.println("---------------------------------------------------------");
		
		//---a) Tietyn osaston tietyn kuukauden myynti-------
		System.out.print("Mink‰ osaston 1-" + OSASTO_LKM + " kuukauden myynnist‰ haluat tietoja?");
		int osastoNumero = lukija.nextInt();
		System.out.println ("Mink‰ kuukauden 1-12 myynnin haluat tiet‰‰?");
		int kuukausi = lukija.nextInt();
		System.out.printf(loc, "Osaston %d kuukauden %d myynti on %.2f%n",
				osastoNumero, kuukausi, haeOsastonKuukausimyynti(myyntiMatriisi, osastoNumero, kuukausi));
		System.out.println("---------------------------------------------------------");
		
		//---b) Tietyn osaston kokonaismyynti (rivisumma)
		System.out.println("Mink‰ osaston 1-" + OSASTO_LKM + " vuosimyynnin haluat tiet‰‰?");
		osastoNumero = lukija.nextInt();
		System.out.printf(loc, "Osaston %d vuosimyynti on %2f%n", osastoNumero, haeOsastonVuosimyynti(myyntiMatriisi, osastoNumero));
		System.out.println("---------------------------------------------------------");
		
		//---c) Tietyn kuukauden kokonaismyynti sarakesumma)
		System.out.println("Mink‰ kuukauden kokonaismyynnist‰ haluat tietoa?");
		kuukausi = lukija.nextInt();
		System.out.printf("Kuukauden %d kokonaismyynti on %.2f%n", kuukausi, haeSarakeSumma(myyntiMatriisi, kuukausi-1));
		System.out.println("--------------------------------------------------------");
		
		//---d) Tietyn osaston parhaan kuukauden myynti (rivin maksimi)
		
		System.out.println("Mink‰ osaston 1-" + OSASTO_LKM + " parhaan kuukauden myynnin haluat tiet‰‰?");
		osastoNumero = lukija.nextInt();
		kuukausi = haeSuurimmanIndeksiRivilt‰ (myyntiMatriisi, osastoNumero - 1);
		System.out.printf(loc, "Osaston %d parhaan kuukauden %d myynti on %.2f%n", kuukausi, osastoNumero + 1, myyntiMatriisi[osastoNumero - 1][kuukausi] );
		System.out.println("--------------------------------------------------------");
		
		
		//---e) Tietyn kuukauden parhaan tuloksen tehnyt osasto (sarakkeen maksimi)
		System.out.println("Mink‰ kuun 1-12 parhaan tuloksen omaavan osaston haluat selvitt‰‰? ");
		kuukausi = lukija.nextInt();
		osastoNumero = haeSuurimmanIndeksiSarakkeesta(myyntiMatriisi, kuukausi-1);
		System.out.printf(loc, "Kuun %d parhaan tuloksen teki osasto %d myynnill‰ %.2f%n",
				kuukausi, osastoNumero + 1, myyntiMatriisi[kuukausi - 1][osastoNumero]);
		System.out.println("--------------------------------------------------------");
		
		
		//---f) Mink‰ osaston vuosimyynti on paras (rivisummien maksimi)
		int parhaanRiviIndeksi = haeSuurinRiviSumma(myyntiMatriisi);
		System.out.printf(loc, "Suurin vuosimyynti %.2f%n on osastolla %d%n",
				haeRiviSumma(myyntiMatriisi[parhaanRiviIndeksi]), parhaanRiviIndeksi+1);
		System.out.println("---------------------------------------------------------");
		
		//---g) Mink‰ kuukauden kokonaismyynti on paras ( sarakasummien maksimi)
		int parhaanSarakkeenIndeksi = haeSuurinSarakeSumma(myyntiMatriisi);
		System.out.printf(loc, "Paras kokonaismyynti on kuukaudella %d%n kokonaismyynnill‰ %.2f",
				haeSarakeSumma(myyntiMatriisi, parhaanSarakkeenIndeksi), parhaanSarakkeenIndeksi+1);
		System.out.println("---------------------------------------------------------");
		
}
	
	//---a)=====================================================================================
	// Tietyn osaston tietyn kuukauden myynti ( tietyn rivin tietyn sarakkeen arvo)
	public static double haeOsastonKuukausimyynti(double[][] a, int osasto, int kuukausi){
		return a [osasto - 1][kuukausi-1];
	}
	
	//---b)=====================================================================================
	//Tietyn osaston vuoden kokonaismyynti (tietyn rivin rivisumma)
	public static double haeOsastonVuosimyynti(double[][] a, int osasto){
		return haeRiviSumma(a[osasto - 1]);
	}
	
	//---c)===================================================================================== 
	//Tietyn kuukauden kokonaismyynti (tietyn sarakkeen sarakesumma)
	public static double haeKuukaudenKokonaismyynti(double[][] a, int kuu){
		return haeSarakeSumma(a, kuu);
	}
	
	//d)=======================================================================================
	//Tietyn osaston parhaan kuukauden myynti (tietyn rivin maksimiarvon sarakeindeksi)
	public static int haeSuurimmanIndeksiRivilt‰(double[][] a, int i){
		double suurin = a[i][0];
		int suurimmanIndeksi = 0;
		for (int j = 1; j< a[i].length; j++){
			if (a[i][j] > suurin){
				suurin = a[i][j];
				suurimmanIndeksi = j;
			}
		}
		return suurimmanIndeksi;
		
	}
	
	//e)=========================================================================================
	//Tietyn kuukauden parhaan myynnin tehnyt osasto (tietyn sarakkeen maksimiarvon rivi-indeksi)
	public static int haeSuurimmanIndeksiSarakkeesta(double[][]a, int j){
		double suurin = a[0][j];
		int suurimmanIndeksi = 0;
		for (int i= 1; i< a.length; i++){
			if (a[i][j] > suurin){
				suurin = a[i][j];
				suurimmanIndeksi = i;
			}
		}
		return suurimmanIndeksi;
	}
	
	
	//f)============================================================================================0
	//T‰ll‰ metodiparilla voidaan hakea suurimman vuosimyynnin osasto
	
	public static int haeSuurinRiviSumma (double[][] a){
		double suurinSumma = haeRiviSumma(a[0]);
		int suurimmanIndeksi = 0;
		for (int i = 1; i < a.length; i++){
			double summa = haeRiviSumma(a[i]);
			if (summa > suurinSumma){
				suurinSumma = summa;
				suurimmanIndeksi = i;
			}
		}
		return suurimmanIndeksi;
	}
	
	public static double haeRiviSumma(double[] a){
		double summa = 0.0;
		for (int i=0; i< a.length; i++)
			summa += a[i];
		return summa;
	}
	
	//=========================================================================================0
	//g) T‰ll‰ metodilla voidaan hakea suurimman kuukausimyynnin.
	
	public static int haeSuurinSarakeSumma(double[][]a){
		double suurinSumma = haeSarakeSumma(a, 0);
		int suurimmanIndeksi = 0;
		for (int j = 1; j< a[0].length; j++){
			double summa = haeSarakeSumma(a, j);
			if (summa > suurinSumma){
				suurinSumma = summa;
				suurimmanIndeksi = j;
			}
		}
		return suurimmanIndeksi;
	}
	
	public static double haeSarakeSumma(double[][] a, int j){
		double summa = 0.0;
		for (int i = 0; i < a.length; i++){
			summa = summa + a [i][j];
		}
		return summa;
	}
	
	

//======================================================================================
//N‰m‰ metodit muodostavat myyntimatriisin ja t‰ytt‰v‰t sen satunnaisluvuilla
//T‰m‰ metodi t‰ytt‰‰ matriisin kutsumalla toistossaan rivin t‰ytt‰v‰‰ metodia
	
public static double[][] teeVuosiMyyntiMatriisi(){
	double[][] myyntiMatriisi = new double [OSASTO_LKM][];
	for (int i = 0; i<OSASTO_LKM; i++)
	myyntiMatriisi[i] = teeOsastonVuosiMyynti();
	return myyntiMatriisi;
}

//T‰m‰ metodi t‰ytt‰‰ rivin kutsumalla toistossaan yksitt‰isen alkion palauttavaa metodia'

public static double[] teeOsastonVuosiMyynti(){
	double[] vuosiMyynti = new double [12];
	for (int i=0; i<12; i++)
	vuosiMyynti[i] = teeKuukausiMyynti();
	return vuosiMyynti;
}

//T‰m‰ metodi tekee yksitt‰isen alkion satunnaislukuna

public static double teeKuukausiMyynti(){
	return (100 * ALIN + rand.nextInt(100 * YLIN + 1 - 100 * ALIN))/100.0;
}

//======================================================================================
// N‰m‰ metodit tulostavat myyntimatriisin perustietoja

public static void tulostaMatriisi (double[][] a){
	for (int i=0; i< a.length; i++){
		for (int j=0; j< a[i].length; j++)
			System.out.printf(loc, "%8.2f", a[i][j]);
		System.out.println();
	
	}
}

public static void tulostaOsastojenVuosiMyynnit(double[][]a){
 System.out.println("--- Vuosimyynnit osastoittain ---");
 for (int i=0; i< a.length; i++)
	 System.out.printf(loc, "Osasto %2d %12.2f%n", i + 1,
			 haeRiviSumma(a[i]));
}

public static void tulostaKuukausiMyynnit (double[][]a){
	System.out.println("-- Kuukausimyynnit --");
	for (int j=0; j< a.length; j++)
		System.out.printf(loc, " Kuu %2d %12.2f%n", j +1,
				haeSarakeSumma (a, j));
	
}
//===================================================================================	
	
	
	
	
}
