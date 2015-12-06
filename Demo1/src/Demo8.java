import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Demo8 {

	private static final Scanner lukija = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Anna rivillinen teksti‰: ");
		String teksti = lukija.nextLine();
		String[][] osat = teeOsaTaulut(teksti);
		System.out.println("VokaTaulu -- " + osat[0].length + " sanaa");
		tulostaStringTaulu(osat[0]);
		System.out.println("KonsoTaulu -- " + osat[1].length + " sanaa");
		tulostaStringTaulu(osat[1]);

		
		
	}
public static String[][] teeOsaTaulut(String tekstiRivi){
	String[][] osat = { new String[0], new String[0]};
	StringTokenizer sanat = new StringTokenizer(tekstiRivi);
	while (sanat.hasMoreTokens()){
		String sana = sanat.nextToken();
		if (onVokaali (sana.charAt(0)))
			osat[0] = lis‰‰String(osat[0], sana);
		else
			osat[1] = lis‰‰String(osat[1], sana); 
	}
	return osat;
}
public static String[] lis‰‰String(String[] taulu, String jono){
	String[] uusiTaulu = Arrays.copyOf(taulu, taulu.length+1);
	uusiTaulu[taulu.length]=jono;
	return uusiTaulu;
}
public static boolean onVokaali (char c){
	if("aeiouyÂ‰ˆ".indexOf(Character.toLowerCase(c)) != -1)
		return true;
	return false;
}
public static void tulostaStringTaulu(String[] taulu){
	if (taulu == null || taulu.length == 0)
		return;
	for (int i=0; i<taulu.length; i++)
		System.out.println(taulu[i] + " ");
	System.out.println();
}

	
}
