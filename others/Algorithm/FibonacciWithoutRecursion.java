package Algorithm;

import java.util.Scanner;

public class FibonacciWithoutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int resultSet[] = new int[n + 1];
		
		buildFibonacci(resultSet, n);
		
		for(int i = 1;i <= n;i++){
			System.out.printf("fibonacci %d = %d\n", i, resultSet[i]);
		}
		
		scan.close();
	}
	public static void buildFibonacci(int resultSet[], int n){
		resultSet[0] = 0;
		resultSet[1] = 1;
		for(int i = 2;i <= n;i++){
			resultSet[i] = resultSet[i - 1] + resultSet[i - 2];
		}
	}
}
