package prev_solve.XORQuery;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro13538 {
	private static final int MAX_SIZE = 500001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A[] = new int[MAX_SIZE];
		Integer a_start_index = 1;
		Integer a_length = 0;
		int M = scan.nextInt();
		
		for(int i = 0;i < M;i++){
			int query = scan.nextInt();
			switch (query) {
				case 1:
				{
					int x = scan.nextInt();
					A[a_start_index + a_length] = x;
					a_length++;
				}
				break;
				case 2:
				{
					int L = scan.nextInt();
					int R = scan.nextInt();
					int x = scan.nextInt();
					System.out.println(query2(A, L, R, x));
				}
				break;
				case 3:
				{
					int k = scan.nextInt();
					a_length -= k;
				}
				break;
				case 4:
				{
					int L = scan.nextInt();
					int R = scan.nextInt();
					int x = scan.nextInt();
					System.out.println(query4(A, L, R, x));
				}
				break;
				default://5
				{
					int L = scan.nextInt();
					int R = scan.nextInt();
					int k = scan.nextInt();
					System.out.println(query5(A, L, R, k));
				}
				break;
			}
		}
		
		scan.close();
		
	}
	public static int query2(int A[], int L, int R, int x){
		int max = -1;
		for(int i = L;i <= R;i++){
			int tmp = A[i] ^ x;
			if(max < tmp){
				max = A[i];
			}
		}
		return max;
	}
	public static int query4(int A[], int L, int R, int x){
		int cnt = 0;
		for(int i = L;i <= R;i++){
			if(A[i] <= x){
				cnt++;
			}
		}
		return cnt;
	}
	public static int query5(int A[], int L, int R, int k){
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i = L;i <= R;i++){
			tmp.add(A[i]);
		}
		tmp.sort(null);
		return tmp.get(k-1);
	}
}
