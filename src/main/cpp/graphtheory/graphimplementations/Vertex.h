#ifndef VERTEX
#define VERTEX

enum Color { WHITE, GRAY, BLACK };

template <typename T>
class Vertex {
private:
  T& val;
  Color color;
public:
  Vertex(T val_) : val(val_), color(Color::WHITE) {}
  
  bool operator== (Vertex<T> &other) {
    return val == other.val;
  }

  T getVal() {
    return val;
  }

  void setVal(T val_) {
    this->val = val_;
  }

  Color getColor() {
    return color;
  }

  void setColor(Color color_) {
    color = color_;
  }
};

#endif
