package demo6
;

import fi.jyu.mit.ohj2.*;

/**
 * Alustava luokka p‰iv‰m‰‰r‰‰ varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 17.02.2003
 * @version 1.3, 11.02.2008
 */
public class Pvm {

    //private int pv;
    //private int kk;
    //private int vv;

    private int pv = 0, kk = 1, vv = 2;

    /** Taulukko kuukausien pituuksista. Oma rivi  karkausvuosille */
    public static final int KPITUUDET[][] = {
            // 1  2  3  4  5  6  7  8  9 10 11 12
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
    };


    /**
     *  Muuttaa p‰iv‰m‰‰r‰n nykyp‰iv‰lle.
     *  Todo: pit‰‰ vaihtaa hakemaan p‰iv‰m‰‰r‰ oikeasti. 
     *  Mutta perinn‰ss‰k‰‰n ei nyt saa k‰ytt‰‰ enemp‰‰ attribuutteja kuin t‰ss‰ on
     */
    public void paivays() {
        pv = 13;
        kk = 2;
        vv = 2012;
    }

    /**
     * Palautetaan tieto siit‰ onko tutkittava vuosi karkausvuosi vai ei
     * @param vv tutkittava vuosi
     * @return 1 jos on karkausvuosi ja 0 jos ei ole
     * @example
     * <pre name="test">
     *   karkausvuosi(1900) === 0
     *   karkausvuosi(1900) === 0
     *   karkausvuosi(1901) === 0
     *   karkausvuosi(1996) === 1
     *   karkausvuosi(2000) === 1
     *   karkausvuosi(2001) === 0
     *   karkausvuosi(2004) === 1
     * </pre>
     */
    public static int karkausvuosi(int vv) {
        if ( vv % 400 == 0 ) return 1;
        if ( vv % 100 == 0 ) return 0;
        if ( vv % 4 == 0 ) return 1;
        return 0;
    }

