package NumberCard;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPro10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i < n;i++){
			list.add(scan.nextInt());
		}
		list.sort(null);
		
		int m = scan.nextInt();
		for(int i = 0;i < m;i++){
			int t = scan.nextInt();
			System.out.printf("%d ", (isExt(list, t)?1:0));
		}
		scan.close();
	}
	public static boolean isExt(ArrayList<Integer> list, int target){
		return isExt(list, 0, list.size() - 1, target);
	}
	public static boolean isExt(ArrayList<Integer> list, int start_index, int end_index, int target){
		if(target < list.get(start_index) || target > list.get(end_index)){
			return false;
		}
		if(list.get(start_index) == target || list.get(end_index) == target){
			return true;
		}
		if(end_index - start_index <= 1){
			return false;
		}
		if(start_index == end_index){
			if(list.get(start_index) == target){
				return true;
			}else{
				return false;
			}
		}
		int mid_index = (start_index + end_index) / 2;
		if(list.get(mid_index) == target){
			return true;
		}else if(list.get(mid_index) < target){
			return isExt(list, mid_index, end_index, target);
		}else{
			return isExt(list, start_index, mid_index, target);
		}
	}
}
