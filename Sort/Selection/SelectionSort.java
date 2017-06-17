package Selection;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int arr[] = {3, 6, 1, 2, 7, 4, 11, 9, 2, 3};
		System.out.println("before");
		System.out.println(Arrays.toString(arr));
		selection(arr, n);
		System.out.println("after");
		System.out.println(Arrays.toString(arr));
	}
	private static void selection(int arr[], int n){
		for(int i = 0;i < n;i++){
			for(int j = i + 1;j < n;j++){
				if(arr[i] > arr[j]){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
}
