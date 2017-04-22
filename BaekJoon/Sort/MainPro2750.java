package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class MainPro2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int seq[] = new int[n];
		
		for(int i = 0;i < n;i++){
			seq[i] = scan.nextInt();
		}
		quicksort(seq);
		for(int i = 0;i < n;i++){
			System.out.println(seq[i]);
		}
		
		scan.close();
	}
	public static void quicksort(int seq[]){
		quicksort(seq, 0, seq.length - 1);
	}
	public static void quicksort(int seq[], int scope_s_pointer, int scope_e_pointer){
		//ascceding order
		if(scope_s_pointer >= scope_e_pointer)
			return;
		int pivot_pos = scope_s_pointer;
		int pivot = seq[pivot_pos];//left most side
		int l = pivot_pos+1;
		int r = scope_e_pointer;
		
		while(l <= r){
			//find l pos
			while(l <= r){
				if(seq[l] <= pivot){
					seq[l-1] = seq[l];
				}else{
					break;
				}
				l++;
			}
			//find r pos
			while(seq[r] > pivot && l <= r){
				r--;
			}
			if(l <= r){
				seq[l-1] = seq[r];
				seq[r] = seq[l];
				l++;
				r--;
			}
		}
		if(l <= scope_e_pointer + 1){
			seq[l-1] = pivot; 
		}
		quicksort(seq, scope_s_pointer, l-2);
		quicksort(seq, l,scope_e_pointer);
	}
}
