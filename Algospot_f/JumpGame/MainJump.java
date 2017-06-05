package JumpGame;

import java.util.Arrays;
import java.util.Scanner;

public class MainJump {
	private static final String yes = "YES";
	private static final String no = "NO";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		for(int i = 0;i < c;i++){
			int n = scan.nextInt();
			int map[][] = new int[n][n];
			for(int j = 0;j < n;j++){
				for(int k = 0;k < n;k++){
					map[j][k] = scan.nextInt();
				}
			}
			System.out.printf("%s\n", F(map, n)?yes:no);
		}
		scan.close();
	}
	public static boolean F(int map[][], int n){
		int memo[][] = new int[n][n];
		for(int i = 0;i < n;i++){
			Arrays.fill(memo[i], -1);
		}
		memo[0][0] = 0;
		return F(map, n, memo, 0);
	}
	public static boolean F(int map[][], int n, int memo[][], int curStep){
		if(memo[n-1][n-1] != -1){
			return true;
		}
		boolean isThereStep = false;
		for(int y = 0;y < n;y++){
			for(int x = 0;x < n;x++){
				if(memo[y][x] == curStep){
					isThereStep = true;
					if(y + map[y][x] < n){
						memo[y + map[y][x]][x] = curStep + 1;
					}
					if(x + map[y][x] < n){
						memo[y][x + map[y][x]] = curStep + 1;
					}
				}
			}
		}
		return (isThereStep)?F(map, n, memo, curStep + 1):false;
	}
}
