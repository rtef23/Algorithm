package NextPalindrome;

import java.util.Scanner;

public class MainPro1334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String n = scan.next();
		System.out.println(nextPalindrome(n));

		scan.close();
	}

	private static String nextPalindrome(String i) {
		String front_half_str = null;
		String back_half_str = null;
		String center_str = null;

		if (i.length() % 2 == 0) {// len is even len
			front_half_str = i.substring(0, i.length() / 2);
			back_half_str = i.substring(i.length() / 2, i.length());
			String reverse_front = reverse(front_half_str);

			if (Float.parseFloat(reverse_front) > Float.parseFloat(back_half_str)) {
				return front_half_str + reverse_front;
			} else {
				front_half_str = i.substring(0, i.length() / 2 - 1);
				back_half_str = i.substring(i.length() / 2 + 1, i.length());
				center_str = i.substring(i.length() / 2 - 1, i.length() / 2 + 1);
				reverse_front = reverse(front_half_str);

				if (center_str.charAt(0) > center_str.charAt(1)) {
					StringBuffer new_center = new StringBuffer();

					for (int j = 0; j < center_str.length(); j++)
						new_center.append(center_str.charAt(0));
					return front_half_str + new_center.toString() + reverse_front;
				} else {
					StringBuffer new_center = new StringBuffer();

					for (int j = 0; j < center_str.length(); j++)
						new_center.append(Integer.parseInt(center_str.charAt(0) + "") + 1);
					return front_half_str + new_center.toString() + reverse_front;
				}
			}
		} else {// len is odd len
			if(i.length() == 1)
				return String.format("%d", Integer.parseInt(i) + 1);
			front_half_str = i.substring(0, i.length() / 2);
			back_half_str = i.substring(i.length() / 2 + 1, i.length());
			center_str = i.substring(i.length() / 2, i.length() / 2 + 1);
			String reverse_str = reverse(front_half_str);

			if (Float.parseFloat(reverse_str) > Float.parseFloat(back_half_str)) {
				return front_half_str + center_str + reverse_str;
			} else {
				return front_half_str + (Integer.parseInt(center_str) + 1) + reverse_str;
			}
		}
	}

	private static String reverse(String s) {
		StringBuffer sbuf = new StringBuffer();

		for (int i = s.length() - 1; i >= 0; i--)
			sbuf.append(s.charAt(i));
		return sbuf.toString();
	}
}
