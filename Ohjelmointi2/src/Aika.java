//package oliot.aika.olio;
/**
 * Ensimm‰inen kunnon olioesimerkki
 * @author  Vesa Lappalainen @version 1.0, 01.02.2003
 * @author Santtu Viitanen @version 1.1, 7.7.2011
 * @example
 * <pre name="test">
 *  Aika a1 = new Aika(12,15);
 *  a1.lisaa(55);    a1.toString() === "13:10";
 * </pre>
 */
public class Aika {

 private int h=0, m=0;

  /**
   * Alustaa ajan
   * @param h tunnit
   * @param m minuutit
   * @example
   * <pre name="test">
   * new Aika(12,15).toString() === "12:15";
   * </pre>
   */
  public Aika(int h,int m) { // Muodostaja
    this.h = h;
    this.m = m;
  }
  
  /**
   * @return aika merkkijonona muodossa 12:05
   * @example
   * <pre name="test">
   * new Aika(12,15).toString() === "12:15";
   * </pre>
   */
  public String toString() {
      return String.format("%02d:%02d",h, m);
  }

  /**
   * Lis‰‰ aikaan valitun minuuttim‰‰r‰n
   * @param lisaMin lis‰tt‰v‰ minuuttim‰‰r‰
   * @example
   * <pre name="test">
   *  Aika a1 = new Aika(13,16);
   *  a1.lisaa(27);    a1.toString() === "13:43";
   *  a1.lisaa(39);    a1.toString() === "14:22";
   * </pre>
   */
  public void lisaa(int lisaMin)  {
    int yht_min = h * 60 + m + lisaMin;
    h = yht_min / 60;
    m = yht_min % 60;
  }
}

