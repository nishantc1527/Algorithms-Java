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
        self.make_heap()

    def make_heap(self):
        for i in range((len(self.heap) >> 1) - 1, -1, -1):
            self._bubble_down(i)

    def is_valid(self):
        return self._is_valid(0)

    def _is_valid(self, index):
        left, right = self._left(index), self._right(index)

        if left < len(self.heap):
            if self.heap[left] < self.heap[index] or not self._is_valid(left):
                return False

        if right < len(self.heap):
            if self.heap[right] < self.heap[index] or not self._is_valid(right):
                return False

        return True

    def add(self, value):
        self.heap.append(value)
        self._bubble_up(len(self.heap) - 1)

    def add_all(self, values):
        self.add(value for value in values)

    def contains(self, item):
        return item in self.heap

    def extract_min(self):
        to_return = self.heap[0]
        self.heap[0], self.heap[len(self.heap) - 1] = self.heap[len(self.heap) - 1], self.heap[0]
        del self.heap[len(self.heap) - 1]
        self._bubble_down(0)
        return to_return

    def is_empty(self):
        return len(self.heap) == 0

    def _bubble_up(self, index):
        if index > 0:
            p = self._parent(index)

            if self.heap[p] > self.heap[index]:
                self.heap[p], self.heap[index] = self.heap[index], self.heap[p]
                self._bubble_up(p)

    def _bubble_down(self, index):
        if index >= len(self.heap):
            return

        l, r, minimum = self._left(index), self._right(index), index

        if l < len(self.heap) and self.heap[l] < self.heap[minimum]:
            minimum = l

        if r < len(self.heap) and self.heap[r] < self.heap[minimum]:
            minimum = r

        self.heap[index], self.heap[minimum] = self.heap[minimum], self.heap[index]

        if minimum is not index:
            self._bubble_down(minimum)

    @staticmethod
    def _right(index):
        return (index * 2) + 2

    @staticmethod
    def _left(index):
        return (index * 2) + 1

    @staticmethod
    def _parent(index):
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

    heap = MinHeap([1, 1, 4, 2, 43, 5, 3, 4, 5])
    print(heap.is_valid())
