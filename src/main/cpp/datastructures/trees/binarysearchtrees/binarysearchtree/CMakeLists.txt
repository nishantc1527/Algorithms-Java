cmake_minimum_required(VERSION 3.13)
project(Algorithms)
set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES test.cpp)
add_subdirectory(lib/googletest-master)
include_directories(lib/googletest-master/googletest/include)
include_directories(lib/googletest-master/googlemock/include)

add_executable(Algorithms ${SOURCE_FILES})
target_link_libraries(Algorithms gtest gtest_main)
