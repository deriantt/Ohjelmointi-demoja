package demo6;

public class Laiva extends Kulkuneuvo {
	

	private int paino;
	
	public Laiva(int nop, int mat, int pain){
		super(nop,mat);
		paino = pain;
	}
	
	public int getPaino(){
		return paino;
	}

}
