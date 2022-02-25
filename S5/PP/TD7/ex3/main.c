#include <stdio.h>
#include <malloc.h>

#include "main.h"

char* readline(){
    size_t size = 256;
    char* line = malloc(size);
    size_t i = 0;
    int c;

    while ((c = getchar()) != EOF){
        line[i] = c;

        ++i;

        if (i == size){
            line = realloc(line, size *= 2);
        }
    }

    if (i > 0){
        return line;
    } else {
        free(line);
        return NULL;
    }
}