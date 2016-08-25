package Algorithm;

public class Main_purchaseApple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price = 25;
		
		System.out.println(getSol(price));
	}
	private static int getSol(int n){
		/*
		 * M[n] : the total number of method which price is n
		 * M[n, i] : with i th value, the total number of method which price is n
		 * d[i] : i th value
		 * 
		 * M[n] = M[n, max(i)]
		 * M[n, i] = sum(M[n - d[i] * k, i - 1])
		 * M[0, i] = 1
		 * M[n, 0] = 0
		 * 
		 * running time : O(n * i)
		 * */
		int money[] = {0, 1, 5, 10, 25};
		int M[][] = new int[n + 1][money.length];
		
		int res = go(M, money, n, money.length - 1);
		for(int i = 0;i < n+1;i++){
			for(int j = 0;j < money.length;j++)
				System.out.printf("M[%02d][%02d] : %02d\t", i, money[j], M[i][j]);
			System.out.println();
		}
		return res;
	}
	private static int go(int M[][], int d[], int n, int i){
		if(n == 0)
			return 1;
		if(i == 0)
			return 0;
		if(M[n][i] > 0)
			return M[n][i];
		
		for(int k = 0;n - d[i] * k >= 0;k++)
			M[n][i] += go(M, d, n - d[i] * k, i - 1);
		return M[n][i];
	}
	private static boolean CanBePrice(int i, int j, int k, int price){
		return (i * 200 + j * 300 + k * 400 == price);
	}
}
