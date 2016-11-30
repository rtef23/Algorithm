package Hanoi;

public class Pan{
	public Pan prev;
	public Pan next;
	int size;

	public Pan(int n){
		size = n;
	}
	public int size(){
		return size;
	}
}