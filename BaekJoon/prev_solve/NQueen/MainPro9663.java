package prev_solve.NQueen;

import java.util.Scanner;

public class MainPro9663 {
	static int n;
	static int res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		int rows[] = new int[n];
		
		positionQueen(rows, 0);
		System.out.println(res);
		
		scan.close();
	}
	
	private static boolean isPromising(int rows[], int rows_size, int test_x_pos){
		if(rows_size <= 0)
			return true;
		for(int i = 0;i < rows_size;i++){
			if(rows[i] == test_x_pos || Math.abs(rows_size - i) == Math.abs(rows[i] - test_x_pos)){
				return false;
			}
		}
		return true;
	}
	private static void positionQueen(int rows[], int y){
		if(y == n){
			//this case is solution
			res++;
			return;
		}
		for(int x = 0;x < n;x++){
			if(isPromising(rows, y, x)){
				rows[y] = x;
				positionQueen(rows, y + 1);
			}
		}
	}
}