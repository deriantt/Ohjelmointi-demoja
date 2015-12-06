package huone;

/**
 * Teht‰v‰t:
 *<pre>
 *   0. K‰‰nn‰ ja aja ensin sellaisenaan.  
 *      Poista rivit  @SuppressWarnings("unused")
 *   1. Tee liitteen HuoneTest.java mukainen JUnit testi ja aja se.
 *      Jatkossa aja aina HuoneTest kun olet muuttanut jotakin.  Loppuvaiheessa
 *      kaikki pit‰isi saada vihre‰ksi.
 *      Aja myˆs t‰m‰n tiedoston testiohjelman (main) jokaisen muutoksen
 *      j‰lkeen.
 *   2. Laita huoneen metodit ala, tilavuus ja getKaappeja toimiviksi
 *      (getKaappeja palauttaa huoneen kaappien lukum‰‰r‰n).
 *   3. T‰ydenn‰ huoneen toString-metodi siten, ett‰
 *      huoneen tiedot tulostuvat seuraavasti (k‰yt‰ muotoile-aliohjelmaa):
 *        olohuone    12 m2 24 m3  1 kaappia
 *   4. Laita kaikki asiamukaiset metodien n‰kyvyysm‰‰rittelyt
 *   5. Lis‰‰ asianmukaiset JavaDoc-kommentit
 *   6. Laita huoneen metodi lisaaKaappeja toimivaksi
 *   7. Mit‰ main-ohjelma tulostaa nyt?
 *   8. Kokeile viel‰ sek‰ HuoneTest ja Huone
 *   9. Tee HuoneTest:i‰ vastaavat testit ComTestill‰
 *</pre>
 * @author Vesa Lappalainen
 * @version 1.0, 25.02.2003
 */

public class Huone {

  /**
   * muotoile("olohuone",12,24,1) palauttaa rivin muodossa:<br>
   * olohuone    12 m2 24 m3  1 kaappia
   * @param teksti teksti joka tulostuu rivin alkuun
   * @param ala tulostettava pinta-ala
   * @param tilavuus tulostettava tilavuus
   * @param kaappeja tulostettava kaappien lukum‰‰r‰
   * @return tiedot muotoiltuna
   */
  public static String muotoile(String teksti,double ala, double tilavuus, int kaappeja) {
      return String.format("%-10s %2.0f m2 %2.0f m3 %2d kaappia",teksti,ala,tilavuus,kaappeja);
  }

  private String nimi;
  private double pit,lev,kork;
  private int kaappeja;
  
  
  Huone(String n, double p, double l, double k, int kaap)
      { nimi=n; pit=p; lev=l; kork=k; kaappeja=kaap; }
  double ala()                { return 0;                                    }
  double tilavuus()           { return 0;                                    }
  int    getKaappeja()        { return 0;                                    }
  void   lisaaKaappeja()      { System.out.println("Kaappi lis‰‰");          }
  public String toString()    { return "huone";                              }

  /**
   * Testataan Huone-luokkaa
   * @param args ei k‰ytˆss‰
   */
  public static void main(String[] args)  {
    Huone olohuone = new Huone("olohuone",3,4,2,0);
    System.out.println(olohuone);
    olohuone.lisaaKaappeja();
    System.out.println(olohuone);
  }
}

