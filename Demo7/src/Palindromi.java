
public class Palindromi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sana = "abba";
		boolean a = true;
		a = onkoPalindromi(sana);
		if(a)System.out.println("Sana on palindromi");
		else{System.out.println("Sana ei ole palindromi");}
	}
	/*
	 * Tarkastaa sanojen samankaltaisuuden
	 * 
	 */
	
	public static boolean onkoPalindromi(String sana){
		
		if(kaanna(sana).equals(sana))return true;
		

		return false;
		
	}
	public static String kaanna(String sana){
		String kaannos = new StringBuffer(sana).reverse().toString();
		
		return kaannos;
	}

}
