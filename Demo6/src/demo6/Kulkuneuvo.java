package demo6;

public class Kulkuneuvo {

	private int nopeus;
	private int matkustajia;
	
	public Kulkuneuvo(int nop, int mat){
		nopeus = nop;
		matkustajia = mat;
	}
	
	/**
	 * Hakee nopeuden
	 * @return
	 */
	
	public int getNopeus(){
		return nopeus;
	}
	
	/**
	 * Hakee matkustajien lukumäärän
	 * @return
	 */
	public int getMatkustajia(){
		return matkustajia;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Laiva laiva = new Laiva(60,30,10000);
		Lentokone lentokone = new Lentokone(600,150,30);
		Kulkuneuvo kulkuneuvo = new Kulkuneuvo(160, 4);
		
		System.out.println("Laivan tietoja matkustajamäärä: " + laiva.getMatkustajia() +
		" nopeus: "	+ laiva.getNopeus()+ " Paino: " + laiva.getPaino());
		System.out.println("Lentokoneen tietoja matkustajamäärä: " + lentokone.getMatkustajia() +
				" nopeus: "	+ lentokone.getNopeus()+ " Siipiväli: " + lentokone.getSiipivali());
		System.out.println("Kulkuneuvon tietoja matkustajamäärä: " + kulkuneuvo.getMatkustajia() +
				" nopeus: "	+ kulkuneuvo.getNopeus());
		
	}

}
