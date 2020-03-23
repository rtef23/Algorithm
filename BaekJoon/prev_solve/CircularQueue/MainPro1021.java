package prev_solve.CircularQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MainPro1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int popsize = scan.nextInt();
		
		int poppos[] = new int[popsize];
		for(int i = 0;i < popsize;i++){
			poppos[i] = scan.nextInt();
		}
		
		scan.close();
		
		System.out.println(compute(size, popsize, poppos));
	}
	public static int compute(int size, int popsize, int poppos[]){
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i = 1;i <= size;i++){
			q.addLast(i);
		}
		
		return compute(0, poppos, 0, q);
	}
	public static int compute(int pop_index, int pop_pos[], int res, ArrayDeque<Integer> q){
		if(pop_index >= pop_pos.length){
			return res;
		}
		int count = 0;
		boolean isAct2Min = false;
		Object[] qs = q.toArray();
		int act2_index, act3_index;
		act2_index = act3_index = 0;

		while(true){
			if((Integer)qs[act2_index] == pop_pos[pop_index]){
				isAct2Min = true;
				break;
			}
			if((Integer)qs[act3_index] == pop_pos[pop_index]){
				isAct2Min = false;
				break;
			}
			count++;
			act2_index++;
			act2_index %= qs.length;
			act3_index--;
			act3_index = (act3_index < 0)?qs.length - 1:act3_index;
		}
		if(isAct2Min){
			for(int i = 0;i < count;i++){
				q.addLast(q.pollFirst());				
			}
		}else{
			for(int i = 0;i < count;i++){
				q.addFirst(q.pollLast());
			}
		}
		q.pollFirst();
		return compute(pop_index+1, pop_pos, res + count, q);
	}
	
	public static int min(int a, int b){
		return (a < b)?a:b;
	}
}
