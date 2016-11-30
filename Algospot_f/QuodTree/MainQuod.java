package QuodTree;

import java.util.ArrayList;
import java.util.Scanner;

public class MainQuod {
	private static final char Black = 'b';
	private static final char White = 'w';
	private static final char Subtree = 'x';
	private static int cur_pos;

	/*
	 * compress x(left-up)(right-up)(left-down)(right-down)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t;// test case

		t = scan.nextInt();

		for (int i = 0; i < t; i++) {
			// input
			String quod_tree = scan.next();
			cur_pos = 0;
			// reverse quod tree
			System.out.println(subtree(quod_tree));
		}

		scan.close();
	}

	private static String subtree(String tree) {
		cur_pos++;
		if (tree.charAt(cur_pos - 1) != Subtree)
			return Character.toString(tree.charAt(cur_pos - 1));
		int tree_pos = 0;
		ArrayList<StringBuffer> sub_trees = new ArrayList<>();

		for (int i = 0; i < 4; i++)
			sub_trees.add(new StringBuffer());

		while (tree_pos < 4) {
			sub_trees.set(tree_pos, sub_trees.get(tree_pos).append(subtree(tree)));
			tree_pos++;
		}

		return Subtree + sub_trees.get(2).toString() + sub_trees.get(3).toString() + sub_trees.get(0).toString()
				+ sub_trees.get(1).toString();
	}
}
