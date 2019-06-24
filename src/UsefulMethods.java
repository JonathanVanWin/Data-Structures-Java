

public class UsefulMethods {
	///
	/// רשימה
	///
	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה "אמת" אם המספר נמצא ברשימה, אחרת מחזירה "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean listContains(Node<Integer> l, int n) {
		Node<Integer> pos = l;
		while (pos != null) {
			if (pos.getValue() == n)
				return true;
			pos = pos.getNext();
		}
		return false;
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים
	// טענת כניסה: הפעולה מחזירה את המספר האיבר הכי קטן ברשימה
	// סיבוכיות זמן ריצה: O(n)
	public static int smallestInList(Node<Integer> l) {
		if (l == null)
			return -1;
		Node<Integer> pos = l;
		int n = pos.getValue();
		while (pos != null) {
			if (pos.getValue() < n) // Max is >
				n = pos.getValue();
			pos = pos.getNext();
		}
		return n;
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים
	// טענת כניסה: הפעולה מחזירה את סכום כל איברי הרשימה
	// סיבוכיות זמן ריצה: O(n)
	public static int sumList(Node<Integer> l) {
		int sum = 0;
		Node<Integer> pos = l;
		while (pos != null) {
			sum += pos.getValue();
			pos = pos.getNext();
		}
		return sum;
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את אורך הרשימה - מספר החוליות בה
	// סיבוכיות זמן ריצה: O(n)
	public static int lengthList(Node<Integer> l) {
		int length = 0;
		Node<Integer> pos = l;
		while (pos != null) {
			length++;
			pos = pos.getNext();
		}
		return length;
	}

	/*
	 * הפעולה מכניסה לרשימה חוליה חדשה שהערך שלה הוא info אחרי החוליה p הפעולה
	 * מחזירה את החוליה החדשה שהוכנסה כדי להכניס איבר ראשון לרשימה הערך של
	 * הפרמטר p צריך להיות null הנחה: החוליה next קיימת ברשימה
	 */
	public static Node<Integer> insert(Node<Integer> list, Node<Integer> p, Integer info) {
		Node<Integer> q = new Node<Integer>(info);
		if (p == null) {
			q.setNext(list);
			list = q;
		} else {
			q.setNext(p.getNext());
			p.setNext(q);
		}
		return q;
	}

	/*
	 * הפעולה מוציאה את החוליה p מן הרשימה ומחזירה את החוליה הבאה אחריה אם הוצאה
	 * החוליה האחרונה ברשימה הפעולה תחזיר null הנחה: החוליה p קיימת ברשימה
	 */
	public static Node<Integer> remove(Node<Integer> list, Node<Integer> p) {
		if (list == p) {
			list = p.getNext();
			return list;
		} else {
			Node<Integer> prev = list;
			while (prev.getNext() != p)
				prev = prev.getNext();
			prev.setNext(p.getNext());
			return prev.getNext();
		}
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מוחקת את כל מופעי המספר שהתקבל מהרשימה
	// סיבוכיות זמן ריצה: O(n)
	public static void debugList(Node<Integer> l, int n) {
		Node<Integer> pos = l;
		while (pos != null)
			if (pos.getValue() == n) {
				pos = remove(l, pos);
			} else
				pos = pos.getNext();
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה את מספר הפעמים שהמספר מופיע ברשימה
	// סיבוכיות זמן ריצה: O(n)
	public static int howManyList(Node<Integer> l, int n) {
		int count = 0;
		Node<Integer> pos = l;
		while (pos != null) {
			if (pos.getValue() == n)
				count++;
			pos = pos.getNext();
		}
		return count;
	}

	// טענת כניסה: הפעולה מקבלת רשימה ממוינת של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מכניסה באופן ממוין את המספר לרשימה
	// סיבוכיות זמן ריצה: O(n)
	public static void insertSorted(Node<Integer> l, int n) {
		Node<Integer> pos = l;
		Node<Integer> before = null;
		while (pos != null && n > pos.getValue()) {
			before = pos;
			pos = pos.getNext();
		}
		insert(l, before, n);
	}

	// טענת כניסה: הפעולה מקבלת רשימה של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה "אמת" אם הרשימה ממוינת בסדר עולה, אחרת מחזירה
	// "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean isSorted(Node<Integer> l) {
		Node<Integer> pos = l;
		while (pos.getNext() != null) {
			if (pos.getValue() > pos.getNext().getValue())
				return false;
			pos = pos.getNext();
		}
		return true;
	}

	// טענת כניסה: הפעולה מקבלת רשימה לא ממוינת של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה רשימה המכילה את כל ערכי הרשימה שהתקבלה בסדר
	// ממוין עולה
	// סיבוכיות זמן ריצה: O(n²)
	public static Node<Integer> sort(Node<Integer> l) {
		Node<Integer> newL = new Node<Integer>(smallestInList(l) - 1);
		Node<Integer> pos = l;
		while (pos != null) {
			insertSorted(newL, pos.getValue()); // ! //O(n)
			pos = pos.getNext();
		}
		return newL.getNext();
	}

	///
	/// מחסנית
	///
	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה מחסנית חדשה, שאיבריה זהים בערכם ובסדרם לאיברי
	/// המחסנית שהתקבלה
	// סיבוכיות זמן ריצה: O(n)
	public static Stack<Integer> cloneStack(Stack<Integer> s) {
		Stack<Integer> newS = new Stack<Integer>();
		Stack<Integer> tmp = new Stack<Integer>();
		while (!s.isEmpty())
			tmp.push(s.pop());
		while (!tmp.isEmpty()) {
			newS.push(tmp.top());
			s.push(tmp.pop());
		}
		return newS;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה מחסנית חדשה, שאיבריה מסודרים בסדר הפוך ביחס
	// לאיברי המחסנית שהתקבלה
	// סיבוכיות זמן ריצה: O(n)
	public static Stack<Integer> flipStack(Stack<Integer> s) {
		Stack<Integer> newS = new Stack<Integer>();
		Stack<Integer> tmp = cloneStack(s); // !
		while (!tmp.isEmpty())
			newS.push(tmp.pop());
		return newS;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים ומספר שלם
	// טענת יציאה: המחסנית מחזירה "אמת" אם המספר נמצא במחסנית, אחרת מחזירה "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean stackContains(Stack<Integer> s, int n) {
		Stack<Integer> sCopy = cloneStack(s); // !
		while (!sCopy.isEmpty())
			if (sCopy.pop() == n)
				return true;
		return false;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה "אמת" אם המספר נמצא במחסנית, אחרת מחזירה "שקר"
	// הערה: הפעולה רקורסיבית, ועדיין שומרת על סדר המחסנית שהתקבלה
	// סיבוכיות זמן ריצה: O(n)
	public static boolean stackContainsRec(Stack<Integer> s, int n) {
		if (s.isEmpty())
			return false;
		int x = s.pop();
		boolean exists = (x == n || stackContainsRec(s, n));
		s.push(x); // לאחר הקריאה הרקורסיבית, האיבר שנשלף נדחף בחזרה אל תוך
					// המחסנית
		return exists;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את סכום איברי המחסנית
	// סיבוכיות זמן ריצה: O(n)
	public static int sumStack(Stack<Integer> s) {
		int sum = 0;
		Stack<Integer> sCopy = cloneStack(s); // !
		while (!sCopy.isEmpty())
			sum += sCopy.pop();
		return sum;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את אורך המחסנית - מספר האיברים בה
	// סיבוכיות זמן ריצה: O(n)
	public static int lengthStack(Stack<Integer> s) {
		int length = 0;
		Stack<Integer> sCopy = cloneStack(s); // !
		while (!sCopy.isEmpty()) {
			length++;
			sCopy.pop();
		}
		return length;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה את מספר הפעמים שהמספר מופיע במחסנית
	// סיבוכיות זמן ריצה: O(n)
	public static int howManyStack(Stack<Integer> s, int n) {
		int count = 0;
		Stack<Integer> tmp = cloneStack(s); // !
		while (!tmp.isEmpty())
			if (tmp.pop() == n)
				count++;
		return count;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מוחקת את כל מופעי המספר שהתקבל מתוך המחסנית
	// סיבוכיות זמן ריצה: O(n)
	public static void DebugStack(Stack<Integer> s, int n) {
		Stack<Integer> tmp = flipStack(s); // !
		while (!s.isEmpty())
			s.pop();
		while (!tmp.isEmpty()) {
			int x = tmp.pop();
			if (x != n)
				s.push(x);
		}
	}

	///
	/// תור
	///
	// טענת כניסה: הפעולה מקבלת תור של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה תור חדש, שאיבריו זהים בערכם ובסדרם לאיברי התור
	/// שהתקבל
	// סיבוכיות זמן ריצה: O(n)
	public static Queue<Integer> cloneQueue(Queue<Integer> q) {
		Queue<Integer> newQ = new Queue<Integer>();
		Queue<Integer> tmp = new Queue<Integer>();
		while (!q.isEmpty()) {
			newQ.insert(q.head());
			tmp.insert(q.remove());
		}
		while (!tmp.isEmpty())
			q.insert(tmp.remove());
		return newQ;
	}

	// טענת כניסה: הפעולה מקבלת מחסנית של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה "אמת" אם המספר קיים בתור, אחרת מחזירה "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean queueContains(Queue<Integer> q, int n) {
		Queue<Integer> qCopy = cloneQueue(q); // !
		while (!qCopy.isEmpty())
			if (qCopy.remove() == n)
				return true;
		return false;
	}

	// טענת כניסה: הפעולה מקבלת תור של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את סכום איברי התור
	// סיבוכיות זמן ריצה: O(n)
	public static int sumQueue(Queue<Integer> q) {
		int sum = 0;
		Queue<Integer> qCopy = cloneQueue(q); // !
		while (!qCopy.isEmpty())
			sum += qCopy.remove();
		return sum;
	}

	// טענת כניסה: הפעולה מקבלת תור של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את אורך התור - מספר האיברים בו
	// סיבוכיות זמן ריצה: O(n)
	public static int lengthQueue(Queue<Integer> q) {
		int length = 0;
		Queue<Integer> qCopy = cloneQueue(q); // !
		while (!qCopy.isEmpty()) {
			length++;
			qCopy.remove();
		}
		return length;
	}

	// טענת כניסה: הפעולה מקבלת תור של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה את מספר הפעמים שהמספר מופיע בתור
	// סיבוכיות זמן ריצה: O(n)
	public static int howManyQueue(Queue<Integer> q, int n) {
		int count = 0;
		Queue<Integer> tmp = cloneQueue(q); // !
		while (!tmp.isEmpty())
			if (tmp.remove() == n)
				count++;
		return count;
	}

	// טענת כניסה: הפעולה מקבלת תור של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מוחקת את כל מופעי המספר שהתקבל מתוך התור
	// סיבוכיות זמן ריצה: O(n)
	public static void DebugQueue(Queue<Integer> q, int n) {
		Queue<Integer> tmp = cloneQueue(q); // !
		while (!q.isEmpty())
			q.remove();
		while (!tmp.isEmpty()) {
			int x = tmp.remove();
			if (x != n)
				q.insert(x);
		}
	}

	///
	/// עץ בינארי
	///
	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה עץ חדש, זהה בדיוק בצמתיו ובמיקומים שלהם לעץ
	/// שהתקבל
	// סיבוכיות זמן ריצה: O(n)
	public static BinNode<Integer> cloneTree(BinNode<Integer> bt) {
		if (bt == null)
			return null;
		BinNode<Integer> left = cloneTree(bt.getLeft());
		BinNode<Integer> right = cloneTree(bt.getRight());
		return new BinNode<Integer>(left, bt.getValue(), right); // להחליף ימין
																	// ושמאל
																	// לקבלת עץ
																	// מראה
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה "אמת" אם המספר שהתקבל נמצא בעץ, אחרת מחזירה
	// "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean treeContains(BinNode<Integer> bt, int n) {
		if (bt == null)
			return false;
		return (bt.getValue() == n || treeContains(bt.getLeft(), n) || treeContains(bt.getRight(), n));
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את סכום ערכי כל הצמתים בעץ
	// סיבוכיות זמן ריצה: O(n)
	public static int sumTree(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		return bt.getValue() + sumTree(bt.getLeft()) + sumTree(bt.getRight());
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה "אמת" אם העץ הוא עלה, אחרת מחזירה "שקר"
	// סיבוכיות זמן ריצה: O(1)
	public static boolean isLeaf(BinNode<Integer> bt) {
		return (bt.getLeft() == null && bt.getRight() == null);
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מדפיסה את ערכי הצמתים בעץ לפי סדר תחילי - שורש, שמאל,
	// ימין
	// סיבוכיות זמן ריצה: O(n)
	public static void printPreOrder(BinNode<Integer> bt) {
		if (bt != null) {
			System.out.println(bt.getValue());
			printPreOrder(bt.getLeft());
			printPreOrder(bt.getRight());
		}
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מדפיסה את ערכי הצמתים בעץ לפי סדר תוכי - שמאל, שורש,
	// ימין
	// סיבוכיות זמן ריצה: O(n)
	public static void printInOrder(BinNode<Integer> bt) {
		if (bt != null) {
			printInOrder(bt.getLeft());
			System.out.println(bt.getValue());
			printInOrder(bt.getRight());
		}
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מדפיסה את ערכי הצמתים בעץ לפי סדר סופי - שמאל, ימין,
	// שורש
	// סיבוכיות זמן ריצה: O(n)
	public static void printPostOrder(BinNode<Integer> bt) {
		if (bt != null) {
			printPostOrder(bt.getLeft());
			printPostOrder(bt.getRight());
			System.out.println(bt.getValue());
		}
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מדפיסה את ערכי הצמתים בעץ לפי הרמה שלהם - כל צמתי העץ
	// ברמה כלשהי יודפסו אחד אחרי השני
	// סיבוכיות זמן ריצה: O(n)
	public static void printByLevels(BinNode<Integer> bt) {
		Queue<BinNode<Integer>> q = new Queue<BinNode<Integer>>();
		q.insert(bt);
		while (!q.isEmpty()) {
			BinNode<Integer> current = q.remove();
			System.out.println(current.getValue());
			if (current.getLeft() != null)
				q.insert(current.getLeft());
			if (current.getRight() != null)
				q.insert(current.getRight());
		}
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את מספר הצמתים בעץ
	// סיבוכיות זמן ריצה: O(n)
	public static int countNodes(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		return 1 + countNodes(bt.getLeft()) + countNodes(bt.getRight());
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את מספר העלים בעץ
	// סיבוכיות זמן ריצה: O(n)
	public static int countLeaves(BinNode<Integer> bt) {
		if (bt == null)
			return 0;
		if (isLeaf(bt)) // !
			return 1;
		return countLeaves(bt.getLeft()) + countLeaves(bt.getRight());
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את גובה העץ
	// סיבוכיות זמן ריצה: O(n)
	public static int height(BinNode<Integer> bt) {
		if (bt == null)
			return -1;
		return 1 + Math.max(height(bt.getLeft()), height(bt.getRight()));
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה את הערך הגבוה ביותר בעץ
	// סיבוכיות זמן ריצה: O(n)
	public static int maxValue(BinNode<Integer> bt) {
		if (isLeaf(bt)) // !
			return bt.getValue();
		int maxLeft = maxValue(bt.getLeft());
		int maxRight = maxValue(bt.getRight());
		return Math.max(bt.getValue(), Math.max(maxLeft, maxRight));
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי "בן" ואת הצומת העליון ביותר בעץ כלשהו
	// בו נמצא "בן" - "שורש"
	// טענת יציאה: הפעולה מחזירה את האב של העץ "בן". אם אביו לא נמצא בעץ "שורש"
	// - יוחזר ערך ריק
	// סיבוכיות זמן ריצה: O(n)
	public static BinNode<Integer> getFather(BinNode<Integer> source, BinNode<Integer> son) {
		if (source == null)
			return null;
		if (source.getLeft() == son || source.getRight() == son)
			return source;
		BinNode<Integer> left = getFather(source.getLeft(), son);
		if (left != null)
			return left;
		return getFather(source.getRight(), son);
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מחזירה את מספר הצמתים בהם מופיע הערך שהתקבל
	// סיבוכיות זמן ריצה: O(n)
	public static int howManyTree(BinNode<Integer> bt, int n) {
		if (bt == null)
			return 0;
		if (bt.getValue() == n)
			return 1 + howManyTree(bt.getLeft(), n) + howManyTree(bt.getRight(), n);
		return howManyTree(bt.getLeft(), n) + howManyTree(bt.getRight(), n);
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים ומספר שלם המייצג רמה
	// בעץ
	// טענת יציאה: הפעולה מחזירה את מספר הצמתים ברמה שהתקבלה
	// סיבוכיות זמן ריצה: O(n)
	public static int nodesInLevel(BinNode<Integer> bt, int level) {
		if (bt == null)
			return 0;
		if (level == 0)
			return 1;
		return nodesInLevel(bt.getLeft(), level - 1) + nodesInLevel(bt.getRight(), level - 1);
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים
	// טענת יציאה: הפעולה מחזירה "אמת" אם העץ הוא עץ חיפוש בינארי, אחרת מחזירה
	// "שקר"
	// סיבוכיות זמן ריצה: O(n)
	public static boolean isBST(BinNode<Integer> bt) {
		if (bt == null)
			return true;
		if (bt.getLeft() != null && bt.getLeft().getValue() >= bt.getValue())
			return false;
		if (bt.getRight() != null && bt.getRight().getValue() < bt.getValue())
			return false;
		return isBST(bt.getLeft()) && isBST(bt.getRight());
	}

	// טענת כניסה: הפעולה מקבלת עץ בינארי של מספרים שלמים ומספר שלם
	// טענת יציאה: הפעולה מוסיפה את המספר שהתקבל לעץ החיפוש הבינארי
	// סיבוכיות זמן ריצה: O(log(n))
	public static void addToBST(BinNode<Integer> bt, int n) {
		if (bt.getLeft() == null && n < bt.getValue())
			bt.setLeft(new BinNode<Integer>(n));
		else if (bt.getRight() == null && n >= bt.getValue())
			bt.setRight(new BinNode<Integer>(n));
		else if (n < bt.getValue())
			addToBST(bt.getLeft(), n);
		else
			addToBST(bt.getRight(), n);
	}
}