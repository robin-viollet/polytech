#include "main.h"

void suppress_char(char str[], char c){

    char c1;

    for (int i = 0; (c1 = str[i]); ++i){

        if (c1 == c){

            for (int j = i + 1; ; ++j){

                str[i] = str[j];
//                str[j - 1] = str[j];

                if(!str[j]){

                    break;

                }
            }
        }
    }
}