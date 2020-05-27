#pragma once

class binary_search_tree {
private:
	class node {
	public:
		int val;
		node* left;
		node* right;
	public:
		node(int _val, node* _left, node* _right) {
			val = _val;
			left = _left;
			right = _right;
		}

		~node() {
			if(left != nullptr) {
				delete(left);
			}

			if(right != nullptr) {
				delete(right);
			}
		}
	};
public:
	node* root;
public:
	binary_search_tree() {
		root = nullptr;
	}
	
	~binary_search_tree() {
		delete(root);
	}
public:
	void insert(int val) {
		if(root == nullptr) {
			root = new node(val, nullptr, nullptr);
		} else {
			node* dummy = root;

			while(true) {
				if(val < dummy->val) {
					if(dummy->left == nullptr) {
						dummy->left = new node(val, nullptr, nullptr);
						break;
					}

					dummy = dummy->left;
				} else {
					if(dummy->right == nullptr) {
						dummy->right = new node(val, nullptr, nullptr);
						break;
					}

					dummy = dummy->right;
				}
			}
		}
	}

	bool contains(int val) {
		if(root != nullptr) {
			node* dummy = root;

			while(dummy != nullptr) {
				if(val < dummy->val) {
					dummy = dummy->left;
				} else if(val > dummy->val) {
					dummy = dummy->right;
				} else {
					return true;
				}
			}
		}

		return false;
	}
};
