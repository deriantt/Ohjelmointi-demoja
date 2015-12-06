import java.io.PrintStream;
import java.io.OutputStream;

public class LinjaAuto {
	

	private final int plkm;
	private int matks;
	

    /**
     * Alustetaan LinjaAuton paikkalkm ja vapaapaikkalkm.
     * @param plkm paikkalukum‰‰r‰
     * @param vplkm vapaa paikka lukum‰‰r‰
     */
    public LinjaAuto(int plkm) {
        this.plkm = plkm;
 
    }
	
   /**
    * Kuinka monta paikkaa on linja-autossa j‰ljell‰
    * @return
    */
    public int getTilaa(){
    	return plkm - matks;
    }
 
    /**
     * Monta paikkaa linja-autossa
     * @return
     */
    public int getPaikkoja(){
    	
    	return plkm;
    }

    /**
     * Montako matkustajaa autossa
     * @return
     */
    public int getMatkustajia(){
    	
    	return matks;
    }
    
    /**
     * Palauttaa true jos getTilaa suurempi kuin nolla, muuten false
     * @return
     */
    public boolean tilaa(){
    	
    	return getTilaa() > 0;
    }
    
    
    
    /**
     * Tulostaa tiedot
     */
    public void tulosta(OutputStream os){
    	

    	@SuppressWarnings("resource")
    	PrintStream out = os instanceof PrintStream ? (PrintStream)os : new PrintStream(os);
    	out.println("Autossa paikkoja: " + getPaikkoja() +
    				" matkustajia: " + getMatkustajia() + 
    				" vapaita paikkoja: " + getTilaa());
    }
    
    /**
     * Lis‰‰ matkustajia linja-autoon
     */
    public int lisaa(int lisa){

    	matks = matks + lisa;
    	if(matks < 0 ){
    		int vajaa = matks;
    		matks = 0;
    	return vajaa;
    	}
    	
    	int yli = matks - getPaikkoja();
    	if(yli <= 0) return 0; // Kaikki mahtu
    	matks = getPaikkoja();
    	return yli;
    	
    }
     /**
      * V‰hent‰‰ matkustajan linja-autosta
     * @return 
      */
    public int vahenna(int vahennys){

    	return lisaa(-vahennys);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//LinjaAuto linkkari = new LinjaAuto();
		
		//lisaa();
		//v‰henn‰();
		//tulosta();
		
	    LinjaAuto pikkubussi = new LinjaAuto(10);
	    LinjaAuto isobussi = new LinjaAuto(45);
	    pikkubussi.lisaa(4);    pikkubussi.tulosta(System.out); // 10,4,6
	    isobussi.lisaa(30);     isobussi.tulosta(System.out);   // 45,30,15
	    int yli = pikkubussi.lisaa(15);
	    isobussi.lisaa(yli);    
	    pikkubussi.tulosta(System.out);                         // 10,10,0
	    isobussi.tulosta(System.out);                           // 45,39,6
	    if ( pikkubussi.getTilaa() > 0 )
	        System.out.println("Pieneen bussiin mahtuu!");   // ei tulosta
	    if ( isobussi.tilaa() )
	        System.out.println("Isoon bussiin mahtuu!");     // tulostaa
	    int vajaa = pikkubussi.vahenna(12);                  // vajaa = -2
	    if ( vajaa < 0 )                                      
	        System.out.println("Pikkubussissa ei edes ole n‰in montaa!");
	    pikkubussi.tulosta(System.out);
		
	
	}



}
