package HideAndSeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MainPro1697 {
	private final static int limit = 150000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		System.out.println(F(n, k));
		
		scan.close();
	}
	public static int F(int n, int k){
		if(n == k){
			return 0;
		}
		HashSet<Integer> path = new HashSet<>();
		ArrayList<Integer> way = new ArrayList<>();
		path.add(n);
		way.add(n);
		return F(k, path, way, 0);
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
	public static int F(int k, HashSet<Integer>searched_path, ArrayList<Integer> way, int depth){
		int size = way.size();
		for(int i = 0;i < size;i++){
			int minus = way.get(i) - 1;
			int plus = way.get(i) + 1;
			int multy = way.get(i) * 2;
			
			if(minus == k || plus == k || multy == k){
				return depth + 1;
			}
			
			if(minus >= 0 && minus <= limit && !searched_path.contains(minus)){
				way.add(minus);
				searched_path.add(minus);
			}
			if(plus >= 0 && plus <= limit && !searched_path.contains(plus)){
				way.add(plus);
				searched_path.add(plus);
			}
			if(multy >= 0 && multy <= limit && !searched_path.contains(multy)){
				way.add(multy);
				searched_path.add(multy);
			}
		}
		for(int i = 0;i < size;i++){
			way.remove(0);
		}
		way.sort(null);
		return F(k, searched_path, way, depth+1);
	}
}
