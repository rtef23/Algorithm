package BoggleGame;

import java.util.Scanner;

public class MainBoggle {
	private static final String yes = "YES";
	private static final String no = "NO";
	private static final int map_size = 5;
	private static final int mov_x[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static final int mov_y[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int num_mov = 8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		for(int i = 0;i < t;i++){
			char map[][] = new char[map_size][];
			String search_str[];
			int n;
			for(int j = 0;j < map_size;j++)
				map[j] = scan.next().toCharArray();
			n = scan.nextInt();
			search_str = new String[n];
			
			for(int j = 0;j < n;j++)
				search_str[j] = scan.next();
			
			for(int j = 0;j < n;j++)
				System.out.printf("%s %s\n", search_str[j], (isExt(map, search_str[j])? yes:no));
		}
		
		scan.close();
	}
	private static boolean isExt(char map[][], String search_str){
		boolean memo[][][] = new boolean[2][map_size][map_size];
		
		for(int i = 0;i < map_size;i++)
			for(int j = 0;j < map_size;j++)
				if(map[i][j] == search_str.charAt(0)){
					memo[0][i][j] = true;
					memo[1][i][j] = false;
				}else{
					memo[0][i][j] = memo[1][i][j] = false;
				}
		
		return goWay(map, memo, search_str, 1);
	}
	private static boolean goWay(char map[][], boolean memo[][][], String search_str, int depth){
		if(search_str.length() == depth)
			return true;
		int cur_map_index = depth % 2;
		int prev_map_index = (depth + 1) % 2;
		boolean cng = false;
		
		for(int i = 0;i < map_size;i++){
			for(int j = 0;j < map_size;j++){
				if(memo[prev_map_index][i][j]){
					for(int k = 0;k < num_mov;k++){
						if(i + mov_x[k] >= map_size || i + mov_x[k] < 0)
							continue;
						if(j + mov_y[k] >= map_size || j + mov_y[k] < 0)
							continue;
						if(map[i + mov_x[k]][j + mov_y[k]] == search_str.charAt(depth)){
							cng = true;
							memo[cur_map_index][i + mov_x[k]][j + mov_y[k]] = true;
						}
					}
					memo[prev_map_index][i][j] = false;
				}
			}
		}
		if(!cng)
			return false;
		else
			return goWay(map, memo, search_str, depth + 1);
	}
}
