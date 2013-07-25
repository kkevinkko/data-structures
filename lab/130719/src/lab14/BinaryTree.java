package lab14;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	protected TreeNode myRoot;
	
	public BinaryTree ( ) {
		myRoot = null;
	}
	
	public BinaryTree (TreeNode t) {
		myRoot = t;
	}
	
	// Print the values in the tree in preorder: root value first,
	// then values in the left subtree (in preorder), then values
	// in the right subtree (in preorder).
	public void printPreorder ( ) {
		printPreorder (myRoot);
		System.out.println ( );
	}
	public static BinaryTree fibTree (int n) {
	    BinaryTree result = new BinaryTree ( );
	    result.myRoot = result.fibTreeHelper (n);
	    return result;
	}

	private TreeNode fibTreeHelper (int n) {
		if (n == 0) {
			return new TreeNode(new Integer(0));
		}
		if (n == 1) {
			return new TreeNode(new Integer(1));
		}
		Integer current1 = (Integer) fibTreeHelper(n-1).myItem;
		Integer current2 = (Integer) fibTreeHelper(n-2).myItem;

		return new TreeNode(current1.intValue() + current2.intValue(), fibTreeHelper(n-1), fibTreeHelper(n-2));
	}

	protected static void printPreorder (TreeNode t) {
		if (t != null) {
			System.out.print (t.myItem + " ");
			printPreorder (t.myLeft);
			printPreorder (t.myRight);
		}
	}

	// Print the values in the tree in inorder: values in the left
	// subtree first (in inorder), then the root value, then values
	// in the right subtree (in inorder).
	public void printInorder ( ) {
		printInorder (myRoot);
		System.out.println ( );
	}

	protected static void printInorder (TreeNode t) {
		if (t != null) {
			printInorder (t.myLeft);
			System.out.print (t.myItem + " ");
			printInorder (t.myRight);
		}
	}
	
	public void fillSampleTree1 ( ) {
		myRoot =
		    new TreeNode ("a",
			new TreeNode ("b"),
			new TreeNode ("c"));
	}

	public void fillSampleTree2 ( ) {
		myRoot =
		    new TreeNode ("a",
			new TreeNode ("b",
			    new TreeNode ("d",
				new TreeNode ("e"),
				new TreeNode ("f")),
			    null),
			new TreeNode ("c"));
	}

	public static void main (String [ ] args) {
		BinaryTree t;
		t = new BinaryTree ( );
		print (t, "the empty tree");
		t.fillSampleTree1 ( );
		print (t, "sample tree 1");
		t.fillSampleTree2 ( );
		print (t, "sample tree 2");
		t.check();
		print (fibTree(5), "fibtree");
		fibTree(5).print();
		t = exprTree("((a+(5*(a+b)))+(6*5))");
		t.print();
		t = exprTree("((a+(5*(9+1)))+(6*5))");
		t.optimize();
		t.print();
	}

	protected static void print (BinaryTree t, String description) {
		System.out.println (description + " in preorder");
		t.printPreorder ( );
		System.out.println (description + " in inorder");
		t.printInorder ( );
		System.out.println ( );
	}
	
	public void print() {
		if (myRoot != null) {
			printHelper(myRoot, 0);
		}
	}
	
	protected static final String indent1 = "    ";
	
	protected static void printHelper(TreeNode root, int indent) {
		if (root != null) printHelper(root.myRight, indent + 1); else return;
		println(root.myItem, indent);
		if (root != null) printHelper(root.myLeft, indent + 1);
	}
	
	protected static void println(Object obj, int indent) {
		for (int k = 0; k < indent; k++) {
			System.out.print(indent1);
		}
		System.out.println(obj);
	}
	
	protected ArrayList<TreeNode> alreadySeen;
	
	public boolean check() {
		alreadySeen = new ArrayList<TreeNode>();
		try {
			isOK(myRoot);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
	protected void isOK(TreeNode t) throws IllegalStateException {
		Iterator<TreeNode> it = new TreeIterator();
		while (it.hasNext()) {
			TreeNode current = it.next();
			if (alreadySeen.contains(current)) {
				throw new IllegalStateException("It has already been seen!");
			} else {
				alreadySeen.add(current);
			}
		}
	}
	

	protected static class TreeNode {
		
		public Object myItem;
		public TreeNode myLeft;
		public TreeNode myRight;
		
		public TreeNode (Object obj) {
			myItem = obj;
			myLeft = myRight = null;
		}
		
		public TreeNode (Object obj, TreeNode left, TreeNode right) {
			myItem = obj;
			myLeft = left;
			myRight = right;
		}

	}
		
		
	public class TreeIterator implements Iterator<TreeNode> {

		public TreeIterator() {
			if (myRoot != null) {
				fringe.add(myRoot);
			}
		}
		
		private Queue<TreeNode> fringe = new LinkedList<TreeNode>();
		
		public boolean hasNext() {
			return !fringe.isEmpty();
		}
	
		public TreeNode next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements in the tree.");
			}
			TreeNode node = (TreeNode) fringe.remove();
			
			if (node.myLeft != null) {
				fringe.add(node.myLeft);
			}
			
			if (node.myRight != null) {
				fringe.add(node.myRight);
			}
	
			return node;
		}
		
		public void remove() {
			// not used
		}

	}
	public static BinaryTree exprTree (String s) {
	    BinaryTree result = new BinaryTree ( );
	    result.myRoot = result.exprTreeHelper (s);
	    return result;
	}
	// Return the tree corresponding to the given arithmetic expression.
	// The expression is legal, fully parenthesized, contains no blanks, 
	// and involves only the operations + and *.
	protected TreeNode exprTreeHelper (String expr) {
	    if (expr.charAt (0) != '(') {
	    	if (Character.isLetter(expr.charAt(0))) return new TreeNode(expr.charAt(0)); else return new TreeNode(new Integer(Character.getNumericValue(expr.charAt(0))));
	    } else {
	        // expr is a parenthesized expression.
	        // Strip off the beginning and ending parentheses,
	        // find the main operator (an occurrence of + or * not nested
	        // in parentheses, and construct the two subtrees.
	        int nesting = 0;
	        int opPos = 0;
	        for (int k=1; k<expr.length()-1; k++) {
	        	if (expr.charAt(k) == '(') nesting++; else if (expr.charAt(k) == ')') nesting--; else if (nesting == 0 && (expr.charAt(k) == '+' || expr.charAt(k) == '*')) opPos = k; // you supply the missing code
	        }
	        String opnd1 = expr.substring (1, opPos);
	        String opnd2 = expr.substring (opPos+1, expr.length()-1);
	        String op = expr.substring (opPos, opPos+1);
	        System.out.println ("expression = " + expr);
	        System.out.println ("operand 1  = " + opnd1);
	        System.out.println ("operator   = " + op);
	        System.out.println ("operand 2  = " + opnd2);
	        System.out.println ( );
	        return new TreeNode(op, exprTreeHelper(opnd1), exprTreeHelper(opnd2)); // you fill this in
	    }
	}
	 public void optimize ( ) {
		 optimizeHelper(this.myRoot);
	 }
	 
	 private void optimizeHelper(TreeNode root) {
		 if (root.myLeft != null) {
			 optimizeHelper(root.myLeft);
		 }
		 if (root.myRight != null) {
			 optimizeHelper(root.myRight);
		 }
		 if (root.myItem instanceof String) {
			 if (root.myLeft.myItem instanceof Integer && root.myRight.myItem instanceof Integer) {
				 String op = (String) root.myItem;
				 Integer left = (Integer) root.myLeft.myItem;
				 Integer right = (Integer) root.myRight.myItem;
	
				 if (op.charAt(0) == '+') {
					 root.myItem = new Integer(left + right);
				 } else {
					 root.myItem = new Integer(left * right);
				 }
				 root.myLeft = null;
				 root.myRight = null;
				 return;
			 }
		 }

	 }
}