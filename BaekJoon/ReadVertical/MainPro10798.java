package ReadVertical;

import java.util.Scanner;

public class MainPro10798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String words[] = new String[5];
		StringBuilder sb = new StringBuilder();
		int readIndex = 0;
		int maxLen = 0;
		
		for(int i = 0;i < 5;i++){
			words[i] = scan.nextLine();
			maxLen = (words[i].length() > maxLen)?words[i].length():maxLen;
		}
		scan.close();
		
		while(readIndex < maxLen){
			for(int i = 0;i < 5;i++){
				if(readIndex >= words[i].length()){
					continue;
				}
				sb.append(words[i].charAt(readIndex));
			}
			readIndex++;
		}
		System.out.println(sb.toString());
	}

}
