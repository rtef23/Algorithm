package Hanoi;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Stack;

public class Hanoi{
	public static void main(String[] args){
		int n = 3;
		HashMap<Integer, Stack<Pan>> barset = new HashMap<>();
		Pan p[] = new Pan[n];
		
		for(int i = 0;i < 3;i++){
			barset.put(i, new Stack<>());
		}
		
		Stack<Pan> bar = barset.get(0);
		for(int i = n;i >= 1;i--)
			bar.push(new Pan(i));
		
		System.out.println("before");
		printBars(barset);
		
		F(10, 0, 2, barset);
		
		System.out.println("after");
		printBars(barset);
	}
	
	public static void printBars(HashMap<Integer, Stack<Pan>>barset){
		for(Integer i : barset.keySet()){
			System.out.printf("bar[%d] : %s\n", i, printBar(barset.get(i)));
		}
	}
	public static String printBar(Stack<Pan> b){
		String res = "";
		for(int i = 0;i < b.size();i++){
			res += b.elementAt(i).size();
			res += " ";
		}
		return res;
	}
	
	public static void F(int n, int from_index, int to_index, HashMap<Integer, Stack<Pan>> barset){
		if(n == 0)
			return;
		int ni = 3 - (from_index + to_index);
		
		System.out.printf("from from_index[%d] to ni[%d] : %s\n", from_index, ni, printBar(barset.get(from_index)));
		F(n - 1, from_index, ni, barset);
		
		movePan(barset.get(from_index), barset.get(to_index));
		
		System.out.printf("from ni[%d] to to_index[%d] : %s\n" , ni, to_index, printBar(barset.get(to_index)));
		F(n - 1, ni, to_index, barset);
	}
	
	public static void movePan(Stack<Pan> from_pan, Stack<Pan> to_pan){
		if(from_pan.isEmpty())
			return;
		Pan p = from_pan.peek();
		if(to_pan.isEmpty()){
			to_pan.push(from_pan.pop());
		}else{
			if(from_pan.peek().size() < to_pan.peek().size()){
				to_pan.push(from_pan.pop());
			}else{
				return;
			}
		}
	}
}