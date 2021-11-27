#include "main.h"

void strcpy(char s1[], char s2[]){

    char c2;

    for (int i = 0; s1[i] && (c2 = s2[i]); ++i){

        s1[i] = c2;

    }
}

int  strcmp(char s1[], char s2[]){

    char c1, c2;

    for (int i = 0; (c1 = s1[i]) && (c2 = s2[i]); ++i){

        if (c1 > c2){

            return 1;

        } else if (c1 < c2){

            return -1;

        }
    }

    return 0;

}

void strupper(char s[]){

    char c;

    for (int i = 0; (c = s[i]); ++i){

        if (c >= 'a' && c <= 'z'){

            s[i] = c - 'a' + 'A';

        }
    }
}