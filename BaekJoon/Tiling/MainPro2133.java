package Tiling;

import java.util.Scanner;

public class MainPro2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		
		System.out.println(getSol(i));
		scan.close();
	}
	private static int getSol(int i){
		/*
		 * Status Dynamic programming
		 * M[i] : return the number of method that fill the 3xN tile
		 * M[i][l] : return the number of method which fills the 3xi tile and last block state is l
		 * 
		 * N : not fill	
		 * F : Fill
		 * 
		 * n = 	0	1	2	3	4	5	6	7
		 * 		N	F	F	F	N	N	N	F
		 * 		N	N	F	F	F	F	N	N
		 * 		N	N	N	F	N	F	F	F
		 * 
		 * n = 	0
		 * 	F	N
		 * 	F	N
		 * 	F	N
		 * 
		 * n =	1
		 * 	N	F
		 * 	F	N
		 * 	F	N
		 * 
		 * n =	2
		 * 	N	F	|	F	F
		 * 	N	F	|	F	F
		 * 	F	N	|	F	N
		 * 
		 * n =	3
		 * 	F	F	|	N	F	|	N	F
		 * 	F	F	|	F	F	|	N	F
		 * 	N	F	|	F	F	|	N	F
		 * 
		 * n =	4
		 * 	F	N
		 * 	N	F
		 * 	F	N
		 * 
		 * n =	5
		 * 	F	N	|	F	N
		 * 	N	F	|	F	F
		 * 	N	F	|	F	F
		 * 
		 * n =	6
		 * 	F	N
		 * 	F	N
		 * 	N	F
		 * 
		 * n =	7
		 * 	N	F
		 * 	F	N
		 * 	N	F
		 * 
		 * D[i][0] = D[i - 1][3]
		 * D[i][1] = D[i - 1][5]
		 * D[i][2] = D[i - 1][6] + D[i - 1][3]
		 * D[i][3] = D[i - 1][2] + D[i - 1][5] + D[i - 1][0]
		 * D[i][4] = D[i - 1][7]
		 * D[i][5] = D[i - 1][1] + D[i - 1][3]
		 * D[i][6] = D[i - 1][2]
		 * D[i][7] = D[i - 1][4]
		 * 
		 * */
		int M[][] = new int[i + 1][8];

		//initialize
		for(int j = 0;j < i + 1;j++)
			for(int k = 0;k < 8;k++)
				M[j][k] = -1;
		
		M[1][0] = 1;
		M[1][1] = 0;
		M[1][2] = 1;
		M[1][3] = 0;
		M[1][4] = 0;
		M[1][5] = 1;
		M[1][6] = 0;
		M[1][7] = 0;

		return go(M, i, 3);
	}
	private static int go(int M[][], int n, int l){
		if(n <= 0)
			return 0;
		if(M[n][l] >= 0)
			return M[n][l];
		
		switch (l) {//last status
		case 0:
			M[n][l] = go(M, n - 1, 3);
			break;
		case 1:
			M[n][l] = go(M, n - 1, 5);
			break;
		case 2:
			M[n][l] = go(M, n - 1, 6) + go(M, n - 1, 3);
			break;
		case 3:
			M[n][l] = go(M, n - 1, 2) + go(M, n - 1, 5) + go(M, n - 1, 0);
			break;
		case 4:
			M[n][l] = go(M, n - 1, 7);
			break;
		case 5:
			M[n][l] = go(M, n - 1, 1) + go(M, n - 1, 3);
			break;
		case 6:
			M[n][l] = go(M, n - 1, 2);
			break;
		default://7
			M[n][l] = go(M, n - 1, 4);
			break;
		}
		return M[n][l];
	}
}
