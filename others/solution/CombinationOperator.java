package solution;

import java.util.HashMap;
import java.util.Scanner;

public class CombinationOperator {
	/*
	 * Q) there is n operator positions, and n + 1 operands. by using operator(+, -), count the combination which is result in given K
	 * 
	 * input)
	 * 	n K
	 * 	operand 1
	 * 	operand 2
	 * 	.
	 * 	.
	 * 	operand n
	 * 	operand n + 1
	 * 
	 * example)
	 * 		input)
	 * 			3 2
	 * 
	 * 			2
	 * 			-3
	 * 			4
	 * 			-1
	 * 
	 * 		output)
	 * 			2
	 * 
	 * 			//because there is just two ways which combination makes K 
	 * 				2 + (-3) + 4 + (-1) = 2
	 * 				2 - (-3) - 4 - (-1) = 2
	 * 
	 * 				2 + (-3) + 4 - (-1) = 4
	 * 				2 + (-3) - 4 + (-1) = -6
	 * 				2 + (-3) - 4 - (-1) = -4
	 * 				2 - (-3) + 4 + (-1) = 8
	 * 				2 - (-3) + 4 - (-1) = 10
	 * 				2 - (-3) - 4 + (-1) = 0
	 * 		
	 * 	constraints)
	 * 		there is no operator in front of first operand
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, K;
		int operands[];
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, HashMap<Integer, Integer>>tmp = new HashMap<>();
		
		n = scan.nextInt();
		K = scan.nextInt();
		
		operands = new int[n + 1];
		
		HashMap<Integer, Integer> tmp1 = new HashMap<>();
		for(int i = 0;i < n + 1;i++){
			operands[i] = scan.nextInt();
		}
		tmp1.put(operands[0], 1);
		tmp.put(1, tmp1);
		
		
		
		System.out.println(countCombination(tmp, n, n + 1, K, operands));
		
		scan.close();
	}
	public static int countCombination(HashMap<Integer, HashMap<Integer, Integer>> log, int n, int n_1, int K, int operands[]){
		/*
		 * using Dynamic programming
		 * let countCombination F
		 * F(n, n + 1, K, operands[]) : with n th operand, return the number of combination which is result in K
		 * F(n, n + 1, K, operands[]) = F(n, n, K + operands[n + 1], operands[]) + F(n, n, K - operands[n + 1], operands[])
		 * F(n, 1, K, operands[]) = (operands[] in K)? 1:0
		 * 
		 * log constructure
		 * HashMap<N, HashMap<K, count>>
		 * */
		if(n_1 <= 0)
			return 0;
		if(n_1 == 1)
			return (log.get(n_1).containsKey(K))?1:0;
		
		HashMap<Integer, Integer>tmp;
		if(log.containsKey(n_1)){
			tmp = log.get(n_1);
			if(tmp.containsKey(K))
				return tmp.get(K);
		}else{
			tmp = new HashMap<>();
		}
		
		int count = countCombination(log, n, n_1 - 1, K + operands[n_1 - 1], operands) + countCombination(log, n, n_1 - 1, K - operands[n_1 - 1], operands);
		tmp.put(K, count);
		log.put(n_1, tmp);
		return count;
	}
}
