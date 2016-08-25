package Selection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(new FileInputStream(new File("in.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			
			int t;
			int n;
			int arr[];
			
			t = scan.nextInt();
			
			for(int i = 0;i < t;i++){
				n = scan.nextInt();
				arr = new int[n];
				StringBuffer sbuf = new StringBuffer();
				
				for(int j = 0;j < n;j++){
					arr[j] = scan.nextInt();
				}
				
				selectionsort(arr, n);
				System.out.println();
				
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
	private static int[] selectionsort(int arr[], int n){
		for(int i = 0;i < n;i++){
			for(int j = i + 1;j < n;j++){
				if(arr[i] > arr[j]){
					//ascending order
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.printf("[phase %d]\t:\t", i+1);
			printArr(arr, n);
		}
		
		return arr;
	}
	private static void printArr(int arr[], int n){
		System.out.print('[');
		for(int i = 0;i < n;i++){
			System.out.printf("%d, ", arr[i]);
		}
		System.out.println(']');
	}
}
