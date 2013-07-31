class BinaryTree(object):
    def __init__(self, rootObj):
        self.item = rootObj
        self.leftChild = None
        self.rightChild = None

    def preorderTraverse(subtree):
        if subtree is not None:
            print(subtree.item)
            preorderTraverse(subtree.leftChild)
            preorderTraverse(subtree.rightChild)

    def inorderTraverse(subtree):
        if subtree is not None:
            inorderTraverse(subtree.leftChild)
            print(subtree.item)
            inorderTraverse(subtree.rightChild)

    def postorderTraverse(subtree):
        if subtree is not None:
            postorderTraverse(subtree.leftChild)
            postorderTraverse(subtree.rightChild)
            print(subtree.item)

    def breadthFirstTraverse(bintree):
        import Queue
        q = Queue()
        q.enqueue(bintree)

        while not q.isEmpty():
            node = q.dequeue()
            print(bintree.item)

        if bintree.left is not None:
            q.enqueue(bintree.left)
        if bintree.right is not None:
            q.enqueue(bintree.right)
