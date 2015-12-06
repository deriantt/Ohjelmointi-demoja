import java.util.*;

public class Ehdokas {
	private double rahat = 0;
	private int aanet = 0;
	
	public Ehdokas(double rahaa, int aania){
		this.rahat = rahaa;
		this.aanet = aania;
	}
	
	/**
	 * Hakee rahat
	 * @return ehdokkaan rahat
 	 */
	public double getRahat(){
		return this.rahat;
	}
	
	/**
	 * Tulostaa ehdokkaan rahat ja äänet
	 */
	public void tulosta(){
		System.out.println("Rahaa " + this.rahat + ", ääniä " + this.aanet);
	}
	
	/**
	 * 
	 * @param aania
	 * @param rahaa
	 * @return true tai false
	 */
	public boolean osta(int aania, double rahaa){
		if(aania*rahaa > this.rahat)return false;
		this.rahat -= aania*rahaa;
		this.aanet += aania; 
		return true;
	}
	
	/**
	 * 
	 * @param ehdokas
	 * @return -1, 1 tai 0	
	 */
	public int compareTo(Ehdokas ehdokas){
		if(this.aanet < ehdokas.aanet)return -1;
		if(this.aanet > ehdokas.aanet)return 1;
		return 0;
	}
	
	public static void main(String[] args)  {
	    Ehdokas ehd1 = new Ehdokas(100000.0, 0);
	    Ehdokas ehd2 = new Ehdokas(20000.0, 300);
	    System.out.println(ehd1); // Tulostaa: Rahaa 100000, ääniä 0
	    System.out.println(ehd2); // Tulostaa: Rahaa 20000, ääniä 300
	    ehd1.osta(200, 100.0); // Ostaa 200 ääntä, 100 mk/kpl
	    System.out.println(ehd1); // Tulostaa: Rahaa 80000, ääniä 200
	    boolean onnistui = ehd2.osta(300, 100);
	    if (!onnistui) System.out.println("Rahat ei riitä :-)");
	    System.out.println(ehd2); // Tulostaa: Rahaa 20000, ääniä 300
	    if (ehd1.compareTo(ehd2) > 0) System.out.println("Ehdokas 1 voitti!");
	    if (ehd1.compareTo(ehd2) < 0) System.out.println("Ehdokas 2 voitti!");
	    if (ehd1.compareTo(ehd2) == 0) System.out.println("Taspeli!");
	    // Vertailu tehdään äänimäärien perusteella.
	    // Esimerkissä tulostuu : Ehdokas 2 voitti!
	}

}

