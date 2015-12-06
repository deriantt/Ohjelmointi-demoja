
/**
 * Esimerkki dynaamisesta taulukosta
 * @author Vesa Lappalainen @version 1.0, 02.03.2002
 * @author Santtu Viitanen @version 1.1, 21.07.2011
 * @example
 * <pre name="test">
 *  #THROWS Taulukko.TaulukkoTaysiException
 *  Taulukko luvut = new Taulukko();
 *  luvut.lisaa(0); luvut.lisaa(2); luvut.lisaa(99);
 *  luvut.toString() === "0,2,99"; 
 *  luvut.set(1,4); luvut.toString() === "0,4,99"; 
 *  int luku = luvut.get(2);
 *  luku === 99;
 *  luvut.get(2) === 99;
 *  luvut.set(21, 4); #THROWS IndexOutOfBoundsException 
 *  luvut.lisaa(0); luvut.lisaa(0); //taulukko t�yteen
 *  luvut.lisaa(0);  #THROWS Taulukko.TaulukkoTaysiException
 * </pre>
 */
public class Taulukko {
    /** Luokka t�yden taulukon poikkeusta varten  */
    public static class TaulukkoTaysiException extends Exception {
        private static final long serialVersionUID = 1L;


        TaulukkoTaysiException(String viesti) {
            super(viesti);
        }
    }

    private int alkiot[];
    private int lkm;


    /**
     * Alustetaan 5 kokoinen taulukko 
     */
    public Taulukko() {
        alkiot = new int[5];
    }


    /**
     * Alutetaan valitun kokoinen taulukko
     * @param koko taulukon koko
     */
    public Taulukko(int koko) {
        alkiot = new int[koko];
    }


    /**
     * Lis�t��n taulukkoon yksi alkio
     * @param luku lis�tt�v� alkio
     * @throws TaulukkoTaysiException jos taulukko t�ysi
     */
    public void lisaa(int luku) throws TaulukkoTaysiException {
        if (lkm >= alkiot.length) throw new TaulukkoTaysiException("Tila loppu");
        alkiot[lkm++] = luku;
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
     * Asetetaan taulukon i's alkio
     * @param i mihin paikkaan astetaan
     * @param luku mik� arvo laitetaan
     * @throws IndexOutOfBoundsException jos v��r� indeksi
     */
    public void set(int i, int luku) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        alkiot[i] = luku;
    }


    /**
     * Palautetana paikasssa i oleva luku
     * @param i mist� paikasta luku otetaan
     * @return paikassa i olevan luvun arvo
     * @throws IndexOutOfBoundsException jos indeksi v��rin
     */
    public int get(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        return alkiot[i];
    }
    public void poista(int n){
    	lkm = PoistaTaulukosta.poista(alkiot, lkm, n);
    }

}