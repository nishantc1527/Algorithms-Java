class trie:
    class node:
        def __init__(self):
            self.count = 0
            self.children = [None] * 26 

    def __init__(self):
        self.root = self.node()
        
    def insert(self, string):
        curr = self.root

        for i in range(len(string)):
            index = ord(string[i]) - ord('a')

            if curr.children[index] == None:
                curr.children[index] = self.node()

            curr = curr.children[index]

        curr.count = curr.count + 1

    def contains(self, string):
        curr = self.root

        for i in range(len(string)):
            index = ord(string[i]) - ord('a')

            if curr.children[index] == None:
               return False 

            curr = curr.children[index]

        return curr.count > 0

if __name__ == "__main__":
    t = trie()

    t.insert("apple")
    t.insert("app")

    print(t.contains("app"))
    print(t.contains("ap"))

