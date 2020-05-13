# [Algorithms](https://github.com/nishantc1527/Algorithms/tree/master/src)

This project is a hope to share the whole knowledge of algorithms there is to offer. Obviously, one guy can't do that, which is why it's open source!

# Side Note

Many of these algorithm problems come from a interview preparing website called [LeetCode](https://leetcode.com/problemset/all/). If you want, you can also check out [my LeetCode solutions](https://github.com/nishantc1527/LeetCode).

# Compiling Algorithms

 ## Go To The Folder Where You Want To Place The Repository
 
This part is optional. Use ```cd```. For example:

    $ cd d:/github/myrepos

 ## Cloning The Repository

    $ git clone https://github.com/nishantc1527/Algorithms.git
    $ cd Algorithms
    
The second command just goes to the repository folder.
    
 ## Compiling A File
    
First use ```cd <the path the folder which contains the file>```. For example: 

    $ cd src/Main/java/com/nishant/algorithms/Sorting/QuickSort/
    
Then compile the file like this:

    $ javac <file name>
    $ java <file name without extension>
    
Example:

    $ javac QuickSort.java
    $ java QuickSort
    
 ## Everything Put Together
 
    $ git clone https://github.com/nishantc1527/Algorithms.git
    $ cd Algorithms
    $ cd src/Main/java/com/nishant/algorithms/Sorting/QuickSort/
    $ javac QuickSort.java
    $ java QuickSort
    
 ## Possible Error
 
    Error: Could not find or load main class MergeSort
    
 A couple of detailed posts about this:
 
 - [Stack Overflow](https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean)
 - [Tutorialspoint](https://www.tutorialspoint.com/how-to-resolve-could-not-find-or-load-main-class-package-in-java)

# Contributing

This repository is welcome to contributing. There are tons of stuff to add, some easy and some hard. If you want something to contribute, look at the issues page.  
To encourage contributing, I developed a fun little game. Every time you contribute, you get points. I'll talk about what score you get and all the details, 
but first, what is the use of the score? The more score you get, you get to put your name higher on the leaderboard in the section below. And what is the point
of the leaderboard? Right under your name, you get to advertise any repository, project, etc... you want. Here is a quick privilege list (I will update it now
and then when I feel something can be made better).

5 points: Share a project.
20 points: Add a description.
Every 20 points, add another project with a description.
(the rest is for you to add in [this issue](https://github.com/nishantc1527/Algorithms/issues/3))

Okay, now, how many points do you get for contributing? When you pick something from [the issues](https://github.com/nishantc1527/Algorithms/issues), the issue
will specify the number of points you get. Sometimes, it will be a concrete number, but sometimes, it will be a range (for example, 5 - 10) and you get rewarded
depending on the quality of your pull request. Even in the issues with concrete numbers, if you go above and beyond and do a really good job I might reward more.
If you leave out some stuff or leave bugs, I will ask if you want to except fewer points or fix it. If you decide to just except fewer points, then I will open
another issue for that.

But what if you found something that wasn't in the issues? Then, submit the pull request anyways, and I will determine the points myself.

Now that I have the game cleared up, I would recommend some easy issues. [Improving explanations](https://github.com/nishantc1527/Algorithms/issues/4) would probably
be the best place to start, then adding privileges. However, you can always look into the [issues](https://github.com/nishantc1527/Algorithms/issues) page for more
stuff.

# Leaderboard

No one here yet. Be the first to put your name!

# [Implementations](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms)

 ## [Sorting](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting)
 
  - [Bubble Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/BubbleSort)
  - [Selection Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/SelectionSort)
  - [Insertion Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/InsertionSort)
  - [Merge Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/MergeSort)
  - [Quick Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/QuickSort)
  - [Counting Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/CountingSort)
  - [Heap Sort](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Sorting/HeapSort)
  
 ## [Bit Manipulation](https://github.com/nishantc1527/Algorithms/tree/master/Algorithms/BitManipulation)
 
  - [Missing Number](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/BitManipulation/MissingNumber)
  - [Power Of Two](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/BitManipulation/PowerOfTwo)
  - [Single Number](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/BitManipulation/SingleNumber)
  
 ## [Graph Theory](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory)
 
  ### [Elementary Graph Algorithms](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ElementaryGraphAlgorithms)
  
  - [Breadth First Search](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ElementaryGraphAlgorithms/BreadthFirstSearch)
  - [Depth First Search](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ElementaryGraphAlgorithms/DepthFirstSearch)
 
  ### [Implementations](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/Implementations)
  
  - [Adjacency List](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/Implementations/AdjacencyList)
  - [Adjacency Matrix](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/Implementations/AdjacencyMatrix)
  
  ### [Shortest Path Algorithms](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ShortestPathAlgorithms)
  
   #### [Single Source Shortest Path](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ShortestPathAlgorithms/SingleSourceShortestPath)
   
   - [Dijkstra's Shortest Path](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ShortestPathAlgorithms/SingleSourceShortestPath/DijkstraShortestPath)
   - [Bellman Ford's Shortest Path Algorithm](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/GraphTheory/ShortestPathAlgorithms/SingleSourceShortestPath/BellmanFordShortestPath)
 
 ## [Data Structures](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures)
 
  ### [Trees](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees)
  
   #### [Binary Search Trees](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees)
   
   - [AVL Tree](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/AVLTree)
   - [Binary Search Tree](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/BinarySearchTree)
   - [Red Black Tree](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/RedBlackTree)
  
   #### [Trie](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/Trees/Trie)
  
  ### [Min Priority Queue](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/MinPriotiryQueue)
  
   - [Fibonacci Heap](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/MinPriotiryQueue/FibonacciHeap)
   - [Min Heap](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DataStructures/MinPriotiryQueue/MinHeap)
 
 ## [Dynamic Programming](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DynamicProgramming)
 
  - [House Robber](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DynamicProgramming/HouseRobber)
  - [Unique Paths](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/DynamicProgramming/UniquePaths)

 ## [Math](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Math)
 
  - [Matrix](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Math)
  - [Vector](https://github.com/nishantc1527/Algorithms/tree/master/src/Main/java/com/nishant/algorithms/Math/Vectors)

# [Testing](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms)

 ## [Sorting](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/Sorting)
 
  - [Bubble Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/BubbleSortTest.java)
  - [Selection Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/SelectionSortTest.java)
  - [Insertion Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/InsertionSortTest.java)
  - [Merge Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/MergeSortTest.java)
  - [Quick Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/QuickSortTest.java)
  - [Counting Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/CountingSortTest.java)
  - [Heap Sort](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/Sorting/HeapSortTest.java)

 ## [Bit Manipulation](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/BitManipulation)
 
  - [Missing Number](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/BitManipulation/MissingNumberTest.java)
  - [Power Of Two](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/BitManipulation/PowerOfTwoTest.java)
  - [Single Number](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/BitManipulation/SingleNumberTest.java)

 ## [Data Structures](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/DataStructures)
 
  ### [Trees](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees)
  
   #### [Binary Search Trees](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees)
  
   - [Binary Search Tree](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/BinarySearchTreeTest.java)
   - [Red Black Tree](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/RedBlackTreeTest.java)
   - [AVL Tree](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees/BinarySearchTrees/AVLTreeTest.java)
   
   #### [Trie](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/Trees/Trie/TrieTest.java)
   
  ### [Min Priority Queue](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/DataStructures/MinPriorityQueue)
  
   - [Fibonacci Heap](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/MinPriorityQueue/FibonacciHeapTest.java)
   - [Min Heap](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DataStructures/MinPriorityQueue/MinHeapTest.java)

 ## [Dynamic Programming](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/DynamicProgramming)
 
  - [House Robber](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DynamicProgramming/HouseRobberTest.java)
  - [Unique Paths](https://github.com/nishantc1527/Algorithms/blob/master/src/Test/java/com/nishant/algorithms/DynamicProgramming/UniquePathsTest.java)

 ## [Math](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/Math)
 
  - [Matrix](https://github.com/nishantc1527/Algorithms/tree/master/src/Test/java/com/nishant/algorithms/Math/Matrices)

# License
Licensed under [MIT License](https://opensource.org/licenses/MIT). That means feel free to add whatever you want if you find it necessary.