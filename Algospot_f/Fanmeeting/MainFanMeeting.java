package Fanmeeting;

import java.util.Arrays;
import java.util.Scanner;

public class MainFanMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine().trim());
		String line;
		for(int i = 0;i < t;i++){
			line = scan.nextLine().trim();
			boolean member[] = new boolean[line.length()];
			for(int j = 0;j < line.length();j++)
				member[j] = (line.charAt(j) == 'M');
			line = scan.nextLine().trim();
			boolean fan[] = new boolean[line.length()];
			for(int j = 0;j < line.length();j++)
				fan[j] = (line.charAt(j) == 'M');
			System.out.println(F(member, fan));
		}
		scan.close();
	}
	public static int F(boolean member[], boolean fan[]){
		return F(member, fan, 0, fan.length - 1);
	}
	public static int F(boolean member[], boolean fan[], int fl, int fr){
		int size = (fr - fl)+1;
		if(size < member.length)
			return 0;
		if(size == member.length)
			return (isAllHug(member, fan, fl, fr))?1:0;
		int mid = (fl + fr) / 2;
		int searchStartIndex = mid - (member.length - 2);
		int searchLen = member.length - 1;
		int midRes = 0;
		
		if(searchStartIndex < fl){
			searchStartIndex = fl;
		}
		for(int i = 0;i < searchLen;i++){
			int searchEndIndex = searchStartIndex + i + member.length - 1;
			if(searchEndIndex > fr)
				searchEndIndex = fr;
			if(isAllHug(member, fan, searchStartIndex + i, searchEndIndex))
				midRes++;
		}
		return F(member, fan, fl, mid) + F(member, fan, mid + 1, fr) + midRes;
	}
	public static boolean isAllHug(boolean member[], boolean fan[], int si, int ei){
		if(si < 0 || (ei - si + 1) != member.length || ei >= fan.length)
			return false;
		for(int i = 0;i < member.length;i++){
			if(member[i] && fan[si + i])
				return false;
		}
		return true;
	}
}
