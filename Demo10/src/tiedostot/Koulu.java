package tiedostot;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.*;
/**
 * Esimerkki linkitetystä listasta,
 * @author Vesa Lappalainen
 * @version 1.0, 15.03.2003
 */
public class Koulu {

  public static class Oppilas {
    private String nimi;
    private double keskiarvo;
    private Oppilas seuraava;
    
    public Oppilas(String nimi, double keskiarvo) {
      this.nimi = nimi; this.keskiarvo = keskiarvo;
    }

    public String toString() {
      return Mjonot.fmt(nimi,-22) + " keskiarvo: " +
                  Mjonot.fmt(keskiarvo,5,2);
    }
  }
  private String luokka;
  private String luokka2;
  private int oppilaita;
  private Oppilas ensimmainen;
  private Oppilas viimeinen;



  public Koulu(String luokka) { this.luokka = luokka;}
  public void lisaa(Oppilas oppilas) {
	  if(oppilaita == 0){
		  ensimmainen = oppilas;
		  viimeinen = oppilas;
	  }
	  else{
		  viimeinen.seuraava = oppilas;
		  viimeinen = oppilas;
	  }
	  oppilaita++;
  }

  public void tulosta(OutputStream os)  {
    PrintStream out = new PrintStream(os);
    out.println("Koulun luokka: " + luokka);
    out.println("Oppilaita: " + oppilaita);
    Oppilas tiedot = ensimmainen;
    int i = 0;
    while(tiedot != null){
    	out.print(i + ":n oppilaan nimi: ");
    	out.println(tiedot.toString());
    	tiedot = tiedot.seuraava;
    	i++;
    }
  }
  
  
/** 
 * Poistaa kaiken
 */
  public void poistaKaikki() {
	  ensimmainen = null;
	  viimeinen = null;
  }
  
  
  /**
   * Kääntää linkitetyn listan
   */
  public void kaanna(){
	   Oppilas eka, toka, apu;
	   if(ensimmainen == null)
	      return;

	   eka = ensimmainen;
	   toka = ensimmainen.seuraava;
	   apu = null;


	   while(toka != null)
	   {
	        eka.seuraava = apu;
	        apu = eka;
	        eka = toka;
	        toka = toka.seuraava;
	   }

	   ensimmainen = eka;
	   ensimmainen.seuraava = apu;
  }

  public static void main(String[] args)  {
    Koulu luokka = new Koulu("1b");

    luokka.lisaa(new Oppilas("Ankka Aku",5.0));
    luokka.lisaa(new Oppilas("Ankka Tupu",7.0));
    luokka.lisaa(new Oppilas("Hiiri Mikki",9.0));

    luokka.tulosta(System.out);// PIIRRÄ KUVA
    System.out.println();
    System.out.println("------------------   Listan Käännös   -----------------------------");
    luokka.kaanna();
    luokka.tulosta(System.out);
    luokka.poistaKaikki();
  }
}