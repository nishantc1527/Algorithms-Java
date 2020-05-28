# Time Complexity

NOTE: Since time complexity is an advanced concept, you can see more about it [here](https://en.wikipedia.org/wiki/Big_O_notation).

You will often find a notation called "Big Oh Notation," which looks like this: O(something). This is a time copmlexity, and is used to analyze how fast something is. Specifically, it wants to know how fast it is compared to an input size N. Take this example, in java but easily readable:

```java
void loop(int N) {
    for(int i = 0; i < N; i ++) {
        // do something
    }
}
```

This simple program loops N times. The time complexity of this is O(N) since the time is takes compared to N is just N. You can also think of the time complexity of how many times it loops, although that isn't technically correct. That's because something like this:

```java
void loop(int N) {
    for(int i = 0; i < N; i ++) {
        // do something
    }
    for(int i = 0; i < N; i ++) {
        // do something
    }
}
```

Is still O(N), even though it loops a total amount of 2N times. In time complexity, the constants that are multiplied, added, subtracted, and so one are dropped. That means this is also O(N):

```java
void loop(int N) {
    for(int i = 0; i < N; i ++) {
        // do something
    }
    for(int i = 0; i < N; i ++) {
        // do something
    }
    for(int i = 0; i < 100; i ++) {
        // do something
    }
}
```

Even though this might be drastically slower than the first example. However, the following is not O(N):

```java
void loop(int N) {
    for(int i = 0; i < N; i ++) {
        for(int j = 0; j < N; j ++) {
            // do something
        }
    }
}
```
Since the amount of loops is N<sup>2</sup>, the time complexity is O(N<sup>2</sup>).

There is still much more to be talked about in time complexity, but these are the basics.
