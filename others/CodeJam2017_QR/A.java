package CodeJam2017_QR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class A {
	private static final String impossible = "IMPOSSIBLE";
	
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("sample.in")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0;i < t;i++){
				String line = br.readLine();
				StringTokenizer tok = new StringTokenizer(line, " "); 
				String sp = tok.nextToken();
				int k = Integer.parseInt(tok.nextToken());
				
				int res = F(sp, k);
				if(res < 0){
					bw.write(String.format("Case #%d: %s\n", (i+1), impossible));
				}else{
					bw.write(String.format("Case #%d: %d\n", (i+1), res));
				}
			}
			
			bw.close();
			br.close();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static int F(String s, int k){
		boolean map[] = new boolean[s.length()];
		
		for(int i = 0;i < s.length();i++){
			map[i] = (s.charAt(i) == '+')?true:false;
		}
		
		return F(map, k, 0);
	}
	public static int F(boolean map[], int k, int index){
		int target = 0;
		boolean isThereFalse = false;
		
		if(index >= map.length)
			return 0;
		
		for(int i = index;i < map.length;i++){
			if(!map[i]){
				isThereFalse = true;
				target = i;
				break;
			}
		}
		if(!isThereFalse)
			return 0;
		
		for(int i = target;i < target + k;i++){
			if(i >= map.length){
				return -1;
			}
			map[i] = !map[i];
		}
		
		int res = F(map, k, target+1);
		return (res >= 0)?res + 1:res;
	}
}
