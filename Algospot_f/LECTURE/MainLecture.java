package LECTURE;

import java.util.Scanner;

public class MainLecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		for(int i = 0;i < t;i++){
			String input = scan.next();
			System.out.println(getSol(input));
		}
		
		scan.close();
	}
	private static String getSol(String input){
		int str_len = input.length();
		int div_len = str_len / 2;
		String divided_str[] = new String[div_len];
		StringBuffer res = new StringBuffer();
		
		//divide
		for(int i = 0;i < div_len;i++){
			divided_str[i] = input.substring(i * 2, i * 2 + 2);
		}
		
		//insertion sort
		for(int i = 0;i < div_len;i++){
			for(int j = i + 1;j < div_len;j++){
				if(divided_str[i].charAt(0) > divided_str[j].charAt(0)){
					String tmp = divided_str[i];
					divided_str[i] = divided_str[j];
					divided_str[j] = tmp;
				}else if(divided_str[i].charAt(0) == divided_str[j].charAt(0)){
					if(divided_str[i].charAt(1) > divided_str[j].charAt(1)){
						String tmp = divided_str[i];
						divided_str[i] = divided_str[j];
						divided_str[j] = tmp;
					}
				}
			}
			//merge
			res.append(divided_str[i]);
		}
		return res.toString();
	}
}
