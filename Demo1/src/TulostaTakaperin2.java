
import java.util.Arrays;
import java.util.Scanner;

/* Tee ohjelma, joka lukee k�ytt�j�n n�pp�imist�lt� antamia
 kokonaislukuja sovittuun tunnistimeen asti tai korkeintaan
 viisi lukua. Sitten tulostetaan luetut luvut p�invastaisessa
 j�rjestyksess� kuin miss� ne luettiin.
 T�ss� ratkaisussa on k�ytetty Java-kirjan valmiita metodeja,
 joiden yksityiskohtia kannattaa tutkia.
 Huom: Pelkk�� tulostamista varten taulukkoa ei normaalisti
 tietenk��n k��nnet�. */

public class TulostaTakaperin2 {
	public static final int SEIS = -99;
	public static final int MAX_M��R� = 5;
	private static final Scanner lukija = new Scanner(System.in);

	public static void main(String[] args) {
		int[] luvut = lueTauluun();
		System.out.print("Etuperin : ");
		tulostaTaulu(luvut);
		k��nn�Taulu(luvut);
		System.out.print("Takaperin: ");
		tulostaTaulu(luvut);
	}
	public static void k��nn�Taulu(int[] a) {
		int i = 0, j = a.length - 1;
		while (i < j)
			swap(a, i++, j--);
	}
	public static void swap(int[] a, int i, int j) {
		int apu = a[i];
		a[i] = a[j];
		a[j] = apu;
	}
	public static int[] lueTauluun() {
		int[] a = new int[0];
		int luku, lukujenM��r� = 0;
		System.out.println("Anna kokonaislukuja,lopetus = " + SEIS);
		while ((luku = lukija.nextInt()) != SEIS) {
			a = lis��Luku(a, luku);
			if (++lukujenM��r� == MAX_M��R�)
				break;
		}
		return a;
	}
        public static int[] lis��Luku(int[] taulu, int arvo) {
          int[] uusiTaulu = Arrays.copyOf(taulu, taulu.length + 1);
          uusiTaulu[taulu.length] = arvo;
          return uusiTaulu;
        }
	public static void tulostaTaulu(int[] a) {
		if (a == null)
			return;
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}
