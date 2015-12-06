package Tentti;

import java.io.OutputStream;
import java.io.PrintStream;

//import tiedostot.Koulu.Oppilas;

import fi.jyu.mit.ohj2.Mjonot;

public class Ainejarjesto implements Jasen{
		
		public static class Opiskelija{
		private String nimi;
		private Opiskelija seuraava;
		
		public Opiskelija(String nimi){
			this.nimi = nimi;
		}
		
		public String toString(){
			return Mjonot.fmt(nimi,-22);
		}
		}
		private Jasen[] jasenet;
		private Opiskelija ensimmainen;
		private Opiskelija viimeinen;
		private int opiskelijoita;

		public void lisaaJasen(Opiskelija oppilas) {
			  if(opiskelijoita == 0){
				  ensimmainen = oppilas;
				  viimeinen = oppilas;
			  }
			  else{
				  viimeinen.seuraava = oppilas;
				  viimeinen = oppilas;
			  }
			  opiskelijoita++;
		  }
		
		private String ainejarjesto;
		public Ainejarjesto(String ainejarjesto){
			this.ainejarjesto = ainejarjesto;
			}
		
		public void tulosta(OutputStream os)  {
		    PrintStream out = new PrintStream(os);
		    out.println(ainejarjesto);
		    out.println("Jasenia: " + opiskelijoita);
		    Opiskelija tiedot = ensimmainen;
		    int i = 0;
		    while(tiedot != null){
		    	//out.print(i + ":n oppilaan nimi: ");
			   	out.println(tiedot.toString());
			   	tiedot = tiedot.seuraava;
			   	i++;
			   }
		  }
		

	public static void main(String[] args){
		Ainejarjesto Linksutin = new Ainejarjesto("Linksutin");
		Ainejarjesto miinus = new Ainejarjesto("Miinus");
		
		//Piirräkuva tietorakenteesta
		//System.out.println(Linksutin);
		Linksutin.tulosta(System.out);
		
		System.out.println();
		
		Linksutin.lisaaJasen(new Opiskelija("Mikko"));
		Linksutin.lisaaJasen(new Opiskelija("Ansku"));
		Linksutin.lisaaJasen(new Opiskelija("Sauli"));
		Linksutin.lisaaJasen(new Opiskelija("Eetu"));
		//Linksutin.lisaaJasen(miinus);
		
		//Piirrä kuva tietorakenteesta
		//System.out.println(Linksutin);
		Linksutin.tulosta(System.out);
	}

	@Override
	public String annaNimesi() {
		// TODO Auto-generated method stub
		return null;
	}
}

