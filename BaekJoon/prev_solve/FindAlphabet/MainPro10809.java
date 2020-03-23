package prev_solve.FindAlphabet;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[26];
		String s = scan.next();
		scan.close();
		
		Arrays.fill(arr, -1);
		for(int i = 0;i < s.length();i++){
			if(arr[s.charAt(i) - 'a'] < 0)
				arr[s.charAt(i) - 'a'] = i;
		}
		for(int i = 0;i < arr.length;i++){
			System.out.printf("%d ", arr[i]);
		}
	}
}
