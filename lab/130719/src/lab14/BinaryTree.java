package lab14;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	private TreeNode myRoot;
	
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

	private static void printPreorder (TreeNode t) {
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

	private static void printInorder (TreeNode t) {
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
		print (t.fibTree(5), "fibtree");
		t.fibTree(5).print();
	}

	private static void print (BinaryTree t, String description) {
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
	
	private static final String indent1 = "    ";
	
	private static void printHelper(TreeNode root, int indent) {
		if (root != null) printHelper(root.myRight, indent + 1); else return;
		println(root.myItem, indent);
		if (root != null) printHelper(root.myLeft, indent + 1);
	}
	
	private static void println(Object obj, int indent) {
		for (int k = 0; k < indent; k++) {
			System.out.print(indent1);
		}
		System.out.println(obj);
	}
	
	
	
	private ArrayList alreadySeen;
	
	public boolean check() {
		alreadySeen = new ArrayList();
		try {
			isOK(myRoot);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
	private void isOK(TreeNode t) throws IllegalStateException {
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
	

	private static class TreeNode {
		
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
		
		private Queue fringe = new LinkedList();
		
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
}