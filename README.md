# Algorithms

A collection of common algorithms and data structures with source code in Java, C++, and Python.

If you want to view the Java source code, go to java.md. If you want to view the Python source code, go to python.md, and same for C++ except go to cpp.md.

# Gradle

This repository uses Gradle. While you don't need it, it will make everything much easier. You don't need to install Gradle as I added the wrapper. Testing is all done with JUnit 5.

# Dependencies Used

* JUnit 5
* Apache Commons Lang
* JBlas

# Using Gradle

To check if everything is correct, run this command:

```bash
./gradlew check
```

This checks for lots of things, like running the tests, check for compile errors, check for correct google java style guide, etc. If you want to run a single file, then go to the build.gradle file and add this line at the bottom.

    mainClassName = 'sorting.bubblesort.BubbleSort'

and run 

```bash
./gradlew run
```

Replace ```sorting.bubblesort.BubbleSort``` with the file you want to run. Make sure you exclude the ```src.main.java``` part.
    
# [Source Code](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java)

## [Bit Manipulation](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/bitmanipulation)

* [Basic Operators](https://github.com/nishantc1527/Algorithms-Java/blob/master/src/main/java/bitmanipulation/BasicOperators.java)

### [Problems](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/bitmanipulation/problems)

* [Missing Number](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/bitmanipulation/problems/missingnumber)
* [Power Of Two](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/bitmanipulation/problems/poweroftwo)
* [Single Number](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/bitmanipulation/problems/singlenumber)

## [Data Structures](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures)

### [Min Priority Queues](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/minpriorityqueue)

* [Fibonacci Heap](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/minpriorityqueue/FibonacciHeap)
* [Min Heap](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/minpriorityqueue/MinHeap)

### [Trees](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees)

#### [Binary Search Trees](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/binarysearchtrees)

* [Avl Tree](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/binarysearchtrees/avltree)
* [Binary Search Tree](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/binarysearchtrees/binarysearchtree)
* [Red Black Tree](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/binarysearchtrees/redblacktree)

#### [Trie](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/trie)

* [Trie](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/datastructures/trees/trie)

## [Dynamic Programming](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/dynmanicprogramming)

### [Problems](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/dynmanicprogramming/problems)

* [House Robber](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/dynmanicprogramming/problems/houserobber)
* [Unique Paths](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/dynmanicprogramming/problems/uniquepaths)

## [Graph Theory](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/graphtheory)

### [Traversals](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/graphtheory/traversals)

* [Breadth First Search](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/graphtheory/traversals/breadthfirstsearch)
* [Depth First Search](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/graphtheory/traversals/depthfirstsearch)

## [Math](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/math)

* [Matrices](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/math/matrices)
* [Vectors](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/math/vectors)

## [Neural Networks](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/neuralnetworks)

* [Multilayered Neural Network](https://github.com/nishantc1527/Algorithms-Java/blob/master/src/main/java/neuralnetworks/MultilayeredNeuralNetwork.java)
* [One Hidden Layer Neural Network](https://github.com/nishantc1527/Algorithms-Java/blob/master/src/main/java/neuralnetworks/OneHiddenLayerNeuralNetwork.java)

## [Sorting](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting)

* [Bogo Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/bogosort)
* [Bubble Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/bubblesort)
* [Counting Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/countingsort)
* [Heap Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/heapsort)
* [Insertion Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/insertionsort)
* [Merge Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/mergesort)
* [Quick Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/quicksort)
* [Selection Sort](https://github.com/nishantc1527/Algorithms-Java/tree/master/src/main/java/sorting/selectionsort)

# License

This repository is licensed under the [MIT license](https://mit-license.org/).