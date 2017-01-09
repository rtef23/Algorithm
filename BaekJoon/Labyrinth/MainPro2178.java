package Labyrinth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MainPro2178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n, m;
		boolean map[][];
		String line;
		StringTokenizer tok;
		
		line = scan.nextLine();
		
		tok = new StringTokenizer(line, " ");
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		
		map = new boolean[n][m];
		for(int i = 0;i < n;i++){
			line = scan.nextLine();
			char c[] = line.toCharArray();
			for(int j = 0;j < m;j++){
				map[i][j] = c[j] == '1';
			}
		}
		
		S(n, m, map);
		
		scan.close();
	}
	public static int S(int n, int m, boolean map[][]){
		int cnt = 0;
		
		boolean memo[][][] = new boolean[2][n][m];
		
		
		return cnt;
	}
	public static void printArr(boolean a[][]){
		for(int i = 0;i < a.length;i++){
			for(int j = 0;j < a[i].length;j++){
				System.out.printf("[%d][%d] %b\t", i, j, a[i][j]);
			}
			System.out.println();
		}
	}

}
