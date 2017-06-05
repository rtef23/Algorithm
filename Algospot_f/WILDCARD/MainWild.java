package WILDCARD;

import java.util.ArrayList;
import java.util.Scanner;

public class MainWild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = Integer.parseInt(scan.nextLine().trim());
		for(int i = 0;i < c;i++){
			String pattern = scan.nextLine().trim();
			int n = Integer.parseInt(scan.nextLine().trim());
			ArrayList<String> res = new ArrayList<>();
			for(int j = 0;j < n;j++){
				String target = scan.nextLine().trim();
				if(isMatch(pattern, target)){
					res.add(target);
				}
			}
			res.sort(null);
			for(int j = 0;j < res.size();j++){
				System.out.println(res.get(j));
			}
		}
		scan.close();
	}
	public static boolean isMatch(String pattern, String str){
		return isMatch(pattern, str, pattern.length() - 1, str.length() - 1);
	}
	private static boolean isMatch(String pattern, String str, int pi, int si){
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
		if(pattern.charAt(pi) == '?'){
			return isMatch(pattern, str, pi - 1, si - 1);
		}else if(pattern.charAt(pi) == '*'){
			for(int i = 0;i <= si + 1;i++)
				if(isMatch(pattern, str, pi - 1, si - i))
					return true; 
			return false;
		}else{
			if(pattern.charAt(pi) == str.charAt(si))
				return isMatch(pattern, str, pi - 1, si - 1);
			return false;
		}
	}
}
