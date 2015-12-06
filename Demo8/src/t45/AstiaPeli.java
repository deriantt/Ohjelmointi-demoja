package t45;

import java.util.ArrayList;
import java.util.List;
import fi.jyu.mit.ohj2.*;

/**
 *  John McLane (Bruce Willis) joutui elokuvassa Die Hard 3 ongelman eteen,
 *  jossa piti kahdella vesikanisterilla mitata jonkin muun suuruinen
 *  vesim��r� "tarkasti" ja n�in est�� pommin r�j�ht�minen.
 *  Koska aika meni varsin tiukalle, on vastaavien tilanteiden harjoittelemiseksi
 *  nyt tehty uusi menestysohjelma "Astia".
 *<br>
 *  Pelill� demonstroidaan/harjoitellaan miten voidaan kahdella astialla,
 *  5 l ja 8 l,  muodostaa kaikki mahdolliset tilavuudet 1-13 l.
 *  Peliss� on kaksi varsinaista astiaa: a5 ja a8, sek� kolmas apuastia
 *  ampari.  Nestett� voidaan kerrallaan kaataa yhdest� astiasta toiseen
 *  joko siten, ett� astian koko sis�lt� tyhjennet��n jos se mahtuu
 *  tai astista kaadetaan sen verran ett� toinen astia tulee t�yteen.
 *<br>
 *  Tee ohjelma jota voitasiin k�ytt�� seuraavasti:
 *<br>
 *<pre>
 *  K�yt�ss�si on 8 ja 5 litran astia ja �mp�ri (100 l)
 *
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >� 8[ret]
 *  8 litran astiassa on 8 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 5 litraa
 *  Mist� kaadetaan ja mihin >5 �[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 0 litraa
 *  Mist� kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 3 litraa
 *  Mist� kaadetaan ja mihin >[ret]
 *</pre>
 * Toteutettu peli-luokaksi, jossa k�ytet��n hyv�ksi Astia2-luokkaa.
 * Tarkistaa my�s pelin aikana l�ydetyt kombinaatiot
 * Valitettavasti AstiaPeliin piti lis�t� metodit getTilavuus ja getMaara
 * @author  Vesa Lappalainen
 * @version 1.0, 09.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 15.02.2003
 * @version 1.3, 13.02.2011
 */
public class AstiaPeli {
    // #import fi.jyu.mit.ohj2.Suuntaaja;

    private ArrayList<Astia> astiat = new ArrayList<Astia>();
    private Esiintymat esiintymat;


    /**
     * Astiapelin alustus.  Laitetaan aina �mp�ri mukaan.
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.etsi("�").getTilavuus() ~~~ 100.0;
     * </pre>
     */
    public AstiaPeli() {
        lisaaYksiAstia("�", 100);
        getAmpari().tayta();
    }


    /**
     * Palauttaa �mp�rin
     * @return viite �mp�riin
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.getAmpari().getTilavuus() ~~~ 100.0;
     * </pre>
     */
    public final Astia getAmpari() {
        return anna(0);
    }
    
    
    /**
     * Palautetaan astioiden lukum��r� peliss�
     * @return astioiden lukum��r�
     * @example
     * <pre name="test">
     *    AstiaPeli peli = new AstiaPeli();
     *    peli.getLkm() === 1;
     * </pre>
     */
    public int getLkm() {
        return astiat.size();
    }


    /**
     * Lis�t��n uusi astia peliin.  Luodaan t�t� varten uusi astia.
     * Apumetodi muodostajasta kutsuttavaksi koska muodostajasta saa kutsua
     * vain final metodeja.
     * @param nimi lis�tt�v�n astian nimi
     * @param tilavuus lis�tt�v�n astian tilavuus
     * @return lis�tty astia
     */
    private final Astia lisaaYksiAstia(String nimi, double tilavuus) {
        Astia astia = new Astia(nimi, tilavuus); 
        astiat.add(astia);
        return astia;
    }


    /**
     * Lis�t��n uusi astia peliin.  Luodaan t�t� varten uusi astia.
     * @param nimi lis�tt�v�n astian nimi
     * @param tilavuus lis�tt�v�n astian tilavuus
     * @return lis�tty astia
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getLkm() === 1;
     *  peli.lisaaAstia("5",5);
     *  peli.getLkm() === 2;
     *  peli.lisaaAstia("8",8);
     *  peli.getLkm() === 3;
     * </pre>
     */
    public Astia lisaaAstia(String nimi, double tilavuus) {
        Astia astia = lisaaYksiAstia(nimi, tilavuus); 
        alusta();
        return astia;
    }


