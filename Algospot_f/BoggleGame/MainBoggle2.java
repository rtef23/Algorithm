package BoggleGame;

import java.util.Scanner;

public class MainBoggle2 {
	private static final int MAP_SIZE = 5;
	private static final int dx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static final int dy[] = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static final int dlen = 8;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		
		for(int i = 0;i < c;i++){
			char map[][] = new char[MAP_SIZE][MAP_SIZE];
			String word_set[];
			int n;
			
			for(int j = 0;j < MAP_SIZE;j++){
				map[j] = scan.next().toCharArray();
			}
			n = scan.nextInt();
			word_set = new String[n];
			
			for(int j = 0;j < n;j++){
				word_set[j] = scan.next();
			}
			for(int j = 0;j < n;j++){
				System.out.printf("%s %s\n", word_set[j], (F(map, word_set[j]))?"YES":"NO");
			}
		}
		
		scan.close();
	}
	public static boolean F(char map[][], String word){
		boolean memo[][][] = new boolean[2][MAP_SIZE][MAP_SIZE];
		
		for(int i = 0;i < MAP_SIZE;i++){
			for(int j = 0;j < MAP_SIZE;j++){
				memo[1][i][j] = false;
				if(word.charAt(0) == map[i][j]){
					memo[0][i][j] = true;
				}else{
					memo[0][i][j] = false;
				}
			}
		}
		return F(map, memo, word, 1);
	}
	public static boolean F(char map[][], boolean memo[][][], String word, int index){
		if(index >= word.length()){
			return true;
		}
		boolean hasCng = false;
		int target_memo = (index % 2 == 0)?1:0;
		int next_target_memo = (index % 2 == 0)?0:1;
		
		for(int i = 0;i < MAP_SIZE;i++){
			for(int j = 0;j < MAP_SIZE;j++){
				if(memo[target_memo][i][j]){
					for(int k = 0;k < dlen;k++){
						if(i + dy[k] < 0 || i + dy[k] >= MAP_SIZE){
							continue;
						}
						if(j + dx[k] < 0 || j + dx[k] >= MAP_SIZE){
							continue;
						}
						if(map[i + dy[k]][j + dx[k]] == word.charAt(index)){
							hasCng = true;
							memo[next_target_memo][i + dy[k]][j + dx[k]] = true;
						}
					}
					memo[target_memo][i][j] = false;
				}
			}
		}
		return (hasCng)?F(map, memo, word, index + 1):false;
	}
}
