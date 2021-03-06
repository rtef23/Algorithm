package QuodTree;

import java.util.Arrays;
import java.util.Scanner;

public class MainQuad1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = Integer.parseInt(scan.nextLine().trim());
		for(int i = 0;i < c;i++){
			System.out.println(F(scan.nextLine().trim()));
		}
		scan.close();
	}
	public static String F(String s){
		if(s.equals("w") || s.equals("b")){
			return s;
		}
		String part[] = new String[4];
		int target = 0;
		int len = -1;
		Arrays.fill(part, new String());
		for(int i = 1;i < s.length();i++){
			part[target] += s.charAt(i);
			if(len < 0){
				if(s.charAt(i) == 'x'){
					len = 3;
				}else{
					target++;
				}
			}else{
				len--;
				if(s.charAt(i) == 'x'){
					len += 4;
				}
				if(len < 0){
					target++;
				}
			}
		}
		return s.charAt(0) + F(part[2]) + F(part[3]) + F(part[0]) + F(part[1]);
	}

}
