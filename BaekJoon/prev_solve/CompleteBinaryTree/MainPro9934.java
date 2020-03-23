package prev_solve.CompleteBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MainPro9934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int depth = scan.nextInt();
		int numNode = pow(2, depth) - 1;
		int inorderTraversal[] = new int[numNode];
		
		for(int i = 0;i < numNode;i++){
			inorderTraversal[i] = scan.nextInt();
		}
		scan.close();
		
		HashMap<Integer, LinkedList<Integer>> index = F(depth, numNode);
		for(int i = 0;i < depth;i++){
			LinkedList<Integer> target = index.get(i);
			for(int j = 0;j < target.size();j++){
				System.out.printf("%d ", inorderTraversal[target.get(j)]);
			}
			System.out.println();
		}
	}
	public static HashMap<Integer, LinkedList<Integer>> F(int depth, int numNode){
		HashMap<Integer, LinkedList<Integer>> resIndex = new HashMap<>();
		LinkedList<Integer> curNodes = new LinkedList<>();
		
		curNodes.add(numNode / 2);
		resIndex.put(0, curNodes);
		
		return F(resIndex, depth, numNode, 1);
	}
	public static HashMap<Integer, LinkedList<Integer>> F(HashMap<Integer, LinkedList<Integer>> res, int depth, int numNode, int curDepth){
		if(curDepth >= depth){
			return res;
		}
		
		LinkedList<Integer> beforeNodeIndex = res.get(curDepth - 1);
		LinkedList<Integer> curNodeIndex = new LinkedList<>();
		int curLen = pow(2, depth - (curDepth + 1));
		
		for(int i = 0;i < beforeNodeIndex.size();i++){
			curNodeIndex.add(beforeNodeIndex.get(i) - curLen);
			curNodeIndex.add(beforeNodeIndex.get(i) + curLen);
		}
		res.put(curDepth, curNodeIndex);
		return F(res, depth, numNode, curDepth + 1);
	}
	public static int pow(int down, int up){
		if(down == 1 || up == 0){
			return 1;
		}
		if(up == 1){
			return down;
		}
		if(up % 2 == 0){
			int tmp = pow(down, up / 2);
			return tmp * tmp;
		}else{
			return pow(down, up - 1) * down;
		}
	}
}
