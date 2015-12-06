package tiedostot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;


public class TietRivTulostus {

	/**
	 * Tulostaa vain rivit jossa ** alussa
	 * @param args
	 * @example
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * String tiednimi = "koe.txt";
     * main(new String[]{tiednimi});
	 *
     * </pre>
     */
	public static void main(String[] args) {
		String testitiedosto = "koe.txt";
		tulostaTiedosto(testitiedosto, System.out);
		
	}
	
	public static void tulostaTiedosto(String tiedosto, PrintStream out){
		
		BufferedReader lukija;
		
		try {
			 lukija = new BufferedReader( new FileReader("koe.txt"));
		} catch (FileNotFoundException ex) {
			System.err.println("Tiedosto ei aukea: " + ex.getMessage());
			return;
		}

		String s;
		
		try {
			while((s = lukija.readLine()) != null){
				
				
			try{
				StringBuilder rivi = new StringBuilder(s);
				if(rivi.length()> 40){
					rivi.delete(40, rivi.length());
				}
				s = rivi.toString();
				String test = s.substring(0,2);
				if (test.equalsIgnoreCase("**")){
				System.out.println(s);
				}
			  
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
			// Jos ei sulkeudu, tämä teksti tulostuu
			System.err.println("Ongelmia suljettaessa: " + ex.getMessage());
		}
	}
		

	}
	


	}


