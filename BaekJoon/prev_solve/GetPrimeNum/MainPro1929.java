package prev_solve.GetPrimeNum;

import java.util.Scanner;

public class MainPro1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		for(int i = M;i <= N;i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
		
		scan.close();
	}
	public static boolean isPrime(int target){
		if(target == 1)
			return false;
		for(int i = 2;i <= Math.sqrt(target);i++){
			if(target % i == 0){
				return false;
			}
		}
		return true;
	}
}
