from Node import Node

class LinkedList:
    def _init__(self):
        self.head = None
    
    def display(self):
        current = self.head

        while current:
            print(current.data, end='->')
            current = current.next
        print("None")

    def insert_head(self, data: int):
        newnode = Node(data)
        newnode.next = self.head
        self.head = newnode

    def deletion_head(self):
        temp = self.head
        self.head = self.head.next
        del temp

    def deleteNode(self, node):
        curr = self.head
        prev = None

        while curr.data != node:
            prev = curr
            curr = curr.next

        prev.next = curr.next
        del curr

    def countNode(self):
        current = self.head
        count = 0
        while current:
            count += 1
            current = current.next
        return count

l1 = LinkedList()

l1.head = Node(10)
second = Node(20)
third = Node(30)

l1.head.next = second
second.next = third
l1.insert_head(40)
# l1.deletion_head()
# l1.deleteNode(20)
print(l1.countNode())


l1.display()