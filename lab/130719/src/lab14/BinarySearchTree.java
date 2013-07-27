package lab14;

public class BinarySearchTree extends BinaryTree {
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(TreeNode t) {
		super(t);
	}
	
	public boolean contains(Comparable obj) {
		if (myRoot == null) {
			return false;
		}

		if (obj.compareTo((String) myRoot.myItem) == 0) {
			return true;
		}

		if(myRoot.myLeft != null || myRoot.myRight != null) {
			if (obj.compareTo((String) myRoot.myLeft.myItem) < 0) {
				BinarySearchTree t = new BinarySearchTree(myRoot.myRight);
				t.contains(obj);
		System.out.println("gets here");
			} else {
				BinarySearchTree t = new BinarySearchTree(myRoot.myLeft);
				t.contains(obj);
		System.out.println("gets here");
			}
		}
		return false;
	}
	
	public void add(Comparable<Object> obj) {
	}
	
	public static void main(String args[]) {
		BinarySearchTree t = new BinarySearchTree();
		t.fillSampleTree1();
		t.print();
		System.out.print(t.contains("b"));
	}

}
