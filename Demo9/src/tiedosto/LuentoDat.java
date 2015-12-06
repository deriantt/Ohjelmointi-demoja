package tiedosto;

import java.util.List;
import fi.jyu.mit.ohj2.Tiedosto;

public class LuentoDat {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> rivit = Tiedosto.lueTiedostoListaan("luvut.dat");
		System.out.println(rivit);
	}

}
