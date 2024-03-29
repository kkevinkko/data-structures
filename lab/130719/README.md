More on Trees (July 19)
===

##Stacks and Queues
A stack data structure models a stack of papers, or plates in a restaurant, or boxes in a garage or closet. A new item is placed on the top of the stack, and only the top item on the stack can be accessed at any particular time. Stack operations include the following:
+ **pushing** an item onto the stack;
+ accessing the **top item** on the stack;
+ **popping** the top item off the stack;
+ checking if the stack **is empty**.

##Q: How do you iterate a tree?
+ Implement java.util.Enumeration interface
    * **boolean** hasMoreElements()
    * **Object** nextElement()
+ As with ArrayList Iterator, store the next element to return
    * However, it is insufficient to simply store the next pointer
    * Store all possible nodes in the **fringe**

```java
public class DepthFirstIterator implements Enumeration {

    private Stack fringe = new Stack ( );

    public DepthFirstIterator ( ) {
        if (myRoot != null) {
            fringe.push (myRoot);
        }
    }

    public boolean hasMoreElements ( ) {
        return !fringe.empty ( );
    }

    public Object nextElement ( ) {
        if (!hasMoreElements ( )) {
            throw new NoSuchElementException ("tree ran out of elements");
        }
        TreeNode node = (TreeNode) fringe.pop ( );
        if (node.myRight != null) {
            fringe.push (node.myRight);
        }
        if (node.myLeft != null) {
            fringe.push (node.myLeft);
        }
        return node;
    }
}
```
