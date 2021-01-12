<<<<<<< HEAD
cmake_minimum_required(VERSION 3.13)
project(Algorithms)
set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES test.cpp)

add_executable(Algorithms ${SOURCE_FILES})
=======
cmake_minimum_required(VERSION 2.6)
 
# Locate GTest
find_package(GTest REQUIRED)
include_directories(${GTEST_INCLUDE_DIRS})
 
# Link runTests with what we want to test and the GTest and pthread library
add_executable(executeTests quick_sort_test.cpp)
target_link_libraries(executeTests ${GTEST_LIBRARIES} pthread)
>>>>>>> 9b756811186f3ad9fb5c1fff9705fee329c4baa8
