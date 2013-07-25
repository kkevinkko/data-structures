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
			if (obj.compareTo(myRoot.myLeft.myItem) < 0) {
				BinarySearchTree t = new BinarySearchTree(myRoot.myLeft);
				t.contains(obj);
			} else {
				BinarySearchTree t = new BinarySearchTree(myRoot.myRight);
				t.contains(obj);
			}
		}
		return false;
	}
	
	public void add(Comparable<Object> obj) {
	}

}
