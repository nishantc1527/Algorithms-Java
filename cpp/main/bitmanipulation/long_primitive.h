#ifndef LONG_PRIMITIVE
#define LONG_PRIMITIVE

#include <algorithm>

// Not Finished

class long_primitive {
private:
  const short int *data;
  const std::size_t size;
  long_primitive() : data(nullptr), size(0) {}
public:
  long_primitive(int size)
    : data(new short int[size]), size(size) {}

  ~long_primitive() {
    delete[] data;
  }

  const long_primitive& operator=(const long_primitive& other) const {
    long_primitive res = long_primitive();
    res.data = other.data;

    return *this;
  }

  const long_primitive& operator=(long long int num) const {
    

    return *this;
  }
};

#endif
