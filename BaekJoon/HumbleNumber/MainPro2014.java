package HumbleNumber;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainPro2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int k = scan.nextInt();
		int n = scan.nextInt();
		int p_num[] = new int[k];
		s
		for(int i = 0;i < k;i++)
			p_num[i] = scan.nextInt();
		
		System.out.println(getSol(p_num, k, n));
		
		scan.close();
	}
	private static int getSol(int p_num[], int k, int n){
		Queue<Integer> q[] = new LinkedList[k];
		int min_val = 0;
		
		for(int i = 0;i < k;i++){
			q[i] = new LinkedList<>();
			q[i].add(p_num[i]);
		}
		
		//sorting prime numbers
		for(int i = 0;i < k;i++)
			for(int j = i;j < k;j++){
				if(p_num[i] > p_num[j]){
					int tmp = p_num[i];
					p_num[i] = p_num[j];
					p_num[j] = tmp;
				}
			}
		
		
		for(int i = 0;i < n;i++){
			int min_index = minQindex(q, k);
			min_val = q[min_index].poll();
			System.out.printf("[%d th] min_index : %d\tmin_val : %d\n", i+1, min_index, min_val);
			for(int j = min_index;j < k;j++)
				q[j].add(p_num[j] * min_val);
		}
		return min_val;
	}
	private static int minQindex(Queue<Integer> qs[], int k){
		int min_val = qs[0].peek();
		int min_index = 0;
		
		for(int i = 1;i < k;i++){
			if(min_val > qs[i].peek()){
				min_val = qs[i].peek();
				min_index = i;
			}
		}
		return min_index;
	}
}
