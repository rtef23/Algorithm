package Picnic;

import java.util.Arrays;
import java.util.Scanner;

public class MainPicnic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(int i = 0;i < testcase;i++){
			boolean friend_map[][];
			int n = scan.nextInt();
			int m = scan.nextInt();
			
			friend_map = new boolean[n][n];
			for(int j = 0;j < n;j++)
				Arrays.fill(friend_map[j], false);
			
			for(int j = 0;j < m;j++){
				int p1 = scan.nextInt();
				int p2 = scan.nextInt();
				
				friend_map[p1][p2] = friend_map[p2][p1] = true;
			}
			System.out.printf("%d\n", F(upper(2, n) - 1, n, 0, friend_map));
		}
		
		scan.close();
	}
	public static int F(int total, int n, int s, boolean friend_map[][]){
		if(s == total){
			return 1;
		}
		
		int res = 0;
		int i = 0;
		
		for(;i < n;i++){
			if((s & (1 << i)) == 0){
				break;
			}
		}
		
		for(int j = 0;j < n;j++){
			int tmp = s;
			if(friend_map[i][j] && ((s & (1 << j)) == 0)){
				tmp |= (1 << i);
				tmp |= (1 << j);
				res += F(total, n, tmp, friend_map);
			}
		}
		return res;
	}
	public static int upper(int bottom, int up){
		if(bottom == 1)
			return 1;
		if(up == 0)
			return 1;
		if(up == 1)
			return bottom;
		
		if(up % 2 == 0){
			int tmp = upper(bottom, up / 2);
			return tmp * tmp;
		}else{
			return upper(bottom, up - 1) * bottom;
		}
	}
}
