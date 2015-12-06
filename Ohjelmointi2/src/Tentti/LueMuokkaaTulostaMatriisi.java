package Tentti;

import java.util.Scanner;
import java.io.*;

public class LueMuokkaaTulostaMatriisi {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int[][] matriisi = lueMatriisi("matriisi.txt");
		int[][] matriisi ={{1,1,1},{2,1,2}, {6,6,6}};
		matriisi = kerroMatriisiKokonaisluvulla(matriisi, 2);
		kirjoitaMatriisi(matriisi, "matriisi2.txt");
	}
//----------------------------------------------------------------------------------------------------------------------	
	static Scanner input = null;
	static PrintStream output = null;
	
	private static void kirjoitaMatriisi(int[][] matriisi, String string) {
		try{
		output = new PrintStream(new FileOutputStream(string + ".txt", false));
		}catch (FileNotFoundException e){
			System.out.println("Tiedosto ei aukea " + e.getMessage());
			return;
		}
			if(true){
			    for (int rivi=0; rivi<matriisi.length; ++rivi) {
			        for (int sarake=0; sarake<matriisi[rivi].length; ++sarake)
			          output.println(matriisi[rivi][sarake]+"\t");
			        output.println();}
			}
	
	
		if(output != null)output.close();
	
}		


	private static int[][] kerroMatriisiKokonaisluvulla(int[][] matriisi, int i) {
	    for (int rivi=0; rivi<matriisi.length; ++rivi)
	        for (int sarake=0; sarake<matriisi[rivi].length; ++sarake)
	          matriisi[rivi][sarake] *= i;  // operaatio '*='kertoo!
		return matriisi;
	}

	public static int[][] lueMatriisi(String tiedostonimi){
		try{
			try {
				input = new Scanner(new FileInputStream(new File("matriisi.txt")));
			}catch (FileNotFoundException e){
				System.out.println("Tiedosto ei aukea " + e.getMessage());
				return null;
			}
			while(input.hasNext()){
				int koko = input.nextInt();
				int[][] matriisi;
				matriisi = new int[koko][koko];
				
				try{
					//for (int i = 0; i < matriisi.length; i++) {
					//	for (int j = 0; j < matriisi[i].length; j++) { 
					//			matriisi[i][j] = input.nextInt();
				    for (int rivi=0; rivi<matriisi.length; ++rivi){
				        for (int sarake=0; sarake<matriisi[rivi].length; ++sarake) {
				          matriisi[rivi][sarake] = input.nextInt();
						}
					}
					return matriisi;
				}catch (NumberFormatException ex) { 
					continue;
				}
			}
		}finally{
			if(input != null)input.close();
		}
		return null;
	}
}


