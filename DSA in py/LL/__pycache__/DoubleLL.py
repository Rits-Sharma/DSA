class Node:
    def __init__(self, data: int):
        self.data = data
        self.prev = None
        self.next = None

class DoubleLL:
    def __init__(self):
        self.head = None

    def displayF(self):
        current = self.head
        while current:
            print(current.data, end='->')
            current = current.next
        print("None")

    # def displayB(self):

    def insertHead(self, data: int):
        newNode = Node(data)
        newNode.next = self.head
        self.head = newNode

    def deleteNode(self, node):
        curr = self.head
        prev = None
        
        while curr.data != node:
            prev = curr
            curr = curr.next


        # print(curr.data, node)
        if prev == None:
            temp = self.head
            self.head = self.head.next
            del temp
        else:
            prev.next = curr.next
        curr.next.prev = prev

l2 = DoubleLL()

l2.head = Node(10)
second = Node(20)
third = Node(30)

l2.head.next = second
second.next = third

l2.insertHead(40)
l2.deleteNode(40)

l2.displayF()
