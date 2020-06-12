//
// Created by nisha on 6/3/2020.
//

#pragma once

class fibonacci_heap {
 private:
  struct node {
    int val;
    node *left;
    node *right;
    node *parent;
    node *child;

    explicit node(int _val,
                  node *_left = nullptr,
                  node *_right = nullptr,
                  node *_parent = nullptr,
                  node *_child = nullptr);

    ~node();

    void insert(node* other);

  };
 private:
  node *min;
 public:
  fibonacci_heap();
  ~fibonacci_heap();
 public:
  void insert(int val);

};
