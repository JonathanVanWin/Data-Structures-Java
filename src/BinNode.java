

public class BinNode<T> {
	private BinNode<T> left;

	private T value;

	private BinNode<T> right;

	public BinNode(T x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}

	public BinNode(BinNode<T> left, T x, BinNode<T> right) {
		this.value = x;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return this.value;
	}

	public BinNode<T> getLeft() {
		return this.left;
	}

	public BinNode<T> getRight() {
		return this.right;
	}

	public boolean hasLeft() {
		return (this.left != null);
	}

	public boolean hasRight() {
		return (this.right != null);
	}

	public String toString() {
		return this.value.toString();
	}

	public void setValue(T x) {
		this.value = x;
	}

	public void setLeft(BinNode<T> left) {
		this.left = left;
	}

	public void setAllLeft(T... values) {
		BinNode<T> leftTemp = this;
		for (T v : values) {
			leftTemp.left = new BinNode<T>(v);
			leftTemp = leftTemp.left;
		}
	}

	public void setAllRight(T... values) {
		BinNode<T> leftTemp = this;
		for (T v : values) {
			leftTemp.right = new BinNode<T>(v);
			leftTemp = leftTemp.right;
		}
	}

	public void setAll(T... values) {
		BinNode<T> leftTemp = this;
		if (values.length > 0) {
			leftTemp.left = new BinNode<T>(values[0]);

			if (1 < values.length)
				leftTemp.value = values[1];
			if (2 < values.length)
				leftTemp = new BinNode<T>(values[2]);

		}
	}

	public void display(String msg) {
		if (this != null) {
			System.out.print(msg);
			if (this.left != null)
				System.out.print(" Left: " + this.left.value);
			System.out.print(" Value: " + this.value);
			if (this.right != null)
				System.out.print(" Right: " + this.right.value);
			System.out.println();
			if (this.left != null)
				this.left.display(msg);
			if (this.right != null)
				this.right.display(msg);
		}
	}

	public void setRight(BinNode<T> right) {
		this.right = right;
	}

	public boolean isFull() {
		if (this == null)
			return true;
		else if (this.left != null && this.right != null)
			return this.left.isFull() && this.right.isFull();
		else if (this.left == null && this.right == null)
			return true;
		else
			return false;
	}

	public void printLevel(BinNode<T> t, int lvl) {
		if (lvl == 1)
			System.out.print(t.getValue() + " ");
		else if (lvl >= 1) {
			printLevel(t.getLeft(), lvl - 1);
			printLevel(t.getRight(), lvl - 1);
		}
	}
	
	public String stringLevel(BinNode<T> t, int lvl, String s) {
		
		if (lvl == 1){
			s+=s.equals("")?t.getValue():" "+t.getValue();
		}
		else if (lvl >= 1) {
			stringLevel(t.getLeft(), lvl - 1, s);
			stringLevel(t.getRight(), lvl - 1, s);
		}
		return s;
	}
	
	public String treeString(BinNode<T> t) {
		int h=height(t);
		
		String s="";
		for (int i = 1; i <= h; i++) {
			//printSpaces(h, i);
			System.out.println(s);
			s+=stringLevel(t, i, s);
		}return s;
	}

	public int height(BinNode<T> t) {
		if (t == null)
			return 0;
		else {
			int l = height(t.getLeft());
			int r = height(t.getRight());
			if (l > r)
				return l + 1;
			else
				return r + 1;
		}
	}

