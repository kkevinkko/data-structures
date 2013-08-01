Data Structures and Programming Methodology
======
Objectives of this Project:
* Notes on Data Structures and Programming Methodology
* To practise version control workflow
* Practise documentation with Github markdown.

Resources:
* http://algs4.cs.princeton.edu/home/
* http://www.cs.usfca.edu/~galles/visualization/Algorithms.html
* http://interactivepython.org/courselib/static/pythonds/index.html
* http://www.cs.cmu.edu/~adamchik/15-121/lectures/

Why are data structures important?
* The way your code will look like, most likely depends on
the data structure you choose to work with.
* The ease that you have coding will also depend on the
data structure chosen.
* Imagine the UNIX directories used a Linked List structure
to keep your directories. How long would that take to retrieve
items??

# ADT's and Data Structures
Every ADT can be implemented in either one of 2 ways:
    * As an **array**
    * As a **linked data structure**

# Collections
# Lists
* Ordered
* In python, we **construct** lists with square brackets.

```python
l = [1, 2, 3, 4]
```
* we **select** elements with indices.

```python
l[0]
```
* In python, lists implement the len interface, which tells us the
length of the list, ```len(l)```

## Array/Array Lists(Dynamic Arrays)
* Linear
* Basic Operations:
    * add
    * remove
    * insert
    * get
    * contains
    * equals
    * toString
* General Style:
    * Iterative vs. Recursive?
* Know the runtimes proportional to ..... And know WHY
* Do not confuse Sentinel class with Node class.
* Advanced Operations:
    * double
    * filter
    * reverse
    * ctrl-f replace
    * Helps you get comfortable
* Destructively or Non-Destructively
* Null checks
## Linked Lists (DS)
Similar to:
    * Recursive Lists (Scheme)

* Singly-linked Lists

```java

// to run to the end of the list.
for (p = myHead; p != null, p.myRest != null, p.myRest.myRest != null; p = p.myFirst)

```

When you remove things, remember to decrement the counter because
when you remove, the items will all move down, by one. Then the
for loop will do a ++, so you'd want to decrement to move back.

## Stacks (ADT/Restriced DS)
* Notice that it can essentially be just a list, with limited access.
    * Only get and put at one end of the list.
* Inorder Iteration (Depth-first)
    * init: Find leftmost descendant of root, then push everything on the way.
    * Why? No matter how big the tree, the leftmost is the smallest, guaranteed?
    * next: Pop node off stack; if right child is null, return node,
    else, find left most descendant of right child,
    push everything on the way.
* Win conditions at the bottom, so use Depth-first search to
find them fastest.

```java

public class KnowledgableStack extends Stack {

    private Object second;

    public KnowledgableStack {
        super();
        second = null;
    }

    public void push(Object obj) {
        second = this.peek();
        super.push(obj);
    }

    public void pop(Object obj) {
        super.pop();
        Object old = super.pop();
        second = this.push();
        super.push(old);
    }

    public E peekUnder() {
        return second;
    }
}

```

## Queues (ADT/Restricted DS)
* Just like a list, except restricted insertion at one end of list,
and removal from the other, strictly.
* Breadth-first search
    * next: Push left child, then Push right child
    * return Pop
    * instantiate: Push root

## Sets (ADT)

## Trees (ADT)
* Best Example: UNIX Directories
    * Each dir folder has pointers to other dir folders.
    * The root of the tree is called ```root```
* Recursive
* General Style:
    * Multi-dimensional structure => 99.99% of time gonna be Recursive.
    * Look at Fibonacci lab exercise again for Mutual Recursion
* Know the runtimes and why
    * log n where n is the height of the tree
* Basic Operations:
    * remove for trees is tricky.
    * Inorder-successor - Right child's Leftmost Descendent, but
    if Right child is null, take Parent
* Null checks and Return checks.
* Advanced Operations:
### Binary Trees (DS)

```java

public Object processBinaryTree() {
    return processHelper();
}

private static Object processHelper(TreeNode node) {
    if (node == null) {
        // Base case is a null check
        // doNullThing
    } else {
        // recurse left
        currentKnowledge = doSomethingWithCurrentNode;
        newKnowledge = BinaryTree.processHelper(node.myLeft);
        // recurse right
        moreNewKnowledge = BinaryTree.processHelper(node.myRight);
        updatedKnowledge = doSomethingWithCurrentKnowledgeNewKnowledgeMoreNewKnowledge();
        
        return updatedKnowledge;
    }
}

```

```java

AmoebaIterator iter = new AmoebaIterator();
while (iter.next) {
    doSomethingWithNext();
}

```

### Binary Search Trees (DS)

## Hash Maps
TreeMap vs. HashMap/HashSet
HashSet only cares about keys. HashMap cares about both keys and values.

* What does the key class require?
    * for TreeMap.
        * compareTo or some Comparable item
    * for HashMap
        * hashCode
        * equal(Object obj)

* Putting new things into the map, you want to put immutable
things into map as keys.

* Invariant: Every thing in the bucket has the same hashcode?

* What must a good hashCode have?
    * For keys that are equal(), they must have the same value
        * won't get the right object if you don't
    * hashCode values should be spread across all possible values.
    * hashCode should be quick to compute

* Timings
    * get
        * ignore calculating the hashCode (Constant time)
        * finding the right bucket
    * put
    * contains

* Know what happens when there's a collision.
    * Chaining
        * Becomes like a linked list.

* Why are collisions bad?
    * Because you'll get chaining. And that produces a Linked List.
    And a Linked List is slow to traverse.

## Tree Maps
Invariant:


## Heaps

## Priority Queues

# Asymptotic Analysis


### Isaac Question
Write a width() method for BinaryTree that returns
the width of the BinaryTree

The width is defined as the maximal number of nodes on a 
path from one node in the tree to another.

Assume each tree node contains height (instance variable myHeight)
Height of an empty tree is 0.
int Math.max(int a, int b) returns whichever a or b is larger.

Attempt:
```java

public int width() {
    return widthHelper(myRoot, 1, 0);
}

public static int widthHelper(TreeNode n, int bestLengthSoFar, int currentLength) {
    if (n == null) {
        return 0;
    } else {
        currentLength += 1
        if (currentLength >= bestLengthSoFar) {
            bestLengthSoFar = currentLength;
        }
        currentLength =  BinaryTree.width(n.myLeft) + BinaryTree.width(n.myRight);
        return Math.max(bestLengthSoFar, currentLength);
    }
}

```

Solution:
```java

public int width() {
    return helper(myRoot);
}

public static int helper(TreeNode node) 
    if (node == null) {
        return 0;
    } else if (node.myLeft == null) {
        return Math.max(node.myHeight, BinaryTree.helper(node.myRight));
    } else if (node.myRight == null) {
        return Math.max(node.myHeight, BinaryTree.helper(node.myLeft));
    } else {
        return Math.max(1 + node.myLeft.myHeight + node.myRight.myHeight,
                Math.max(BinaryTree.helper(node.myLeft), BinaryTree.helper(node.myRight)))
        // This is tree recursion, you check on the current node,
        // then do the same calculations on children.
    }
}

```
