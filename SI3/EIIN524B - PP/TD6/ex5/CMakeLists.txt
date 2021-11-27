cmake_minimum_required(VERSION 3.16)

add_library(ex5 STATIC main.c)

add_executable(ex5_tests tests.c)
target_link_libraries(ex5_tests ex5)