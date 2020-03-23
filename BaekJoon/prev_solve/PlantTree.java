package prev_solve;

import java.util.Scanner;

public class PlantTree {
	private static final float limit = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int tree_pos[] = new int[n];
		for(int i = 0;i < n;i++){
			tree_pos[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println((int)F(n, tree_pos));
	}
	public static float F(int n, int tree_pos[]){
		int plus = tree_pos[0];
		float res = 1;
		
		for(int i = 1;i < n;i++){//cost i+1 th
			
		}
		
		return res % limit;
	}

}
