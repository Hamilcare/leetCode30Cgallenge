package leetcode30Challenge;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree {
	List<VisitedNode> visitedNodes = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		two.left = four;
		two.right = five;
		one.left = two;
		one.right = three;

		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(one));
	}

	public int diameterOfBinaryTree(TreeNode root) {
		int max = 0;
		if (root != null) {
			visitNode(root);
			max = visitedNodes.stream().map(node -> node.leftDepth + node.rightDepth).mapToInt(i -> i).max().getAsInt();
		}
		return max;
	}

	public VisitedNode visitNode(TreeNode node) {
		VisitedNode visit = new VisitedNode(node.val);
		if (null != node.left) {
			VisitedNode visitedLeft = visitNode(node.left);
			visit.leftDepth = 1 + Math.max(visitedLeft.leftDepth, visitedLeft.rightDepth);
		}
		if (null != node.right) {
			VisitedNode visitedRight = visitNode(node.right);
			visit.rightDepth = 1 + Math.max(visitedRight.leftDepth, visitedRight.rightDepth);
		}
		visitedNodes.add(visit);
		return visit;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class VisitedNode {
	public VisitedNode(int val) {
		this.val = val;
	}

	int val; // debug purpose
	int leftDepth = 0;
	int rightDepth = 0;
}
