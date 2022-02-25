#include "main.h"
#include <stddef.h>
#include <malloc.h>

char *strcpy(char *dest, const char *src){
    int i = 0;

    for (; src[i]; ++i){
        dest[i] = src[i];
    }

    dest[i] = '\0';

    return dest;
}

size_t strlen(const char *s){
    size_t len = 0;

    for (int i = 0; s[i]; ++i){
        len++;
    }

    return len;
}

char *strdup(const char *s){
    char* d = malloc(strlen(s));

    strcpy(d, s);

    return d;
}

char *strchr(const char *s, int c){
    for (int i = 0; s[i]; ++i){
        if (s[i] == c){

            return (char*) s + i;

        }
    }

    return NULL;
}
