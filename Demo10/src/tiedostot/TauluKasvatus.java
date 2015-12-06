package tiedostot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import fi.jyu.mit.ohj2.Mjonot;

public class TauluKasvatus {



		
		/**
		 * Esimerkki dynaamisesta taulukosta Java 1.5:n geneerisyytt‰
		 * ja "autoboxingia" k‰ytt‰en.
		 * @author Vesa Lappalainen @version 1.0, 02.03.2002
		 * @version 1.1, 01.03.2005
		 * @author Santtu Viitanen @version 1.2, 21.07.2011
		 * @param <TYPE> Tyyppi jota talletetaan
		 * @example
		 * <pre name="test">
		 *  #THROWS TaulukkoGen.TaulukkoTaysiException
		 *  TaulukkoGen<Integer> luvut = new TaulukkoGen<Integer>();
		 *  Integer oma = new Integer(7);
		 *  luvut.lisaa(0); luvut.lisaa(2);
		 *  luvut.lisaa(99);  // Tekee oikeasti luvut.lisaa(new Integer(99));
		 *  luvut.lisaa(oma);
		 *  luvut.toString() === "0,2,99,7";
		 *  luvut.set(1,4);
		 *  luvut.set(3,88);
		 *  oma = luvut.get(3);
		 *  luvut.toString() === "0,4,99,88";
		 *  int luku = luvut.get(2);  // oik: luku = (Integer)(luvut.get(2)).intValue();
		 *  luku === 99; 
		 *  luvut.lisaa(4); 
		 *  luvut.lisaa(4); #THROWS TaulukkoGen.TaulukkoTaysiException
		 *  
		 *  TaulukkoGen<String> sanat = new TaulukkoGen<String>(); 
		 *  sanat.lisaa("kissa");
		 *  sanat.lisaa("koira");
		 *  sanat.toString() === "kissa,koira";
		 * </pre>
		 */
		public static class TaulukkoGen<TYPE> {
		    /** Luokka t‰yden taulukon poikkeusta varten  */
		    public static class TaulukkoTaysiException extends Error {
		        private static final long serialVersionUID = 1L;


		        TaulukkoTaysiException(String viesti) {
		            super(viesti);
		        }
		    }

		    private TYPE alkiot[];
		    private int lkm;
		    private static int alkioita = 5;

		    /**
		     * Alustetaan 5 kokoinen taulukko 
		     */
		    public TaulukkoGen() {
		        this(alkioita);
		    }


		    /**
		     * Alustetaan valitun kokoinen taulukko
		     * @param koko taulukon koko
		     */
		    @SuppressWarnings("unchecked")
		    public TaulukkoGen(int koko) {
		        alkiot = (TYPE[]) new Object[koko];
		        
		    }

		    
		    /**
		     * Lis‰t‰‰n taulukkon uusi alkio
		     * @param alkio lis‰tt‰v‰n alkion viite
		     * @throws TaulukkoTaysiException jos taulukko jo t‰ysi
		     */
		    public void lisaa(TYPE alkio) throws TaulukkoTaysiException {
		        if (lkm >= alkiot.length){
		        	kasvata();}
		        //throw new TaulukkoTaysiException("Tila loppu");
		        alkiot[lkm++] = alkio;

		    }
		    

		    /**
		     * Tehd‰‰n taulukosta suurempi
		     */
		    private void kasvata() {
				// Tuplaa taulukon koon
				alkiot = Arrays.copyOf(alkiot, alkiot.length * 2);
			}


			@Override
		    public String toString() {
		        StringBuilder s = new StringBuilder("");
		        String erotin = "";
		        for (int i = 0; i < lkm; i++) {
		            s.append(erotin + alkiot[i]);
		            erotin = ",";
		        }
		        return s.toString();
		    }


		    /**
		     * Muutetaan paikan i arvo
		     * @param i mihin paikkaa asetetaan
		     * @param alkio uuden alkion viite
		     * @throws IndexOutOfBoundsException jos indeksiv‰‰rin
		     */
		    public void set(int i, TYPE alkio) throws IndexOutOfBoundsException {
		        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
		        alkiot[i] = alkio;
		    }


		    /**
		     * Paikassa i olevan alkion viite
		     * @param i mist‰ paikasta
		     * @return paikassa i oleva viite
		     * @throws IndexOutOfBoundsException jos indeksi v‰‰rin
		     */
		    public TYPE get(int i) throws IndexOutOfBoundsException {
		        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
		        return alkiot[i];
		    }
		    
		    
		    /**
		     * Testataan taulukkoa
		     * @param args ei k‰ytˆss‰
		     * @throws TaulukkoTaysiException jos ei mahu
		     */
		    public static void main(String[] args) throws  TaulukkoTaysiException {
		    	
		        TaulukkoGen<Integer> luvut = new TaulukkoGen<Integer>();
		        
		        luvut.lisaa(0);
		        luvut.lisaa(1);
		        luvut.lisaa(2);// Tekee oikeasti luvut.lisaa(new Integer(99));
		        luvut.lisaa(3);
		        luvut.lisaa(4);
		        luvut.lisaa(5);
		        luvut.lisaa(6);
		        luvut.lisaa(7);
		        
		        System.out.println(luvut);
		        luvut.set(1, 4);
		        System.out.println(luvut);
		        int luku = luvut.get(2); // oik: luku = luvut.get(2).intValue();
		        System.out.println("Paikassa 2 on " + luku);
		        try {
		            luvut.set(21, 4);
		        } catch (IndexOutOfBoundsException e) {
		            System.out.println("Virhe: " + e.getMessage());
		        }
		        
		        TaulukkoGen<String> jonot = new TaulukkoGen<String>();
		        jonot.lisaa("kissa");
		        jonot.lisaa("kana");
		        jonot.lisaa("koira");
		        System.out.println(jonot);
		        
		        }
		        
		        
		    }



		}


