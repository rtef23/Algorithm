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
			System.out.printf("ret : %d %d\n", ret, res.size());
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
		int ret = 0;
		ret = F(res, memo, mass, need, w, 0);
		System.out.println(Arrays.deepToString(memo).replace("],", "],\n"));
		return ret;
	}
	public static int F(ArrayList<Integer> res, int memo[][], int mass[], int need[], int w, int i){
		if(memo[i][w] != -1)
			return memo[i][w];
		if(i >= mass.length)
			return 0;
		if(w < mass[i]){
			memo[i][w] = F(res, memo, mass, need, w, i + 1);
		}else{//>=
			int f1 = F(res, memo, mass, need, w - mass[i], i + 1) + need[i];
			int f2 = F(res, memo, mass, need, w, i + 1);
			memo[i][w] = max(f1, f2);
		}
		return memo[i][w];
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
}
