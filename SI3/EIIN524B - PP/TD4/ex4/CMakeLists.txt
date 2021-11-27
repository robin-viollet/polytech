cmake_minimum_required(VERSION 3.16)

add_library(ex4 STATIC main.c)

add_executable(ex4_tests tests.c)
target_link_libraries(ex4_tests ex4)