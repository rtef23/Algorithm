package HumbleNumber;

import java.util.Scanner;

public class MainPro2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int k = scan.nextInt();
		int n = scan.nextInt();
		int p_num[] = new int[k];

		for(int i = 0;i < k;i++)
			p_num[i] = scan.nextInt();
		
		//sorting inserted prime numbers
		for(int i = 0;i < p_num.length;i++){
			for(int j = 0;j <= i;j++){
				if(p_num[j] < p_num[i]){
					int tmp = p_num[i];
					p_num[i] = p_num[j];
					p_num[j] = tmp;
				}
			}
		}
		
		long maxnum = 1l;
		
		for(;n > 0;n--){
			
		}
		
		scan.close();
	}
	/*
	 * let F(n) : return the n th prime number with k primes
	 * F(n) = F(n - 1) / d(d is the largest number that is divide without rest in n prime numbers)
	 * F(0) = 1
	 * */
}
