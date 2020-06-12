//
// Created by nisha on 6/3/2020.
//

#include "fibonacci_heap.hpp"

fibonacci_heap::node::node(int _val,
                           fibonacci_heap::node *_left,
                           fibonacci_heap::node *_right,
                           fibonacci_heap::node *_parent,
                           fibonacci_heap::node *_child) :
    val(_val), left(_left), right(_right), parent(_parent), child(_child) {}

fibonacci_heap::node::~node() {

}

void fibonacci_heap::node::insert(fibonacci_heap::node *other) {
  if (left == this) {
    left = other;
    right = other;
    left->left = this;
    left->right = this;
  } else {
    node *temp = left;
    left = other;
    left->right = this;
    temp->right = left;
    left->left = temp;
  }
}

fibonacci_heap::fibonacci_heap() :
    min(nullptr) {}

fibonacci_heap::~fibonacci_heap() {
  delete min;
}

void fibonacci_heap::insert(int val) {
  if (!min) {
    min = new node(val);
    min->left = min;
    min->right = min;
  } else {
    min->insert(new node(val));
  }
}
