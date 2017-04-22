package CodeJam2017_QR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("sample.in")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("out.txt")));
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0;i < t;i++){
				bw.write(String.format("Case #%d: %s\n", (i + 1), F(br.readLine())));
			}
			
			br.close();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static String F(String i){
		BigInteger bi = new BigInteger(i);
		BigInteger minus = new BigInteger("-1");
		
		
		
		return "-1";
	}
	public static boolean isTidyNumber(BigInteger bi){
		String s = bi.toString();
		
		for(int i = s.length() - 1;i > 0;i--){
			if(s.charAt(i) < s.charAt(i - 1)){
				return false;
			}
		}
		
		return true;
	}
}
