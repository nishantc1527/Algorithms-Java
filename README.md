# [Algorithms](https://github.com/nishantc1527/Algorithms/tree/master/src)

Algorithms are a way to solve problems. Not only that, it wants to solve problem fast. That's why there's tons and tons of theory on this stuff.

This project is a hope to share the whole knowledge of algorithms there is to offer. If you don't know the algorithm, there are detailed explanations on each algorithm (all in the explanations folder).

Obviously, one guy can't do that, which is why it's open source! I also developed a fun way to contribute. You can look at it in the [contributing page](https://github.com/nishantc1527/Algorithms#contributing).

# Languages

While Java has the most algorithms, you might find an algorithm in Java, Python, or C++.  

# LeetCode

Many of these algorithm problems come from a interview preparing website called [LeetCode](https://leetcode.com/problemset/all/). If you want, you can also check out [my LeetCode solutions](https://github.com/nishantc1527/LeetCode).

# Compiling Algorithms

NOTE: Whenever I use ```<something>``` it means you have to replace that with whatever it says.

 ## Go To The Folder Where You Want To Place The Repository
 
This part is optional. Use ```cd``` to go to the location you want to place the repository. In my case, I have a seperate location in my ```d``` drive. For example:

    $ cd d:/github/myrepos

 ## Cloning The Repository

    $ git clone https://github.com/nishantc1527/Algorithms.git
    $ cd Algorithms
    
The second command just goes to the repository folder.
    
 ## Compiling A File
    
If you are using C++, then first use ```cd <the path the folder which contains the file>```. For example: 

    $ cd src/main/cpp/com/nishant/algorithms/sorting/quicksort/

If you are using Java, then compile the file like this:

    $ javac <file-path>
    $ java <file-name-without-extension>
    
Example:

    $ javac src/main/java/<...>/QuickSort.java
    $ java QuickSort

If you are using Python, then run it (not compile) using this:

    $ python <file-file-path>

Example:

    $ python <...>/BubbleSort.py

If you are using C++, then compile and run like this:

    $ g++ <file-name> -o <name-of-your-choice>
    $ ./<name-of-your-choice>

The ```-o <name-of-your-choice>``` is optional; if you don't add it replace ```./<name-of-your-choice>``` with ```./a```.

Example:

    $ g++ bubble_sort.cpp -o out
    $ ./out 
    
 ## Possible Error

In Java (or python, but the error message is different), you might get this:
 
    Error: Could not find or load main class QuickSort
    
 A couple of detailed posts about this:
 
 - [Stack Overflow](https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean)
 - [Tutorialspoint](https://www.tutorialspoint.com/how-to-resolve-could-not-find-or-load-main-class-package-in-java)

In short, you can't go to the directory itself to compile it. You have to start from the main repository folder, then compile using the full path. This is the same for python, except the error message will be different.

 ## Another Possible Error

    ModuleError: Could not load module 'src'

Like I said, the reason is the same for Java. Don't compile it by first going into the directory, instead compile from the repository folder.

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

# Implementations

This part contains all the implementations of the algorithms. If you want to view the file associated to an implementation, go to ```src/main/<language-of-your-choice>/<follow-the-headers-before-the-file>```. If you want to see the JUnit tests, replace ```src/main``` with ```src/test```. If you want to see the explanation of something, replace ```<language-of-your-choice>``` with ```explanations```.

 ## Sorting
 
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Counting Sort
  - Heap Sort
  
 ## Bit Manipulation
 
  - Missing Number
  - Power Of Two
  - Single Number
  
 ## Graph Theory
 
  ### Elementary Graph Algorithms
  
  - Breadth First Search
  - Depth First Search
 
  ### Implementations
  
  - Adjacency List
  - Adjacency Matrix
  
  ### Shortest Path Algorithms
  
   #### Single Source Shortest Path
   
   - Dijkstra's Shortest Path
   - Bellman Ford's Shortest Path Algorithm
 
 ## Data Structures
 
  ### Trees
  
   #### Binary Search Trees
   
   - AVL Tree
   - Binary Search Tree
   - Red Black Tree
  
   #### Trie
  
  ### Min Priority Queue
  
   - Fibonacci Heap
   - Min Heap
 
 ## Dynamic Programming
 
  - House Robber
  - Unique Paths

 ## Math
 
  - Matrix
  - Vector

 ## Neural Networks

# License
Licensed under [MIT License](https://opensource.org/licenses/MIT). That means feel free to add whatever you want if you find it necessary.
