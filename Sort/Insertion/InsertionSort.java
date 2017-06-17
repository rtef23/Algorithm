package Insertion;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int arr[] = {3, 6, 1, 2, 7, 4, 11, 9, 2, 3};
		System.out.println("before");
		System.out.println(Arrays.toString(arr));
		insertion(arr, n);
		System.out.println("after");
		System.out.println(Arrays.toString(arr));
	}
	public static void insertion(int arr[], int n){
		//ascending order
		//O(n^2)
		
		for(int i = 1;i < n;i++){
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
