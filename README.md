Data Structures and Programming Methodology
======
Objectives of this Project:
* Notes for cs61bl class
* To practise version control workflow
* Practise documentation with Github markdown.

# Collections
## Array/Array Lists
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

## Stacks (ADT/Restriced DS)
* Inorder Iteration (Depth-first)
    * init: Find leftmost descendant of root, then push everything on the way.
    * Why? No matter how big the tree, the leftmost is the smallest, guaranteed?
    * next: Pop node off stack; if right child is null, return node,
    else, find left most descendant of right child,
    push everything on the way.
* Win conditions at the bottom, so use Depth-first search to
find them fastest.

## Queues (ADT/Restricted DS)
* Breadth-first search
    * next: Push left child, then Push right child
    * return Pop
    * instantiate: Push root

## Sets (ADT)

## Trees (ADT)
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
* Null checks
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
### Binary Search Trees (DS)

## Hash Maps

## Heaps

## Priority Queues

# Asymptotic Analysis

