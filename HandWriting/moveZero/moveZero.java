package moveZero;

import java.util.Arrays;
import java.util.Scanner;

public class moveZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int len;
		int nums[];
		System.out.println("enter array length : ");
		
		len = scan.nextInt();
		nums = new int[len];
		for(int i = 0;i < len;i++){
			nums[i] = scan.nextInt();
		}
		
		System.out.println("initial state of array");
		System.out.printf("%s\n", ArrToStr(nums));
		
		moveZero(nums);
		
		System.out.println("after state of array");
		System.out.printf("%s\n", ArrToStr(nums));
		
		scan.close();
	}
	public static void moveZero(int nums[]){
		int zero_pos, none_zero_pos;
		
		zero_pos = -1;
		none_zero_pos = 0;
		
		for(;none_zero_pos < nums.length;none_zero_pos++){
			if(nums[none_zero_pos] != 0){
				for(zero_pos++;zero_pos < none_zero_pos;zero_pos++){
					if(nums[zero_pos] == 0){
						nums[zero_pos] = nums[none_zero_pos];
						nums[none_zero_pos] = 0;
						break;
					}
				}
			}
		}
	}
	private static String ArrToStr(int num[]){
		String res = "[";
		
		for(int i = 0;i < num.length;i++){
			if(i == num.length - 1){
				res += String.format("%d]", num[i]);
			}else{
				res += String.format("%d, ", num[i]);
			}
		}
		return res;
	}
}
