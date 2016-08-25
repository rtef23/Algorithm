package PrintStar;

import java.util.Scanner;

public class MainPro10991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i = 1;i <= n;i++){//line
			for(int j = 0;j < (n - i);j++)
				System.out.print(" ");//print left blank
			for(int j = 0;j < i;j++)
				if(j == i - 1)
					System.out.print("*");
				else
					System.out.print("* ");
			if(i != n)
				System.out.println();
		}
		
		scan.close();
	}

}
