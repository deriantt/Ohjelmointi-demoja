
public class Paras {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tulokset = {1,2,3,2,3,4,6,4,3,2,2,5,7,9,9,7,6,24,5,4,6,7};
		
		int pars = paras(tulokset);
		int sum = summa(tulokset);
		System.out.println("Paras tulos on " + pars);
		System.out.println("Tulosten summa " + sum);
	}
	public static int paras(int[] tau){
		int v = 0;
		int prs = 0;
		for(int i = 0; i<tau.length; i++){
			v = tau[(i + 1)];
			if(tau[i] < v){
				prs = v;
			}
			else{prs = tau[i];}
		}
		return prs;
	}
	public static int summa(int[] taul){
		int s = 0;
		
		for (int i=0; i<taul.length; i++){
		s = s + taul[i];
		}
		return s;
	}

	
}
