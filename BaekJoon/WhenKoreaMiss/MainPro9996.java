package WhenKoreaMiss;

import java.util.Scanner;

public class MainPro9996 {
	private static final String YES = "DA";
	private static final String NO = "NE";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String pattern = scan.nextLine();
		String fileNames[] = new String[n];
		
		for(int i = 0;i < n;i++){
			fileNames[i] = scan.nextLine();
		}
		scan.close();
		for(int i = 0;i < n;i++){
			System.out.printf("%s\n", (isMatch(pattern, fileNames[i]))?YES:NO);
		}
	}
	public static boolean isMatch(String pattern, String filename){
		return isMatch(pattern, filename, pattern.length() - 1, filename.length() - 1);
	}
	public static boolean isMatch(String pattern, String str, int pi, int si){
		if(pi < 0 && si < 0){
			return true;
		}
		if(pi < 0){
			return false;
		}
		if(si < 0){
			if(pattern.charAt(pi) == '*')
				return isMatch(pattern, str, pi - 1, si);
			return false;
		}
		if(pattern.charAt(pi) == '*'){
			for(int i = 0;i <= si + 1;i++){
				if(isMatch(pattern, str, pi - 1, si - i))
					return true;
			}
			return false;
		}else{
			if(pattern.charAt(pi) == str.charAt(si))
				return isMatch(pattern, str, pi - 1, si - 1);
			return false;
		}
	}
}
