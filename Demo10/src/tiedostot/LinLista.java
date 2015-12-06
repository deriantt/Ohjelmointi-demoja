package tiedostot;

/**
 * Esimerkki linkitetytst‰ listasta
 * @author Vesa Lappalainen
 * @version 1.0, 16.03.2002
 * @example
 * <pre name="test">
 *   LinLista luvut = new LinLista();
 *   luvut.lisaa(2);
 *   luvut.lisaa(99);
 *   luvut.toString() === " 2 99";
 * </pre>
 */

@SuppressWarnings({"all"})
public class LinLista {

  /**
   * Linkitetyn listan yksi alkio.  Sis‰lt‰‰ datan ja viitteen seuraavaan.
   */
  public static class Alkio {
    private int sisalto;
    private Alkio seuraava;
    public Alkio(int sisalto) { this.sisalto = sisalto; seuraava = null; }
    public int getSisalto() { return sisalto; }
  }

  private Alkio eka;
  private Alkio viimeinen;

  public LinLista() { eka = null; viimeinen = null; }
  public LinLista(int koko) { this(); }

  public void lisaa(int sisalto) {
    Alkio uusi = new Alkio(sisalto);
    if ( eka != null ) viimeinen.seuraava = uusi;
    else eka = uusi;
    viimeinen = uusi;
  }

  @Override
  public String toString() {
    StringBuffer s = new StringBuffer("");
    for (Alkio alkio=eka; alkio!=null; alkio = alkio.seuraava )
      s.append(" " + alkio.getSisalto());
    return s.toString();
  }

  public static void main(String[] args) {
    LinLista luvut = new LinLista();
    luvut.lisaa(0); 
    luvut.lisaa(2);
    luvut.lisaa(99);
    System.out.println(luvut);
  }
}