//
// Created by nisha on 6/2/2020.
//

#include <string>
#include <vector>
#include <iostream>

#include "trie.hpp"

int main() {
  trie t;
  t.insert("hi");
  t.insert("hello");

  std::cout << std::boolalpha << t.contains("hi") << std::endl;
  std::cout << std::boolalpha << t.contains("h") << std::endl;
}