	public void print(BinNode<T> t) {
		int h=height(t);
		for (int i = 1; i <= h; i++) {
			printSpaces(h, i);
			printLevel(t, i);
			System.out.println();
		}
	}
	/*
     1
    / \
   /   \
  2     3
 / \   / \
4   5 6   7


       1
      / \
     /   \
    /     \
   2       3
  / \     / \
 /   \   /   \
4     5 6     7


       1
      / \
     /   \
    /     \
   2       3
  / \     / \
 /   \   /   \
4     5 6     7



         1
        / \
       /   \
      /     \
     /       \
    2         3
   / \       / \
  /   \     /   \
 /     \   /     \
4       5 6       7

         1
        / \
       /   \
      /     \
     /       \
    /         \
   2           3
  / \         / \
 /   \       /   \
/     \     /     \
4      5   6       7


             1
            / \
           /   \
          /     \
         /       \
        /         \
       /           \
      2             3
     / \          / \
    /   \        /   \
   /     \      /     \
  4       5    6       7
 / \     / \  / \     / \
8   9   10 11 12

             1
            / \
           /   \
          /     \
         /       \
        /         \
       /           \
      2             3
     / \           / \
    /   \         /   \
   4     5       6     7
  / \   / \     / \   / \
 8   9 10 11   12 13 14 15
 
             1
            / \
           /   \
          /     \
         /       \
        /         \
       2           3
      / \         / \
     /   \       /   \
    4     5     6     7
   / \   / \   / \   / \
  8   9 0   1 2   3 4   5
  
             1
            / \
           /   \
          /     \
         /       \
        /         \
       2           3
      / \         / \
     /   \       /   \
    4     5     6     7
   / \   / \   / \   / \
  8   9 10 11 12 13 14 15
  
  
               1
              / \ 
             /   \
            /     \
           /       \
          /         \
         5           6
        / \         / \
       /   \       /   \
      /     \     /     \
     2       5   7       3
    / \     / \ / \   / \
   /   \   /   \ /   \ /   \
  4     5          6     7
 / \   / \         / \   / \
8   9 10 11       12 13 14 15


                       1
                      / \ 
                     /   \
                    /     \
                   /       \
                  /         \
                 /           \
                /             \
               /               \
              /                 \
             /                   \
            /                     \
           5                       6
          / \                     / \
         /   \                   /   \
        /     \                 /     \
       /       \               /       \
      /         \             /         \
     2           5           7           3
    / \         / \         / \         / \
   /   \       /   \       /   \       /   \ 
  4     5     6     7     8     9     10   11
 / \   / \   / \   / \   / \   / \   / \   / \
8   9 10 11 12 13 14 15 16 17 18 19 20 21 22 23

                                               1
                                              / \
                                             /   \
                                            /     \ 
                                           /       \
                                          /         \
                                         /           \       
                                        /             \
                                       /               \
                                      /                 \ 
                                     /                   \
                                    /                     \
                                   /                       \
                                  /                         \
                                 /                           \
                                /                             \
                               /                               \
                              /                                 \
                             /                                   \
                            /                                     \
                           /                                       \
                          /                                         \ 
                         /                                           \
                        /                                             \
                       1                                               1
                      / \                                             / \
                     /   \                                           /   \
                    /     \                                         /     \
                   /       \                                       /       \
                  /         \                                     /         \
                 /           \                                   /           \
                /             \                                 /             \
               /               \                               /               \
              /                 \                             /                 \
             /                   \                           /                   \
            /                     \                         /                     \
           5                       6                       5                       6
          / \                     / \                     / \                     / \           
         /   \                   /   \                   /   \                   /   \
        /     \                 /     \                 /     \                 /     \
       /       \               /       \               /       \               /       \
      /         \             /         \             /         \             /         \
     2           5           7           3           2           5           7           3
    / \         / \         / \         / \         / \         / \         / \         / \
   /   \       /   \       /   \       /   \       /   \       /   \       /   \       /   \ 
  4     5     6     7     8     9     10   11     4     5     6     7     8     9     10   11
 / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \
8   9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 8   9 10 11 12 13 14 15 16 17 18 19 20 21 22 23



	 */
	public void printSpaces(int height, int lvl){
		for(int i=0; i<height-lvl; i++){
			System.out.print(" ");
		}
	}
	
	Queue<BinNode<T>> queue = new Queue<>() ;
	public String breadth(BinNode<T> root) {
		String s="";
	    if (root == null)
	        return s;
	    queue.clear();
	    queue.insert(root);
	    while(!queue.isEmpty()){
	        BinNode<T> node = queue.remove();
	        if(node==null){
	        	s+="# ";
	        }else{
	        	s+=node.getValue() + " ";
	        	queue.insert(node.left);
	        	queue.insert(node.right);
	        }
	    }
	    return s;
	}
	/*
	 * public BinNode<T> parent(BinNode<T> child){ if(this!=child) return null;
	 * if(this.right==child||this.left==child) return this; else{
	 * if(this.left!=null)return this.left.parent(child);
	 * if(this.right!=null)return this.right.parent(child); } }
	 */
}
