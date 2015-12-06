import java.util.List;

import fi.jyu.mit.ohj2.Tiedosto;


public class TiedKaList {

	/**
	 * Lukujen lukeminen tiedostosta
	 * @author Deniz
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> rivit = Tiedosto.lueTiedostoListaan("luvut.dat");
		System.out.println(rivit);
	}

}
