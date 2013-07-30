class Node(object):
    def __init__(self, car = None, cdr = None):
        self.car = car
        self.cdr = cdr

class MinimalistLinkedList(object):
    def __init__(self, head = None):
        self.head = head

l = MinimalistLinkedList()
n1 = Node(1, Node(2, Node(3)))
l = n1
