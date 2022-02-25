#include "main.h"

void xorcrypt(char msg[], const char key[]){

    for (int i = 0, j = 0; msg[i]; ++i, ++j){

        if (!key[j]){

            j = 0;

        }

        msg[i] ^= key[j];

    }
}