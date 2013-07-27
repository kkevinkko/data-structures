lab14
===

* Introduction to Trees

##Terminology
* **Edge** - the link that connects 2 nodes *directly*
* **Path** - a combination of **Edges** that connects 2 nodes.
    * Note that there are usually multiple **Paths** between 2
    nodes. **Path** doesn't refer to the shortest **path**
* **Height** (of a node) - the length of the longest downward path from
that **node** to a **leaf**.
    * Height of a Tree is the Height from the root
* **Depth** (of a node) - the length of the longest downward path from
**root** to that **node**.
* **Children** (of a node) - is the direct children. Don't count nodes
deeper than an edgeworth. EDGEWORTH lol.

# Trees
* **Tree** is an ADT, while **Linked Tree** is a Data Structure, as how
**List** is an ADT, while **Linked List** is a Data Structure
* Like a Linked List, except can have multiple "rests"

## Tree Traversal
* Trees have many traversal ways unlike lists, because you can only
move through a list one way forward, or backwards. On trees, we can
move breadth first or depth first. Furthermore, moving depth first
could be done pre-order, in-order or post-order.

## Methods to practise writing
* ```busiestNode```
* ```height```
* ```isBalanced```

# A Subclass of Trees: Binary Trees
* Just one further restriction: Each node can have at most 2 children.
