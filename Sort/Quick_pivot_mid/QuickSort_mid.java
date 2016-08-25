package Quick_pivot_mid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort_mid {
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(new FileInputStream("in.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
	
			int t;
			int arr[];
			
			t = scan.nextInt();
			
			for(int i = 0;i < t;i++){
				n = scan.nextInt();
				arr = new int[n];
				StringBuffer sbuf = new StringBuffer();
				
				for(int j = 0;j < n;j++){
					arr[j] = scan.nextInt();
				}
				
				sbuf.append("original : ");
				for(int j = 0;j < n;j++){
					sbuf.append(arr[j] + "\t");
				}
				sbuf.append("\n");
				
				quick(arr, 0, n - 1);
				
				
				for(int j = 0;j < n;j++)
					sbuf.append(arr[j] + "\t");
				sbuf.append('\n');
				bw.write(sbuf.toString());
			}
			
			scan.close();
			bw.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//pivot is in the center position
	private static void quick(int arr[], int l, int r){
		int index = partition(arr, l, r);//get pivot pos
		printArr(arr, r);
		if(l < index - 1)
			quick(arr, l, index - 1);
		if(index < r)
			quick(arr, index, r);
	}
	private static int partition(int arr[], int l, int r){
		//return pivot pos
		int pivot = arr[(l + r) / 2];
		int i = l;
		int j = r;
		
		while(i <= j){
			for(;arr[i] < pivot;)
				i++;
			for(;arr[j] > pivot;)
				j--;
			if(i <= j){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		return i;
	}

	private static void printArr(int arr[], int n){
		System.out.print('[');
		for(int i = 0;i < n;i++){
			System.out.printf("%d, ", arr[i]);
		}
		System.out.println(']');
	}
}
