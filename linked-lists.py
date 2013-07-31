class Node(object):
    def __init__(self, car = None, cdr = None):
        self.car = car
        self.next = cdr

class MinimalistLinkedList(object):
    def __init__(self, head = None):
        self.head = head

    # O(1) since the problem doesn't grow with items
    def prepend(self, item):
        self.head = Node(item, self.head)

    # O(n) since must traverse all n items.
    def traverse(self):
        current = self.head
        while current is not None:
            current = current.next

    # O(n) in worst case, if target is at the end
    def search(self, target):
        current = self.head
        while current is not None and current.car is not target:
            current = current.next
        return current is not None

    # O(n) in worst case, if target is at the end
    def remove(self, target):
        current = self.head
        previous = None
        while current is not None and current.car is not target:
            previous = current
            current = current.next

        if current is not None:
            if current is self.head:
                self.head = current.next
            else:
                previous.next = current.next

l = MinimalistLinkedList()
n1 = Node(1, Node(2, Node(3)))
l = n1
