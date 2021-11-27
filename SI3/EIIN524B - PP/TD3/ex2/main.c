#include "main.h"

unsigned long strlen(const char str[]){

    int i = 0;

    for (; str[i]; ++i){}

    return i;

}

int palindrome(const char str[]){

    unsigned long len = strlen(str);

    for (int i = 0; i < len / 2; ++i){

        if (str[i] != str[len - i - 1]){

            return 0;

        }
    }

    return 1;

}
