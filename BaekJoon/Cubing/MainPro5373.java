package Cubing;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro5373 {
	public static final char colors[] = {'w', 'y', 'r', 'o', 'g', 'b'};
	public static final int U = 0;
	public static final int F = 2;
	public static final int D = 1;
	public static final int B = 3;
	public static final int L = 4;
	public static final int R = 5;
	public static final char plats[] = {'U', 'D', 'F', 'B', 'L', 'R'};
	public static final int num_plat = 6;
	public static final int num_elem = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line;
		int t;
		int n;
		
		line = scan.nextLine();
		
		t = Integer.parseInt(line);
		
		for(int i = 0;i < t;i++){
			line = scan.nextLine();
			char[][][] cube = initCube();
			n = Integer.parseInt(line);
			ArrayList<String> ways = new ArrayList<>();
			
			line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line, " ");
			for(int j = 0;j < n;j++){
				ways.add(tok.nextToken());
			}
		}
		
		scan.close();
	}
	public static void rotate(char[][][] cube, int n, ArrayList<String> ways){
		for(int i = 0;i < n;i++){
			rotate(cube, ways.get(i));
		}
	}
	public static void rotate(char[][][] cube, String way){
		int rotate_target = findPlat(way.charAt(0));
		boolean vector = way.charAt(1) == '+';//+, -
		
		char[][] main_plat = cube[rotate_target];
		if(vector){//+
			
		}else{//-
			
		}
	}
	public char[] elem_copy(char[][]plat, int isVertical, int target){
		char[] cp = new char[num_elem];
		for(int i = 0;;i++){
			
		}
		return ;
	}
	public static int findPlat(char t){
		for(int i = 0;i < num_plat;i++){
			if(t == plats[i]){
				return i;
			}
		}
		return -1;
	}
	public static char[][][] initCube(){
		char[][][] cube = new char[num_plat][num_elem][num_elem];
		
		for(int i = 0;i < num_plat;i++){
			for(int j = 0;j < num_elem;j++){
				for(int k = 0;k < num_elem;k++){
					cube[i][j][k] = colors[i];
				}
			}
		}
		return cube;
	}
}
