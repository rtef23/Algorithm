package prev_solve.Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainPro6568_1 {
	private static final int MEM_SIZE = 32;
	private static final int PC_SIZE = 32;//0~31
	private static final int ACC_SIZE = 256;//0~255

	public static int pc;
	public static int acc;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		pc = acc = 0;
		try {
			while((tmp = br.readLine()) != null){
				int mem[] = new int[MEM_SIZE];
				
				mem[0] = bi2int(tmp);
				for(int i = 1;i < MEM_SIZE;i++){
					mem[i] = bi2int(br.readLine());
				}
				F(mem);
				
				String t = int2bi(acc);
				System.out.println(t.substring(t.length() - 8));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void F(int mem[]){
		boolean go = true;
		
		while(go){
			int cmd = mem[pc];
			int op = cmd >> 5;
			int operand = cmd & 31;//31 => 0001 1111
			
			increasePC();
			
			switch (op) {//execute op
				case 0:{//=> 000
					mem[operand] = acc;
					break;
				}
				case 1:{//=> 001
					setACC(mem[operand]);
					break;
				}
				case 2:{//=> 010
					if(acc == 0){
						setPC(operand);
					}
					break;
				}
				case 3:{//=> 011
					//do nothing
					break;
				}
				case 4:{//=> 100
					decreaseACC();
					break;
				}
				case 5:{//=> 101
					increaseACC();
					break;
				}
				case 6:{//=> 110
					setPC(operand);
					break;
				}
				default:{//7 => 111
					go = false;
					break;
				}
			}
		}
	}
	public static void increasePC(){
		pc += 1;
		pc %= PC_SIZE;
	}
	public static void setPC(int val){
		pc = val % PC_SIZE;
	}
	public static void increaseACC(){
		acc += 1;
		acc %= ACC_SIZE;
	}
	public static void decreaseACC(){
		if(acc == 0){
			return;
		}
		acc -= 1;
	}
	public static void setACC(int val){
		acc = val % ACC_SIZE;
	}
	public static int bi2int(String target){
		return bi2int(target, 0, target.length() - 1);
	}
	private static int bi2int(String target, int from_index, int to_index){
		if(from_index >= to_index){
			return (target.charAt(from_index) == '1')?1:0;
		}
		return bi2int(target, from_index + 1, to_index) + ((target.charAt(from_index) == '1')?(int)Math.pow(2, (to_index - from_index)):0);
	}
	public static String int2bi(int val){
		StringBuilder sb = new StringBuilder();
		String tmp = Integer.toBinaryString(val);
		
		for(int i = 0;i < 8 - tmp.length();i++){
			sb.append('0');
		}
		sb.append(tmp);
		
		return sb.toString();
	}
}
