From Wiki:
An array stores a number of elements in a specific order. They are accessed using an integer to specify which element is required (although the elements may be of almost any type). Typical implementations allocate contiguous memory words for the elements of arrays (but this is not always a necessity). Arrays may be fixed-length or expandable.


Essence of the Array:

* Ordered Elements
* Computable Index

Everything else is a consequence of the essence:

* O(n) insertion due to having to keep the order
* O(1) access due to computable index
