#include "main.h"

#include <stdio.h>

char flag = 1;

void print(int integer, int base){

    if(flag && integer == 0){

        putchar('0');
        return;

    }

    flag = 0;

    if (base >= 2 && base <= 36){

        if (integer != 0){

            print(integer / base, base);

            char digit = (char) (integer % base);

            if (digit >= 0 && digit < 10){

                putchar('0' + digit);

            } else if (digit >= 10 && digit <= 36){

                putchar('A' - 10 + digit);

            } else {

                putchar('?');

            }
        }

    } else {

        const char errorMessage[] = "Invalid base";

        char c;

        for (int i = 0; (c = errorMessage[i]); ++i){

            putc(c, stderr);

        }
    }

    flag = 1;

    //2 <= base <= 36

}

void en_binaire(int integer){

    if (flag && integer == 0){

        putchar('0');
        return;

    }

    flag = 0;

    if (integer != 0){

        en_binaire(integer >> 1);
        putchar('0' + (integer & 1));

    }

    flag = 1;

}