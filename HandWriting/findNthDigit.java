import java.awt.Point;
import java.util.Scanner;

public class findNthDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("enter n : ");
		int n = scan.nextInt();
		
		System.out.println("n : " + n + "\nsolution : " + findNthDigit(n));
		
		scan.close();
	}
	
	static int findNthDigit(int n){
		Point t = G(1, n);
		long first_n_num = up(10, t.x - 1);
		int pos_n;
		if(t.x == 1)
			pos_n = 1;
		else
			pos_n = t.y % t.x;
		int num_n = t.y / t.x;
		long target_num = first_n_num + num_n - 1;
		System.out.println("target_num : " + target_num + "\npos_n : " + pos_n);
		return (Integer.parseInt(String.format("%d", target_num).charAt(pos_n) + ""));
	}
	static long up(int d1, int d2){
		//return d1^d2
		if(d2 <= 0)
			return 1;
		if(d2 == 1)
			return d1;
		if(d2 % 2 == 0){
			long half = up(d1, d2 / 2);
			return half * half;
		}else{
			return up(d1, d2 - 1) * d1;
		}
	}
	static Point G(long x, long rem){
		long up = up(10, (int)x);
		if(up > rem){
			Point t = new Point();
			t.x = (int)x;
			t.y = (int)rem;
			return t;
		}
		return G(x + 1, rem - (up - 1));
	}
}