    /**
     * Palautetaan i:s astia joukosta
     * @param i monesko astia
     * @return i's astia
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.anna(0).getNimi() === "�";
     *  peli.lisaaAstia("5",5);
     *  peli.anna(1).getNimi() === "5";
     * </pre>
     */
    public Astia anna(int i) {
        return astiat.get(i);
    }


    /**
     * Tulostetaan pelin ohje
     * 
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.tulostaOhje();
     *  so.ero("K�yt�ss�si on 5.0 sek� 8.0 litran astiat ja �mpari (100.0 l)\n") === null;
     *  so.palauta();
     * </pre>
     */
    public void tulostaOhje() {
        if ( getLkm() <= 0 ) return;
        String ja = "";
        System.out.print("K�yt�ss�si on ");
        for (int i = 1; i < getLkm(); i++) {
            System.out.print(ja + anna(i).getTilavuus());
            ja = " sek� ";
        }
        System.out.println(" litran astiat ja �mpari (" +
                getAmpari().getTilavuus() + " l)");
    }


    /**
     * Tulostetaan astioissa olevat nestem��r�t
     * @example
     * <pre name="test">
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * String tulos =
     *   "5.0 litran astiassa on 5.0 litraa nestett�\n"       +
     *   "8.0 litran astiassa on 3.0 litraa nestett�\n";
     * 
     *   AstiaPeli peli = new AstiaPeli();
     *   Astia ampari = peli.getAmpari(); 
     *   Astia a5 = peli.lisaaAstia("5",5);
     *   Astia a8 = peli.lisaaAstia("8",8);
     *   peli.kaada(ampari,a8);
     *   peli.kaada(a8,a5);
     *   peli.tulostaMaarat();
     * 
     * so.ero(tulos) === null; 
     * so.palauta();
     * </pre>
     */
    public void tulostaMaarat() {
        for (int i = 1; i < getLkm(); i++)
            System.out.println(anna(i).getTilavuus() + " litran astiassa on " +
                    anna(i).getMaara() + " litraa nestett�");
    }


    /**
     * Palautetaan astioissa olevat nestem��r�t �mp�ri� lukuunottamatta
     * @return astioissa olevat nestem��r�t merkkijonona
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.getMaarat() === "0.0 0.0";
     *  peli.kaada(peli.etsi("�"),peli.etsi("8")); peli.getMaarat() === "0.0 8.0";
     *  peli.kaada(peli.etsi("8"),peli.etsi("5")); peli.getMaarat() === "5.0 3.0";
     * </pre>
     */
    public String getMaarat() {
        StringBuilder tulos = new StringBuilder();
        for (int i = 1; i < getLkm(); i++)
            tulos.append(anna(i).getMaara() + " ");
        return tulos.toString().trim();
    }


    /**
     * Etsii sen astian, jolla on annettu nimi.
     * @param nimi etsitt�v�n astian nimi
     * @return astian viite tai null jos ei l�ydy
     * 
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.etsi("�").oletko("�") === true;
     *  peli.etsi("�").oletko("�") === true;
     *  peli.etsi("5").getTilavuus() ~~~ 5.0;
     *  peli.etsi("8").getTilavuus() ~~~ 8.0;
     *  peli.etsi("9") === null;
     * </pre>
     */
    public Astia etsi(String nimi) {
        for (Astia astia : astiat)
            if ( astia.oletko(nimi) ) return astia;
        return null;
    }


    /**
     * Tulostetaan ohjeet nimist�.
     * @param mista mist� yritettiin
     * @param mihin mihin yritettiin
     * 
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  AstiaPeli peli = new AstiaPeli(); peli.lisaaAstia("5",5); peli.lisaaAstia("8",8);
     *  peli.nimiOhje("4","6");
     *  String tulos = "Nime� ei tunneta: 4 tai 6\n" +
     *                 "Tunnetaan nimet: \n"         +
     *                 "� 5 8 \n";
     *  so.ero(tulos) === null;
     *  peli.nimiOhje("?","6");
     *         tulos = "Tunnetaan nimet: \n� 5 8 \n";
     *  so.ero(tulos) === null;
     *  so.palauta();
     * </pre>
     */
    public void nimiOhje(String mista, String mihin) {
        if ( !"?".equals(mista) )
            System.out.println("Nime� ei tunneta: " + mista + " tai " + mihin);
        System.out.println("Tunnetaan nimet: ");
        for (Astia astia : astiat)
            System.out.print(astia.getNimi() + " ");
        System.out.println("");
    }

    
    /**
     * Kaataa astiasta toiseen
     * @param mista mist� astiasta kaadetaan
     * @param mihin mihin astiaan kaadetaan.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();  peli.lisaaAstia("5",5);  peli.lisaaAstia("8",8);
     *  peli.getMaarat() === "0.0 0.0";
     *  peli.kaada(peli.etsi("�"),peli.etsi("8")); peli.getMaarat() === "0.0 8.0";
     *  peli.kaada(peli.etsi("8"),peli.etsi("5")); peli.getMaarat() === "5.0 3.0";
     * </pre>
     */
    public void kaada(Astia mista, Astia mihin) {
        mista.kaada(mihin);
        lisaaEsiintymat(); // ver.1.2
    }
    
    
    
