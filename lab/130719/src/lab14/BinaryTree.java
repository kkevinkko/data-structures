package lab14;
import java.util.ArrayList;

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
	}

	private static void print (BinaryTree t, String description) {
		System.out.println (description + " in preorder");
		t.printPreorder ( );
		System.out.println (description + " in inorder");
		t.printInorder ( );
		System.out.println ( );
	}
	
	private ArrayList alreadySeen;
	
	public boolean isOK() {
		alreadySeen = new ArrayList();
		try {
			check(myRoot);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
	private void check(TreeNode t) throws IllegalStateException {
		
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
}