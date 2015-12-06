package demo6;

public class Lentokone extends Kulkuneuvo {

	private int siipivali;
	
	public Lentokone(int nop, int mat, int siip){
		super(nop, mat);
		siipivali = siip;
	}
	
	public int getSiipivali(){
		return siipivali;
	}
}
