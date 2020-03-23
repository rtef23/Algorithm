package prev_solve.FindPath;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro11403 {
	private static final int exist = 1;
	private static final int not_exist = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());
		boolean map[][] = new boolean[n][n];

		for(int i = 0;i < n;i++){
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line, " ");
			for(int j = 0;tok.hasMoreTokens();j++){
				int t = Integer.parseInt(tok.nextToken());
				map[i][j] = (t == 1)?true:false;
			}
		}
		
		int res[][] = findPath(map, n);
		System.out.println(Arrays.deepToString(res).replace("[[", "").replace("],", "\n").replace("]]", "").replace(",", "").replace(" [", ""));
		scan.close();
	}
	public static int[][] findPath(boolean map[][], int n){
		int memo[][] = new int[n][];
		
		for(int i = 0;i < n;i++){
			memo[i] = buildMap(map, n, i);
		}
		
		return memo;
	}
	public static int[] buildMap(boolean map[][], int n, int from){
		int memo[] = new int[n];
		
		Arrays.fill(memo, not_exist);
		return buildMap(memo, map, n, from);
	}
	public static int[] buildMap(int memo[], boolean map[][], int n, int from){
		for(int i = 0;i < n;i++){
			if(map[from][i] && memo[i] == not_exist){
				memo[i] = exist;
				buildMap(memo, map, n, i);
			}
		}
		return memo;
	}
}
