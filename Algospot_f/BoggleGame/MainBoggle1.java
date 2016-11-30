package BoggleGame;

import java.util.Scanner;

public class MainBoggle1 {
	public static final String yes = "YES";
	public static final String no = "NO";
	public static final int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static final int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(;testcase > 0;testcase--){
			char map[][] = new char[5][5];
			for(int i = 0;i < 5;i++){
				String tmp = scan.next();
				for(int j = 0;j < 5;j++){
					map[i][j] = tmp.charAt(j);
				}
			}
			int num_str = scan.nextInt();
			for(int i = 0;i < num_str;i++){
				String tmp = scan.next();
				System.out.printf("%s %s\n", tmp, (canMake(map, tmp))?yes:no);
			}
			
		}
		scan.close();
	}
	public static boolean canMake(char[][] map, String str){
		boolean tmp_map[][][] = new boolean[2][5][5];
		boolean isChanged = false;
		
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 5;j++){
				if(str.charAt(str.length() - 1) == map[i][j]){
					tmp_map[0][i][j] = true;
					isChanged = true;
				}else{
					tmp_map[0][i][j] = false;
				}
				tmp_map[1][i][j] = false;
			}
		}
		if(!isChanged)
			return false;
		return F(str, str.length() - 2, map, tmp_map, 0);
	}
	public static boolean F(String str, int str_index, char[][] map, boolean[][][] tmp_map, int stage_index){
		/*
		 * F[n] : return find n th character
		 * F[n] = F[n-1]
		 * */
		if(str_index < 0)
			return true;
		int this_stage_index = stage_index % 2;
		int next_stage_index = (stage_index + 1) % 2;
		char this_ch = str.charAt(str_index);
		boolean isChanged = false;
		
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 5;j++){
				if(tmp_map[this_stage_index][i][j]){
					for(int k = 0;k < dx.length;k++){
						int tmp_x = j + dx[k];
						int tmp_y = i + dy[k];
						if(tmp_x >= 0 && tmp_x < 5 && tmp_y >= 0 && tmp_y < 5){
							if(map[tmp_y][tmp_x] == this_ch){
								tmp_map[next_stage_index][tmp_y][tmp_x] = true;
								isChanged = true;
							}
						}
					}
					tmp_map[this_stage_index][i][j] = false;
				}
			}
		}
		if(!isChanged){
			return false;
		}
		return F(str, str_index - 1, map, tmp_map, stage_index + 1);
	}
}
