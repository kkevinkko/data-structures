Linked Lists
===

### Implementation in Python

```python

class LinkedList(Object):
    
    class ListNode(Object):
        def __init__(self, list, item, next):
            self.list = list
            self.item = item
            self.next = next

        def get_item(self):
            return self.item

        def get_next(self):
            return self.next

```
