package demo;

//import fi.jyu.mit.ohj2.*;

	/**
	 * Luokkien alut mäkihyppyä varten.
	 * 
	 * @author Deniz Anttila
	 * @version 1.0, 4.03.2012
	 */
	public class MakiHyppy {

//---------------------------------------------------------------------------------------------------------------------------------------------------
	    /**
	     * Luokka yhtä mäkihypyn kierrosta varten
	     */
	    public static class Kierros {
	        private final static int TUOMAREITA = 5;
	        private static double pituus; // hyppyjen pituudet metreinä
	        private final double tuomarit[] = new double[TUOMAREITA];// tuomaripisteet
	        

	        /** Kierroksen alustaminen   */
	        public Kierros() {
	               	
	        }
	        
	        public void setPituus(double apituus){
	        	this.pituus = apituus;
	        	 	
	        }

			public void setTuomari(int tuomari, double pisteet) {
				tuomarit[tuomari - 1] = pisteet;
				
			}

			public String toString(){
    	
				StringBuilder pisteet = new StringBuilder();
    	
				for (int i = 0; i<tuomarit.length; i++){
					pisteet.append(tuomarit[i] + ", ");
				}
				pisteet.delete(pisteet.length()-2, pisteet.length());
				return pisteet.toString();
				}
	    
	}	    
	    
	        
    
//------------------------------------------------------------------------------------------------------------------------------------------------
	    /**
	     * Luokka mäkihypyn yhden kilpailijan tulosta varten.
	     * Sisältää monta kierosta.
	     */	
	    public static class Tulos {//implements Comparable<Tulos> {
	        private final static int KIERROKSIA = 2;
	        private final Kierros kierros[] = new Kierros[KIERROKSIA];

	        
	        /** Tuloksen alustaminen */
	        public Tulos() {
	        	for(int i = 0; i < KIERROKSIA; i++)
	        		kierros[i] = new Kierros();	
	        }
	     
	        
	     /**
	      * Asetetaan hypyn pituus
	      */
	     public void setPituus(int kierros, double pituus){
	    	 this.kierros[kierros-1].setPituus(pituus);
	     }
	     
	     
	     /**
	      * Asetetaan tuomari 
	      * @param kierros
	      * @param tuomari
	      * @param pisteet
	      */
	     public void setTuomari(int kierros, int tuomari, double pisteet){
	    	 this.kierros[kierros-1].setTuomari(tuomari, pisteet);
	     }
	    }
	    
//-----------------------------------------------------------------------------------------------------------------------------------------------	    
	    /**
	     * Luokka yhtä mäkihypyn kilpailijaa varten.
	     * Sisältää mm. tuloksen.
	     */
	  
	    public static class Kilpailija {
	        private String nimi;
	        private int nro;
	        private final Tulos tulos = new Tulos();

	        
	        /**
	         * Kilpailijan alustaminen
	         * @param nimi kilpailijan nimi
	         * @param nro kilpailijan kilpailunumero
	         */
	        public Kilpailija(String nimi,int nro) {
	            // Täytä
	        	this.nimi = nimi;
	        	this.nro = nro;
	        }
	        
	        
	        /**
	         * Asetetaan hypyn pituus
	         * @param kierros
	         * @param pituus
	         */
	        public void setPituus(int kierros, double pituus){
	        	tulos.setPituus(kierros, pituus);
	        }
	        
	        
	        /**
	         * Kierroksen tuomari pisteet yhdeltä kierrokselta
	         * @param i
	         * @param j
	         * @param d
	         */
			public void setTuomari(int kierros, int tuomari, double pisteet) {
				tulos.setTuomari(kierros, tuomari, pisteet);	
			}
			

	        /** Tulostaa kilpailijan tiedot */
	        @SuppressWarnings("static-method")
	        public void tulosta() {
	            System.out.println("Tässä tulostuu aikanaan kilpailijan tiedot");
	            System.out.println ("Nimi: " + nimi);
	            System.out.println ("Numero: " + nro);
	            System.out.println ("Hypyn pituus: " + Kierros.pituus);
	           //System.out.println (Tulos.kierros);
	            //System.out.println (tulos);
	            System.out.println ();
	        }	
			}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	    /**
	     * Tyhjä aliohjelma kilpailua varten
	     */
	    @SuppressWarnings("static-method")
	    public void kisa() {
	    	Kilpailija toni = new Kilpailija("Toni",3); 
	        Kilpailija matti = new Kilpailija("Matti",7); 
	        toni.tulosta(); 
	        matti.tulosta(); 

	        toni.setPituus(1,107);       // 1. kierros, 107 m
	        toni.setPituus(2,100);       // 2. kierros, 100 m
	        toni.setTuomari(2,1,19.0);   // 2. kierros, 1. tuomari, 19 p 
	        toni.setTuomari(2,2,18.0);   // 2. kierros, 2. tuomari, 18 p
	        toni.setTuomari(2,3,19.5); 
	        toni.setTuomari(2,4,18.0); 
	        toni.setTuomari(2,5,20.0); 

	        matti.setPituus(1,125); 
	        matti.setTuomari(1,1,20.0); 
	        matti.setTuomari(1,2,20.0); 
	        matti.setTuomari(1,3,20.0); 
	        matti.setTuomari(1,4,20.0); 
	        matti.setPituus(2,109); 
	        matti.setTuomari(2,1,20.0); 
	        matti.setTuomari(2,2,20.0); 
	        matti.setTuomari(2,3,20.0); 
	        matti.setTuomari(2,4,20.0); 

	        toni.tulosta(); 
	        matti.tulosta(); 
	    }

	    /**
	     * Testataan luokan kääntymistä
	     * @param args ei käytössä
	     */
	    public static void main(String[] args) {
	        MakiHyppy kisa = new MakiHyppy();
	        kisa.kisa();
	    }
}

