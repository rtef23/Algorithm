package Algospot_Contest;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class H {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n,m,s;
		int map[][];
		int max = -1;
		n = scan.nextInt();
		m = scan.nextInt();
		s = scan.nextInt();
		
		map = new int[n][m];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				map[i][j] = scan.nextInt();
				if(map[i][j] > max)
					max = map[i][j];
			}
		}
		
		System.out.printf("%d\n");
		
		scan.close();
	}
	public static ArrayList<Integer> tot(int max, int mel_pos, int map[][]){
		ArrayList<Integer> t = new ArrayList<>();
		
		for(int i = 1;mel_pos <= max;i++, mel_pos++){
			if(canWatch(i, mel_pos, map))
				t.add(i);
		}
		return t;
	}
	public static boolean canWatch(int o_pos, int m_pos, int map[][]){
		Point o_point = getPos(o_pos, map);
		Point m_point = getPos(m_pos, map);
		
		for(int x = min(o_point.x, m_point.x) + 1;x < max(o_point.x, m_point.x);x++){
//			if(isOn(x1, y1, x2, y2, tx1, ty2))
		}
		return false;
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
	public static int min(int a, int b){
		return (a > b)?b:a;
	}
	public static Point getPos(int pos_num, int map[][]){
		for(int i = 0;i < map.length;i++){
			for(int j = 0;j < map[0].length;j++){
				if(map[i][j] == pos_num)
					return new Point(i, j);
			}
		}
		return new Point(-1, -1);
	}
	public static boolean isOn(int x1, int y1, int x2, int y2, int tx1, int ty2){
		return (ty2 == (((y2 - y1) / (x2 - x1)) * tx1));
	}
}
