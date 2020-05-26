#include <string>
#include <vector>
#include <iostream>

class trie {
private:
	class node {
	public:
		int count;
		std::vector<node*> children;

		node() {
			children = std::vector<node*>(26, nullptr);
		}
	};
public:
	node* root;

	trie() {
		root = new node();
	}

	void insert(std::string string) {
		node* curr = root;

		for(int i = 0; i < string.length(); i ++) {
			int index = string[i] - 'a';

			if(curr->children[index] == nullptr) {
				curr->children[index] = new node();
			}

			curr = curr->children[index];
		}

		curr->count ++;
	}

	bool contains(std::string string) {
		node* curr = root;

		for(int i = 0; i < string.length(); i ++) {
			int index = string[i] - 'a';

			if(curr->children[index] == nullptr) {
				return false;	
			}

			curr = curr->children[index];
		}

		return curr->count > 0;
	}
		
};

int main() {
	trie t;
	t.insert("hi");
	t.insert("hello");

	std::cout << std::boolalpha << t.contains("hi") << std::endl;
	std::cout << std::boolalpha << t.contains("h") << std::endl;
}