    /**
     * Alustetaan peli astioiden m��r�n mukaan.
     */
    private void alusta() {
        int yla = (int)(astioidenSumma()); // ver.1.2
        esiintymat = new Esiintymat(1, yla); // ver.1.2
    }
    

    /**
     * K�ynistet��n peli.  Peli loppuu kun k�ytt�j� sy�tt�� tyhj�n rivin.
     * @example
     * <pre name="test">
     * Suuntaaja.StringInput si = new Suuntaaja.StringInput("");  
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * si.input("� 8\n8 5\n4 5\n\n");  
     * String tulos =
     *   "K�yt�ss�si on 5.0 sek� 8.0 litran astiat ja �mpari (100.0 l)\n"+
     *   "5.0 litran astiassa on 0.0 litraa nestett�\n"       +
     *   "8.0 litran astiassa on 0.0 litraa nestett�\n"       +
     *   "Olet ratkaissut tilavuudet: \n"                     +
     *   "Ratkaisematta on: 1 2 3 4 5 6 7 8 9 10 11 12 13\n"  +  
     *   "Mist� kaadetaan ja mihin >"                         + // NOPMD
     *   "5.0 litran astiassa on 0.0 litraa nestett�\n"       +
     *   "8.0 litran astiassa on 8.0 litraa nestett�\n"       +
     *   "Olet ratkaissut tilavuudet: 8\n"                    +
     *   "Ratkaisematta on: 1 2 3 4 5 6 7 9 10 11 12 13\n"    +  
     *   "Mist� kaadetaan ja mihin >"                         +
     *   "5.0 litran astiassa on 5.0 litraa nestett�\n"       +
     *   "8.0 litran astiassa on 3.0 litraa nestett�\n"       +
     *   "Olet ratkaissut tilavuudet: 3 5 8\n"                +
     *   "Ratkaisematta on: 1 2 4 6 7 9 10 11 12 13\n"        +  
     *   "Mist� kaadetaan ja mihin >"                         +
     *   "Nime� ei tunneta: 4 tai 5\n"                        +
     *   "Tunnetaan nimet: \n"                                + 
     *   "� 5 8 \n"                                           +
     *   "5.0 litran astiassa on 5.0 litraa nestett�\n"       +
     *   "8.0 litran astiassa on 3.0 litraa nestett�\n"       +
     *   "Olet ratkaissut tilavuudet: 3 5 8\n"                +
     *   "Ratkaisematta on: 1 2 4 6 7 9 10 11 12 13\n"        +  
     *   "Mist� kaadetaan ja mihin >";
     * 
     *   AstiaPeli peli = new AstiaPeli();
     *   peli.lisaaAstia("5",5);
     *   peli.lisaaAstia("8",8);
     *   peli.tulostaOhje();
     *   peli.pelaa();
     * 
     * so.ero(tulos) === null; 
     * si.palauta(); so.palauta();
     * </pre>
     */
    public void pelaa() {

        while ( true ) {
            tulostaMaarat();
            if ( tulostaEsiintymat() ) return; // ver.1.2

            String rivi = Syotto.kysy("Mist� kaadetaan ja mihin");
            if ( rivi.length() == 0 ) break;
            StringBuffer sb = new StringBuffer(rivi); // NOPMD
            String smista = Mjonot.erota(sb);
            String smihin = Mjonot.erota(sb);
            Astia mista = etsi(smista);
            Astia mihin = etsi(smihin);

            if ( (mista == null) || (mihin == null) )
                nimiOhje(smista, smihin);
            else kaada(mista,mihin);
        }
    }


    /**
     * @param i mink� astia m��r� halutaan
     * @return i:n astian m��r�n
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getMaara(0) ~~~ 100;
     *  Astia a5 = peli.lisaaAstia("5",5);
     *  peli.getMaara(1) ~~~ 0;
     *  peli.kaada(peli.getAmpari(),a5); peli.getMaara(1) ~~~ 5;
     * </pre>
     */
    public double getMaara(int i) {
        return anna(i).getMaara();
    }


