package Algospot_Contest;

import java.util.Scanner;

public class L {
	public static final String lyric = "pen-pineapple-apple-pen/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int l = scan.nextInt();
		int r = scan.nextInt();
		String p = scan.next();
		
		System.out.printf("%d\n", F(l, r, p));
		
		scan.close();
	}
	public static int F(int l, int r, String p){
		int l_index = l - 1;
		int r_index = r - 1;
		int s_index = l_index % lyric.length();
		int e_index = r_index % lyric.length();
		int times = (r_index - l_index + 1) / lyric.length();
		
		int cnt_rem = countStr(lyric.substring(l_index, r_index), p);
		int cnt_center = countStr(, p);
		
		return cnt_rem + cnt_center;
	}
	public static int countStr(String target, String tester){
		int cnt = 0;
		int t_index = 0;
		
		for(int i = 0;i < target.length();i++){
			if(target.charAt(i) == tester.charAt(t_index)){
				t_index++;
				if(t_index >= tester.length()){
					t_index = 0;
					cnt++;
				}
			}else{
				t_index = 0;
			}
		}
		return cnt;
	}
}
