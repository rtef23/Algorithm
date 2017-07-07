package StringNArray;

public class cngChar {
	public char[] change(char[] target, int targetLen, String cngStr){
		int emptyLen = countEmptyChar(target, targetLen);
		int convertLen = targetLen + emptyLen * (cngStr.length() - 1);
		char ret[] = new char[convertLen];
		int retIndex = 0;
		
		for(int i = 0;i < targetLen;i++){
			if(target[i] == ' '){
				for(int j = 0;j < cngStr.length();j++){
					ret[retIndex++] = cngStr.charAt(j);
				}
			}else{
				ret[retIndex++] = target[i];
			}
		}
		
		return ret;
	}
	private int countEmptyChar(char target[], int targetLen){
		int ret = 0;
		for(int i = 0;i < targetLen;i++)
			if(target[i] == ' ')
				ret++;
		return ret;
	}
}
