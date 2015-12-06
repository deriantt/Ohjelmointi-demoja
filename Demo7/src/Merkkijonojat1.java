


public class Merkkijonojat1 {

	/**
	 * @param args
	 */
	/**
	 * @param jono testattava merkkijono
	 * @param k jono jossa löydettävät kirjaimet
	 * @example
	 * <pre name="test">
	 * String jono = "kissa";
	 * String eiole = "aik";
	 * String on = "aiks";
	 * onkoKirjaimia(jono, eiole) 	=== false;
	 * onkoKirjaimia(jono, on) 		=== true;
	 * </pre>
	 */
	public static boolean onkoKirjaimia(String jono, String k){

		for(int i = 0; i < jono.length(); i++){
			char a = jono.charAt(i); 
			if(k.indexOf(a) == -1) return false;
			}
		return true;
	
	}
	/**
	 * 
	 * @param jono haetaan tästä kirjainta
	 * @param a haettu kirjain
	 * @return viimeinen a:n esiintymä jonossa
	 * <pre name ="test">
	 * jononViimeinenChar("kissa", s) === 3;
	 * 
	 * </pre>
	 */
	public static int jononViimeinenChar(String jono, char a){
		
		int vikaindeksi = jono.lastIndexOf(a);
		return vikaindeksi;
	}
	
	/**
	 * 
	 * @param jono merkkijono
	 * @param merkit merkkejä joita haetaan merkkijonosta
	 * @return true/false
	 */
	public static boolean onkoJokinMerkki(String jono, String merkit){
		 
		for(int i = 0; i < jono.length()- 1; i++){
			for(int e = 0; e < merkit.length() - 1; e++){
			if(jono.charAt(i) == merkit.charAt(e))return true;
			}
		}
		return false;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Tehtävä a
		String jono = "kissa";
		String k = "aik";
		String k2 = "aiks";
		if(onkoKirjaimia(jono, k))System.out.println(jono + " " + k + " löytyy samat");
		else{System.out.println(jono + " " + k + " ei löydy samat");}
		if(onkoKirjaimia(jono, k2))System.out.println(jono + " " + k2 + " löytyy samat");
		else{System.out.println(jono + " " + k2 + " ei löydy samat");}
		
		// Tehtävä b
		jono = "lentokone";
		char vika = jono.charAt(6);
		System.out.println(jononViimeinenChar(jono, vika));
		
		//Tehtävä c
		jono = "kissa";
		k = "ibm";
		String c = "pc";
		
		if(onkoJokinMerkki(jono, k))System.out.println("Löytyy");
		if(onkoJokinMerkki(jono, c))System.out.println("Löytyy");
			
	}

}
