cmake_minimum_required(VERSION 3.13)
project(Algorithms)

set(CMAKE_CXX_STANDARD 14)

# 'Google_test' is the subproject name
project(cpp)

# 'lib' is the folder with Google Test sources
add_subdirectory(lib/googletest-master)
include_directories(${gtest_SOURCE_DIR}/include ${gtest_SOURCE_DIR})

# 'Google_Tests_run' is the target name
# 'test1.cpp tests2.cpp' are source files with tests
add_executable(Google_Tests_run sorting/bubblesort/bubble_sort_test.cpp
        sorting/insertionsort/insertion_sort_test.cpp
        sorting/mergesort/merge_sort_test.cpp)

target_link_libraries(Google_Tests_run gtest gtest_main)
