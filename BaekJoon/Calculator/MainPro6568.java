package Calculator;

import java.util.Scanner;

public class MainPro6568 {
	private static final int MEM_SIZE = 32;
	private static final int BIT = 8;
	private static final int OP_START_INDEX = 0;
	private static final int OP_LAST_INDEX = 3;
	private static final int VAL_START_INDEX = 3;
	private static final int VAL_LAST_INDEX = 8;
	private static int acc = 0;
	private static int pc = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String memory[] = new String[MEM_SIZE];
		
		for(int i = 0;i < MEM_SIZE;i++){
			memory[i] = scan.nextLine();
		}
		F(memory);
		String tmp = int2bi(acc);
		System.out.println(tmp.substring(tmp.length() - BIT));
		scan.close();
	}
	public static void F(String mem[]){
		boolean ongoing = true;
		
		while(ongoing){
			String command = mem[pc];
			String op = command.substring(OP_START_INDEX, OP_LAST_INDEX);//len is always 3
			String operand = command.substring(VAL_START_INDEX, VAL_LAST_INDEX);//len is always 5
			increasePC();
			
			switch (bi2int(op)) {
				case 0://STA
				{
					int mem_addr = bi2int(operand);
					String tmp = int2bi(acc);
					mem[mem_addr] = tmp.substring(tmp.length() - BIT);
					break;
				}
				case 1://LDA
				{
					int mem_addr = bi2int(operand);
					setACC(bi2int(mem[mem_addr]));
					break;
				}
				case 2://BEQ
				{
					if(acc == 0){
						setPC(bi2int(operand));
					}
					break;
				}
				case 3://NOP
				{
					//do nothing
					break;
				}
				case 4://DEC
				{
					decreaseACC();
					break;
				}
				case 5://INC
				{
					increaseACC();
					break;
				}
				case 6://JMP
				{
					setPC(bi2int(operand));
					break;
				}
				default://HLT
				{//111 => 7
					ongoing = false;
					break;
				}
			}
		}
	}
	private static void increasePC(){
		pc = (pc+1) % MEM_SIZE;
	}
	private static void setPC(int val){
		pc = val % MEM_SIZE;
	}
	private static void increaseACC(){
		acc = (acc+1) % 256;
	}
	private static void decreaseACC(){
		if(acc <= 0){
			return;
		}
		acc--;
	}
	private static void setACC(int val){
		acc = val % 256;
	}
	private static String int2bi(int val){
		StringBuilder sb = new StringBuilder();
		String tmp = Integer.toBinaryString(val);
		
		for(int i = 0;i < 8 - tmp.length();i++){
			sb.append('0');
		}
		sb.append(tmp);
		
		return sb.toString();
	}
	private static int bi2int(String target){
		return bi2int(target, 0, target.length()-1);
	}
	private static int bi2int(String target, int from_index, int to_index){
		if(from_index >= to_index){
			return (target.charAt(from_index) == '1')?1:0;
		}
		return bi2int(target, from_index + 1, to_index) + ((target.charAt(from_index) == '1')?upper(2, (to_index - from_index)):0);
	}
	private static int upper(int down, int up){
		if(down == 0){
			return 0;
		}
		if(down == 1){
			return 1;
		}
		if(up == 0){
			return 1;
		}
		if(up == 1){
			return down;
		}
		if(up % 2 == 0){
			int tmp = upper(down, up / 2);
			return tmp * tmp;
		}else{
			return upper(down, up-1) * down;
		}
	}
}
