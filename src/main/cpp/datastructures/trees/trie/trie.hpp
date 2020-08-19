class trie {
 private:
  class node {
   public:
    int count;
    node **children;

    node() {
      children = new node *[26];
      for (int i = 0; i < 26; i++) {
        children[i] = nullptr;
      }
      count = 0;
    }
  };

 public:
  node *root;

  trie() {
    root = new node();
  }

  void insert(const std::string &string) {
    node *curr = root;

    for (int i = 0; i < string.length(); i++) {
      int index = string[i] - 'a';

      if (curr->children[index] == nullptr) {
        curr->children[index] = new node();
      }

      curr = curr->children[index];
    }

    curr->count++;
  }

  bool contains(const std::string &string) {
    node *curr = root;

    for (int i = 0; i < string.length(); i++) {
      int index = string[i] - 'a';

      if (curr->children[index] == nullptr) {
        return false;
      }

      curr = curr->children[index];
    }

    return curr->count > 0;
  }

  ~trie() {
    delete (root);
  }

};
