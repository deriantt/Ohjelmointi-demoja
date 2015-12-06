package tiedosto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fi.jyu.mit.ohj2.Mjonot;


/**
 * Lukujen lukeminen tiedostosta
 * @author Deniz
 *
 */


public class TiedKa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader fi;
		try {
			 fi = new BufferedReader( new FileReader("luvut.dat"));
		} catch (FileNotFoundException ex) {
			System.out.println("Kissa");
			System.err.println("Tiedosto ei aukea: " + ex.getMessage());
			System.out.println("Kissa");
			return;
		}

		
		double summa = 0;
		int n = 0;
		String s;
		try {
			while((s = fi.readLine()) != null){
			try{
			  double luku = Double.parseDouble(s);
			  summa += luku;
			  n++;
			} catch (NumberFormatException ex){
				// ei noteerata
			}
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.err.println("Virhe luettaessa: " + ex.getMessage());
		}finally{
			try {
				fi.close();
			} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.err.println("Ongelmia suljettaessa: " + ex.getMessage());
		}
		}
		double ka = 0;
		if (n > 0) ka = summa/n;
		System.out.println("Lukuja oli " + n + " kappaletta.");
		System.out.println("Niiden summa oli " + Mjonot.fmt(summa,4,2));
		System.out.println("ja keskiarvo oli " + Mjonot.fmt(ka,4,2));
		
	}

}
