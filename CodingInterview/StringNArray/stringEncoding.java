package StringNArray;

public class stringEncoding {
	public String encoding(String target){
		if(target == null || target.length() <= 2)
			return target;

		StringBuilder sb = new StringBuilder();
		char prev = target.charAt(0);
		int chCnt = 1;
		
		sb.append(prev);
		for(int i = 1;i < target.length();i++){
			if(prev != target.charAt(i)){
				sb.append(chCnt);
				prev = target.charAt(i);
				sb.append(prev);
				chCnt = 1;
			}else{
				chCnt++;
			}
		}
		sb.append(chCnt);
		return (target.length() <= sb.length())?target:sb.toString();
	}
}
