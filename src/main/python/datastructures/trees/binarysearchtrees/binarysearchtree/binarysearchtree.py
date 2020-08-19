class BinarySearchTree:
    class Node:
        def __init__(self, val, left, right, parent):
            self.val = val
            self.left = left
            self.right = right
            self.parent = parent

    def __init__(self):
        self.root = None

    def insert(self, val):
        if self.root is None:
            self.root = self.Node(val, None, None, None)
        else:
            dummy = self.root

            while dummy:
                if val < dummy.val:
                    if not dummy.left:
                        dummy.left = self.Node(val, None, None, dummy)
                        dummy = dummy.left
                        break
                    else:
                        dummy = dummy.left
                else:
                    if not dummy.right:
                        dummy.right = self.Node(val, None, None, dummy)
                        dummy = dummy.right
                        break
                    else:
                        dummy = dummy.right

        return self

    def __contains__(self, val):
        if self.root:
            dummy = self.root

            while dummy:
                if val < dummy.val:
                    dummy = dummy.left
                elif val > dummy.val:
                    dummy = dummy.right
                else:
                    return True

        return False


if __name__ == "__main__":
    tree = BinarySearchTree()

    tree.insert(5)
    tree.insert(10)
    tree.insert(2)

    print(10 in tree)
    print(14 in tree)
