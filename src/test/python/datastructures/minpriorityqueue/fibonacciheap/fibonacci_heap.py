class FibonacciHeap:
    class Node:
        def __init__(self, val):
            self.val = val
            self.left = None
            self.right = None

        def insert(self, new_node):
            if self.left is self:
                self.left = new_node
                self.right = new_node

                self.left.right = self
                self.left.left = self
            else:
                temp = self.left
                left = new_node
                left.right = self
                left.left = temp
                new_node.right = left

    def __init__(self):
        self.min = None

    def insert(self, val):
        new_node = self.Node(val)
        if not self.min:
            self.min = new_node
            self.min.left = self.min
            self.min.right = self.min
        else:
            self.min.insert(new_node)

            if val < self.min.val:
                self.min = new_node


if __name__ == "__main__":
    heap = FibonacciHeap()
    heap.insert(5)
    heap.insert(4)
    heap.insert(6)
    heap.insert(1)
    print("ended")
