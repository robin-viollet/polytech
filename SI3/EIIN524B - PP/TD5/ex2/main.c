#include <stdio.h>
#include <stdarg.h>

#include "main.h"

void cat_strings(char str1[], ...){

    va_list args;
    va_start(args, str1);

    while (str1) {
        puts(str1);
        str1 = va_arg(args, char*);
    }

    va_end(args);

}