    /**
     * Alustetaan p‰iv‰m‰‰r‰. 0-arvot eiv‰t muuta vastaavaa attribuuttia  
     * TODO: oikeellisuustarkistukset
     * @param ipv p‰iv‰n alustus
     * @param ikk kuukauden alustus
     * @param ivv vuoden alustus
     * @example
     * <pre name="test">
     * Pvm pvmtest = new Pvm(69,2,1988);
     * pvmtest.toString() === "69.2.1988";
     * 
     * 
     * </pre>
     */
    public void alusta(int ipv, int ikk, int ivv) {
    	int karkaus = karkausvuosi(vv);
    	if (kk < 0 || kk > 12) return;
    	if (pv < 0 || pv > KPITUUDET[karkaus][this.kk])return;
    	
        if ( ipv > 0 ) this.pv = ipv;
        if ( ikk > 0 ) this.kk = ikk;
        if ( ivv > 0 ) this.vv = ivv;
        if ( this.vv < 50 ) this.vv += 2000;
        if ( this.vv < 100 ) this.vv += 1900;
    }


    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
    }


    /** 
     * Alustetaan kuukausi ja vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     * @param kk kuukauden oletusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv p‰iv‰n alustusarvo
     * @param kk kuukauden oletusarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        paivays();
        alusta(pv, kk, vv);
    } // NOPMD


    /**
     * Alustetaan p‰iv‰m‰‰r‰ merkkijonosta
     * @param s muotoa 12.3.2008 oleva merkkijono
     */
    public Pvm(String s) {
        paivays();
        pvmParse(s);
    } // NOPMD 


    /**
     * P‰iv‰m‰‰r‰ merkkijonona
     * @return p‰iv‰m‰‰r‰ muodossa 17.2.2007
     * @example
     * <pre name="test">
     *   Pvm tammi2011 = new Pvm(1,1,2011);
     *   tammi2011.toString() === "1.1.2011"
     *   Pvm helmi2011 = new Pvm(1,2,2011);
     *   helmi2011.toString() === "1.2.2011"
     *   Pvm tanaan = new Pvm(14,2,2011);
     *   tanaan.toString()    === "14.2.2011"
     *   Pvm maalis97 = new Pvm(1,3,1997);
     *   maalis97.toString()  === "1.3.1997"
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param sb tutkittava merkkijono
     */
    protected final void pvmParse(StringBuilder sb) {
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, ' ', 0);
        alusta(p, k, v);
        // tai alusta(Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0));
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param s tutkittava merkkijono
     */
    protected final void pvmParse(String s) {
        pvmParse(new StringBuilder(s));
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * @param s tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * pvm.parse("12");           pvm.toString() === "12.3.2003";
     * pvm.parse("..2001");       pvm.toString() === "12.3.2001";
     * pvm.parse("..2009 14:30"); pvm.toString() === "12.3.2009"; 
     * </pre>
     */
    public void parse(String s) {
        pvmParse(s);
    }


    /**
     * Ottaa p‰iv‰m‰‰r‰n tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille k‰ytet‰‰n t‰m‰n p‰iv‰n arvoa oletuksena.
     * Merkkijonosta otetaan pois vain se osa, jota tarvitaan.
     * @param sb tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * StringBuilder jono = new StringBuilder("12");
     * pvm.parse(jono); pvm.toString() === "12.3.2003"; jono.toString() === "";
     * jono = new StringBuilder("..2001");
     * pvm.parse(jono); pvm.toString() === "12.3.2001"; jono.toString() === "";
     * jono = new StringBuilder("..2009 14:30");
     * pvm.parse(jono); pvm.toString() === "12.3.2009"; jono.toString() === "14:30";
     * </pre>
     */
    public void parse(StringBuilder sb) {
        pvmParse(sb);
    }


    // Lis‰tty saantimetodit:

    /**
     * @return p‰iv‰n arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getPv() === 14;
     * </pre>
     */
    public int getPv() {
        return pv;
    }


    /**
     * @return kuukauden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getKk() === 2;
     * </pre>
     */
    public int getKk() {
        return kk;
    }


    /**
     * @return vuoden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getVv() === 2011;
     * </pre>
     */
    public int getVv() {
        return vv;
    }
    //----------------------- teht‰v‰ 2 ---------------------------------------------------
    
    /**
     * @return -1 jos pv1 on ennen kuin pv2
     * @return 1 jos pv2 on ennen kuin pv1
     * @return 0 jos p‰iv‰t ovat samoja
     * @example
     * <pre name="test">
     *   Pvm pv1 = new Pvm("14.2.2011");
     *   Pvm pv2 = new Pvm("13.2.2011");
     *   Pvm pv3 = new Pvm("13.3.2011");
     *   Pvm pv4 = new Pvm("13.3.2010");
     *   compareTo(pv1, pv2) === 1;
     *   compareTo(pv2, pv1) === -1;
     *   compareTo(pv2, pv3) === -1;
     *   compareTo(pv3, pv4) === 1;
     *   compareTo(pv4, pv4) === 0;
     *   
     * </pre>
     */
    public static int compareTo(Pvm pv1, Pvm pv2){
    	if(pv1.getVv() < pv2.getVv())return -1;
    	if(pv1.getVv() > pv2.getVv())return 1;
    	if(pv1.getVv() == pv2.getVv()){
    		if(pv1.getKk() < pv2.getKk())return -1;
    		if(pv1.getKk() > pv2.getKk())return 1;
    		if(pv1.getKk() == pv2.getKk()){
    			if(pv1.getPv() < pv2.getPv()) return -1;
    			if(pv1.getPv() > pv2.getPv()) return 1;
    			else return 0;
    		}
    	}
    		
    	return 0;
    	
    }
    
    //---------------------------------teht‰v‰ 3--------------------------------------------------------------'
    /**
     * @return -1 jos this on ennen kuin pv2
     * @return 1 jos pv2 on ennen kuin this
     * @return 0 jos p‰iv‰t ovat samoja
     * @example
     * <pre name="test">
     * Pvm pv1 = new Pvm("1.2.1988");
     * Pvm pv2 = new Pvm("2.2.1988");
     * Pvm pv3 = new Pvm("1.3.1988");
     * Pvm pv4 = new Pvm("1.2.1990");
     * pv1.compareTo(pv2) === -1;
     * pv2.compareTo(pv1) === 1;
     * pv1.compareTo(pv3) === -1;
     * pv4.compareTo(pv3) === 1;
     * pv1.compareTo(pv1) === 0;
     * </pre>
     */
    public int compareTo(Pvm pv2){
    	if(pv2.getVv() < this.getVv())return 1;
    	if(this.getVv() < pv2.getVv())return -1;
    	if(this.getVv() == pv2.getVv()){
    		if(pv2.getKk() < this.getKk())return 1;
    		if(this.getKk() < pv2.getKk())return -1;
    		if(pv2.getKk() == this.getKk()){
    			if(pv2.getPv() < this.getPv())return 1;
    			if(this.getPv() < pv2.getPv())return -1;
    			if(pv2.getPv() == this.getPv())return 0;
    		}
    	}
    	return 0;
    }


    /**
     * Testataan p‰iv‰m‰‰r‰-luokkaa
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");
        System.out.println(pvm);
        pvm.parse("15.3");
        System.out.println(pvm);
        pvm.parse("14");
        System.out.println(pvm.getPv());

    }
}