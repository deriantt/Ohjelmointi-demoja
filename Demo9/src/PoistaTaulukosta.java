
public class PoistaTaulukosta {

	
	/**
	 * Ohjelma aliohjelma poistaa luvun m esiintym‰t
	 * @param taulukko josta poistetaan lukuja
	 * @param lkm alkioiden lukum‰‰r‰
	 * @param n mik‰ luku tulee poistaa taulukosta
	 * @return montako lukua poistettu
	 * @example
	 * <pre name="test">
	 * int a[]= {1,2,4,3,3,2,4};
	 * int lkm = 7;
	 * lkm poista(a, lkm, 3) === 5; 
	 * </pre>
	 */
	public static int poista(int[] taulukko, int lkm, int n){
		if(0 < lkm){
			int i = 0;
			for(int j = 0; j < lkm; j++)
				if(taulukko[j] != n)
					taulukko[i++] = taulukko[j];
					return i;
				}
		
				else return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
