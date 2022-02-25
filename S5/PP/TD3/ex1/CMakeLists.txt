cmake_minimum_required(VERSION 3.16)

add_library(ex1 STATIC main.c)

add_executable(ex1_tests tests.c)
target_link_libraries(ex1_tests ex1)