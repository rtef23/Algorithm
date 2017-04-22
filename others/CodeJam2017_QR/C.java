package CodeJam2017_QR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("sample.in")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			 
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0;i < t;i++){
				String s = br.readLine();
				StringTokenizer tok = new StringTokenizer(s, " ");
				int n = Integer.parseInt(tok.nextToken());
				int k = Integer.parseInt(tok.nextToken());
				int res[] = F(n, k);
				
				bw.write(String.format("Case #%d: %d %d\n", (i+1), res[0], res[1]));
			}
			
			br.close();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static int[] F(int n, int k){
		boolean stalls[] = new boolean[n+2];
		int values[][] = new int[n+2][2];
		int tmp[] = new int[2];
		
		Arrays.fill(stalls, false);
		stalls[0] = stalls[n + 1] = true;
		
		for(int i = 1;i <= n;i++){
			values[i][0] = LS(stalls, i);
			values[i][1] = RS(stalls, i);
		}
		
		for(int i = 0;i < k;i++){
			tmp = occupy(stalls, values, n, k);
		}
		return tmp;
	}
	public static int[] occupy(boolean stalls[], int values[][], int n, int k){
		int min = 0;
		int max = 0;
		int index = 0;
		int tmp[] = new int[2];
		
		for(int i = stalls.length - 1;i >= 0;i--){
			if(stalls[i])
				continue;
			int res = min(values[i][0], values[i][1]); 
			if(res > min){
				min = res;
				max = max(values[i][0], values[i][1]);
				index = i;
			}else if(res == min){
				int res1 = max(values[i][0], values[i][1]);
				int res2 = max(values[index][0], values[index][1]);
				if(res1 >= res2){
					max = res1;
					index = i;
				}
			}
		}
		stalls[index] = true;
		tmp[0] = max;
		tmp[1] = min;
		
		for(int i = 1;i <= n;i++){
			values[i][0] = LS(stalls, i);
			values[i][1] = RS(stalls, i);
		}
		return tmp;
	}
	public static int min(int a, int b){
		return (a < b)?a:b;
	}
	public static int max(int a, int b){
		return (a < b)?b:a;
	}
	public static int LS(boolean stalls[], int pos){
		int cnt = 0;
		if(pos == 0)
			return 0;
			
		for(int i = pos-1;i >= 0;i--){
			if(stalls[i]){
				return cnt;
			}
			cnt++;
		}
		return cnt;
	}
	public static int RS(boolean stalls[], int pos){
		int cnt = 0;
		if(pos >= stalls.length)
			return 0;
		
		for(int i = pos+1;pos < stalls.length;i++){
			if(stalls[i]){
				return cnt;
			}
			cnt++;
		}
		return cnt;
	}
}
