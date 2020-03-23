package prev_solve.countIsland;

import java.util.Scanner;

public class MainPro4963 {
	private static final int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
	private static final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static final int cntD = 8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		while(true){
			int w, h;
			boolean map[][];
			
			w = scan.nextInt();
			h = scan.nextInt();
			
			if(w == 0 && h == 0){
				//end point
				break;
			}
			
			map = new boolean[h][w];
			
			for(int i = 0;i < h;i++){
				for(int j = 0;j < w;j++){
					map[i][j] = (scan.nextInt() == 1);
				}
			}

			System.out.printf("%d\n", countIsland(w, h, map));
		}
		
		scan.close();
	}
	private static int countIsland(int w, int h, boolean map[][]){
		int cnt = 0;
		for(int y = 0;y < h;y++){
			for(int x = 0;x < w;x++){
				if(map[y][x]){
					cnt++;
					removeIsland(map, x, y, w, h);
				}
			}
		}
		return cnt;
	}
	private static void removeIsland(boolean map[][], int x, int y, int w, int h){
		if(x < 0 || x >= w || y < 0 || y >= h)
			return;
		if(!map[y][x])
			return;
		
		map[y][x] = false;
		for(int i = 0;i < cntD;i++){
			removeIsland(map, x + dx[i], y + dy[i], w, h);
		}
	}
}
