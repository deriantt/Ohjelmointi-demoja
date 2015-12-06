/**
 * Tutki päytätestin avulla mitä ohjelma tulostaa.
 * Merkitse myös milloin mikäkin olio muuttuu "roskaksi".
 * @author Vesa Lappalainen
 * @version 1.0, 09.03.2003
 */
@SuppressWarnings("synthetic-access")
public class SorsaT1 { 
  /* 09 */ protected static class Sorsa {
  /* 10 */   private int vari;
  /* 11 */   private String nimi;
  /* 12 */
  /* 13 */   private Sorsa() { nimi = "Repe"; vari = 0; }
  /* 14 */   private Sorsa(StringBuffer inimi) {
  /* 15 */     inimi.append("Aku"); vari = 2;
  /* 16 */   }
  /* 17 */
  /* 18 */
  /* 19 */
  /* 20 */   private void hyppaa(Sorsa apu) {
  /* 21 */     apu.nimi = "Senkin Sorsa";
  /* 22 */     vari++;
  /* 23 */   }
  /* 24 */   private void tulosta() {
  /* 25 */     vari++;
  /* 26 */     System.out.println(nimi + " " + vari);
  /* 27 */   }
  /* 28 */ } 
  /* 29 */ /** @param args ei käytössä */
  /* 30 */ public static void main(String[] args)
  /* 31 */ {
  /* 32 */   StringBuffer nimi = new StringBuffer("Väiski");
  /* 33 */   Sorsa aku = new Sorsa(nimi); // NOPMD
  /* 34 */   System.out.println(nimi);
  /* 35 */   aku.tulosta();
  /* 36 */   {
  /* 37 */     Sorsa repe = new Sorsa(); // NOPMD
  /* 38 */     repe.tulosta();
  /* 39 */     aku.hyppaa(repe);
  /* 40 */     aku.tulosta();
  /* 41 */     aku = repe;
  /* 42 */   }
  /* 43 */   aku.tulosta();
  /* 44 */ }
}