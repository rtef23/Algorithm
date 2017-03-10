package findComplement;

public class findComplement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 5;
		
		System.out.printf("\ttarget : %d \n\tconverted : %d\n", target, findComplement(target));
	}
	public static int findComplement(int target){
		int t = 0;
		for(int t1 = 1;t1 > 0;t1<<=1){
			t |= (t1 & target)^t1;
			System.out.println(Integer.toBinaryString(t1));
		}
		return t;
	}
}
