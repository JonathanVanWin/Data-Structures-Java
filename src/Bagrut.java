

public class Bagrut {

	public static int numParentsTwoKids(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		if (bt.hasLeft() && bt.hasRight())
			return 1 + numParentsTwoKids(bt.getLeft()) + numParentsTwoKids(bt.getRight());
		return numParentsTwoKids(bt.getLeft()) + numParentsTwoKids(bt.getRight());
	}

	// Num Nodes that are bigger than n
	public static int countBiggerThanN(BinNode<Integer> bt, int n) {
		if (bt == null)
			return 0;
		if (bt.getValue() > n)
			return 1 + countBiggerThanN(bt.getLeft(), n) + countBiggerThanN(bt.getRight(), n);
		return countBiggerThanN(bt.getLeft(), n) + countBiggerThanN(bt.getRight(), n);
	}

	// Sum Nodes that are even or that their value has no decimals
	public static int sumEvenOrWhole(BinNode<Double> bt) {
		if (bt == null)
			return 0;
		if (bt.getValue() % 2 == 0 || bt.getValue() % 1 == 0)
			return 1 + sumEvenOrWhole(bt.getLeft()) + sumEvenOrWhole(bt.getRight());
		return sumEvenOrWhole(bt.getLeft()) + sumEvenOrWhole(bt.getRight());
	}

	// Sum of nodes that have brothers, and they are the biggest from the two
	public static int sumBiggerThanBrother(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		if (bt.hasLeft() && bt.hasRight())
			return Math.max(bt.getLeft().getValue(), bt.getRight().getValue()) + sumBiggerThanBrother(bt.getLeft())
					+ sumBiggerThanBrother(bt.getRight());
		return sumBiggerThanBrother(bt.getLeft()) + sumBiggerThanBrother(bt.getRight());
	}

	public static boolean isLeaf(BinNode<Integer> bt) {
		if (bt == null)
			return false;
		if (bt.getLeft() == null && bt.getRight() == null)
			return true;
		return false;
	}

	public static int countLeaves(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		if (isLeaf(bt))
			return 1;
		return countLeaves(bt.getLeft()) + countLeaves(bt.getRight());
	}

	// sum of nodes, that left son has more leaves than right son
	public static int countLeavesLeftMoreRight(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		if (countLeaves(bt.getLeft()) > countLeaves(bt.getRight()))
			return 1 + countLeavesLeftMoreRight(bt.getLeft()) + countLeavesLeftMoreRight(bt.getRight());
		return countLeavesLeftMoreRight(bt.getLeft()) + countLeavesLeftMoreRight(bt.getRight());
	}

	// True if sum sons is like dad
	public static boolean sumKidsLikeDad(BinNode<Integer> bt) {
		if (bt == null)
			return false;
		if (!bt.hasLeft() && !bt.hasRight())
			return true;
		if (bt.getValue() == bt.getLeft().getValue() + bt.getRight().getValue() && sumKidsLikeDad(bt.getLeft())
				&& sumKidsLikeDad(bt.getRight()))
			return true;
		return false;
	}

	public static int numNodes(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		return 1 + numNodes(bt.getLeft()) + numNodes(bt.getRight());
	}

	public static boolean pizzaTree(BinNode<Integer> bt) {
		if (bt == null)
			return true;
		if (numNodes(bt.getRight()) >= numNodes(bt.getLeft()) && pizzaTree(bt.getLeft()) && pizzaTree(bt.getRight()))
			return true;
		return false;
	}

	public static boolean isBalanced(BinNode<Integer> bt) {
		if (bt == null)
			return true;
		if (Math.abs(height(bt.getLeft()) - height(bt.getRight())) > 1)
			return false;
		return isBalanced(bt.getLeft()) && isBalanced(bt.getRight());
	}

	public static int height(BinNode<Integer> bt) {
		if (bt == null)
			return -1;
		return 1 + Math.max(height(bt.getLeft()), height(bt.getRight()));
	}

	//Returns true if there is one path from root to leaf with the same value
	public static boolean onePath(BinNode<Integer> bt) {
		if (bt == null || !bt.hasLeft() && !bt.hasRight())
			return true;
		if (bt.hasLeft() && bt.hasRight())
			return bt.getValue().equals(bt.getRight().getValue()) && onePath(bt.getRight())
					|| bt.getValue().equals(bt.getLeft().getValue()) && onePath(bt.getLeft());
		else if (bt.hasLeft()) {
			return bt.getValue().equals(bt.getLeft().getValue()) && onePath(bt.getLeft());
		} else
			return bt.getValue().equals(bt.getRight().getValue()) && onePath(bt.getRight());
	}

	public static void main(String[] args) {
		BinNode<Integer> b = new BinNode<Integer>(
				new BinNode<Integer>(new BinNode<Integer>(99), 3, new BinNode<Integer>(2)), 10,
				new BinNode<Integer>(new BinNode<Integer>(599), 7, new BinNode<Integer>(6)));
		BinNode<Double> bD = new BinNode<Double>(
				new BinNode<Double>(new BinNode<Double>(99.54), 3.0, new BinNode<Double>(2.1)), 10.0,
				new BinNode<Double>(new BinNode<Double>(599.0), 7.5, new BinNode<Double>(6.0)));
		BinNode<Integer> tree = new BinNode<Integer>(new BinNode<Integer>(new BinNode<Integer>(1), 4, new BinNode<>(3)),
				9, new BinNode<Integer>(new BinNode<Integer>(3), 5, new BinNode<>(2)));
		BinNode<Integer> oP = new BinNode<Integer>(new BinNode<Integer>(new BinNode<Integer>(2), 1, new BinNode<>(2)),
				1, new BinNode<Integer>(new BinNode<Integer>(2), 1, new BinNode<>(2)));
		TriangleTreeMaxPerimeter.formatTree(b.height(b), b.breadth(b).split(" "));
		System.out.println("\n\n\n" + numParentsTwoKids(b));
		System.out.println(countBiggerThanN(b, 50));

		TriangleTreeMaxPerimeter.formatTree(bD.height(bD), bD.breadth(bD).split(" "));
		System.out.println(sumEvenOrWhole(bD));
		System.out.println(sumBiggerThanBrother(b));
		System.out.println(countLeavesLeftMoreRight(b));
		TriangleTreeMaxPerimeter.formatTree(tree.height(tree), tree.breadth(tree).split(" "));
		System.out.println(sumKidsLikeDad(tree));
		System.out.println(pizzaTree(b));
		TriangleTreeMaxPerimeter.formatTree(tree.height(oP), tree.breadth(oP).split(" "));
		System.out.println(onePath(oP));
	}
}