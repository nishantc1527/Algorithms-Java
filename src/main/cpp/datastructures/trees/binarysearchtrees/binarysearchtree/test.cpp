#include <iostream>

#include "binary_search_tree.hpp"

int main() {
	binary_search_tree t;

	for(int i = 0; i < 100; i ++) {
		t.insert(i);
	}

	std::cout << std::boolalpha << t.contains(55) << std::endl;
	std::cout << std::boolalpha << t.contains(100) << std::endl;
}
