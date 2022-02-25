#include "main.h"

int indice(const char str[], const char c){

    for (int i = 0; str[i]; ++i){

        if (str[i] == c){

            return i;

        }
    }

    return -1;

}

int indice_droite(const char str[], const char c){

    int index = -1;

    for (int i = 0; str[i]; ++i){

        if (str[i] == c){

            index = i;

        }
    }

    return index;

}