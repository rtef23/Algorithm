package GetAreaSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2583 {
	final static int BLOCKED_CELL = -1;
	final static int AVAIL_CELL = 10001;
	final static int dsize = 4;
	final static int dx[] = {-1, 0, 1, 0};
	final static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int m = scan.nextInt();
		int n = scan.nextInt();
		int k = scan.nextInt();
		int map[][] = new int[m][n];
		
		for(int i = 0;i < m;i++){
			Arrays.fill(map[i], AVAIL_CELL);
		}
		
		for(int i = 0;i < k;i++){
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			
			fillBlockedCell(map, x1, y1, x2-1, y2-1);
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				int t = getAvailAreaSize(map, j, i, 1, 0);
				if(t > 0){
					res.add(t);
				}
			}
		}
		res.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o1>o2)?1:(o1==o2)?0:-1;
			}
		});
		System.out.println(res.size());
		for(Integer i:res){
			System.out.printf("%d ", i);
		}
		
		scan.close();
	}
	public static void fillBlockedCell(int map[][],int x1, int y1, int x2, int y2){
		for(int i = y1;i <= y2;i++){
			for(int j = x1;j <= x2;j++){
				switch (map[i][j]) {
				case AVAIL_CELL:
					map[i][j] = BLOCKED_CELL;
					break;
				default://already blocked cell
					break;
				}
			}
		}
	}
	public static int getAvailAreaSize(int map[][], int x, int y, int index, int size){
		if(y < 0 || y >= map.length){
			return 0;
		}
		if(x < 0 || x >= map[0].length){
			return 0;
		}
		switch (map[y][x]) {
		case AVAIL_CELL:
			map[y][x] = index;
			size++;
			index++;
			for(int i = 0;i < dsize;i++){
				int t = getAvailAreaSize(map, x+dx[i], y+dy[i], index, 0);
				size += t;
				if(t > 0){
					index++;
				}
			}
			return size;
		case BLOCKED_CELL:
		default:
			return 0;
		}
	}
}
