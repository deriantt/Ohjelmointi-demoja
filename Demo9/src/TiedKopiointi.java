import java.util.Scanner;
import java.io.*;

public class TiedKopiointi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = null;
		PrintStream output = null;
		
		try{
			
		try {
			input = new Scanner(new FileInputStream(new File("LukuTiedosto.txt")));
			output = new PrintStream(new FileOutputStream("Tuloste.txt", false));
		}catch (FileNotFoundException e){
			System.out.println("Tiedosto ei aukea " + e.getMessage());
			return;
		}
		
		String jono = null;
		double luku;
		
		while(input.hasNext()){
			jono = input.nextLine();
			try{
				int ind = jono.indexOf(' ');
				if (ind >= 0)jono = jono.substring(0, ind);
				luku = Double.parseDouble(jono);
			}catch (NumberFormatException ex) { 
				continue;
			}
			if(luku > 30){
				output.println(jono);
			}
			
		}
		}finally{
			if(input != null)input.close();
			if(output != null)output.close();
		}
	}

}
