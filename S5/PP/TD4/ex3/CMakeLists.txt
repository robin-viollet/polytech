cmake_minimum_required(VERSION 3.16)

add_library(ex3 STATIC main.c)

add_executable(ex3_tests tests.c)
target_link_libraries(ex3_tests ex3)