

	/* Tee ohjelma, jolla voidaan tutkia väitettä:
	 Väite: Kun lasketaan yhteen parittomia lukuja ykkösestä eteenpäin 1+3+5+7+...
	 niin summan arvo on sama kuin summaan sisältyneiden lukujen lukumäärän neliö.
	 Siis esimerkiksi: summa 1+3+5+7 = 16, joka on sama kuin 4*4.
	 */

	import java.util.Scanner;

	public class Testi {
	    private static final Scanner lukija = new Scanner(System.in);

	    public static void main(String[] args) {
	        System.out.println("Väite: "
	                        + "Kun lasketaan yhteen parittomia lukuja ykkösestä eteenpäin 1+3+5+7+...\n"
	                        + "niin summan arvo on sama kuin summaan sisältyneiden lukujen lukumäärän neliö.");
	        System.out
	                .print("Kuinka monta paritonta lukua summataan järjestyksessä: ");
	        int montako = lukija.nextInt();
	        int summa = 0;
	        int seuraavaPariton = 1;
	        for (int i = 1; i <= montako; i++) {
	            summa = summa + seuraavaPariton;
	            seuraavaPariton = seuraavaPariton + 2;
	            // Seuraavalla lauseella saat välitulostusta.
	            /*
	             * System.out.printf("Lukuja summassa %d lukua. Summa on %d." +
	             * " Luvun %d neliö on %d\n", i, summa, i, i*i);
	             */

	        }
	        System.out.printf("Lukuja summassa %d lukua. Summa on %d.%n"
	                + "Luvun %d neliö on %d%n", montako, summa, montako, montako*montako);
	    }
	}