    /**
     * @param i mink� astian tilavuus
     * @return i:n astian tilavuus
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.getTilavuus(0) ~~~ 100;
     *  peli.lisaaAstia("5",5);
     *  peli.getTilavuus(1) ~~~ 5;
     * </pre>
     */
    public double getTilavuus(int i) {
        return anna(i).getTilavuus();
    }


    /* Version 1.2 tarvitsemat lis�ykset */

    /**
     * Laskee kaikkien k�yt�ss� olevien astioiden yhteistilavuuden
     * lukuunottamatta �mp�ri�
     * @return yhteistilavuus
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.astioidenSumma() ~~~ 0;
     *  peli.lisaaAstia("5",5); peli.astioidenSumma() ~~~ 5;
     *  peli.lisaaAstia("8",8); peli.astioidenSumma() ~~~ 13;
     * </pre>
     */
    public double astioidenSumma() {
        double summa = 0;
        for (int i = 1; i < getLkm(); i++)
            summa += getTilavuus(i);
        return summa;
    }


    /**
     * Lis�� esiintymat-taulukkoon kaikki ne astioiden summakombinaatiot,
     * joita niist� saa t�ll� hetkell�.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.lisaaEsiintymat();  
     *  peli.getLoydetyt().toString() === "[]";
     *  ampari.kaada(a1); peli.lisaaEsiintymat();
     *  peli.getLoydetyt().toString() === "[1]";
     *  ampari.kaada(a2); peli.lisaaEsiintymat();
     *  peli.getLoydetyt().toString() === "[1, 2, 3]";
     * </pre>
     */
    public void lisaaEsiintymat() {
        Kombinaatiot kombi = new Kombinaatiot();
        for (int i = 1; i < getLkm(); i++)
            kombi.lisaa((int)(Math.round(getMaara(i))));

        for (int summa : kombi)
            esiintymat.lisaa(summa);
    }


    /**
     * Tulostaa l�yt�mistilanteen
     * @return joka jokaista m��r�� on l�ydetty
     * @example
     * <pre name="test">
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * String tulos =
     *   "Olet ratkaissut tilavuudet: 3 5 8\n"  +
     *   "Ratkaisematta on: 1 2 4 6 7 9 10 11 12 13\n";  
     * 
     *   AstiaPeli peli = new AstiaPeli();
     *   Astia ampari = peli.getAmpari(); 
     *   Astia a5 = peli.lisaaAstia("5",5);
     *   Astia a8 = peli.lisaaAstia("8",8);
     *   peli.kaada(ampari,a8);
     *   peli.kaada(a8,a5);
     *   peli.tulostaEsiintymat();
     * 
     * so.ero(tulos) === null; 
     * so.palauta();
     * </pre>
     */
    public boolean tulostaEsiintymat() {
        System.out.println("Olet ratkaissut tilavuudet: " + esiintymat.loydetyt());
        if ( esiintymat.getLoydettyja() >= esiintymat.getYla() ) return true;
        System.out.println("Ratkaisematta on: " + esiintymat.eiLoydetyt());
        return false;

    }


    /**
     * Palautetaan tieto siit�, onko peli mennyt l�pi.
     * @return true jos peli on mennyt l�pi.
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.kaada(ampari,a1); peli.lapi() === false;
     *  peli.kaada(ampari,a2); peli.lapi() === true;
     * </pre>
     */
    public boolean lapi() {
        return esiintymat.onkoKaikki(); 
    }
    
    
    /**
     * Palautetaan l�ydettyjen lista.
     * @return l�ydetyjen tilavuuksien lista
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  Astia ampari = peli.getAmpari();
     *  Astia a1 = peli.lisaaAstia("1",1); 
     *  Astia a2 = peli.lisaaAstia("2",2);
     *  peli.getLoydetyt().toString() === "[]";
     *  peli.kaada(ampari,a1); peli.getLoydetyt().toString() === "[1]";
     *  peli.kaada(ampari,a2); peli.getLoydetyt().toString() === "[1, 2, 3]";
     * </pre>
     */
    public List<Integer> getLoydetyt() {
        return esiintymat.getLoydetyt();
    }
    
    
    /**
     * Testataan astiapeli�
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        AstiaPeli peli = new AstiaPeli();

        peli.lisaaAstia("8", 8);
        peli.lisaaAstia("5", 5);
        peli.tulostaOhje();

        peli.pelaa();
    }

}