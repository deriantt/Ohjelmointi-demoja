import fi.jyu.mit.ohj2.Mjonot;

/**
 * Alustava luokka p‰iv‰m‰‰r‰‰ varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 09.02.2008
 */
public class Pvm {
    private int pv, kk, vv;


    /**
     * Palauttaa t‰m‰nhetkisen p‰iv‰yksen.
     * TODO: muutettava toimimaan oikein.
     */
    public void paivays() {
        pv = 30;
        kk = 1;
        vv = 2012;
    }


    /**
     * Alustetaan p‰iv‰m‰‰r‰. 0-arvot eiv‰t muuta vastaavaa attribuuttia  
     * TODO: oikeellisuustarkitukset
     * @param pv p‰iv‰n alustus
     * @param kk kuukauden alustus
     * @param vv vuoden alustus
     */
    public final void alusta(final int pv, final int kk, final int vv) {
        if (pv > 0)        this.pv = pv;
        if (kk > 0)        this.kk = kk;
        if (vv > 0)        this.vv = vv;
        if (this.vv < 50)  this.vv += 2000;
        if (this.vv < 100) this.vv += 1900;
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
    }


    /**
     * Palautetaan p‰iv‰ys merkkijonona
     * @return p‰iv‰ys merkkijonoja
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(10,2,2008);
     * pvm.toString() === "10.2.2008";
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Alustetaan p‰iv‰n arvon merkkijonosta
     * @param s jono josta pvm otetaan
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm();
     * pvm.parse("11.05.02");  pvm.toString() === "11.5.2002";
     * pvm.parse("11.05.97");  pvm.toString() === "11.5.1997";
     * pvm.parse("17.3");      pvm.toString() === "17.3.1997";
     * pvm.parse("19");        pvm.toString() === "19.3.1997";
     * </pre>
     */
    public void parse(String s) {
        StringBuffer sb = new StringBuffer(s);
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, '.', 0);
        alusta(p, k, v);
    }


    /**
     * Testataan p‰iv‰m‰‰r‰luokkaa
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Pvm tammi2008 = new Pvm(1, 1);
        Pvm maalis97 = new Pvm(1, 3, 97);
        Pvm tanaan = new Pvm();

        System.out.println(tammi2008 + " " + maalis97 + " " + tanaan);

        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");     System.out.println(pvm);
        pvm.parse("15.3");          System.out.println(pvm);
        pvm.parse("14");            System.out.println(pvm);
        
 //       Pvm pvm = new Pvm();
        pvm.parse("3.4.2011");
        System.out.println(pvm.getPv()); // tulostaa 3
        System.out.println(pvm.getKk()); // tulostaa 4
        System.out.println(pvm.getVv()); // tulostaa 2011
    }

//---------Omaa koodia-------------------------------------------------------

    //Hakee p‰iv‰m‰‰r‰n p‰iv‰n
 public int getPv(){
	 
	 return pv;
 }
   //Hakee p‰iv‰m‰‰r‰n kuukauden
 public int getKk(){
	 return kk;
 }
 
 	//Hakee p‰iv‰m‰‰r‰n vuoden
 public int getVv(){
	 return vv;
 }
}