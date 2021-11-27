cmake_minimum_required(VERSION 3.16)

add_library(ex7 STATIC main.c)

add_executable(ex7_tests tests.c)
target_link_libraries(ex7_tests ex7)