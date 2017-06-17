package Packing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = Integer.parseInt(scan.nextLine().trim());
		String line;
		StringTokenizer tok;
		for(int i = 0;i < c;i++){
			line = scan.nextLine();
			tok = new StringTokenizer(line, " ");
			int n = Integer.parseInt(tok.nextToken());
			int w = Integer.parseInt(tok.nextToken());
			String name[] = new String[n];
			int mass[] = new int[n];
			int need[] = new int[n];
			for(int j = 0;j < n;j++){
				line = scan.nextLine();
				tok = new StringTokenizer(line, " ");
				name[j] = tok.nextToken();
				mass[j] = Integer.parseInt(tok.nextToken());
				need[j] = Integer.parseInt(tok.nextToken());
			}
			ArrayList<Integer> res = new ArrayList<>();
			int ret = F(res, n, w, name, mass, need);
			System.out.printf("%d %d\n", ret, res.size());
			for(int j = 0;j < res.size();j++)
				System.out.println(name[res.get(j)]); 
		}
		scan.close();
	}
	public static int F(ArrayList<Integer> res, int n, int w, String name[], int mass[], int need[]){
		int memo[][] = new int[n + 1][w + 1];
		
		for(int i = 0;i <= n;i++){
			Arrays.fill(memo[i], -1);
		}
		
		int ret = F(res, memo, w, n - 1, mass, need);
		return ret;
	}
	public static int F(ArrayList<Integer> res, int memo[][], int w, int n, int mass[], int need[]){
		if(w <= 0)
			return 0;
		if(n == 0)
			return need[n];
		if(memo[n][w] != -1)
			return memo[n][w];
		
		if(w < mass[n]){
			memo[n][w] = F(res, memo, w, n - 1, mass, need);
		}else{//w >= mass[n] ; w - mass[n] >= 0
			int f1 = F(res, memo, w - mass[n], n - 1, mass, need) + need[n];
			int f2 = F(res, memo, w, n - 1, mass, need);
			if(f1 > f2 && !res.contains(n)){
				res.add(n);
			}
			memo[n][w] = max(f1, f2);
		}
		
		return memo[n][w];
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
