package ClockSync;

import java.util.Scanner;

public class MainClockSync {
	private static final int switchs[][] = {
			{0, 1, 2},			//0
			{3, 7, 9, 11},		//1
			{4, 10, 14, 15},	//2
			{0, 4, 5, 6, 7},	//3
			{6, 7, 8, 10, 12},	//4
			{0, 2, 14, 15},		//5
			{3, 14, 15},		//6
			{4, 5, 7, 14, 15},	//7
			{1, 2, 3, 4, 5},	//8
			{3, 4, 5, 9, 13}	//9
	};
	private static final int numSwitch = 10;
	private static final int numClock = 16;
	private static final int hour = 12;
	private static final int impossible = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 0;i < t;i++){
			int clocks[] = new int[numClock];
			for(int j = 0;j < numClock;j++){
				clocks[j] = scan.nextInt();
			}
			System.out.println(F(clocks));
		}
		scan.close();
	}
	public static int F(int clocks[]){
		return F(clocks, 0);
	}
	public static int F(int clocks[], int targetSwitch){
		if(targetSwitch >= numSwitch){
			return (isAllSync(clocks))?0:impossible;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i < 4;i++){
			int tmp = F(clocks, targetSwitch + 1);
			if(tmp >= 0){
				min = Math.min(min, tmp + i);
			}
			move(clocks, switchs[targetSwitch], 3);
		}
		return (min == Integer.MAX_VALUE)?impossible:min;
	}
	public static void move(int clocks[], int switchs[], int movelen){
		for(int i = 0;i < switchs.length;i++){
			clocks[switchs[i]] += movelen;
			while(clocks[switchs[i]] > hour){
				clocks[switchs[i]] -= hour;
			}
		}
	}
	public static boolean isAllSync(int clocks[]){
		for(int i = 0;i < numClock;i++){
			if(clocks[i] != 12){
				return false;
			}
		}
		return true;
	}
}
