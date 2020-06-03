cmake_minimum_required(VERSION 3.13)
project(Algorithms)
set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES test.cpp ../../../../test/cpp/sorting/heapsort/heap_sort_test.cpp)

add_executable(Algorithms ${SOURCE_FILES})
