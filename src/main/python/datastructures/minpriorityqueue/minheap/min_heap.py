class MinHeap:
    class MinHeapIter:
        def __init__(self, heap_list):
            self.heap = MinHeap(heap_list)

        def __next__(self):
            if self.heap:
                return self.heap.extract_min()

            raise StopIteration

    def __init__(self, default=None):
        if default is None:
            default = []
        self.heap = default

    def add(self, value):
        self.heap.append(value)
        self.__bubble_up(len(self.heap) - 1)

    def add_all(self, values):
        for value in values:
            self.add(value)

    def contains(self, item):
        return item in self.heap

    def extract_min(self):
        to_return = self.heap[0]
        self.heap[0], self.heap[len(self.heap) - 1] = self.heap[len(self.heap) - 1], self.heap[0]
        del self.heap[len(self.heap) - 1]
        self.__bubble_down(0)
        return to_return

    def delete(self, value):
        self.delete_index(self.heap.index(value))

    def delete_index(self, index):
        self.heap[index], self.heap[len(self.heap) - 1] = self.heap[len(self.heap) - 1], self.heap[index]
        del self.heap[len(self.heap) - 1]
        self.__bubble_down(index)

    def is_empty(self):
        return len(self.heap) == 0

    def __bubble_up(self, index):
        if index > 0:
            p = self.__parent(index)

            if self.heap[p] > self.heap[index]:
                self.heap[p], self.heap[index] = self.heap[index], self.heap[p]
                self.__bubble_up(p)

    def __bubble_down(self, index):
        if index >= len(self.heap):
            return

        l, r, minimum = self.__left(index), self.__right(index), index

        if l < len(self.heap) and self.heap[l] < self.heap[minimum]:
            minimum = l

        if r < len(self.heap) and self.heap[r] < self.heap[minimum]:
            minimum = r

        self.heap[index], self.heap[minimum] = self.heap[minimum], self.heap[index]

        if minimum is not index:
            self.__bubble_down(minimum)

    @staticmethod
    def __right(index):
        return (index * 2) + 2

    @staticmethod
    def __left(index):
        return (index * 2) + 1

    @staticmethod
    def __parent(index):
        return (index // 2) - 1 if (index & 1) == 0 else index // 2

    def __iter__(self):
        return self.MinHeapIter(self.heap.copy())

    def __contains__(self, item):
        return self.contains(item)

    def __bool__(self):
        return not self.is_empty()

    def __iadd__(self, value):
        self.add(val)

    def __isub__(self, value):
        self.delete(value)

    def __lt__(self, other):
        return self.heap < other.heap

    def __le__(self, other):
        return self.heap <= other.heap

    def __eq__(self, other):
        return self.heap == other.heap

    def __gt__(self, other):
        return self.heap > other.heap

    def __ge__(self, other):
        return self.heap >= other.heap


if __name__ == "__main__":
    heap = MinHeap()
    heap.add(5)
    heap.add(1)
    heap.add(7)
    print(5 in heap)
    print(6 in heap)
    print(7 in heap)

    for val in heap:
        print(val)

    while heap:
        print(heap.extract_min())
