package demo;

public class MatriisinSumma {
	
	/**
	 * Palauttaa taulukon alkioiden summan
	 * @param mat
	 * @return summa - alkioiden summa
	 * @example
	 * <pre name="test">
	 * int[][] mat = {{6,3,7,9,2},{5,3,8,3,2}};
	 * matriisinSumma(mat) === 48;
	 * </pre>
	 */
public static int matriisinSumma(int[][] mat){
	int summa = 0;
	for(int i = 0; i < mat.length; i++){
		for(int j = 0; j < mat[i].length; j++){
			summa += mat[i][j];
		}
	}
	return summa;
}


/**
 *Pääohjelma testaamiseen 
 * @param args
 */
public static void main(String[] args){
	int[][] mat = {{4,3,2,4,5},{1,5,3,6,2}};
	int tulos = matriisinSumma(mat);
	System.out.println(tulos);
}
}
