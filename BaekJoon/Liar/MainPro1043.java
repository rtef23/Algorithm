package Liar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro1043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line;
		StringTokenizer tok;
		int n, m;//n is the number of people, m is the number of party
		boolean party[][];
		boolean isknow[];
		
		line = scan.nextLine();
		tok = new StringTokenizer(line, " ");
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		
		party = new boolean[m + 1][n + 1];
		isknow = new boolean[n + 1];
		
		Arrays.fill(isknow, false);
		
		line = scan.nextLine();
		tok = new StringTokenizer(line, " ");
		int num = Integer.parseInt(tok.nextToken());
		for(int i = 0;i < num;i++){
			isknow[Integer.parseInt(tok.nextToken())] = true;
		}
		
		Arrays.fill(party[0], false);
		for(int i = 0;i < m;i++){
			Arrays.fill(party[i + 1], false);
			line = scan.nextLine();
			tok = new StringTokenizer(line, " ");
			int par_num = Integer.parseInt(tok.nextToken());
			for(int j = 0;j < par_num;j++){
				party[i + 1][Integer.parseInt(tok.nextToken())] = true;
			}
		}
		System.out.printf("%d\n", F(n, m, isknow, party));
		
		scan.close();
	}
	public static int F(int n, int m, boolean isknow[], boolean party[][]){
		int cnt = 0;
		boolean ischecked[] = new boolean[n + 1];
		boolean isliable[] = new boolean[m + 1];
		
		Arrays.fill(ischecked, false);
		Arrays.fill(isliable, true);
		
		int isknow_index = 1;
		boolean ischanged = false;
		
		while(true){
			if(isknow[isknow_index] && !ischecked[isknow_index]){
				ischanged = true;
				ischecked[isknow_index] = true;
				for(int j = 1;j <= m;j++){
					if(party[j][isknow_index]){
						isliable[j] = false;
						for(int i = 1;i <= n;i++){
							if(party[j][i])
								isknow[i] = true;
						}
					}
				}
			}
			isknow_index++;
			if(isknow_index > n){
				if(!ischanged){
					break;
				}
				isknow_index--;
				isknow_index %= n;
				isknow_index++;
				ischanged = false;
			}
		}
		for(int i = 1;i < m + 1;i++)
			if(isliable[i])
				cnt++;
		
		return cnt;
	}
}
