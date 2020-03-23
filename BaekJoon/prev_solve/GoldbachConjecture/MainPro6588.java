package prev_solve.GoldbachConjecture;

import java.util.Scanner;

public class MainPro6588 {
	static String wrong = "Goldbach's conjecture is wrong.";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t;
		
		while(true){
			if(n == 0){
				break;
			}
			
			t = findMinOddNum(n);
			if(t > 0)
				System.out.printf("%d = %d + %d\n", n, t, (n-t));
			else
				System.out.printf("%s\n", wrong);
			
			n = scan.nextInt();
		}
		
		scan.close();
	}
	public static int findMinOddNum(int n){
		for(int i = 1;i <= n - 1;i++){
			if(i % 2 == 0){//when i is even number
				continue;
			}
			//when i is odd number
			if(isPrimeNumber(i) && isPrimeNumber((n - i))){
				return i;
			}
		}
		return -1;
	}
	public static boolean isPrimeNumber(int n){
		if(n == 1)
			return false;
		int sqrt = (int)Math.sqrt(n);
		for(int i = 2;i <= sqrt;i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
}
