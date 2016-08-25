package NIZOVI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPro11954 {
	private static final char L_bracket = '{';
	private static final char R_bracket = '}';
	private static final String tab = "  ";
	private static final char comma = ',';

	private static String input;
	private static int len;
	private static int str_pos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringBuffer rem_blank = new StringBuffer();
			input = br.readLine();

			for (int i = 0; i < input.length(); i++)
				if (!Character.isSpaceChar(input.charAt(i)))
					rem_blank.append(input.charAt(i));
			input = rem_blank.toString();
			len = rem_blank.length();
			str_pos = 0;

			printArr(0);

			br.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	private static void printArr(int depth) {
		boolean new_line = false;
		boolean l_paren_open;

		if (depth > 0)
			l_paren_open = true;
		else
			l_paren_open = false;

		for (; str_pos < len; str_pos++) {
			char this_ch = input.charAt(str_pos);
			switch (this_ch) {
			case L_bracket: {
				printTab(depth - 1);
				System.out.print(this_ch);
				str_pos++;
				l_paren_open = true;
				// if (str_pos < len)
				// if (input.charAt(str_pos) != R_bracket)
				// printTab(depth + 1);
				printArr(depth + 1);
			}
				break;
			case R_bracket: {
				if (l_paren_open)
					if (str_pos >= 1)
						if (input.charAt(str_pos - 1) != comma)
							System.out.println();
				printTab(depth - 1);
				System.out.print(this_ch);
				return;
			}
			case comma: {
				System.out.print(comma);
				System.out.println();
				printTab(depth);
				new_line = false;
			}
				break;
			default: {
				if (str_pos >= 1 && str_pos < len)
					if (input.charAt(str_pos - 1) == L_bracket || input.charAt(str_pos - 1) == R_bracket) {
						System.out.println();
						printTab(depth);
					}

				System.out.print(this_ch);
			}
				break;
			}
		}
	}

	private static void printTab(int depth) {
		for (int i = 0; i < depth; i++)
			System.out.print(tab);
	}
}
