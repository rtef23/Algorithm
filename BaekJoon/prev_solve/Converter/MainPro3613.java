package prev_solve.Converter;

import java.util.Scanner;

public class MainPro3613 {
	private static final int JAVA = -1;
	private static final int CPP = 1;
	private static final int NONE = 0;
	private static final Character UNDER = '_';
	private static final String errStr = "Error!";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String target = scan.next();
		scan.close();
		
		int type = detectType(target);
		switch (type) {
			case JAVA:
			case CPP:
			{
				System.out.println(convert(target, type));
			}
			break;
			default://NONE
			{
				System.out.println(errStr);
			}
			break;
		}
	}
	
	public static int detectType(String target){
		boolean isUnderExt = false;
		boolean isUpperExt = false;
		boolean isNone = false;
		if(Character.isUpperCase(target.charAt(0)) || target.charAt(0) == UNDER){
			return NONE;
		}
		for(int i = 1;i < target.length();i++){
			if(target.charAt(i) <= 'Z' && target.charAt(i) >= 'A'){
				isUpperExt = true;
			}
			if(target.charAt(i) == UNDER){
				isUnderExt = true;
				if(target.charAt(i - 1) == UNDER || i == target.length() - 1){
					isNone = true;
					break;
				}
			}
		}
		
		return (isNone)?NONE:(isUpperExt && isUnderExt)?NONE:(isUnderExt)?CPP:JAVA;
	}
	private static String convert(String target, int fromType){
		StringBuilder sb = new StringBuilder();
		switch (fromType) {
			case CPP:
			{
				boolean toUpper = false;
				for(int i = 0;i < target.length();i++){
					if(toUpper){
						sb.append(Character.toUpperCase(target.charAt(i)));
						toUpper = false;
						continue;
					}
					if(target.charAt(i) == UNDER){
						toUpper = true;
						continue;
					}
					sb.append(target.charAt(i));
				}
			}
			break;
			default://JAVA
			{
				for(int i = 0;i < target.length();i++){
					if(Character.isUpperCase(target.charAt(i))){
						sb.append(UNDER);
						sb.append(Character.toLowerCase(target.charAt(i)));
						continue;
					}
					sb.append(target.charAt(i));
				}
			}
			break;
		}
		return sb.toString();
	}
}
