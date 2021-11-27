cmake_minimum_required(VERSION 3.16)

add_library(ex2 STATIC main.c)

add_executable(ex2_tests tests.c)
target_link_libraries(ex2_tests ex2)