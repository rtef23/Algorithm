package BanStudyOversea;

import java.util.Scanner;

public class MainPro2789 {
	private static char rem_word[] = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String target = scan.nextLine();
		
		System.out.printf("%s", removeStr(target));
		
		scan.close();
	}
	public static StringBuilder removeStr(String target){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < target.length();i++){
			boolean isContained = false;
			for(int j = 0;j < rem_word.length;j++){
				if(target.charAt(i) == rem_word[j]){
					isContained = true;
					break;
				}
			}
			if(!isContained){
				sb.append(target.charAt(i));
			}
		}
		return sb;
	}
}
