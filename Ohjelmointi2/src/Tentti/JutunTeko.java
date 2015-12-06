package Tentti;

import java.util.Arrays;

public class JutunTeko {
	
	public static int[][] teeJuttu(int[][] a, int b){
		for(int i = 0; i<a.length; ++i){
			for(int j = 0; j<a[i].length; ++j){
				a[i][j] *= b;
			}}
		return a;
	}
	
	public static void main(String[] args){
		
		int[][] c = {{1,2},{3,4}, {5,6}};
			
			System.out.println(Arrays.deepToString(c));
			c = teeJuttu(c, 2);
			System.out.println(Arrays.deepToString(c));
		//}
	}
}
