# Java Users

This repository supports Gradle. While you don't need it, it will make everything much easier.

# Using Gradle

If you have gradle, to run everything it simply uses this command:

    ./gradlew build
    
This checks for lots of things, like running the tests, check for compile errors, check for correct google java style guide, etc. If you only
want to run a single file, then go to the build.gradle file and change this line at the bottom.

    mainClassName = 'sorting.bubblesort.BubbleSort'

Replace ```sorting.bubblesort.BubbleSort``` with the file you want to run. Make sure you exclude the ```src.main.java``` part. If you want to
run the tests, simply run this command:

    ./gradlew test
    
# Using Only Java JDK (Not Recommended)

Compile a file like this:

    javac <path-to-file>
    
Then run it like this:

    java <class-name>
    
Java implementations:

# [Bit Manipulation]

* [Basic Operators]

## [Problems]

* [Missing Number]
* [Power Of Two]
* [Single Number]

# [Data Structures]

## [Min Priority Queues]

* [Fibonacci Heap]
* [Min Heap]

## [Trees]

### [Binary Search Trees]

* [Avl Tree]
* [Binary Search Tree]
* [Red Black Tree]

### [Trie]

* [Trie]

# [Dynamic Programming]

## [Problems]

* [House Robber]
* [Unique Paths]

# [Graph Theory]

## [Traversals]

* [Breadth First Search]
* [Depth First Search]

# [Math]

* [Matrices]
* [Vectors]

# [Neural Networks]

* [Multilayered Neural Network]
* [One Hidden Layer Neural Network]

# [Sorting]

* [Bogo Sort]
* [Bubble Sort]
* [Counting Sort]
* [Heap Sort]
* [Insertion Sort]
* [Merge Sort]
* [Quick Sort]
* [Selection Sort]