package prev_solve.OrderByAge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPro10814 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = Integer.parseInt(scan.nextLine().trim());
		int ages[] = new int[n];
		String names[] = new String[n];
		for(int i = 0;i < n;i++){
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line, " ");
			ages[i] = Integer.parseInt(tok.nextToken());
			names[i] = tok.nextToken();
			q.offer(i);
		}
		
		Queue<Integer> res = mergesort(q, ages);
		
		while(!res.isEmpty()){
			Integer index = res.poll();
			System.out.printf("%d %s\n", ages[index], names[index]);
		}
		
		scan.close();
	}
	
	private static Queue<Integer> mergesort(Queue<Integer> q, int ages[]){
		return divide(q, ages);
	}
	private static Queue<Integer> divide(Queue<Integer> q, int ages[]){
		if(q.size() <= 1){
			return q;
		}
		
		int mid = q.size() / 2;
		int index = 0;
		Queue<Integer> left = new LinkedList<>();
		Queue<Integer> right = new LinkedList<>();
		
		while(!q.isEmpty()){
			if(index < mid){
				left.offer(q.poll());
			}else{
				right.offer(q.poll());
			}
			index++;
		}
		
		Queue<Integer> left_res = divide(left, ages);
		Queue<Integer> right_res = divide(right, ages);
		
		return merge(left_res, right_res, ages);
	}
	private static Queue<Integer> merge(Queue<Integer> left, Queue<Integer> right, int ages[]){
		Queue<Integer> res = new LinkedList<>();
		
		while(!left.isEmpty() && !right.isEmpty()){
			Integer target;
			if(ages[left.peek()] < ages[right.peek()]){
				target = left.poll();
			}else if(ages[left.peek()] == ages[right.peek()]){
				target = (left.peek() < right.peek())?left.poll():right.poll();
			}else{
				target = right.poll();
			}
			res.offer(target);
		}
		while(!left.isEmpty()){
			res.offer(left.poll());
		}
		while(!right.isEmpty()){
			res.offer(right.poll());
		}
		
		return res;
	}
}
