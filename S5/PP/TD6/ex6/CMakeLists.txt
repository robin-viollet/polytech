cmake_minimum_required(VERSION 3.16)

add_library(ex6 STATIC main.c)

add_executable(ex6_tests tests.c)
target_link_libraries(ex6_tests ex6)