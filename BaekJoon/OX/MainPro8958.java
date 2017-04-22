package OX;

import java.util.Scanner;

public class MainPro8958 {
	private static final char correct = 'O';
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 0;i < t;i++){
			String score = scan.next();
			System.out.println(F(score));
		}
		
		scan.close();
	}
	public static int F(String s){
		int score = 0;
		int tmp = 0;
		
		for(int i = 0;i < s.length();i++){
			if(s.charAt(i) == correct){
				tmp++;
				score += tmp;
			}else{
				tmp = 0;
			}
		}
		return score;
	}
}
