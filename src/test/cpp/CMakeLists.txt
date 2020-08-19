cmake_minimum_required(VERSION 3.13)
project(Algorithms LANGUAGES CXX)

add_subdirectory(libs/googletest)
include_directories(${gtest_SOURCE_DIR}/include ${gtest_SOURCE_DIR})
include_directories(../..)

add_executable(Algorithms all_tests.cpp)
target_link_libraries(Algorithms gtest gtest_main)