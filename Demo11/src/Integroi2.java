import static java.lang.Math.*;

/**
 * Ohjelmalla integroidaan numeerisesti funktio sin(x)
 * @author Vesa Lappalainen
 * @version 1.0, 25.03.2003
 */
public class Integroi2 {

    /**
     * Rajapinta kaikille funktiolle R->R
     */
    public interface FunktioRR {
        /**
         * @param x piste jossa lasketaan
         * @return funktion arvo pisteessä
         */
        public double f(double x);
    }

    /**
     * Luokka sini-funktiolla
     */
    public static class SinFun implements FunktioRR {
        @Override
        public double f(double x) {
            return Math.sin(x);
        }
    }

    /**
     * Luokka 2-asteen polynomille
     */
    public static class P2 implements FunktioRR {
        private double a;
        private double b;
        private double c;

        /**
         * Alustetaan polynomiksi x^2 
         */
        public P2() {
            a = 1;
        }


        /**
         * Alustetaan polynomi kertoimilla
         * @param a x^2 kerroin
         * @param b x:n kerroin
         * @param c vakiotermi
         */
        public P2(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double f(double x) {
            return a * x * x + b * x + c;
        }
    }


    /**
     * Integroidaan sin(x) välillä x1-x2
     * @param f integroitva funktio-olio
     * @param x1 alkuarvo
     * @param x2 loppuarvo
     * @param tiheys monellako askeleella
     * @return likiarvo integraalille
     */
    public static double integroi(FunktioRR f, double x1, double x2, int tiheys) {
        double summa = 0;
        double dx = (x2 - x1) / tiheys;
        for (double x = x1 + dx / 2; x < x2; x += dx)
            summa += f.f(x) * dx;
        return summa;
    }

    public static double funMin(FunktioRR funktio, double a, double b){
    	int tiheys = 1000;
    	double minimin = funktio.f(a);

    	double dx = (b/a)/tiheys;
    	
    	for(double x = a; x<=b; x+=dx){
    		if(funktio.f(x)< minimin){
    			minimin = funktio.f(x);
    		}
    	}
    	return minimin;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        SinFun sin = new SinFun();
        double ala = integroi(sin, 0, PI, 10000);
        System.out.printf("%17.15f%n", ala);
        P2 p2 = new P2(1, 2, -3); // x^2 +2x -3 x^2 1/3*x^3
        ala = integroi(p2, 0, 3, 100);
        System.out.printf("%17.15f%n", ala);
        p2 = new P2(1, 2, 0); // x^2 +2x -3 x^2 1/3*x^3
        ala = integroi(p2, 0, 3, 10000);
        System.out.printf("%17.15f%n", ala);
        double minimi = funMin(sin, 2, -3);
        System.out.printf("%17.15f%n", minimi);
    }

}