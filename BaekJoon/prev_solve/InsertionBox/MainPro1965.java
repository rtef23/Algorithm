package prev_solve.InsertionBox;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro1965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i < n;i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println(F(arr, n));
	}
	public static int F(int arr[], int n){
		//n개의 상자중 최대 상자 갯수
		int memo[] = new int[n];
		
		Arrays.fill(memo, -1);
		int largest = -1;
		for(int i = 0;i < n;i++){
			int tmp = G(arr, memo, i);
			largest = (tmp > largest)?tmp:largest;
		}
		return largest;
	}
	public static int G(int arr[], int memo[], int n){
		//n번째 상자를 마지막으로 하는 최대 상자 갯수
		if(n == 0){
			return 1;
		}
		if(memo[n] != -1){
			return memo[n];
		}
		int largest = 0;
		for(int i = n - 1;i >= 0;i--){
			if(arr[i] >= arr[n]){
				continue;
			}
			int tmp = G(arr, memo, i);
			largest = (tmp > largest)?tmp:largest; 
		}
		memo[n] = largest + 1;
		return memo[n];
	}
}
