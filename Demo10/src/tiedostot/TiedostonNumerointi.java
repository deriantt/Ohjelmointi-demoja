package tiedostot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

public class TiedostonNumerointi {

	/**
	 * Tiedoston numerointiin ja rajoittamiseen tehty luokka
	 * @param args
	 * @example
	 * <pre name="test">
	 * BufferedReader fi;
	 * fi = new BufferedReader( new FileReader("koe3.txt"));
	 * int rivinro = 0;
	 * String s;
	 * s = fi.readLine(0);
	 * StringBuilder rivi = new StringBuilder(s);rivi.charAt(0) === 1;
	 * </pre>
	 */
	public static void main(String[] args) {
		BufferedReader lukija;
		
		
		try {
			 lukija = new BufferedReader( new FileReader("koe.txt"));
			 
		} catch (FileNotFoundException ex) {
			// Jos tiedosto ei aukea
			System.err.println("Tiedosto ei aukea: " + ex.getMessage());
			return;
		}

		double summa = 0;
		int rivinro = 0;
		String s;
		//PrintStream fo = null;
		
		try {
			while((s = lukija.readLine()) != null){
				rivinro++;
				
			try{		
				StringBuilder rivi = new StringBuilder(s);
				
				if(rivi.length()> 40){
					rivi.delete(40, rivi.length());
				}
				
				s = rivi.toString();
				System.out.printf("/* %02d */ %s \n", rivinro, s);

			  
			} catch (NumberFormatException ex){
				// ei noteerata
			}
			}
		} catch (IOException ex) {
			System.err.println("Virhe luettaessa: " + ex.getMessage());
			
		}finally{
			try {
				lukija.close();
			
			} catch (IOException ex) {
			// Jos ei sulkeudu
			System.err.println("Ongelmia suljettaessa: " + ex.getMessage());
		}
	}
		

	}
	}
