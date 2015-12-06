

	/* Tee ohjelma, jolla voidaan tutkia v�itett�:
	 V�ite: Kun lasketaan yhteen parittomia lukuja ykk�sest� eteenp�in 1+3+5+7+...
	 niin summan arvo on sama kuin summaan sis�ltyneiden lukujen lukum��r�n neli�.
	 Siis esimerkiksi: summa 1+3+5+7 = 16, joka on sama kuin 4*4.
	 */

	import java.util.Scanner;

	public class Testi {
	    private static final Scanner lukija = new Scanner(System.in);

	    public static void main(String[] args) {
	        System.out.println("V�ite: "
	                        + "Kun lasketaan yhteen parittomia lukuja ykk�sest� eteenp�in 1+3+5+7+...\n"
	                        + "niin summan arvo on sama kuin summaan sis�ltyneiden lukujen lukum��r�n neli�.");
	        System.out
	                .print("Kuinka monta paritonta lukua summataan j�rjestyksess�: ");
	        int montako = lukija.nextInt();
	        int summa = 0;
	        int seuraavaPariton = 1;
	        for (int i = 1; i <= montako; i++) {
	            summa = summa + seuraavaPariton;
	            seuraavaPariton = seuraavaPariton + 2;
	            // Seuraavalla lauseella saat v�litulostusta.
	            /*
	             * System.out.printf("Lukuja summassa %d lukua. Summa on %d." +
	             * " Luvun %d neli� on %d\n", i, summa, i, i*i);
	             */

	        }
	        System.out.printf("Lukuja summassa %d lukua. Summa on %d.%n"
	                + "Luvun %d neli� on %d%n", montako, summa, montako, montako*montako);
	    }
	}