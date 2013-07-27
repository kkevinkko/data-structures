lab11
===

So far, we have learnt Java bits, OOP concepts, and programming
methodologies, but we haven't got into the meat of data structures
yet. We have only dealt with Array data structure. And talked about
Collection ADT.

* This lab introduces **Linked Lists** Data Structure
* Also, Algorithm analysis. But 61a covers more.

# Linked Lists

* Linked lists are data structures.
* It's not just ADT's that can have various implementations, Data
Structures too can have many ways of being implemented.
* Reminds me of **Recursive Lists** of 61a

* It is basically a chain of Nodes that each store one value,
and **one** other value that points to another Node.
* This is unlike *Trees* where there can be links to multiple nodes
from a given node.

## Ingredients of a Linked List
1. Nodes (ListNode)
    * That has attributes:
        * (Object) myFirst
        * (ListNode) myRest

The rest depends on the variant of Linked Lists:
* **Empty List Node** at the end of the chain
* **Sentinel Nodes** at the beginning of the chain
* References to previous nodes in **Doubly-Linked Lists**
* Reference to start of node at the end node for **Circular lists**

## Methods to practise writing
* ```size```
* ```get```
* ```toString```
* ```equals```

## Pros
By breaking up the list into nodes, we can do operations between
each node.
* Expandable - the Linked List is expandable since we don't
require the items to be continuously blocked together. We already
store references to the nodes, so we can just jump to places around
the memory.
* Insert elements **anywhere** easily.
    * Previously, when we tried to insert items in Arrays, we
    need to reshift all items in the array up.
    * But linked lists are broken into nodes, we can just get in
    between the nodes, and change the referencing nodes.
* Inserting elements at beginning of list is O(1)


## Cons
* Sequential Access - Gotta traverse node by node to get
to an element. Unless... you store an index to each node, and
store a table to look up in the sentinel?
    * Implications: No sequential access means that stuff like
    getting a certain node, or inserting at given position,
    is gonna take, in the worst case, as long as the number
    of elements in the linked list.
* Searching is rather slow due to sequential access.
* Insertion although easy to implement, is slow, if position
to add is deep into the list.

# Timing Code Segments
* Used to time an algorithm

# Counting statements
