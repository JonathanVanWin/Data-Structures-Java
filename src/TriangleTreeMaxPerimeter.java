

public class TriangleTreeMaxPerimeter {

	public static int heykef(BinNode<Integer> t) {
		int maxV = -1;
		if (!t.hasLeft() && !t.hasRight())
			return -1;

		if (t.hasLeft())
			return Math.max(Math.max(heykef(t.getLeft()), heykef(t.getRight())),
					t.getValue() + t.getLeft().getValue() + t.getRight().getValue());
		return -1;

	}

	public static void printString(String s, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(s);
	}

	public static void printPattern(int n, int offset, int c, int sec) {
		int num = (int) (3 * Math.pow(2, n - 1) + 1);
		int length = num - 1;
		for (int i = 0; i <= n; i++) {
			printString(" ", offset + 1 - i);
			printString("/", 1);
			printString(" ", i + i + 1);
			printString("\\", 1);

			for (int j = 0; j < c; j++) {
				printString(" ", length + n * 6 - 2 * i + sec);
				printString("/", 1);
				printString(" ", i + i + 1);
				printString("\\", 1);
			}

			System.out.println();
		}
	}

	public static int numBars(int lvl) {
		if (lvl <= 1)
			return 0;
		else if (lvl == 2)
			return 1;
		else if (lvl == 3)
			return 2;
		else
			return numBars(lvl - 1) * 2 + 1;
	}

	public static int beforeNumSpaces(int lvl) {
		if (lvl <= 1)
			return 0;
		else
			return numBars(lvl + 1);
	}

	public static int betweenNumSpaces(int lvl) {
		if (lvl <= 1)
			return 3;
		else
			return numBars(lvl + 2);
	}

	public static <T>void formatTree(int levels, T[] arr) {
		
		int p=0, c=0;
		for (int i = levels; i >= 1; i--) {
			printString(" ", String.valueOf(arr[p]).length()==1?beforeNumSpaces(i):beforeNumSpaces(i)-String.valueOf(arr[p]).length());
			System.out.print(arr[p++]);
			for (int t = 0; t < (int) (Math.pow(2, levels - i) - 1); t++) {
				if (i < 1)
					break;
				if (i != 1) {
					printString(" ",  String.valueOf(arr[p]).length()==1?betweenNumSpaces(i):betweenNumSpaces(i)-String.valueOf(arr[p]).length()+1);
					System.out.print(arr[p++]);
				} else {
					printString(" ", t % 2 != 0 ? 1 : 3);
					System.out.print(arr[p++]);

				}
			}
			System.out.println();
			for (int j = 0; j < numBars(i); j++) {
				printString(" ", beforeNumSpaces(i) - 1 - j);
				printString("/", 1);
				printString(" ", 2 * j + 1);
				printString("\\", 1);
				int num = (int) (3 * Math.pow(2, numBars(j) - 1) + 1);
				int length = num - 1;
				for (int k = 0; k < (int) (Math.pow(2, levels - i) - 1); k++) {
					printString(" ", betweenNumSpaces(i) - 2 * (j + 1));
					printString("/", 1);
					printString(" ", j + j + 1);
					printString("\\", 1);
				}
				System.out.println();

			}
		}

	}
	public static boolean isPow2(int value){
		return value==1||value==2?true:value>2&&value%2==0?isPow2(value/2):false;
	}
	public static int log2(int value){
		int c=0;if(!isPow2(value))return 0;

		for(int i=1; i<Integer.MAX_VALUE; i*=2){
			
			if(value==i)return c;
			c++;
		}
		return 0;
	}

	public static void main(String[] args) {
		BinNode<Integer> b = new BinNode<Integer>(
				new BinNode<Integer>(new BinNode<Integer>(99), 3, new BinNode<Integer>(2)), 10,
				new BinNode<Integer>(new BinNode<Integer>(599), 7, new BinNode<Integer>(6)));
		BinNode<Integer> tree = new BinNode<Integer>(new BinNode<Integer>(4), 2, new BinNode<>(5));
		int size  = 127;
		Integer[] arr=new Integer[size];
			for(int i=1; i<size+1; i++)arr[i-1]=i%10;
		System.out.println("-----------------------------------------------------");
		//System.out.println(tree.breadth(tree));
		String[] s= tree.breadth(tree).split(" ");
		
		//formatTree(tree.height(tree),s );
		formatTree(log2(arr.length+1), arr);
		Queue<Object> q=new Queue<>();
		q.insert(1);
		q.insert(2);
		q.insert(null);
		q.insert(3);
		/*while(!q.isEmpty()){
			//System.out.println(q.remove());
		}*/
		//for(String ss:s)System.out.println(ss);
		//System.out.println(log2(arr.length+1));
		//System.out.println("k"+s.length);
		//System.out.println();
		//System.out.println(tree.treeString(tree));
	}

}
