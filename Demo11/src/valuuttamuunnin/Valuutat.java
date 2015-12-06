package valuuttamuunnin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Valuutat {

	public static final Scanner lukija = new Scanner(System.in);
	public static String[] valuutat = new String[4]; 
	public static double[] kurssit = new double[4];
	public static double maara = 0.0;
	public static int kurssinIndeksi = 0;
	/**
	 * Kirjoita tekstipohjainen rahanvaihto-ohjelma, jossa on vakiotaulukko

 val.   kur.
+-----+----------+
|mk   |  1.0     |
|$    |  5.7     |
|EUROA|  5.94573 |
|SKr  |  0.6     |
+-----+----------+ 

ja jonka toiminta näyttäisi seuraavalta:

Määrä ja valuutta>10 Skr[RET]
10.00 Skr on 6.00 mk.
Määrä ja valuutta>2 EUROA[RET]
2 EUROA on 11.89 mk.
Määrä ja valuutta>loppu[RET]
Kiitos!

Saa tehdä suoraan myös graafisen version jos haluaa. 
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader fi;
		try {
			 fi = new BufferedReader( new FileReader("Valuutta.txt"));
		} catch (FileNotFoundException ex) {
			
			System.err.println("Tiedosto ei aukea: " + ex.getMessage());
			
			return;
		}
		
		String s;
		try {
			for(int i = 0; i < valuutat.length; i++)
			while((s = fi.readLine()) != null){
				valuutat[i] = s;
			}
		} catch (IOException ex) {
			System.err.println("Virhe luettaessa: " + ex.getMessage());
		}
		kurssit[0] = 1.0;
		kurssit[1] = 5.7;
		kurssit[2] = 5.94573;
		kurssit[3] = 0.6;
		
		//valuutat = { "mk", "$", "EUROA", "SKr"};
		
		System.out.println("Määrä ja valuutta> ");
		String syotto = lukija.nextLine();
		if(syotto.equals("loppu"))System.out.println("Kiitos!");
		String valuutta = haeValuutta(syotto);
		maara = haeKurssi(syotto);
		double arvo = vertaa(valuutta);
		
		System.out.println(maara + valuutta + " on " + arvo + " mk.");

	}
	private static double vertaa(String valuutta) {
		
		double tulos = maara * kurssit[kurssinIndeksi];
		System.out.println(kurssinIndeksi);
		return tulos;
	}
	private static double haeKurssi(String syotto) {
		double takas = 0;
		String raha;
		
		for(int i = 0; i < syotto.length(); i++){
			String vali = syotto.substring(i, (i +1));
			if(vali.equals(" ")){
				raha = syotto.substring(0, i);
				takas = StringToDouble(raha);
			}
		}
		return takas;
	}
	
	private static String haeValuutta(String syotto) {
		String valuutta = syotto;
		
		for(int i = 0; i < syotto.length(); i++){
			
			String vali = syotto.substring(i, (i +1));
			if(vali.equals(" ")){
				valuutta = syotto.substring(i, syotto.length());
				break;

				}
		}
					for(int a = 0; a < valuutat.length; a++ ){
					if(syotto.equalsIgnoreCase(valuutat[a]));
					
					kurssinIndeksi = a;
		}
		return valuutta;
	}

	private static double StringToDouble(String num){ 	
		double d = Double.parseDouble(num);
		  return d;
		}
}

