package Onepiece;

import java.util.Scanner;

public class MainPro12780 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String h = scan.nextLine();
		String n = scan.nextLine();
		System.out.printf("%d", count(h, n));
		scan.close();
	}
	public static int count(String h, String n){
		if(h.length() < n.length())
			return 0;
		int count = 0;
		int tmp = 0;
		boolean arriveAtTail;
		for(int h_index = 0;h_index < h.length();h_index++){
			if(h.charAt(h_index) == n.charAt(0)){
				tmp = h_index;
				arriveAtTail = true;
				for(int n_index = 0;n_index < n.length();n_index++, tmp++){
					if(tmp >= h.length()){
						arriveAtTail = false;
						break;
					}
					if(h.charAt(tmp) != n.charAt(n_index)){
						arriveAtTail = false;
						break;
					}
				}
				if(arriveAtTail)
					count++;
			}
		}
		return count;
	}
}
