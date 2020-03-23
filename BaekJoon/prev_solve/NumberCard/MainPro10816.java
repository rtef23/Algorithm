package prev_solve.NumberCard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class MainPro10816 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		int m;

		HashMap<Integer, Integer> map = new HashMap<>();
		
		ArrayList<Integer> arrn = new ArrayList<>();
		ArrayList<Integer> arrm = new ArrayList<>();
		ArrayList<Integer> arrm_cp = new ArrayList<>();
		
		n = scan.nextInt();
		
		for(int i = 0;i < n;i++){
			arrn.add(scan.nextInt());
		}
		
		m = scan.nextInt();
		
		for(int i = 0;i < m;i++){
			int t = scan.nextInt();
			arrm.add(t);
			arrm_cp.add(t);
		}
		
		arrn.sort(new ascComp());
		arrm.sort(new ascComp());
		
		int index_n, index_m;
		
		index_n = index_m = 0;

		while(index_m < arrm.size()){
			int target = arrm.get(index_m);
			int cnt = 0;
			
			while(index_n < arrn.size()){
				int target_n = arrn.get(index_n);
				if(target_n <= target){
					index_n++;
					if(target_n == target)
						cnt++;
				}else{
					break;
				}
			}
			if(!map.containsKey(target))
				map.put(target, cnt);
			index_m++;
		}
		
		for(int i = 0;i < arrm_cp.size();i++){
			System.out.printf("%d ", map.get(arrm_cp.get(i)));
		}
		
		scan.close();
	}
	
	private static class ascComp implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return (o1 < o2)?-1:((o1 == o2)?0:1);
		}
	}
}
