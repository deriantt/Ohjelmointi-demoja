/**
 * @author Deniz
 *
 */
public class PVM {
	/**
	 * @param args
	 */
private int d = 0, m = 0, y = 0;
	
	/**
	 * Alustaa p‰iv‰m‰‰r‰n 
	 * @param d p‰iv‰
	 * @param m kuukausi
	 * @param y vuosi
	 * <pre name = "test"
	 * new PVM(1,1,2013).toString()==="1.1.2013";
	 * </pre>
	 */
	public PVM(int d, int m, int y){ //Muodostaja
		this.d = d;
		this.m = m;
		this.y = y;
	}
    /**
     * @return p‰iv‰m‰‰r‰ merkkijonona muodossa 1.1.2013
     * @example
     * <pre name="test">
     * new PVM(1,1,2013).toString() === "1.1.2013";
     * </pre>
     */
	@Override
	public String toString(){
		return String.format("%02d.%02d.%02d", d, m, y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World!");
		// System.out.println("Pvm on:" + PVM);
	}

}
