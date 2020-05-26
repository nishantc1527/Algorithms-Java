class binary_search_tree:
    class node:
        def __init__(self, val, left, right, parent):
           self.val = val
           self.left = left
           self.right = right
           self.parent = parent

    def __init__(self):
        self.root = None

    def insert(self, val):
        if self.root == None:
            self.root = self.node(val, None, None, None)
        else:
            dummy = self.root

            while dummy:
                if val < dummy.val:
                    if not dummy.left:
                        dummy.left = self.node(val, None, None, dummy)
                        dummy = dummy.left
                        break
                    else:
                        dummy = dummy.left
                else:
                    if not dummy.right:
                        dummy.right = self.node(val, None, None, dummy)
                        dummy = dummy.right
                        break
                    else:
                        dummy = dummy.right

    def contains(self, val):
        if not self.root == None:
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
    tree = binary_search_tree()

    tree.insert(5)
    tree.insert(10)
    tree.insert(2)

    print(tree.contains(10))
    print(tree.contains(4))
