package NextPalindrome;

import java.util.Scanner;

public class MainPro1334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String n = scan.next();

		scan.close();
		
	}
	public static String getNextPal(String s){
		if(s.length() <= 2){
			switch (s) {
			case "1":
				return "2";
			case "2":
				return "3";
			case "3":
				return "4";
			case "4":
				return "5";
			case "5":
				return "6";
			case "6":
				return "7";
			case "7":
				return "8";
			case "8":
				return "9";
			case "9":
			case "10":
				return "11";
			default://9
				break;
			}
		}
		if(s.length() % 2 == 0){//even length
			String front = s.substring(0, s.length() / 2);
			String back = s.substring(s.length() / 2, s.length());
			int res = compare(front, back);
			
		}else{//odd length
			String front = s.substring(0, s.length() / 2);
			String back = s.substring(s.length() / 2 + 1, s.length());
			int res = compare(front, back);
			int center = s.charAt(s.length() / 2) - '0';
			
		}
	}
	public static String nextStr(String s){
		StringBuilder sb = new StringBuilder();
		char[] c = s.toCharArray();
		
		
	}
	public static int compare(String s1, String s2){
		if(s1.length() > s2.length()){
			return -1;
		}else if(s1.length() < s2.length()){
			return 1;
		}
		for(int i = 0;i < s1.length();i++){
			if(s1.charAt(i) == s2.charAt(i)){
				continue;
			}
			return (s1.charAt(i) > s2.charAt(i))?-1:1;
		}
		return 0;
	}
	public static boolean isPalindrome(String s){
		int s_index = 0;
		int e_index = s.length() - 1;
		
		while(s_index < e_index){
			if(s.charAt(s_index) != s.charAt(e_index)){
				return false;
			}
			s_index++;
			e_index--;
		}
		return true;
	}
}
