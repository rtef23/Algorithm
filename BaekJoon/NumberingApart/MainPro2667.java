package NumberingApart;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro2667 {
	private static final int d_x[] = {-1, 0, 1, 0};
	private static final int d_y[] = {0, -1, 0, 1};
	private static final int d_len = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int map[][];
		int n = scan.nextInt();//array size
		
		map = new int[n][n];
		
		for(int i = 0;i < n;i++){
			char line[] = scan.next().toCharArray();
			
			for(int j = 0;j < n;j++){
				if(line[j] == '0')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}

		//end input
		ArrayList<Integer> ap_cnt = getApartNum(map, n);
		
		System.out.println(ap_cnt.size());
		//sorting
		Integer i_l[] = new Integer[ap_cnt.size()];
		
		for(int i = 0;i < ap_cnt.size();i++)
			i_l[i] = ap_cnt.get(i);
		
		for(int i = 0;i < ap_cnt.size();i++)
			for(int j = 0;j < i;j++){
				if(i_l[i] < i_l[j]){
					Integer tmp = i_l[i];
					i_l[i] = i_l[j];
					i_l[j] = tmp;
				}
			}
		for(Integer i : i_l)
			System.out.println(i);
		
		scan.close();
	}
	private static ArrayList<Integer> getApartNum(int map[][], int n){
		ArrayList<Integer> res = new ArrayList<>();
		int memo[][] = new int[n][n];
		int apart_index = 1;
		
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				if(map[i][j] == 1 && memo[i][j] == 0){//find can be apartable
					go(map, memo, n, j, i, apart_index++);
				}
			}
		}
		
		for(int i = 1;i < apart_index;i++){
			int cnt = 0;
			for(int j = 0;j < n;j++){
				for(int k = 0;k < n;k++){
					if(memo[j][k] == i)
						cnt++;
				}
			}
			res.add(cnt);
		}
		
		return res;
	}
	private static void go(int map[][],int memo[][], int n, int cur_x, int cur_y, int apart_index){
		if(cur_x < 0 || cur_x >= n)
			return;
		if(cur_y < 0 || cur_y >= n)
			return;
		
		if(!(map[cur_y][cur_x] == 1))
			return;
		
		if(memo[cur_y][cur_x] != 0)
			return;
		
		memo[cur_y][cur_x] = apart_index;
		
		for(int i = 0;i < d_len;i++){
			go(map, memo, n, cur_x + d_x[i], cur_y + d_y[i], apart_index);
		}
	}
}
