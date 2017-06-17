package Bubble;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int n = 10;
		int arr[] = {3, 6, 1, 2, 7, 4, 11, 9, 2, 3};
		System.out.println("before");
		System.out.println(Arrays.toString(arr));
		bubble(arr, n);
		System.out.println("after");
		System.out.println(Arrays.toString(arr));
	}
	public static void bubble(int arr[], int n){
		//ascending order
		//O(n^2)
		for(int i = 0;i < n - 1;i++){
			for(int j = 0;j < n - 1 - i;j++){
				if(arr[j] > arr[j + 1]){
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}
