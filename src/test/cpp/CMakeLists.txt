cmake_minimum_required(VERSION 3.13)
project(Algorithms)

set(CMAKE_CXX_STANDARD 14)

add_subdirectory(libs/googletest-master)
include_directories(${gtest_SOURCE_DIR}/include ${gtest_SOURCE_DIR})

add_executable(Algorithms sorting/bubblesort/bubble_sort_test.cpp
        sorting/insertionsort/insertion_sort_test.cpp
        sorting/mergesort/merge_sort_test.cpp
        sorting/quicksort/quick_sort_test.cpp
        sorting/selectionsort/selection_sort_test.cpp
        sorting/heapsort/heap_sort_test.cpp
        )

target_link_libraries(Algorithms gtest gtest_main)
