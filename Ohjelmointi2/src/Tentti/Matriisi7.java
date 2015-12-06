package Tentti;

import java.util.Scanner;

public class Matriisi7 {
  private static Scanner lukija = new Scanner(System.in);

  public static void main(String[] args) {

    int[][] matriisi = new int[2][3];

    // luetaan arvot:

    for (int rivi=0; rivi<matriisi.length; ++rivi)
      for (int sarake=0; sarake<matriisi[rivi].length; ++sarake) {
        System.out.println("Anna alkio "+rivi+", "+sarake);
        matriisi[rivi][sarake] = lukija.nextInt();
      }

    // kerrotaan alkiot 7:llä:

    for (int rivi=0; rivi<matriisi.length; ++rivi)
      for (int sarake=0; sarake<matriisi[rivi].length; ++sarake)
        matriisi[rivi][sarake] *= 7;  // operaatio '*='kertoo!

    // tulostetaan matriisi:

    System.out.println("Seitsemällä kerrottuna:");
    for (int rivi=0; rivi<matriisi.length; ++rivi) {
      for (int sarake=0; sarake<matriisi[rivi].length; ++sarake)
        System.out.print(matriisi[rivi][sarake]+"\t");
      System.out.println();
    }

    // lasketaan alkioiden summa:

    int summa = 0;
    for (int[] rivi : matriisi)   // nyt tarvitaan vain alkioiden arvot!
      for (int alkio : rivi)
        summa = summa + alkio;
    System.out.println("Alkioiden summa on " + summa + ".");

  }
}
