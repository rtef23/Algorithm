package QuodTree;

import java.util.Scanner;

public class MainQuad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int testcase = scan.nextInt();
		
		for(;testcase > 0;testcase--){
			System.out.printf("%s\n", (reverseTree(scan.next())));
		}
		
		scan.close();
	}
	public static String reverseTree(String tree){
		/*
		 * */
		if(tree.length() <= 1)
			return tree;
		if(tree.charAt(0) == 'b' || tree.charAt(0) == 'w')
			return tree;
		else{//tree.charAt(0) == 'x'
			int prev_index = 1;
			int next_index = getNextNodeIndex(tree, prev_index);
			if(next_index < 0)
				return 'x' + tree;
			String l_u = tree.substring(prev_index, next_index);
			prev_index = next_index;
			next_index = getNextNodeIndex(tree, prev_index);
			if(next_index < 0)
				return 'x' + reverseTree(l_u);
			String r_u = tree.substring(prev_index, next_index);
			prev_index = next_index;
			next_index = getNextNodeIndex(tree, prev_index);
			if(next_index < 0)
				return 'x' + reverseTree(r_u) + reverseTree(l_u);
			String l_d = tree.substring(prev_index, next_index);
			prev_index = next_index;
			next_index = getNextNodeIndex(tree, prev_index);
			if(next_index < 0)
				return 'x' + reverseTree(l_d) + reverseTree(r_u) + reverseTree(l_u);
			String r_d = tree.substring(prev_index, next_index);
			return 'x' + reverseTree(l_d) + reverseTree(r_d) + reverseTree(l_u) + reverseTree(r_u);
		}
	}
	public static int getNextNodeIndex(String str, int n){
		/*
		 return next node index
		 F(n) =
		 	iff c[n] == 'b'
		 		return n + 1
		 	iff c[n] == 'w'
		 		return n + 1
		 	iff c[n] == 'x'
		 		return F(F(F(F(n + 1))))
		 * */
		if(str.length() <= n)
			return -1;
		if(str.charAt(n) == 'b')
			return n + 1;
		else if(str.charAt(n) == 'w')
			return n + 1;
		else
			return getNextNodeIndex(str, getNextNodeIndex(str, getNextNodeIndex(str, getNextNodeIndex(str, n+1))));
	}
}
