package FENCE;

import java.util.Scanner;

public class MainFence {
	private static final int unknown = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;//testcase
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		
		for(int i = 0;i < t;i++){
			int n = scan.nextInt();
			int fence[] = new int[n];
			
			for(int j = 0;j < n;j++){
				fence[j] = scan.nextInt();
			}
			//end input
			
			System.out.println(getSol(fence, n));
		}
		
		scan.close();
	}
	private static int getSol(int fence[], int n){
		int width[] = new int[n];
		int max_size = unknown;
		
		for(int i = 0;i < n;i++){
			int left_most_index = i;
			int right_most_index = i;
			
			for(;left_most_index >= 0;left_most_index--){
				if(fence[left_most_index] < fence[i]){
					left_most_index++;
					break;
				}
			}
			if(left_most_index < 0)
				left_most_index = 0;
			for(;right_most_index < n;right_most_index++){
				if(fence[right_most_index] < fence[i]){
					right_most_index--;
					break;
				}
			}
			if(right_most_index >= n)
				right_most_index = n - 1;
			max_size = max(max_size, (right_most_index - left_most_index + 1) * fence[i]);
		}
		return max_size;
	}
	private static int max(int a, int b){
		return (a > b)? a:b;
	}
}
