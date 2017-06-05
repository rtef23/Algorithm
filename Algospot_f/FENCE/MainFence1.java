package FENCE;

import java.util.Scanner;

public class MainFence1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 0;i < t;i++){
			int n = scan.nextInt();
			int h[] = new int[n];
			for(int j = 0;j < n;j++){
				h[j] = scan.nextInt();
			}
			System.out.println(F(n, h));
		}
		scan.close();
	}
	public static int F(int n, int h[]){
		return F(0, n-1, h);
	}
	public static int F(int li, int ri, int h[]){
		if(li >= ri){
			return h[ri];
		}
		int mid = (li + ri) / 2;
		return max(max(F(li, mid, h), F(mid + 1, ri, h)), G(li, ri, mid, h));
	}
	public static int G(int li, int ri, int mid, int h[]){
		int ml = mid;
		int mr = mid+1;
		int num = 2;
		int limitH = min(h[ml--], h[mr++]);
		int size = limitH * num;
		
		while((li <= ml) || (ri >= mr)){
			int ti = (li > ml)?mr:(ri < mr)?ml:(h[ml] > h[mr])?ml:mr;
			if(h[ti] < limitH){
				limitH = h[ti];
			}
			num++;
			int ts = num * limitH;
			if(ts > size){
				size = ts;
			}
			if(ti == ml)
				ml--;
			else
				mr++;
		}
		return size;
	}
	public static int max(int a, int b){
		return (a > b)?a:b;
	}
	public static int min(int a, int b){
		return (a > b)?b:a;
	}
}
