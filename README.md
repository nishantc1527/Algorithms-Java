# [Algorithms](https://github.com/nishantc1527/Algorithms/tree/master/src)

Algorithms are a way to solve problems. Not only that, it wants to solve problem fast. That's why there're tons and tons of theory on this stuff.

This project is a hope to share the whole knowledge of algorithms there is to offer. If you don't know the algorithm, there are detailed explanations on each algorithm (all at the bottom of this page).

Obviously, one guy can't do that, which is why it's open source! I also developed a fun way to contribute. You can look at it in the [contributing page](https://github.com/nishantc1527/Algorithms#contributing).

# Languages

While Java has the most algorithms, you might find an algorithm in Java, Python, or C++.  

# LeetCode

Many of these algorithm problems come from an interview preparing website called [LeetCode](https://leetcode.com/problemset/all/). If you want, you can also check out [my LeetCode solutions](https://github.com/nishantc1527/LeetCode).

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

In short, you can't go to the directory itself to compile it. You have to start from the main repository folder, then compile using the full path. 
This is the same for Python, except the error message will be different.

 ## Another Possible Error

    ModuleError: Could not load module 'src'

Like I said, the reason is the same for Java. Don't compile it by first going into the directory, instead compile from the repository folder.

# Leaderboard

No one here yet. Be the first to put your name!

# License
Licensed under [MIT License](https://opensource.org/licenses/MIT). That means feel free to add whatever you want if you find it necessary.

