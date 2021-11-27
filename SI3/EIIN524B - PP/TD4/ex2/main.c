#include <stdio.h>
#include "main.h"

void BigSet_init(BigSet s){

    for (int i = 0; i < MAX_BIGSET; ++i){

        s[i] = 0;

    }
}

void BigSet_add(BigSet s, int i){

    s[i / 8] |= 1 << i % 8;

}

int BigSet_is_in(BigSet s, int i){

    return s[i / 8] & i % 8;

}

void BigSet_print(BigSet s){

    printf("{");

    for (int i = 0; i < MAX_BIGSET; ++i){
        for (int j = 0; j < 8; ++j){

            if (s[i] & 1 << j){

                printf("%d,", i * 8 + j);

            }
        }
    }

    printf("}\n");

}

void BigSet_inter(BigSet s1, BigSet s2, BigSet res){

    for (int i = 0; i < MAX_BIGSET; ++i){

        res[i] = s1[i] & s2[i];

    }
}