#include <stdio.h>
#include <stdarg.h>
#include "main.h"

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

void Printf(char format[], ...){

    va_list args;
    va_start(args, format);

    while (*format != '\0'){

        if (*format == '%'){

            format++;

            if (*format == '%' || *format == '\0'){

                putchar('%');

            } else if (*format == 'c'){

                putchar(va_arg(args, int));

            } else if(*format == 's'){

                char* s = va_arg(args, char*);

                for (int i = 0; s[i]; ++i){

                    putchar(s[i]);

                }

            } else if (*format == 'd'){

                int i = va_arg(args, int);

                if (i < 0){

                    putchar('-');
                    i *= -1;

                }

                print(i, 10);

            } else if (*format == 'x'){

                print(va_arg(args, int), 16);

            } else if (*format == 'f'){

                char buffer[40];

                snprintf(buffer, 40, "%f", 3.1415926);

                for (int i = 0; buffer[i]; ++i){

                    putchar(buffer[i]);

                }

            } else {

                putchar('%');
                putchar(*format);

            }

        } else {

            putchar(*format);

        }

        format++;

    }

    va_end(args);

//    %d: affichage d’un entier en décimal;
//    %x: affichage d’un entier en hexadécimal;
//    %f: affichage d’un nombre flottant
//    %c: affichage d’un caractère;
//    %s: affichage d’une chaîne de caractères;
//    %%: affichage du caractère '%'.

}